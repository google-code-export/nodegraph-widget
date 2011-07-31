/**
 * 
 */
package com.pantar.widget.graph.server.styles;

import com.pantar.widget.graph.server.Node;
import com.pantar.widget.graph.shared.GraphConstants;
import com.pantar.widget.graph.shared.component.style.NodeStyle;

/**
 * @author mauro.monti
 *
 */
public class DefaultNodeStyle implements NodeStyle {

	/**
	 * 
	 */
	protected Node node;
	
	/**
	 * @param pNode
	 */
	public DefaultNodeStyle(final Node pNode) {
		this.node = pNode;
	}
	
	/**
	 * {@inheritdoc}
	 */
	@Override
	public String getStyleClassName() {
		return this.node.getType().getType();
	}

	/**
	 * {@inheritdoc}
	 */
	@Override
	public String getSelectedClassName() {
		return GraphConstants.DOM.NODE_CSS_FIELD_VALUE_SELECTED_CLASSNAME;
	}

	/**
	 * {@inheritdoc}
	 */
	@Override
	public String getEnabledClassName() {
		return GraphConstants.DOM.NODE_CSS_FIELD_VALUE_ENABLED_CLASSNAME;
	}

	/**
	 * {@inheritdoc}
	 */
	@Override
	public String getDisabledClassName() {
		return GraphConstants.DOM.NODE_CSS_FIELD_VALUE_DISABLED_CLASSNAME;
	}

	/**
	 * {@inheritdoc}
	 */
	@Override
	public String getLabelClassName() {
		return GraphConstants.DOM.NODE_CSS_FIELD_VALUE_LABEL_CLASSNAME;
	}
}
