/**
 * 
 */
package com.pantar.widget.graph.server;

import java.util.Arrays;
import java.util.Map;

import com.pantar.widget.graph.server.serializer.DefaultJSONProvider;
import com.pantar.widget.graph.server.serializer.JSONProvider;
import com.pantar.widget.graph.shared.GraphConstants;
import com.vaadin.terminal.PaintException;
import com.vaadin.terminal.PaintTarget;
import com.vaadin.ui.AbstractComponent;

/**
 * Server side component for the VGraphComponent widget.
 * 
 * @author mauro.monti
 */
@com.vaadin.ui.ClientWidget(com.pantar.widget.graph.client.ui.VGraphComponent.class)
public class GraphComponent extends AbstractComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5013185850896397113L;

	/**
	 * GraphModel.
	 */
	private GraphModel graphModel = null;

	/**
	 * Serializer. 
	 */
	private JSONProvider provider;
	
	/**
	 * Default Constructor.
	 */
	public GraphComponent(final GraphModel pGraphModel) {
		this.graphModel = pGraphModel;
		this.provider = new DefaultJSONProvider();
		
		String[] exclusionList = { "*.class", "*.nodeFrom", "*.nodeTo" };
		for (String expression : Arrays.asList(exclusionList)) {
			this.provider.addExclusion(expression);
		}
	}

	/**
	 * {@inheritdoc}
	 */
	@Override
	public void paintContent(final PaintTarget pTarget) throws PaintException {
		super.paintContent(pTarget);

		if (!this.graphModel.isInitialized()) {
			final String graphModel = this.provider.serialize(this.graphModel);
			pTarget.addAttribute(GraphConstants.MODEL.GRAPHMODEL_NAME, graphModel);
		} else {
			// = Update the Graph Model.
			
		}
	}
	
	/**
	 * Receive and handle events and other variable changes from the client.
	 * 
	 * {@inheritDoc}
	 */
	@Override
	@SuppressWarnings("unchecked")
	public void changeVariables(final Object source, final Map<String, Object> variables) {
		super.changeVariables(source, variables);

		// = Obtain the model reference to update.
		final GraphModelImpl implementation = ((GraphModelImpl) this.graphModel);
		
		// = GraphModel Initialized Event.
		if (variables.containsKey(GraphConstants.EVENTS.EVT_GRAPHMODEL_INITIALIZED)) {
			implementation.initialize();
		}

		// = GraphModel Attributes Changed.		
		if (variables.containsKey(GraphConstants.EVENTS.EVT_GRAPHMODEL_ATTR_CHANGED)) {
			final Map<String, Object> attributesChanges = (Map<String, Object>) variables.get(GraphConstants.EVENTS.EVT_GRAPHMODEL_ATTR_CHANGED);
			final String id = (String) attributesChanges.get(GraphConstants.MODEL.ATTR_ID);
			
			final Double x = (Double) attributesChanges.get(GraphConstants.MODEL.ATTR_X);
			final Double y = (Double) attributesChanges.get(GraphConstants.MODEL.ATTR_Y);
			
			final Boolean selected = (Boolean) attributesChanges.get(GraphConstants.MODEL.ATTR_SELECTED);
			final String label = (String) attributesChanges.get(GraphConstants.MODEL.ATTR_LABEL);
					
			final Node currentNode = implementation.getNodeById(id);
			if (currentNode == null) {
				return;
			}
			
			// = Set node selection.
			if (selected != null) {
				if (selected) currentNode.select();
				else currentNode.unselect();
			}
			// = Set new position.				
			if (x != null && y != null) {
				currentNode.setPosition(x, y);
			}
			// = Set label.
			if (label != null) {
				currentNode.setLabel(label);
			}
		}
	}

	/**
	 * @return
	 */
	public GraphModel getGraphModel() {
		return this.graphModel;
	}
}
