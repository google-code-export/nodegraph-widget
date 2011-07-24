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
	private String styleClassName;

	/**
	 * 
	 */
	private String selectedStyleClassName;

	/**
	 * 
	 */
	private String enabledStyleClassName;
	
	/**
	 * 
	 */
	private String disabledStyleClassName;
	
	/**
	 * 
	 */
	public DefaultNodeStyle() {
		this.styleClassName = GraphConstants.DOM.NODE_CSS_TYPE_CLASSNAME;
		this.selectedStyleClassName = GraphConstants.DOM.NODE_CSS_SELECTED_CLASSNAME;
		this.enabledStyleClassName = GraphConstants.DOM.NODE_CSS_ENABLED_CLASSNAME;
		this.disabledStyleClassName = GraphConstants.DOM.NODE_CSS_DISABLED_CLASSNAME;
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

	/**
	 * {@inheritdoc}
	 */
	@Override
	public String getEnabledClassName() {
		return this.enabledStyleClassName;
	}
	
	/**
	 * {@inheritdoc}
	 */
	@Override
	public String getDisabledClassName() {
		return this.disabledStyleClassName;
	}
}
