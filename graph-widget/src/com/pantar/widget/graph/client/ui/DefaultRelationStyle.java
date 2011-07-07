/**
 * 
 */
package com.pantar.widget.graph.client.ui;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author mauro.monti
 * 
 */
public class DefaultRelationStyle implements RelationStyle {

	/**
	 * 
	 */
	private final Map<String, String> properties;

	/**
	 * 
	 */
	public DefaultRelationStyle() {
		this.properties = new HashMap<String, String>();
	}

	/**
	 * 
	 */
	public DefaultRelationStyle(final Map<String, String> pStyleProperties) {
		this.properties = pStyleProperties;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<String> getKeys() {
		return this.properties.keySet();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getStyleValue(final String pProperty) {
		return this.properties.get(pProperty);
	}
}
