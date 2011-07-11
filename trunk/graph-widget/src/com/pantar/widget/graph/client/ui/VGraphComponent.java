package com.pantar.widget.graph.client.ui;

import java.util.HashSet;
import java.util.Set;

import org.vectomatic.dom.svg.OMSVGSVGElement;
import org.vectomatic.dom.svg.utils.OMSVGParser;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.terminal.gwt.client.ApplicationConnection;
import com.vaadin.terminal.gwt.client.Paintable;
import com.vaadin.terminal.gwt.client.UIDL;
import com.vaadin.terminal.gwt.client.Util;

/**
 * Client side widget which communicates with the server. Messages from the
 * server are shown as HTML and mouse clicks are sent to the server.
 */
public class VGraphComponent extends Composite implements Paintable, ClickHandler {

	/**
	 * Set the CSS class name to allow styling.
	 */
	public static final String CLASSNAME = "v-graphcomponent";

	/**
	 * The client side widget identifier
	 */
	protected String paintableId;

	/**
	 * Reference to the server connection object.
	 */
	protected ApplicationConnection client;

	/**
	 * Collection of nodes.
	 */
	private final Set<Node> nodes = new HashSet<Node>();

	/**
	 * Root Panel.
	 */
	protected Panel root = new AbsolutePanel();

	/**
	 * Canvas.
	 */
	protected OMSVGSVGElement canvas = OMSVGParser.currentDocument().createSVGSVGElement();

	/**
	 * The constructor should first call super() to initialize the component and
	 * then handle any initialization relevant to Vaadin.
	 */
	public VGraphComponent() {
		// =
		this.initWidget(this.root);

		// =
		this.setStyleName(CLASSNAME);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void initWidget(final Widget pWidget) {
		super.initWidget(pWidget);

		// =
		this.initCanvas(this.canvas);

		// =
		this.root.getElement().getStyle().setPosition(Position.ABSOLUTE);
		this.root.getElement().getStyle().setBackgroundColor("white");
		this.root.getElement().appendChild(this.canvas.getElement());
	}

	/**
	 * @param pCanvas
	 */
	private void initCanvas(final OMSVGSVGElement pCanvas) {
		this.canvas.addClickHandler(this);
	}

	/**
	 * Called whenever an update is received from the server
	 */
	@Override
	public void updateFromUIDL(final UIDL uidl, final ApplicationConnection client) {
		if (client.updateComponent(this, uidl, true)) {
			return;
		}

		this.client = client;
		this.paintableId = uidl.getId();

		// = Temp.

		final Node node1 = new Node(this, "1", NodeTypeEnum.CUSTOM_NODE);
		node1.setSelected(Boolean.TRUE);

		final Node node2 = new Node(this, "2", NodeTypeEnum.CUSTOM_NODE);
		node2.setSelected(Boolean.TRUE);

		final Node node3 = new Node(this, "3", NodeTypeEnum.CUSTOM_NODE);
		node2.setSelected(Boolean.TRUE);

		final Relation r1 = new Relation(this, node1, node2, RelationTypeEnum.BEZIER, new DefaultRelationStyle());
		final Relation r2 = new Relation(this, node1, node1, RelationTypeEnum.BEZIER, new DefaultRelationStyle());
		final Relation r3 = new Relation(this, node1, node3, RelationTypeEnum.LINE, new DefaultRelationStyle());

		this.add(node1);
		this.add(node2);
		this.add(node3);
	}

	/**
	 * Called when a native click event is fired.
	 * 
	 * @param event
	 *            the {@link ClickEvent} that was fired
	 */
	@Override
	public void onClick(final ClickEvent event) {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setWidth(final String width) {
		Util.setWidthExcludingPaddingAndBorder(this, width, 0);
		this.canvas.setViewBox(0, 0, this.getOffsetWidth(), this.getOffsetHeight());

		this.updateNodes();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setHeight(final String height) {
		Util.setHeightExcludingPaddingAndBorder(this, height, 0);
		this.canvas.setViewBox(0, 0, this.getOffsetWidth(), this.getOffsetHeight());

		this.updateNodes();
	}

	/**
	 * @param pNode
	 */
	protected void add(final Node pNode) {
		this.nodes.add(pNode);
	}

	/**
	 * @param widget
	 */
	protected void add(final HTML widget) {
		this.root.add(widget);
	}

	/**
	 * @param widget
	 */
	protected void add(final Element pElement) {
		this.canvas.getElement().appendChild(pElement);
	}

	/**
	 * @param pKey
	 * @return
	 */
	public Node getNodeById(final String pKey) {
		for (final Node currentNode : this.nodes) {
			if (currentNode.getId().equals(pKey)) {
				return currentNode;
			}
		}
		return null;
	}

	/**
	 * 
	 */
	public void updateNodes() {
		for (final Node node : this.nodes) {
			node.update();
		}
	}
}
