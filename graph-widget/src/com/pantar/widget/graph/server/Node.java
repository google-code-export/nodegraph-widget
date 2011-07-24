/**
 * 
 */
package com.pantar.widget.graph.server;

import java.beans.PropertyChangeListener;

import com.pantar.widget.graph.shared.model.TypeEnum;

/**
 * @author mauro.monti
 * 
 */
public interface Node {

    /**
     * @return
     */
    String getId();

    /**
     * @return
     */
    TypeEnum getType();

    /**
     * @return
     */
    Double getX();

    /**
     * @return
     */
    Double getY();

    /**
     * @return
     */
    Boolean hasLabel();

    /**
     * @return
     */
    String getLabel();

    /**
     * @param pLabel
     * @return
     */
    void setLabel(String pLabel);

    /**
     * @param pPosX
     * @param pPosY
     */
    void setPosition(Double pPosX, Double pPosY);

    /**
     * @return
     */
    Boolean isSelected();

    /**
     * 
     */
    void select();
    
    /**
     * 
     */
    void unselect();

    /**
     * @return
     */
    Boolean isEnabled();

    /**
     * 
     */
    void enable();

    /**
     * 
     */
    void disable();

    /**
     * @return
     */
    NodeStyle getStyle();
    
    /**
     * @param pNodeStyle
     */
    void setStyle(NodeStyle pNodeStyle);
    
    /**
     * @param propertyChangeListener
     */
    void addPropertyChangeListener(PropertyChangeListener propertyChangeListener);

}
