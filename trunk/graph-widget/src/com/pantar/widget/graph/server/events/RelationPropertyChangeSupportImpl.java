/**
 * 
 */
package com.pantar.widget.graph.server.events;

import com.pantar.widget.graph.server.Node;

/**
 * @author mauro.monti
 *
 */
public class RelationPropertyChangeSupportImpl extends DefaultPropertyChangeSupport implements RelationPropertyChangeSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5159521261393230783L;

	/**
	 * @param sourceBean
	 */
	public RelationPropertyChangeSupportImpl(Object sourceBean) {
		super(sourceBean);
	}
	
	/**
	 * {@inheritdoc}
	 */
	@Override
	public void firePropertyChange(GraphModelEventType pEventType, Node pOldNode, Node pNewNode) {
		super.firePropertyChange(pEventType.getType(), pOldNode, pNewNode);
	}
}
