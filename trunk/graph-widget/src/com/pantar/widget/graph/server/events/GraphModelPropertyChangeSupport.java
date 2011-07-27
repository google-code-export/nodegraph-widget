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
	void firePropertyChange(final EventType pEventType, final Boolean pOldValue, final Boolean pNewValue);
	
	/**
	 * @param pEventType
	 * @param pOldValue
	 * @param pNewValue
	 */
	void firePropertyChange(final EventType pEventType, final String pOldValue, final String pNewValue);
	
	/**
	 * @param pEventType
	 * @param pOldValue
	 * @param pNewValue
	 */
	void firePropertyChange(final EventType pEventType, final Double pOldValue, final Double pNewValue);
	
	/**
	 * @param pEventType
	 * @param pOldValue
	 * @param pNewValue
	 */
	void firePropertyChange(final EventType pEventType, final Double[] pOldValue, final Double[] pNewValue);
	
	/**
	 * @param pPropertyChangeListener
	 */
	void addPropertyChangeListener(final PropertyChangeListener pPropertyChangeListener);
}
