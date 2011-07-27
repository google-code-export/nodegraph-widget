/**
 * 
 */
package com.pantar.widget.graph.client.ui;

import java.util.Set;

import com.pantar.widget.graph.shared.component.RelationTypeEnum;

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
	String getStyleValue(final String pProperty);

	/**
	 * @return
	 */
	RelationTypeEnum getRelationType();
}
