/**
 * 
 */
package com.pantar.widget.graph;

import java.util.Map;

import com.pantar.widget.graph.server.GraphModel;
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
	 * 
	 */
	private GraphModel graphModel = null;

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

		target.addAttribute("attr", 1);
	}

	/**
	 * Receive and handle events and other variable changes from the client.
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public void changeVariables(final Object source, final Map<String, Object> variables) {
		super.changeVariables(source, variables);
	}

	/**
	 * @return
	 */
	public GraphModel getGraphModel() {
		return this.graphModel;
	}
}
