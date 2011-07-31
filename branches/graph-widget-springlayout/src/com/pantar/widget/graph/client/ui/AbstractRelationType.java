/**
 * 
 */
package com.pantar.widget.graph.client.ui;

import java.util.Set;

import org.vectomatic.dom.svg.OMSVGElement;

import com.pantar.widget.graph.shared.GraphConstants;

/**
 * @author mauro.monti
 * 
 */
public abstract class AbstractRelationType implements RelationType {

	/**
	 * @param pElement
	 * @param pAttributes
	 */
	protected void applyAttributes(final OMSVGElement pElement, final RelationStyle pRelationStyle) {
		final Set<String> keys = pRelationStyle.getKeys();
		for (String currentKey : keys) {
			String value = pRelationStyle.getStyleValue(currentKey);
			if (value.contains(GraphConstants.CONST_DOUBLE_QUOTES)) {
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
