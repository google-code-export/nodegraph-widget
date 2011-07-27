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
public class GraphModelPropertyChangeSupportImpl extends PropertyChangeSupport implements GraphModelPropertyChangeSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1135125757555739653L;

	/**
	 * @param sourceBean
	 */
	public GraphModelPropertyChangeSupportImpl(final Object sourceBean) {
		super(sourceBean);
	}

	/**
	 * {@inheritdoc}
	 */
	@Override
	public void firePropertyChange(final EventType pEventType, final Boolean pOldValue, final Boolean pNewValue) {
		super.firePropertyChange(pEventType.getType(), pOldValue, pNewValue);
	}
	
	/**
	 * {@inheritdoc}
	 */
	@Override
	public void firePropertyChange(final EventType pEventType, final Double pOldValue, final Double pNewValue) {
		super.firePropertyChange(pEventType.getType(), pOldValue, pNewValue);
	}
	
	/**
	 * {@inheritdoc}
	 */
	@Override
	public void firePropertyChange(final EventType pEventType, final String pOldValue, final String pNewValue) {
		super.firePropertyChange(pEventType.getType(), pOldValue, pNewValue);
	}
	
	/**
	 * {@inheritdoc}
	 */
	@Override
	public void firePropertyChange(final EventType pEventType, final Double[] pOldValue, final Double[] pNewValue) {
		super.firePropertyChange(pEventType.getType(), pOldValue, pNewValue);	
	}
	
	/**
	 * {@inheritdoc}
	 */
	@Override
	public synchronized void addPropertyChangeListener(final PropertyChangeListener pListener) {
		super.addPropertyChangeListener(pListener);
	}

}
