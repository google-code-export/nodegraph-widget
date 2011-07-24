/**
 * 
 */
package com.pantar.widget.graph.server;

import java.beans.PropertyChangeListener;

import com.pantar.widget.graph.shared.model.RelationTypeEnum;
import com.pantar.widget.graph.shared.model.TypeEnum;

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
    void setRelationType(RelationTypeEnum pRelationTypeEnum);
    
    /**
     * @return
     */
    RelationStyle getStyle();
    
    /**
     * @param pRelationStyle
     */
    void setStyle(RelationStyle pRelationStyle);
    
    /**
     * @param propertyChangeListener
     */
    void addPropertyChangeListener(PropertyChangeListener propertyChangeListener);
}