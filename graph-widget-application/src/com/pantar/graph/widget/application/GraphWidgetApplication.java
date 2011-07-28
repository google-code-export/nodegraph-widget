package com.pantar.graph.widget.application;

import java.beans.PropertyChangeEvent;

import com.pantar.graph.widget.customs.ConsoleNode;
import com.pantar.widget.graph.server.CustomNode;
import com.pantar.widget.graph.server.GraphComponent;
import com.pantar.widget.graph.server.GraphModel;
import com.pantar.widget.graph.server.Node;
import com.pantar.widget.graph.server.elements.BeginNode;
import com.pantar.widget.graph.server.elements.EndNode;
import com.pantar.widget.graph.server.elements.SplitNode;
import com.pantar.widget.graph.server.events.EventType;
import com.pantar.widget.graph.server.events.GraphModelEventType;
import com.pantar.widget.graph.server.events.NodeEventType;
import com.pantar.widget.graph.server.events.PropertyChangeCallback;
import com.pantar.widget.graph.server.factories.GraphModelFactory;
import com.pantar.widget.graph.server.layout.GraphModelRandomLayout;
import com.pantar.widget.graph.server.styles.DefaultRelationStyle;
import com.pantar.widget.graph.server.styles.RelationStyle;
import com.pantar.widget.graph.shared.GraphConstants;
import com.pantar.widget.graph.shared.component.RelationTypeEnum;
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
	private static final long serialVersionUID = 6589069304591155681L;

	/**
	 * {@inheritdoc}
	 */
	@Override
	public void init() {
		setTheme("mytheme");

		final VerticalLayout vl = new VerticalLayout();
		vl.setSizeFull();

		final Window mainWindow = new Window("NodeGraph Widget Application");
		mainWindow.setContent(vl);

		final GraphComponent component = GraphWidgetApplication
				.getNodeGraphComponent();
		mainWindow.addComponent(component);

		this.setMainWindow(mainWindow);
	}

	/**
	 * @return
	 */
	private static GraphComponent getNodeGraphComponent() {
		// = Retrive the model.
		final GraphModel graphModel = GraphWidgetApplication.getGraphModel();
		final EventType[] eventTypes = { NodeEventType.SELECTED,
				NodeEventType.POSITION, GraphModelEventType.INITIALIZED };

		// = Register on some events.
		graphModel.registerCallbacks(eventTypes, new PropertyChangeCallback() {

			/**
			 * {@inheritdoc}
			 */
			@Override
			public void onPropertyChange(PropertyChangeEvent propertyChangeEvent) {
				System.out.println("Property="
						+ propertyChangeEvent.getPropertyName());
				System.out.println("New Value:"
						+ propertyChangeEvent.getNewValue());
				System.out.println("Old Value:"
						+ propertyChangeEvent.getOldValue());
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

		Node customNodeConsole = new ConsoleNode();
		Node customNodeFolderMail = new CustomNode("folde-icon-id",
				"folder-mail");

		Node end = new EndNode();

		// = Nodes meet nodes!.
		final RelationStyle dashedBlue = new DefaultRelationStyle(
				GraphConstants.DOM.CSS_BLUE_VALUE, 2);
		dashedBlue.setDashedStroke(5, 5);

		final RelationStyle straightRed = new DefaultRelationStyle();
		straightRed.strokeColor(GraphConstants.DOM.CSS_RED_VALUE)
				.strokeWidth(3);

		final RelationStyle defaultNormalBlack = new DefaultRelationStyle();

		// = Tie all the stuff.
		graphModel.connect(begin, splitNode, straightRed);
		graphModel.connect(splitNode, customNodeConsole, dashedBlue);
		graphModel.connect(splitNode, end, defaultNormalBlack);
		graphModel.connect(customNodeConsole, customNodeFolderMail,
				RelationTypeEnum.BEZIER);

		// = Self connection.
		graphModel.connect(customNodeConsole, customNodeConsole);

		graphModel.connect(customNodeFolderMail, end, RelationTypeEnum.BEZIER,
				new DefaultRelationStyle()
						.strokeColor(GraphConstants.DOM.CSS_GREEN_VALUE));
		return graphModel;
	}
}
