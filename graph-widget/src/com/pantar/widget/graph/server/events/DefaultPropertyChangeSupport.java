/**
 * 
 */
package com.pantar.widget.graph.server.events;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * @author mauro.monti
 *
 */
public class DefaultPropertyChangeSupport extends PropertyChangeSupport implements GraphModelPropertyChangeSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1135125757555739653L;

	/**
	 * @param sourceBean
	 */
	public DefaultPropertyChangeSupport(Object sourceBean) {
		super(sourceBean);
	}

	/**
	 * {@inheritdoc}
	 */
	@Override
	public void firePropertyChange(EventType pEventType, Boolean pOldValue, Boolean pNewValue) {
		super.firePropertyChange(pEventType.getType(), pOldValue, pNewValue);
	}
	
	/**
	 * {@inheritdoc}
	 */
	@Override
	public void firePropertyChange(EventType pEventType, Double pOldValue, Double pNewValue) {
		super.firePropertyChange(pEventType.getType(), pOldValue, pNewValue);
	}
	
	/**
	 * {@inheritdoc}
	 */
	@Override
	public void firePropertyChange(EventType pEventType, String pOldValue, String pNewValue) {
		super.firePropertyChange(pEventType.getType(), pOldValue, pNewValue);
	}
	
	/**
	 * {@inheritdoc}
	 */
	@Override
	public void firePropertyChange(EventType pEventType, Double[] pOldValue, Double[] pNewValue) {
		super.firePropertyChange(pEventType.getType(), pOldValue, pNewValue);	
	}
	
	/**
	 * {@inheritdoc}
	 */
	@Override
	public synchronized void addPropertyChangeListener(PropertyChangeListener pListener) {
		super.addPropertyChangeListener(pListener);
	}

}
