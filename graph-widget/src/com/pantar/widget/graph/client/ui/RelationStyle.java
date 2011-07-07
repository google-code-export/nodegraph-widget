/**
 * 
 */
package com.pantar.widget.graph.client.ui;

import java.util.Set;

/**
 * @author mauro.monti
 * 
 */
public interface RelationStyle {

	/**
	 * @return
	 */
	Set<String> getKeys();

	/**
	 * @param pProperty
	 * @return
	 */
	String getStyleValue(String pProperty);

}
