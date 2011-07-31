/**
 * 
 */
package com.pantar.widget.graph.server;

import java.beans.PropertyChangeListener;

import com.pantar.widget.graph.server.styles.RelationStyle;
import com.pantar.widget.graph.shared.component.RelationTypeEnum;

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
     * @param pNode
     */
    void setNodeFrom(final Node pNode);

    /**
     * @param pNode
     */
    void setNodeTo(final Node pNode);
    
    /**
     * @return
     */
    String getToRef();
    
    /**
     * @return
     */
    Node getNodeFrom();

    /**
     * @return
     */
    String getFromRef();
    
    /**
     * @return
     */
    Node getNodeTo();

    /**
     * @return
     */
    RelationTypeEnum getRelationType();
    
    /**
     * @param pRelationTypeEnum
     */
    void setRelationType(final RelationTypeEnum pRelationTypeEnum);
    
    /**
     * @return
     */
    RelationStyle getStyle();
    
    /**
     * @param pRelationStyle
     */
    void setStyle(final RelationStyle pRelationStyle);
    
    /**
     * @param propertyChangeListener
     */
    void addPropertyChangeListener(final PropertyChangeListener propertyChangeListener);
}