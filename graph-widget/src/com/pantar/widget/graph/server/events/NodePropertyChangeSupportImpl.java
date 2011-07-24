/**
 * 
 */
package com.pantar.widget.graph.server.events;


/**
 * @author mauro.monti
 *
 */
public class NodePropertyChangeSupportImpl extends DefaultPropertyChangeSupport implements NodePropertyChangeSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6544713356237479711L;

	/**
	 * @param sourceBean
	 */
	public NodePropertyChangeSupportImpl(Object sourceBean) {
		super(sourceBean);
	}
	
}
