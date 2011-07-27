/**
 * 
 */
package com.pantar.widget.graph.server.style;

import com.pantar.widget.graph.server.CustomNode;
import com.pantar.widget.graph.server.Node;
import com.pantar.widget.graph.shared.GraphConstants;

/**
 * @author mauro.monti
 *
 */
public class CustomNodeStyle extends DefaultNodeStyle {

	/**
	 * @param pNode
	 */
	public CustomNodeStyle(final Node pNode) {
		super(pNode);
	}
	
	/**
	 * {@inheritdoc}
	 */
	@Override
	public String getStyleClassName() {
		final CustomNode customNode = (CustomNode) this.node;
		return super.getStyleClassName() + GraphConstants.CONST_SPACE + customNode.getTypeName();
	}

}
