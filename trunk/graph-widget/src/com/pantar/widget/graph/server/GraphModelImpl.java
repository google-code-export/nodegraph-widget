/**
 * 
 */
package com.pantar.widget.graph.server;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.pantar.widget.graph.server.events.EventType;
import com.pantar.widget.graph.server.events.GraphModelEventType;
import com.pantar.widget.graph.server.events.GraphModelPropertyChangeSupport;
import com.pantar.widget.graph.server.events.GraphModelPropertyChangeSupportImpl;
import com.pantar.widget.graph.server.events.PropertyChangeCallback;
import com.pantar.widget.graph.server.layout.GraphModelLayout;
import com.pantar.widget.graph.server.styles.RelationStyle;
import com.pantar.widget.graph.shared.component.RelationTypeEnum;

/**
 * @author mauro.monti
 * 
 */
public class GraphModelImpl implements GraphModel, PropertyChangeListener {

	/**
	 * 
	 */
	private final GraphModelPropertyChangeSupport propertyChangeSupport = new GraphModelPropertyChangeSupportImpl(this);

    /**
     * 
     */
	private final Map<String, Set<PropertyChangeCallback>> registeredCallbacks = new HashMap<String, Set<PropertyChangeCallback>>();
    
    /**
     * 
     */
    protected final Set<Node> nodes = new HashSet<Node>();
    
    /**
     * 
     */
    protected final Set<Relation> relations = new HashSet<Relation>();

    /**
     * 
     */
    protected boolean singleSelectionSupport = Boolean.FALSE;
    
    /**
     * 
     */
    protected boolean initialized = Boolean.FALSE;
	
    /**
     * 
     */
    public GraphModelImpl() {
    	this.addPropertyChangeListener(this);
	}
    
    /**
	 * {@inheritdoc}
	 */
	@Override
	public void addNode(Node pNode) {
		pNode.addPropertyChangeListener(this);
		((AbstractNode) pNode).graphModel = this;
		
		this.nodes.add(pNode);
	}

	/**
	 * {@inheritdoc}
	 */
	@Override
	public void addRelation(Relation pRelation) {
		pRelation.addPropertyChangeListener(this);
		this.relations.add(pRelation);
	}

	/**
	 * {@inheritdoc}
	 */
	@Override
	public void connect(Node pFrom, Node pTo) {
		connect(pFrom, pTo, new DefaultRelation());
	}

	/**
	 * {@inheritdoc}
	 */
	@Override
	public void connect(Node pFrom, Node pTo, Relation pRelation) {
		if (!this.nodes.contains(pFrom)) {
            this.addNode(pFrom);
        }
        
		if (!this.nodes.contains(pTo)) {
            this.addNode(pTo);
        }

		pRelation.setNodeFrom(pFrom);
		pRelation.setNodeTo(pTo);

        this.addRelation(pRelation);		
	}
	
	/**
	 * {@inheritdoc}
	 */
	@Override
	public void connect(Node pFrom, Node pTo, RelationStyle pRelationStyle) {
		final Relation defaultRelation = new DefaultRelation();
		defaultRelation.setStyle(pRelationStyle);
		
		connect(pFrom, pTo, defaultRelation);
	}
	
	/**
	 * {@inheritdoc}
	 */
	@Override
	public void connect(Node pFrom, Node pTo, RelationTypeEnum pRelationTypeEnum) {
		final Relation defaultRelation = new DefaultRelation();
		defaultRelation.setRelationType(pRelationTypeEnum);
		
		connect(pFrom, pTo, defaultRelation);
	}
	
	/**
	 * {@inheritdoc}
	 */
	@Override
	public void connect(Node pFrom, Node pTo, RelationTypeEnum pRelationTypeEnum, RelationStyle pRelationStyle) {
		final Relation defaultRelation = new DefaultRelation();
		defaultRelation.setStyle(pRelationStyle);
		defaultRelation.setRelationType(pRelationTypeEnum);
		
		connect(pFrom, pTo, defaultRelation);
	}
	
