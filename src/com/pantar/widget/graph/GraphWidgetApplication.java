package com.pantar.widget.graph;

import java.beans.PropertyChangeEvent;

import com.pantar.widget.graph.server.DefaultNode;
import com.pantar.widget.graph.server.GraphComponent;
import com.pantar.widget.graph.server.GraphModel;
import com.pantar.widget.graph.server.Node;
import com.pantar.widget.graph.server.elements.BeginNode;
import com.pantar.widget.graph.server.elements.EndNode;
import com.pantar.widget.graph.server.elements.ProcessCreationNode;
import com.pantar.widget.graph.server.elements.SplitNode;
import com.pantar.widget.graph.server.events.EventType;
import com.pantar.widget.graph.server.events.GraphModelEventType;
import com.pantar.widget.graph.server.events.NodeEventType;
import com.pantar.widget.graph.server.events.PropertyChangeCallback;
import com.pantar.widget.graph.server.factories.GraphModelFactory;
import com.pantar.widget.graph.server.layouts.GraphModelRandomLayout;
import com.pantar.widget.graph.server.styles.DefaultRelationStyle;
import com.pantar.widget.graph.server.styles.RelationStyle;
import com.pantar.widget.graph.shared.GraphConstants;
import com.pantar.widget.graph.shared.component.RelationTypeEnum;
import com.vaadin.Application;
import com.vaadin.terminal.Sizeable;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
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

	/**
	 * {@inheritdoc}
	 */
	@Override
	public void init() {
		// Add a horizontal SplitPanel to the lower area
        final HorizontalSplitPanel horizontalSplitPanel = new HorizontalSplitPanel();
        horizontalSplitPanel.setSplitPosition(150, Sizeable.UNITS_PIXELS);
        horizontalSplitPanel.setSizeFull();

        final Window mainWindow = new Window("NodeGraph Widget Application");
        
        final Button openWindow = new Button("Open diagram");
        openWindow.addListener(new Button.ClickListener() {
        	
			/**
			 * 
			 */
			private static final long serialVersionUID = -1522261898787739587L;

			/**
			 * {@inheritdoc}
			 */
			@Override
			public void buttonClick(ClickEvent event) {
				final Window subwindow = new Window("Node Graph Widget");
				subwindow.setWidth("850px");
				subwindow.setHeight("500px");
				subwindow.setModal(true);
				
				final VerticalLayout layout = (VerticalLayout) subwindow.getContent();
				layout.setMargin(true);
				layout.setSpacing(true);
				layout.setSizeFull();
				
				final GraphComponent nodeGraphWidget = getNodeGraph();		
				layout.addComponent(nodeGraphWidget);
				
				mainWindow.addWindow(subwindow);
			}
		});
        
        final HorizontalLayout hl = new HorizontalLayout();
        hl.setSizeFull();
        
        horizontalSplitPanel.setFirstComponent(openWindow);
        horizontalSplitPanel.setSecondComponent(hl);
        
		mainWindow.setContent(horizontalSplitPanel);
		mainWindow.setSizeFull();

		this.setMainWindow(mainWindow);
	}

	/**
	 * @return
	 */
	private static GraphComponent getNodeGraph() {
		// = Retrive the model.
		final GraphModel graphModel = getGraphModel();
		
		final EventType[] eventTypes = { NodeEventType.SELECTED, NodeEventType.POSITION, GraphModelEventType.INITIALIZED };

		// = Register on some events.
		graphModel.registerCallbacks(eventTypes, new PropertyChangeCallback() {
			
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

		// = Apply some "intelligent" layout to the nodes.
		graphModel.layout(new GraphModelRandomLayout());
		
		// = Create the component.
		final GraphComponent component = new GraphComponent(graphModel);
		component.setSizeFull();

		return component;
	}

	/**
	 * @return
	 */
	private static GraphModel getGraphModel() {
		// = Create the model.
		final GraphModel graphModel = GraphModelFactory.getGraphModelInstance();
		
		// = Support for single click to select nodes.
		graphModel.setSingleSelectionSupport(Boolean.TRUE);
		
		// = Create some nodes.
		Node begin = new BeginNode();
		
		Node splitNode = new SplitNode();
		
		Node nodeA = new DefaultNode();
		nodeA.setLabel("NodeA");
		
		Node nodeB = new DefaultNode();
		nodeB.setLabel("NodeB");
	
		Node processCreation = new ProcessCreationNode();
		processCreation.setLabel("Process");
	
		Node end = new EndNode();
		
		// = Nodes meet nodes!.
		final RelationStyle dashedBlue = new DefaultRelationStyle(GraphConstants.DOM.CSS_BLUE_VALUE, 2);
		dashedBlue.setDashedStroke(5, 5);
		
		final RelationStyle straightRed = new DefaultRelationStyle();
		straightRed.strokeColor(GraphConstants.DOM.CSS_RED_VALUE).strokeWidth(3);
		
		final RelationStyle defaultNormalBlack = new DefaultRelationStyle();
		
		// = Tie all the stuff.
		graphModel.connect(begin, splitNode, straightRed);
		graphModel.connect(splitNode, nodeA, dashedBlue);
		graphModel.connect(splitNode, nodeB, defaultNormalBlack);
		graphModel.connect(nodeA, end, RelationTypeEnum.BEZIER);
		graphModel.connect(nodeB, processCreation, RelationTypeEnum.BEZIER, new DefaultRelationStyle().strokeColor(GraphConstants.DOM.CSS_GREEN_VALUE));
		graphModel.connect(processCreation, end, RelationTypeEnum.LINE);
		
		return graphModel;
	}

}
