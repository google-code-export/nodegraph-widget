/**
 * 
 */
package com.pantar.widget.graph.server.events;

import java.beans.PropertyChangeListener;

/**
 * @author mauro.monti
 *
 */
public interface GraphModelPropertyChangeSupport {

	/**
	 * @param pEventType
	 * @param pOldValue
	 * @param pNewValue
	 */
	void firePropertyChange(EventType pEventType, Boolean pOldValue, Boolean pNewValue);
	
	/**
	 * @param pEventType
	 * @param pOldValue
	 * @param pNewValue
	 */
	void firePropertyChange(EventType pEventType, String pOldValue, String pNewValue);
	
	/**
	 * @param pEventType
	 * @param pOldValue
	 * @param pNewValue
	 */
	void firePropertyChange(EventType pEventType, Double pOldValue, Double pNewValue);
	
	/**
	 * @param pEventType
	 * @param pOldValue
	 * @param pNewValue
	 */
	void firePropertyChange(EventType pEventType, Double[] pOldValue, Double[] pNewValue);
	
	/**
	 * @param pPropertyChangeListener
	 */
	void addPropertyChangeListener(PropertyChangeListener pPropertyChangeListener);
}
