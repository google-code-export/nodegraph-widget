/**
 * 
 */
package com.pantar.widget.graph.server.events;

import java.beans.PropertyChangeEvent;

/**
 * @author mauro.monti
 * 
 */
public interface PropertyChangeCallback {

    /**
     * @param propertyChangeEvent
     */
    void onPropertyChange(final PropertyChangeEvent propertyChangeEvent);

}
