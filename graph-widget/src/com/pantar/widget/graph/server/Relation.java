/**
 * 
 */
package com.pantar.widget.graph.server;

import java.beans.PropertyChangeListener;

/**
 * @author mauro.monti
 * 
 */
public interface Relation {

    /**
     * @return
     */
    String getId();

    /**
     * @return
     */
    TypeEnum getType();

    /**
     * @param pNode
     */
    void setNodeFrom(Node pNode);

    /**
     * @param pNode
     */
    void setNodeTo(Node pNode);

    /**
     * @return
     */
    Node getNodeFrom();

    /**
     * @return
     */
    Node getNodeTo();

    /**
     * @param propertyChangeListener
     */
    void addPropertyChangeListener(PropertyChangeListener propertyChangeListener);
}