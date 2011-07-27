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
	void setDashedStroke(final Integer pLine, final Integer pSpace);
	
	/**
	 * @param pColor
	 */
	void setStrokeColor(final String pColor);
	
	/**
	 * @param pWidth
	 */
	void setStrokeWidth(final Integer pWidth);
}
