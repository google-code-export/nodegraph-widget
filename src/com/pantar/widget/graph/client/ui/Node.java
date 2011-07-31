/**
 * 
 */
package com.pantar.widget.graph.client.ui;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.DoubleClickEvent;
import com.google.gwt.event.dom.client.DoubleClickHandler;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.event.dom.client.MouseMoveHandler;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.event.dom.client.MouseUpHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.UIObject;
import com.pantar.widget.graph.shared.GraphConstants;
import com.pantar.widget.graph.shared.component.NodeTypeEnum;

/**
 * @author mauro.monti
 * 
 */
public class Node {

	/**
	 * 
	 */
	protected String id;

	/**
	 * 
	 */
	protected HTML widget;

	/**
	 * 
	 */
	protected HTML label;
	
	/**
	 * 
	 */
	protected boolean dragging;

	/**
	 * 
	 */
	protected boolean selected;

	/**
	 * 
	 */
	protected boolean enabled;

	/**
	 * 
	 */
	protected int dragStartX;

	/**
	 * 
	 */
	protected int dragStartY;

	/**
	 * 
	 */
	protected boolean mouseDown;

	/**
	 * 
	 */
	protected final Set<Relation> outgoing = new HashSet<Relation>();

	/**
	 * 
	 */
	protected final Set<Relation> incoming = new HashSet<Relation>();

	/**
	 * 
	 */
	protected NodeTypeEnum nodeTypeEnum;

	/**
	 * 
	 */
	protected NodeStyle nodeStyle;

	/**
	 * 
	 */
	protected VGraphComponent parent;

	/**
	 * 
	 */
	protected Map<String, Object> nodeAttributes = new HashMap<String, Object>();

	/**
	 * @param pParent
	 * @param pId
	 * @param pNodeTypeEnum
	 */
	public Node(final VGraphComponent pParent, final String pId, final NodeTypeEnum pNodeTypeEnum) {
		this(pParent, pId, pNodeTypeEnum, new DefaultNodeStyle(), 0, 0);
	}

	/**
	 * @param pParent
	 * @param pId
	 * @param pNodeTypeEnum
	 * @param pNodeStyle
	 * @param pX
	 * @param pY
	 */
	public Node(final VGraphComponent pParent, final String pId, final NodeTypeEnum pNodeTypeEnum, final NodeStyle pNodeStyle, final double pX, final double pY) {
		if (pParent == null) {
			throw new IllegalArgumentException("VGraphComponent cannot be null.");
		}
		if (pId == null) {
			throw new IllegalArgumentException("Node Id cannot be null.");
		}
		if (pNodeTypeEnum == null) {
			throw new IllegalArgumentException("Node Type cannot be null.");
		}

		this.parent = pParent;
		this.id = pId;
		this.nodeTypeEnum = pNodeTypeEnum;
		this.nodeStyle = pNodeStyle;
		this.enabled = true;
		this.selected = false;
		
		this.initializeNode(pX, pY);
	}

	/**
	 * 
	 */
	private void initializeNode(final double pX, final double pY) {
		this.widget = new HTML();
		this.widget.getElement().setId(this.id);

		this.widget.setStyleName(this.nodeStyle.getStyleClassName());
//		if (!this.nodeTypeEnum.equals(NodeTypeEnum.NODE)) {
//			this.widget.addStyleName(this.nodeTypeEnum.getTypeName());	
//		}

		this.widget.getElement().getStyle().setCursor(Cursor.POINTER);
		this.widget.getElement().getStyle().setPosition(Position.ABSOLUTE);
		this.widget.getElement().getStyle().setLeft(pX, Unit.PX);
		this.widget.getElement().getStyle().setTop(pY, Unit.PX);

		this.parent.add(this.widget);

		this.addHandlers();
		this.update();
	}

	/**
	 * @return
	 */
	public String getId() {
		return this.widget.getElement().getId();
	}

