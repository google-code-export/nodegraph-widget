package com.pantar.widget.graph;

import java.beans.PropertyChangeEvent;

import com.pantar.widget.graph.server.CustomNode;
import com.pantar.widget.graph.server.DefaultNode;
import com.pantar.widget.graph.server.GraphComponent;
import com.pantar.widget.graph.server.GraphModel;
import com.pantar.widget.graph.server.Node;
import com.pantar.widget.graph.server.RelationStyle;
import com.pantar.widget.graph.server.events.EventType;
import com.pantar.widget.graph.server.events.GraphModelEventType;
import com.pantar.widget.graph.server.events.NodeEventType;
import com.pantar.widget.graph.server.events.PropertyChangeCallback;
import com.pantar.widget.graph.server.factories.GraphModelFactory;
import com.pantar.widget.graph.server.layout.GraphModelRandomLayout;
import com.pantar.widget.graph.server.style.DefaultRelationStyle;
import com.pantar.widget.graph.shared.GraphConstants;
import com.pantar.widget.graph.shared.component.RelationTypeEnum;
import com.vaadin.Application;
import com.vaadin.ui.HorizontalLayout;
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
		HorizontalLayout hl = new HorizontalLayout();
		hl.setSizeFull();
		final Window mainWindow = new Window("Graph Widget Application");
		mainWindow.setContent(hl);
		
		GraphModel graphModel = this.getGraphModel();
		
		EventType[] eventTypes = { NodeEventType.POSITION, GraphModelEventType.INITIALIZED };
		graphModel.registerCallback(eventTypes, new PropertyChangeCallback() {
			
			/**
			 * {@inheritdoc}
			 */
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
		mainWindow.setSizeFull();

		this.setMainWindow(mainWindow);
	}

	private GraphModel getGraphModel() {
		final GraphModel graphModel = GraphModelFactory.getGraphModelInstance();
		graphModel.setSingleSelectionSupport(Boolean.TRUE);
		
		Node start = new DefaultNode();
		start.setPosition(0D, 0D);
	
		Node nodeA = new DefaultNode();
		nodeA.setPosition(100D, 100D);
		nodeA.setLabel("NodeA");
		
		Node nodeB = new DefaultNode();
		nodeB.setPosition(200D, 200D);
		nodeB.setLabel("NodeB");
	
		Node end = new DefaultNode();
		start.setPosition(300D, 150D);

		Node cn = new CustomNode();
		
		RelationStyle dashedBlue = new DefaultRelationStyle(GraphConstants.DOM.CSS_BLUE_VALUE, 2);
		dashedBlue.setDashedStroke(5, 5);
		
		graphModel.connect(start, nodeA, new DefaultRelationStyle(GraphConstants.DOM.CSS_RED_VALUE, 2));
		graphModel.connect(nodeA, nodeB, RelationTypeEnum.BEZIER, dashedBlue);
		graphModel.connect(nodeB, end, RelationTypeEnum.LINE);
		graphModel.connect(nodeB, cn, RelationTypeEnum.LINE);
		
		return graphModel;
	}

}
