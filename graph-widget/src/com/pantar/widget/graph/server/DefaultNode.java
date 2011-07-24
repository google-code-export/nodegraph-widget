/**
 * 
 */
package com.pantar.widget.graph.server;

import java.beans.PropertyChangeListener;

import com.pantar.widget.graph.server.events.NodeEventType;
import com.pantar.widget.graph.server.events.NodePropertyChangeSupport;
import com.pantar.widget.graph.server.events.NodePropertyChangeSupportImpl;

/**
 * @author mauro.monti
 * 
 */
public class DefaultNode extends AbstractNode {

    /**
     * 
     */
    private NodePropertyChangeSupport propertyChangeSupport = new NodePropertyChangeSupportImpl(this);

    /**
     * 
     */
    public DefaultNode() {
        super();
    }

    /**
     * @param pId
     */
    public DefaultNode(String pId) {
        super(pId);
    }

	/**
	 * {@inheritdoc}
	 */
	@Override
	public void setPosition(Double pPosX, Double pPosY) {
		Double oldX = this.getX();
        Double oldY = this.getY();

        if ((oldX != null && oldX.equals(pPosX)) && (oldX != null && oldY.equals(pPosY))) {
            return;
        }

        this.x = pPosX;
        this.y = pPosY;

        Double[] oldPoints = { oldX, oldY };
        Double[] newPoints = { this.getX(), this.getY() };

        this.propertyChangeSupport.firePropertyChange(NodeEventType.POSITION, oldPoints, newPoints);
	}

	/**
	 * {@inheritdoc}
	 */
	@Override
	public void setLabel(String pLabel) {
		final String currentLabel = this.getLabel();
        if (currentLabel != null && currentLabel.equals(label)) {
            return;
        }
        
        this.label = pLabel;
        this.propertyChangeSupport.firePropertyChange(NodeEventType.LABEL, currentLabel, this.getLabel());	
	}
	
	/**
	 * {@inheritdoc}
	 */
	@Override
	public void enable() {
		final Boolean currentState = this.isEnabled();
		this.enabled = Boolean.TRUE;
		
		if (currentState.equals(this.isEnabled())) {
			return;
		}
		
		this.propertyChangeSupport.firePropertyChange(NodeEventType.ENABLED, currentState, this.isEnabled());
	}
	
	/**
	 * {@inheritdoc}
	 */
	@Override
	public void disable() {
		final Boolean currentState = this.isEnabled();
		this.enabled = Boolean.FALSE;
		
		if (currentState.equals(this.isEnabled())) {
			return;
		}
		
		this.propertyChangeSupport.firePropertyChange(NodeEventType.DISABLED, currentState, this.isEnabled());
	}
	
	/**
	 * {@inheritdoc}
	 */
	@Override
	public void select() {
		final Boolean currentState = this.isSelected();
		
		this.graphModel.reset();
		this.selected = Boolean.TRUE;
		
		if (currentState.equals(this.isSelected())) {
			return;
		}
		
		this.propertyChangeSupport.firePropertyChange(NodeEventType.SELECTED, currentState, this.isSelected());
	}
	
	/**
	 * {@inheritdoc}
	 */
	@Override
	public void unselect() {
		final Boolean currentState = this.isSelected();
		this.selected = Boolean.FALSE;
		
		if (currentState.equals(this.isSelected())) {
			return;
		}
		
		this.propertyChangeSupport.firePropertyChange(NodeEventType.UNSELECTED, currentState, this.isSelected());
	}
	
	/**
	 * {@inheritdoc}
	 */
	@Override
	public void addPropertyChangeListener(PropertyChangeListener pPropertyChangeListener) {
		this.propertyChangeSupport.addPropertyChangeListener(pPropertyChangeListener);
	}

}
