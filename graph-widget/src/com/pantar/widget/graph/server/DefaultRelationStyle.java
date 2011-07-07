/**
 * 
 */
package com.pantar.widget.graph.server;

/**
 * @author mauro.monti
 * 
 */
public class DefaultRelationStyle implements RelationStyle {

	/**
	 * 
	 */
	private boolean dashedStroke;

	/**
	 * 
	 */
	private String dashedLinePattern;

	/**
	 * 
	 */
	private int strokeWidth = 2;

	/**
	 * 
	 */
	private String strokeColor = "black";

	/**
	 * 
	 */
	public DefaultRelationStyle() {
	}

	/**
	 * 
	 */
	public DefaultRelationStyle(final String pStrokeColor, final int pStrokeWidth) {
		this.strokeColor = pStrokeColor;
		this.strokeWidth = pStrokeWidth;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getStrokeColor() {
		return this.strokeColor;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getStrokeWidth() {
		return this.strokeWidth;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Boolean isDashedStroke() {
		return this.dashedStroke;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setDashedStroke(final Boolean pDashedStroke) {
		if (pDashedStroke && this.dashedLinePattern.isEmpty()) {
			this.setDashedStrokePattern(2, 2);
		}
		this.dashedStroke = pDashedStroke;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setDashedStrokePattern(final int pLine, final int pSpace) {
		this.dashedLinePattern = pLine + "," + pSpace;
	}

}