	/**
	 * @return
	 */
	private Map<String, Object> getAttributes() {
		nodeAttributes.put(GraphConstants.MODEL.ATTR_ID, Node.this.widget.getElement().getId());
		nodeAttributes.put(GraphConstants.MODEL.ATTR_X, Node.this.getCenterX());
		nodeAttributes.put(GraphConstants.MODEL.ATTR_Y, Node.this.getCenterY());
		nodeAttributes.put(GraphConstants.MODEL.ATTR_SELECTED, Node.this.selected);
		nodeAttributes.put(GraphConstants.MODEL.ATTR_SELECTED, Node.this.enabled);
		
		return nodeAttributes;
	}
	
	/**
	 * 
	 */
	private void addHandlers() {
		if (this.parent.singleSelectionSupport.booleanValue()) {
			this.widget.addDomHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					Node.this.setSelected(Boolean.TRUE);
					Node.this.parent.client.updateVariable(Node.this.parent.paintableId, GraphConstants.EVENTS.EVT_GRAPHMODEL_ATTR_CHANGED, getAttributes(), true);
				}
			}, ClickEvent.getType());
		}

		this.widget.addDomHandler(new DoubleClickHandler() {
			@Override
			public void onDoubleClick(DoubleClickEvent event) {
				Node.this.setSelected((!Node.this.selected));
				Node.this.parent.client.updateVariable(Node.this.parent.paintableId, GraphConstants.EVENTS.EVT_GRAPHMODEL_ATTR_CHANGED, getAttributes(), true);
			}
		}, DoubleClickEvent.getType());

		this.widget.addDomHandler(new MouseDownHandler() {

			/**
			 * {@inheritDoc}
			 */
			@Override
			public void onMouseDown(final MouseDownEvent event) {
				if (!Node.this.selected) {
					return;
				}
				
				Node.this.mouseDown = true;
				
				DOM.setCapture(Node.this.widget.getElement());
				Node.this.dragStartX = event.getX();
				Node.this.dragStartY = event.getY();

				event.preventDefault();
			}

		}, MouseDownEvent.getType());

		this.widget.addDomHandler(new MouseMoveHandler() {

			/**
			 * {@inheritDoc}
			 */
			@Override
			public void onMouseMove(final MouseMoveEvent event) {
				if (Node.this.mouseDown) {
					Node.this.dragging = true;

					final Element element = Node.this.widget.getElement();
					final int newX = event.getX() + element.getOffsetLeft() - Node.this.dragStartX;
					final int newY = event.getY() + element.getOffsetTop() - Node.this.dragStartY;

					Node.this.move(newX, newY);
					final int clientX = event.getClientX();
					final int clientY = event.getClientY();

					if ((clientX < 0) || (clientY < 0) || (clientX > Window.getClientWidth()) || (clientY > Window.getClientHeight())) {
						Node.this.dragging = false;
					}
				}
				event.preventDefault();
			}

		}, MouseMoveEvent.getType());

		this.widget.addDomHandler(new MouseUpHandler() {

			/**
			 * {@inheritDoc}
			 */
			@Override
			public void onMouseUp(final MouseUpEvent event) {
				Node.this.dragging = false;
				Node.this.mouseDown = false;
				DOM.releaseCapture(Node.this.widget.getElement());

				if (!Node.this.dragging) {
					return;
				}
				
				Node.this.parent.client.updateVariable(Node.this.parent.paintableId, GraphConstants.EVENTS.EVT_GRAPHMODEL_ATTR_CHANGED, getAttributes(), true);
				event.preventDefault();
			}

		}, MouseUpEvent.getType());
	}

	/**
	 * @param pLabel
	 */
	public void setLabel(String pLabel) {
		this.label = new HTML(pLabel);
		if (this.widget.getElement().hasChildNodes()) {
			this.widget.getElement().getFirstChildElement().setInnerText(pLabel);
		} else {
			this.widget.getElement().appendChild(this.label.getElement());
		}
		this.label.getElement().getStyle().setPosition(Position.RELATIVE);
		this.label.setStyleName(this.nodeStyle.getLabelClassName());
	}
	
	/**
	 * @param pRelation
	 */
	public void addIncoming(final Relation pRelation) {
		this.incoming.add(pRelation);
	}

	/**
	 * @param pRelation
	 */
	public void addOutgoing(final Relation pRelation) {
		this.outgoing.add(pRelation);
	}

	/**
	 * @param pSelected
	 *            the selected to set
	 */
	public void setSelected(final boolean pSelected) {
		if (!this.enabled) {
			return;
		}
		
		for (Node node : this.parent.getNodes()) {
			node.selected = Boolean.FALSE;
			node.widget.getElement().removeClassName(Node.this.nodeStyle.getSelectedClassName());
			node.widget.getElement().addClassName(Node.this.nodeStyle.getEnabledClassName());
		}
		
		this.selected = pSelected;
		
		if (this.selected) {
			Node.this.widget.getElement().removeClassName(Node.this.nodeStyle.getEnabledClassName());
			Node.this.widget.getElement().addClassName(Node.this.nodeStyle.getSelectedClassName());
		} else {
			Node.this.widget.getElement().addClassName(Node.this.nodeStyle.getEnabledClassName());
			Node.this.widget.getElement().removeClassName(Node.this.nodeStyle.getSelectedClassName());
		}
	}

	/**
	 * @param pEnabled
	 */
	public void setEnabled(final boolean pEnabled) {
		String cssClassName = (pEnabled) ? Node.this.nodeStyle.getEnabledClassName() : Node.this.nodeStyle.getDisabledClassName(); 
		Node.this.widget.getElement().removeClassName(Node.this.nodeStyle.getEnabledClassName());
		Node.this.widget.getElement().removeClassName(Node.this.nodeStyle.getDisabledClassName());
		
		this.enabled = pEnabled;
		Node.this.widget.getElement().addClassName(cssClassName);
	}

	/**
	 * 
	 */
	void updateRelations() {
		update(this.outgoing);
		update(this.incoming);
	}

	/**
	 * @param pRelations
	 */
	protected static void update(final Set<Relation> pRelations) {
		if (pRelations != null) {
			for (final Relation currentRelation : pRelations) {
				currentRelation.update();
			}
		}
	}

	/**
	 * 
	 */
	void update() {
		final Element element = this.widget.getElement();
		this.move(element.getOffsetLeft(), element.getOffsetTop());
	}

	/**
	 * @param pElement
	 * @return
	 */
	protected static double getCenterX(final Element pElement) {
		return pElement.getOffsetLeft() + pElement.getOffsetWidth() / 2.0;
	}

	/**
	 * @param pElement
	 * @return
	 */
	protected static double getCenterY(final Element pElement) {
		return pElement.getOffsetTop() + pElement.getOffsetHeight() / 2.0;
	}

	/**
	 * @param pWidget
	 * @return
	 */
	protected static double getCenterX(final UIObject pWidget) {
		return getCenterX(pWidget.getElement());
	}

	/**
	 * @param pWidget
	 * @return
	 */
	protected static double getCenterY(final UIObject pWidget) {
		return getCenterY(pWidget.getElement());
	}

	/**
	 * @param pMin
	 * @param pValue
	 * @param pMax
	 * @return
	 */
	protected static int limit(final int pMin, final int pValue, final int pMax) {
		return Math.min(Math.max(pMin, pValue), pMax);
	}

	/**
	 * @return
	 */
	protected double getCenterX() {
		return getCenterX(this.widget);
	}

	/**
	 * @return
	 */
	protected double getCenterY() {
		return getCenterY(this.widget);
	}

	/**
	 * @param pNewX
	 * @param pNewY
	 */
	public void move(final int pNewX, final int pNewY) {
		final Style style = this.widget.getElement().getStyle();
		style.setLeft(limit(0, pNewX, this.parent.getOffsetWidth() - this.widget.getOffsetWidth()), Unit.PX);
		style.setTop(limit(0, pNewY, this.parent.getOffsetHeight() - this.widget.getOffsetHeight()), Unit.PX);

		this.updateRelations();
	}

}
