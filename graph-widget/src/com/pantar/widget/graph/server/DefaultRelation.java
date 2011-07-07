/**
 * 
 */
package com.pantar.widget.graph.server;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * @author mauro.monti
 * 
 */
public class DefaultRelation extends AbstractRelation {

    /**
     * 
     */
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

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

    @Override
    public void setNodeFrom(Node from) {
        Node oldFrom = this.getFrom();
        if (oldFrom != null && oldFrom.equals(from)) {
            return;
        }
        this.setFrom(from);
        this.setFromRef(from.getId());
        this.propertyChangeSupport.firePropertyChange("from", oldFrom, this.getFrom());
    }

    @Override
    public void setNodeTo(Node to) {
        Node oldTo = this.getTo();
        if (oldTo != null && oldTo.equals(to)) {
            return;
        }
        this.setTo(to);
        this.setToRef(to.getId());
        this.propertyChangeSupport.firePropertyChange("to", oldTo, this.getTo());
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        this.propertyChangeSupport.addPropertyChangeListener(propertyChangeListener);
    }
}