	/**
	 * {@inheritdoc}
	 */
	@Override
	public Node getNodeById(String pId) {
		for (Node currentNode : this.nodes) {
			if (currentNode.getId().equals(pId))  {
				return currentNode;
			}
		}
		return null;
	}

	/**
	 * {@inheritdoc}
	 */
	@Override
	public Set<Node> getNodes() {
		return this.nodes;
	}

	/**
	 * {@inheritdoc}
	 */
	@Override
	public Set<Relation> getRelations() {
		return this.relations;
	}

	/**
	 * {@inheritdoc}
	 */
	@Override
	public void reset() {
		for (final Node currentNode : this.nodes) {
			final AbstractNode abstractNode = (AbstractNode) currentNode;

			abstractNode.setEnabled(Boolean.TRUE);
			abstractNode.setSelected(Boolean.FALSE);
		}
	}

	/**
	 * {@inheritdoc}
	 */
	@Override
	public void unselectAllNodes() {
		for (final Node currentNode : this.nodes) {
			final AbstractNode abstractNode = (AbstractNode) currentNode;
			abstractNode.setSelected(Boolean.FALSE);
		}
	}
	
	/**
	 * {@inheritdoc}
	 */
	@Override
	public void disableAllNodes() {
		for (final Node currentNode : this.nodes) {
			final AbstractNode abstractNode = (AbstractNode) currentNode;
			abstractNode.setEnabled(Boolean.FALSE);
		}
	}
	
	/**
	 * {@inheritdoc}
	 */
	@Override
	public void setSingleSelectionSupport(final Boolean pSingleSelectionSupport) {
		this.singleSelectionSupport = pSingleSelectionSupport;
	}
	
	/**
	 * {@inheritdoc}
	 */
	@Override
	public Boolean isSingleSelectionSupport() {
		return this.singleSelectionSupport;
	}
	
	/**
	 * {@inheritdoc}
	 */
	@Override
	public void registerCallback(final EventType eventType, final PropertyChangeCallback pCallback) {
		String type = eventType.getType();
		
		Set<PropertyChangeCallback> storedCallbacks = this.registeredCallbacks.get(type);
		if (storedCallbacks == null) {
			storedCallbacks = new HashSet<PropertyChangeCallback>();
		}
		storedCallbacks.add(pCallback);
		
		this.registeredCallbacks.put(type, storedCallbacks);
	}

	/**
	 * {@inheritdoc}
	 */
	@Override
	public void registerCallbacks(final EventType[] eventType, final PropertyChangeCallback pCallback) {
		for (int idx = 0; idx < eventType.length; idx++) {
			final EventType currentEventType = eventType[idx];
			
			this.registerCallback(currentEventType, pCallback);
		}
	}
	
	/**
	 * {@inheritdoc}
	 */
	@Override
	public void propertyChange(final PropertyChangeEvent pPropertyChangeEvent) {
		final String propertyName = pPropertyChangeEvent.getPropertyName();
		final Set<PropertyChangeCallback> callbacks = this.registeredCallbacks.get(propertyName);
		if (callbacks != null) {
			for (PropertyChangeCallback currentCallbak : callbacks) {
				currentCallbak.onPropertyChange(pPropertyChangeEvent);
			}
		}
	}
	
	/**
	 * {@inheritdoc}
	 */
	@Override
	public Boolean isInitialized() {
		return this.initialized;
	}
	
	/**
	 * Change the initialized state and fires the notification change.
	 */
	protected void initialize() {
		final Boolean currentValue = this.initialized;
		this.initialized = Boolean.TRUE;

		this.propertyChangeSupport.firePropertyChange(GraphModelEventType.INITIALIZED, currentValue, this.initialized);
	}
	
	/**
	 * {@inheritdoc}
	 */
	@Override
	public void layout(final GraphModelLayout pLayout) {
		pLayout.layout(this);
	}
	
	/**
	 * {@inheritdoc}
	 */
	@Override
	public void addPropertyChangeListener(PropertyChangeListener pPropertyChangeListener) {
		this.propertyChangeSupport.addPropertyChangeListener(pPropertyChangeListener);
	}
	
}