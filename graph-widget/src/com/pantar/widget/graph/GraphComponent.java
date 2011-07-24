/**
 * 
 */
package com.pantar.widget.graph;

import java.util.Map;

import com.pantar.widget.graph.server.GraphModel;
import com.pantar.widget.graph.server.Node;
import com.pantar.widget.graph.shared.GraphConstants;
import com.vaadin.terminal.PaintException;
import com.vaadin.terminal.PaintTarget;
import com.vaadin.ui.AbstractComponent;

import flexjson.JSONSerializer;

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
	 * Indicates if the graph model was initialized.
	 */
	private Boolean graphModelInitialized = Boolean.FALSE;

	/**
	 * Serializer. 
	 */
	private JSONSerializer jsonSerializer = new JSONSerializer();
	
	/**
	 * Default Constructor.
	 */
	public GraphComponent(final GraphModel pGraphModel) {
		this.setSizeFull();
		this.graphModel = pGraphModel;
	}

	@Override
	public void paintContent(final PaintTarget target) throws PaintException {
		super.paintContent(target);

		if (!this.graphModelInitialized) {
			String jsonGraphModel = jsonSerializer.exclude("*.class").deepSerialize(this.graphModel);
			target.addAttribute(GraphConstants.MODEL.GRAPHMODEL_NAME, jsonGraphModel);
			
			this.graphModelInitialized = Boolean.TRUE;
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
	public void changeVariables(final Object source, final Map<String, Object> variables) {
		super.changeVariables(source, variables);
		
		Map<String, Object> changes = (Map<String, Object>) variables.get(GraphConstants.MODEL.ATTRIBUTES_NAME);
		String id = (String) changes.get(GraphConstants.MODEL.ATTR_ID);
		Double x = (Double) changes.get(GraphConstants.MODEL.ATTR_X);
		Double y = (Double) changes.get(GraphConstants.MODEL.ATTR_Y);
		Boolean selected = (Boolean) changes.get(GraphConstants.MODEL.ATTR_SELECTED);
		String label = (String) changes.get(GraphConstants.MODEL.ATTR_LABEL);
		
		Node currentNode = this.graphModel.getNodeById(id);
		if (currentNode != null) {
			if (selected != null) {
				if (selected) {
					currentNode.select();
				} else {
					currentNode.unselect();
				}
			}
			
			if (x != null && y != null) {
				currentNode.setPosition(x, y);
			}
			
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
