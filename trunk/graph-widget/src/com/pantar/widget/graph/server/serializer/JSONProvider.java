/**
 * 
 */
package com.pantar.widget.graph.server.serializer;

import com.pantar.widget.graph.server.GraphModel;

/**
 * @author mauro.monti
 *
 */
public interface JSONProvider {

	/**
	 * @param pGraphModel
	 * @return
	 */
	String serialize(final GraphModel pGraphModel);
	
	/**
	 * @param pExpression
	 */
	void addExclusion(String pExpression);
	
	/**
	 * @param pExpression
	 */
	void addExclusion(String[] pExpressions);
}
