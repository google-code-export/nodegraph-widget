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
	 * @return
	 */
	String getStrokeColor();

	/**
	 * @return
	 */
	int getStrokeWidth();

	/**
	 * @return
	 */
	Boolean isDashedStroke();

	/**
	 * @param pDashedStroke
	 */
	void setDashedStroke(Boolean pDashedStroke);

	/**
	 * @param pLine
	 * @param pSpace
	 */
	void setDashedStrokePattern(int pLine, int pSpace);
}
