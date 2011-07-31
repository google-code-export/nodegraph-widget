package com.pantar.widget.graph.client.ui;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.vectomatic.dom.svg.OMSVGSVGElement;
import org.vectomatic.dom.svg.utils.OMSVGParser;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;
import com.pantar.widget.graph.shared.GraphConstants;
import com.pantar.widget.graph.shared.component.NodeTypeEnum;
import com.pantar.widget.graph.shared.component.RelationTypeEnum;
import com.pathf.gwt.util.json.client.JSONWrapper;
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
	public static final String CSS_COMPONENT_CLASSNAME = "v-graphcomponent";

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
	 * Indicates if the graph model was initialized.
	 */
	protected Boolean graphModelInitialized = Boolean.FALSE;
	
	/**
	 * Single selection support.
	 */
	protected Boolean singleSelectionSupport = Boolean.FALSE;
	
	/**
	 * The constructor should first call super() to initialize the component and
	 * then handle any initialization relevant to Vaadin.
	 */
	public VGraphComponent() {
		// =
		this.initWidget(this.root);

		// =
		this.setStyleName(CSS_COMPONENT_CLASSNAME);
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
		this.root.getElement().getStyle().setBackgroundColor(GraphConstants.DOM.CSS_WHITE_VALUE);
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

		// = Initialize Graph.
		if (!this.graphModelInitialized) {
			this.initializeGraphModel(uidl);

			// = Notify initialization.
			this.client.updateVariable(paintableId, GraphConstants.EVENTS.EVT_GRAPHMODEL_INITIALIZED, Boolean.TRUE, Boolean.TRUE);
		}
	}

	/**
	 * @param pUidl
	 */
	private void initializeGraphModel(final UIDL pUidl) {
		if (pUidl.hasAttribute(GraphConstants.MODEL.GRAPHMODEL_NAME) && !this.graphModelInitialized) {
			final String graphModel = pUidl.getStringAttribute(GraphConstants.MODEL.GRAPHMODEL_NAME);
			final JSONValue jsGraphModel = JSONParser.parseLenient(graphModel);
			final JSONWrapper graphModelWrapper = new JSONWrapper(jsGraphModel);

			// = GraphModel Properties.
			this.singleSelectionSupport = graphModelWrapper.get(GraphConstants.MODEL.ATTR_SINGLE_SELECTION_SUPPORT).booleanValue();

			// = Nodes.
			this.createNodes(graphModelWrapper.get(GraphConstants.MODEL.NODES_NAME));

			// = Relations.
			this.createRelations(graphModelWrapper.get(GraphConstants.MODEL.RELATIONS_NAME));

			this.graphModelInitialized = Boolean.TRUE;
		}
	}

	/**
	 * @param pRelations
	 */
	private void createRelations(final JSONWrapper pRelations) {
		final int quantity = pRelations.size();
		for (int idx = 0; idx < quantity; idx++) {
			final JSONWrapper nodeWrapper = pRelations.get(idx);

			final String fromRef = nodeWrapper.get(GraphConstants.MODEL.ATTR_FROM_REF).stringValue();
			final String toRef = nodeWrapper.get(GraphConstants.MODEL.ATTR_TO_REF).stringValue();
			final String type = nodeWrapper.get(GraphConstants.MODEL.ATTR_RELATION_TYPE).stringValue();

			final Node from = this.getNodeById(fromRef);
			final Node to = this.getNodeById(toRef);
			
			final RelationTypeEnum relationType = RelationTypeEnum.valueOf(type);

			final RelationStyle relationStyle = createRelationStyle(nodeWrapper.get(GraphConstants.MODEL.ATTR_STYLE));
			final Relation relation = new Relation(this, from, to, relationType, relationStyle);
			
			from.addOutgoing(relation);
			to.addIncoming(relation);
		}
	}

	/**
	 * @param pNodes
	 */
	private void createNodes(final JSONWrapper pNodes) {
		final int quantity = pNodes.size();
		for (int idx = 0; idx < quantity; idx++) {
			final JSONWrapper nodeWrapper = pNodes.get(idx);

			// = Mandatory attributes.
			final String id = nodeWrapper.get(GraphConstants.MODEL.ATTR_ID).stringValue();
			final String type = nodeWrapper.get(GraphConstants.MODEL.ATTR_TYPE).stringValue();
			final NodeTypeEnum nodeType = NodeTypeEnum.valueOf(type);
			
			// = Optional attributes.
			final Double posX = nodeWrapper.get(GraphConstants.MODEL.ATTR_X).numberValue();
			final Double posY = nodeWrapper.get(GraphConstants.MODEL.ATTR_Y).numberValue();

			final Boolean enabled = nodeWrapper.get(GraphConstants.MODEL.ATTR_ENABLED).booleanValue();
			final Boolean selected = nodeWrapper.get(GraphConstants.MODEL.ATTR_SELECTED).booleanValue();

			final String label = nodeWrapper.get(GraphConstants.MODEL.ATTR_LABEL).stringValue();

			Node node = null;
			if (posX == null || posY == null) {
				node = new Node(this, id, nodeType);
				
			} else {
				final JSONWrapper styleWrapper = nodeWrapper.get(GraphConstants.MODEL.ATTR_STYLE);
				final NodeStyle nodeStyle = createNodeStyle(styleWrapper);

				node = new Node(this, id, nodeType, nodeStyle, posX, posY);
				node.setEnabled(enabled);
				node.setSelected(selected);
				
				if (label != null && !label.isEmpty()) {
					node.setLabel(label);
				}
			}
			this.nodes.add(node);
		}
		this.updateNodes();
	}
	
	/**
	 * @param nodeType 
	 * @param nodeWrapper
	 * @return
	 */
	private NodeStyle createNodeStyle(JSONWrapper nodeWrapper) {
		DefaultNodeStyle style = new DefaultNodeStyle();

		style.setStyleClassName(nodeWrapper.get(GraphConstants.DOM.NODE_CSS_FIELD_TYPE_CLASSNAME).stringValue());
		style.setEnabledStyleClassName(nodeWrapper.get(GraphConstants.DOM.NODE_CSS_FIELD_ENABLED_CLASSNAME).stringValue());
		style.setDisabledStyleClassName(nodeWrapper.get(GraphConstants.DOM.NODE_CSS_FIELD_DISABLED_CLASSNAME).stringValue());
		style.setLabelStyleClassName(nodeWrapper.get(GraphConstants.DOM.NODE_CSS_FIELD_LABEL_CLASSNAME).stringValue());
		style.setSelectedStyleClassName(nodeWrapper.get(GraphConstants.DOM.NODE_CSS_FIELD_SELECTED_CLASSNAME).stringValue());
		
		return style;
	}
	
	/**
	 * @param pRelationAttributes
	 * @return
	 */
	private RelationStyle createRelationStyle(JSONWrapper pRelationAttributes) {
		final Map<String, String> styleAttributes = new HashMap<String, String>();
		final Set<String> keys = pRelationAttributes.keySet();
		for (String currentKey : keys) {
			styleAttributes.put(currentKey, pRelationAttributes.get(currentKey).getValue().toString());
		}
		return new DefaultRelationStyle(styleAttributes);
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
	 * @return
	 */
	protected Set<Node> getNodes() {
		return this.nodes;
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
