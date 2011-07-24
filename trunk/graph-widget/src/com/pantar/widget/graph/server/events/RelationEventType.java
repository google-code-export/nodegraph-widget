/**
 * 
 */
package com.pantar.widget.graph.server.events;

/**
 * @author mauro.monti
 *
 */
public enum RelationEventType implements GraphModelEventType {

	TO, FROM;

	/**
	 * {@inheritdoc}
	 */
	@Override
	public String getType() {
		return this.name();
	}
	
}
