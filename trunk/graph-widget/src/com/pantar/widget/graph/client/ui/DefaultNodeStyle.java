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
	private String labelStyleClassName;
	
	/**
	 * 
	 */
	public DefaultNodeStyle() {
		this.styleClassName = GraphConstants.DOM.NODE_CSS_FIELD_VALUE_TYPE_CLASSNAME;
		this.selectedStyleClassName = GraphConstants.DOM.NODE_CSS_FIELD_VALUE_SELECTED_CLASSNAME;
		this.enabledStyleClassName = GraphConstants.DOM.NODE_CSS_FIELD_VALUE_ENABLED_CLASSNAME;
		this.disabledStyleClassName = GraphConstants.DOM.NODE_CSS_FIELD_VALUE_DISABLED_CLASSNAME;
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

	/**
	 * {@inheritdoc}
	 */
	@Override
	public String getLabelClassName() {
		return this.labelStyleClassName;
	}
	
	/**
	 * @param styleClassName the styleClassName to set
	 */
	protected void setStyleClassName(String styleClassName) {
		this.styleClassName = styleClassName;
	}

	/**
	 * @param selectedStyleClassName the selectedStyleClassName to set
	 */
	protected void setSelectedStyleClassName(String selectedStyleClassName) {
		this.selectedStyleClassName = selectedStyleClassName;
	}

	/**
	 * @param enabledStyleClassName the enabledStyleClassName to set
	 */
	protected void setEnabledStyleClassName(String enabledStyleClassName) {
		this.enabledStyleClassName = enabledStyleClassName;
	}

	/**
	 * @param disabledStyleClassName the disabledStyleClassName to set
	 */
	protected void setDisabledStyleClassName(String disabledStyleClassName) {
		this.disabledStyleClassName = disabledStyleClassName;
	}

	/**
	 * @param labelStyleClassName
	 */
	protected void setLabelStyleClassName(String labelStyleClassName) {
		this.labelStyleClassName = labelStyleClassName;
	}
}
