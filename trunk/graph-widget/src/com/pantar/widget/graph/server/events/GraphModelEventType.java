/**
 * 
 */
package com.pantar.widget.graph.server.events;

/**
 * @author mauro.monti
 *
 */
public enum GraphModelEventType implements EventType {

	/**
	 * 
	 */
	INITIALIZED;

	/**
	 * {@inheritdoc}
	 */
	@Override
	public String getType() {
		return this.name();
	}
	
}
