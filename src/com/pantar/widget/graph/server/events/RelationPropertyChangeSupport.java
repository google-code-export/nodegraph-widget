/**
 * 
 */
package com.pantar.widget.graph.server.events;

import com.pantar.widget.graph.server.Node;

/**
 * @author mauro.monti
 *
 */
public interface RelationPropertyChangeSupport extends GraphModelPropertyChangeSupport {

	/**
	 * @param pEventType
	 * @param pOldNode
	 * @param pNewNode
	 */
	void firePropertyChange(final EventType pEventType, final Node pOldNode, final Node pNewNode);
	
}
