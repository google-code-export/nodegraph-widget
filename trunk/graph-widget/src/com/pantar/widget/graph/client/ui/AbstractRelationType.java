/**
 * 
 */
package com.pantar.widget.graph.client.ui;

import java.util.Set;

import org.vectomatic.dom.svg.OMSVGElement;

/**
 * @author mauro.monti
 * 
 */
public abstract class AbstractRelationType implements RelationType {

	/**
	 * 
	 */
	private static final String CONST_DOUBLE_QUOTES = "\"";

	/**
	 * @param pElement
	 * @param pAttributes
	 */
	protected void applyAttributes(OMSVGElement pElement, RelationStyle pRelationStyle) {
		final Set<String> keys = pRelationStyle.getKeys();
		for (String currentKey : keys) {
			String value = pRelationStyle.getStyleValue(currentKey);
			if (value.contains(AbstractRelationType.CONST_DOUBLE_QUOTES)) {
				value = value.substring(1, value.length()-1).toString();
			}
			pElement.setAttribute(currentKey, value);
		}
	}

	/**
	 * @param pRelationStyle
	 */
	public abstract void applyAttributes(RelationStyle pRelationStyle);

}
