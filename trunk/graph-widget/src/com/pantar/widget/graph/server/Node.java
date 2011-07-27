/**
 * 
 */
package com.pantar.widget.graph.server;

import java.beans.PropertyChangeListener;

import com.pantar.widget.graph.shared.component.Type;
import com.pantar.widget.graph.shared.component.style.NodeStyle;

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
    Type getType();

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
    void setLabel(final String pLabel);

    /**
     * @param pPosX
     * @param pPosY
     */
    void setPosition(final Double pPosX, final Double pPosY);

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
    void setStyle(final NodeStyle pNodeStyle);
    
    /**
     * @param propertyChangeListener
     */
    void addPropertyChangeListener(final PropertyChangeListener propertyChangeListener);

}
