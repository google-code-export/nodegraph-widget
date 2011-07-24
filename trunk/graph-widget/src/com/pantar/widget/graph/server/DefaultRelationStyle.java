/**
 * 
 */
package com.pantar.widget.graph.server;

import java.util.HashMap;

import com.pantar.widget.graph.shared.GraphConstants;

/**
 * @author mauro.monti
 * 
 */
public class DefaultRelationStyle extends HashMap<String, String> implements RelationStyle {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7737781018306578215L;
	
	/**
	 * 
	 */
	private static final String DEFAULT_STROKE_WIDTH = "2";

	/**
	 * 
	 */
	public DefaultRelationStyle() {
		this.put(GraphConstants.DOM.CSS_STROKE_WIDTH_PROPERTY, DefaultRelationStyle.DEFAULT_STROKE_WIDTH);
		this.put(GraphConstants.DOM.CSS_STROKE_VALUE, GraphConstants.DOM.CSS_BLACK_VALUE);
	}

	/**
	 * 
	 */
	public DefaultRelationStyle(final String pStrokeColor, final Integer pStrokeWidth) {
		this.put(GraphConstants.DOM.CSS_STROKE_WIDTH_PROPERTY, pStrokeWidth.toString());
		this.put(GraphConstants.DOM.CSS_STROKE_VALUE, pStrokeColor);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setContinuousLine() {
		this.remove(GraphConstants.DOM.CSS_STROKE_DASHARRAY_PROPERTY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setDashedStroke(final Integer pLine, final Integer pSpace) {
		if (pLine == null || pSpace == null) {
			return;
		}
		this.put(GraphConstants.DOM.CSS_STROKE_DASHARRAY_PROPERTY, pLine + "," + pSpace);
	}

}
