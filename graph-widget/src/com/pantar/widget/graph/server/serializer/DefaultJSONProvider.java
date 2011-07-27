/**
 * 
 */
package com.pantar.widget.graph.server.serializer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.pantar.widget.graph.server.GraphModel;

import flexjson.JSONSerializer;

/**
 * @author mauro.monti
 *
 */
public class DefaultJSONProvider implements JSONProvider {

	/**
	 * 
	 */
	private JSONSerializer serializer;
	
	/**
	 * 
	 */
	private Set<String> excludeProperties = new HashSet<String>();
	
	/**
	 * 
	 */
	public DefaultJSONProvider() {
		this.serializer = new JSONSerializer();
	}
	
	/**
	 * {@inheritdoc}
	 */
	@Override
	public String serialize(GraphModel pGraphModel) {
		this.serializer.setExcludes(new ArrayList<String>(this.excludeProperties));
		return this.serializer.deepSerialize(pGraphModel);
	}

	/**
	 * @param pExpression
	 */
	@Override
	public void addExclusion(String pExpression) {
		if (pExpression != null && !pExpression.isEmpty()) {
			this.excludeProperties.add(pExpression);
		}
	}
}
