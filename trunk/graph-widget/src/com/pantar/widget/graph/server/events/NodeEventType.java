/**
 * 
 */
package com.pantar.widget.graph.server.events;

/**
 * @author mauro.monti
 *
 */
public enum NodeEventType implements GraphModelEventType {

	POSITION, LABEL, SELECTED, UNSELECTED, ENABLED, DISABLED;

	/**
	 * {@inheritdoc}
	 */
	@Override
	public String getType() {
		return this.name();
	}
	
}
