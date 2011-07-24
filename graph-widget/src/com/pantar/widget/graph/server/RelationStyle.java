/**
 * 
 */
package com.pantar.widget.graph.server;


/**
 * @author mauro.monti
 * 
 */
public interface RelationStyle {

	/**
	 * 
	 */
	void setContinuousLine();

	/**
	 * @param pLine
	 * @param pSpace
	 */
	void setDashedStroke(Integer pLine, Integer pSpace);
}
