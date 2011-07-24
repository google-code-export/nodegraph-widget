/**
 * 
 */
package com.pantar.widget.graph.client.ui;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.pantar.widget.graph.shared.model.RelationTypeEnum;

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
	private RelationTypeEnum relationTypeEnum;
	
	/**
	 * 
	 */
	public DefaultRelationStyle() {
		this.properties = new HashMap<String, String>();
		this.relationTypeEnum = RelationTypeEnum.LINE;
	}
	
	/**
	 * @param pRelationTypeEnum
	 */
	public DefaultRelationStyle(final RelationTypeEnum pRelationTypeEnum) {
		this.properties = new HashMap<String, String>();
		this.relationTypeEnum = pRelationTypeEnum;
	}

	/**
	 * @param pStyleProperties
	 */
	public DefaultRelationStyle(final Map<String, String> pStyleProperties) {
		this.properties = pStyleProperties;
		this.relationTypeEnum = RelationTypeEnum.LINE;
	}

	/**
	 * @param pRelationTypeEnum
	 * @param pStyleProperties
	 */
	public DefaultRelationStyle(final RelationTypeEnum pRelationTypeEnum, final Map<String, String> pStyleProperties) {
		this.properties = pStyleProperties;
		this.relationTypeEnum = pRelationTypeEnum;
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

	/**
	 * {@inheritdoc}
	 */
	@Override
	public RelationTypeEnum getRelationType() {
		return this.relationTypeEnum;
	}
}
