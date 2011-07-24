package com.pantar.widget.graph;

import java.beans.PropertyChangeEvent;

import com.pantar.widget.graph.server.DefaultNode;
import com.pantar.widget.graph.server.DefaultRelationStyle;
import com.pantar.widget.graph.server.EndGraphNode;
import com.pantar.widget.graph.server.GraphModel;
import com.pantar.widget.graph.server.Node;
import com.pantar.widget.graph.server.RelationStyle;
import com.pantar.widget.graph.server.StartGraphNode;
import com.pantar.widget.graph.server.events.NodeEventType;
import com.pantar.widget.graph.server.events.PropertyChangeCallback;
import com.pantar.widget.graph.server.factories.GraphModelFactory;
import com.pantar.widget.graph.server.layout.GraphModelRandomLayout;
import com.pantar.widget.graph.shared.GraphConstants;
import com.pantar.widget.graph.shared.model.RelationTypeEnum;
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
		
		GraphModel graphModel = this.getGraphModel();
		graphModel.registerCallback(NodeEventType.POSITION, new PropertyChangeCallback() {
			@Override
			public void onPropertyChange(PropertyChangeEvent propertyChangeEvent) {
				System.out.println("Property=" + propertyChangeEvent.getPropertyName());
				System.out.println("New Value:" + propertyChangeEvent.getNewValue());
				System.out.println("Old Value:" + propertyChangeEvent.getOldValue());
			}
		});
		graphModel.layout(new GraphModelRandomLayout());
		
		final GraphComponent component = new GraphComponent(graphModel);
		mainWindow.addComponent(component);

		this.setMainWindow(mainWindow);
	}

	private GraphModel getGraphModel() {
		final GraphModel graphModel = GraphModelFactory.getGraphModelInstance();
		graphModel.setSingleSelectionSupport(Boolean.TRUE);
		
		Node start = new StartGraphNode();
		start.setPosition(0D, 0D);
	
		Node nodeA = new DefaultNode();
		nodeA.setPosition(100D, 100D);
		nodeA.setLabel("NodeA");
		
		Node nodeB = new DefaultNode();
		nodeB.setPosition(200D, 200D);
		nodeB.setLabel("NodeB");

		Node end = new EndGraphNode();
		start.setPosition(300D, 150D);
		
		RelationStyle dashedBlue = new DefaultRelationStyle(GraphConstants.DOM.CSS_BLUE_VALUE, 2);
		dashedBlue.setDashedStroke(5, 5);
		
		graphModel.connect(start, nodeA, new DefaultRelationStyle(GraphConstants.DOM.CSS_RED_VALUE, 2));
		graphModel.connect(nodeA, nodeB, RelationTypeEnum.BEZIER, dashedBlue);
		graphModel.connect(nodeB, end, RelationTypeEnum.BEZIER);
		
		return graphModel;
	}
}
