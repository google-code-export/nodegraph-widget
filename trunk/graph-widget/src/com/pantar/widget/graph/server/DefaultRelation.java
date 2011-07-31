/**
 * 
 */
package com.pantar.widget.graph.server;

import java.beans.PropertyChangeListener;

import com.pantar.widget.graph.server.events.RelationEventType;
import com.pantar.widget.graph.server.events.RelationPropertyChangeSupport;
import com.pantar.widget.graph.server.events.RelationPropertyChangeSupportImpl;

/**
 * @author mauro.monti
 * 
 */
public class DefaultRelation extends AbstractRelation {

    /**
     * 
     */
    private RelationPropertyChangeSupport propertyChangeSupport = new RelationPropertyChangeSupportImpl(this);

    /**
     * 
     */
    public DefaultRelation() {
        super();
    }

    /**
     * @param pId
     */
    public DefaultRelation(String pId) {
        super(pId);
    }

	/**
	 * {@inheritdoc}
	 */
	@Override
	public void setNodeFrom(Node pNode) {
		Node currentNode = this.from;
		if (currentNode != null && currentNode.equals(pNode)) {
			return;
		}
		
		this.from = pNode;
		this.fromRef = pNode.getId();

		this.propertyChangeSupport.firePropertyChange(RelationEventType.FROM, currentNode, this.from);
	}

	/**
	 * {@inheritdoc}
	 */
	@Override
	public void setNodeTo(Node pNode) {
		Node currentNode = this.to;
		if (currentNode != null && currentNode.equals(pNode)) {
			return;
		}
		
		this.to = pNode;
		this.toRef = pNode.getId();

		this.propertyChangeSupport.firePropertyChange(RelationEventType.TO, currentNode, this.to);
	}

	/**
	 * {@inheritdoc}
	 */
	@Override
	public void addPropertyChangeListener(PropertyChangeListener pPropertyChangeListener) {
        this.propertyChangeSupport.addPropertyChangeListener(pPropertyChangeListener);
	}
    
}
