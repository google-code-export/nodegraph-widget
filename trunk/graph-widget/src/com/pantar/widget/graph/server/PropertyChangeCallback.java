/**
 * 
 */
package com.pantar.widget.graph.server;

import java.beans.PropertyChangeEvent;

/**
 * @author mauro.monti
 * 
 */
public interface PropertyChangeCallback {

    /**
     * @param pPropertyName
     * @return
     */
    Boolean evaluatePropertyName(String pPropertyName);

    /**
     * @param propertyChangeEvent
     */
    void onPropertyChange(PropertyChangeEvent propertyChangeEvent);

}
