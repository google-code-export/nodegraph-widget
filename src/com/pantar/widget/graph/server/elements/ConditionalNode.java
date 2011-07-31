/**
 * 
 */
package com.pantar.widget.graph.server.elements;

import com.pantar.widget.graph.server.CustomNode;

/**
 * @author mauro.monti
 *
 */
public class ConditionalNode extends CustomNode {
	
	/**
	 * 
	 */
	private static final String CONDITIONAL_NODE = "conditional";

	/**
	 * 
	 */
	public ConditionalNode() {
		super();
		this.setTypeName(ConditionalNode.CONDITIONAL_NODE);
	}
	
	/**
	 * @param pId
	 */
	public ConditionalNode(String pId) {
		super(pId);
	}
	
	/**
	 * @param pId
	 * @param pTypeName
	 */
	public ConditionalNode(String pId, String pTypeName) {
		super(pId, pTypeName);
	}
}
