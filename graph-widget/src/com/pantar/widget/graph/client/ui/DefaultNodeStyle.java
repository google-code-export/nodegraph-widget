/**
 * 
 */
package com.pantar.widget.graph.client.ui;

import com.pantar.widget.graph.shared.GraphConstants;

/**
 * @author mauro.monti
 * 
 */
public class DefaultNodeStyle implements NodeStyle {

	/**
	 * 
	 */
	private final String styleClassName;

	/**
	 * 
	 */
	private final String selectedStyleClassName;

	/**
	 * 
	 */
	public DefaultNodeStyle() {
		this.styleClassName = GraphConstants.NODE_NAME;
		this.selectedStyleClassName = GraphConstants.NODE_CSS_SELECTED_CLASSNAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getStyleClassName() {
		return this.styleClassName;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getSelectedClassName() {
		return this.selectedStyleClassName;
	}

}
