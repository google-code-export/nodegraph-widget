/**
 * 
 */
package com.pantar.widget.graph.server.events;

import com.pantar.widget.graph.server.Node;

/**
 * @author mauro.monti
 *
 */
public class RelationPropertyChangeSupportImpl extends GraphModelPropertyChangeSupportImpl implements RelationPropertyChangeSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5159521261393230783L;

	/**
	 * @param sourceBean
	 */
	public RelationPropertyChangeSupportImpl(final Object sourceBean) {
		super(sourceBean);
	}
	
	/**
	 * {@inheritdoc}
	 */
	@Override
	public void firePropertyChange(final EventType pEventType, final Node pOldNode, final Node pNewNode) {
		super.firePropertyChange(pEventType.getType(), pOldNode, pNewNode);
	}
}
