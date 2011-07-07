/**
 * 
 */
package com.pantar.widget.graph.server;

import java.beans.PropertyChangeListener;

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
    String getLabel();

    /**
     * @param pLabel
     * @return
     */
    void setLabel(String pLabel);

    /**
     * @return
     */
    Boolean hasLabel();

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
     * @param pSelected
     */
    void setSelected(Boolean pSelected);

    /**
     * @param propertyChangeListener
     */
    void addPropertyChangeListener(PropertyChangeListener propertyChangeListener);
}
