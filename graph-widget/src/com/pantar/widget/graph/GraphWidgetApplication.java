package com.pantar.widget.graph;

import com.pantar.widget.graph.server.GraphModel;
import com.pantar.widget.graph.server.GraphModelFactory;
import com.vaadin.Application;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

/**
 * @author mauro.monti
 * 
 */
public class GraphWidgetApplication extends Application {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1733587095488273477L;

	@Override
	public void init() {
		final VerticalLayout vl = new VerticalLayout();
		vl.setSizeFull();

		final Window mainWindow = new Window("Graph Widget Application");
		mainWindow.setContent(vl);

		final GraphComponent component = new GraphComponent(this.getGraphModel());
		mainWindow.addComponent(component);

		this.setMainWindow(mainWindow);
	}

	private GraphModel getGraphModel() {
		final GraphModel graphModel = GraphModelFactory.getGraphModelInstance();
		return graphModel;
	}
}
