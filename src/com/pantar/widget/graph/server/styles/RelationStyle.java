/**
 * 
 */
package com.pantar.widget.graph.server.styles;


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
	 * @return
	 */
	RelationStyle strokeColor(final String pColor);
	
	/**
	 * @param pWidth
	 */
	RelationStyle strokeWidth(final Integer pWidth);
}
