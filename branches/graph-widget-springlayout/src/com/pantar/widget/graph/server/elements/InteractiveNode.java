/**
 * 
 */
package com.pantar.widget.graph.server.elements;

import com.pantar.widget.graph.server.CustomNode;

/**
 * @author mauro.monti
 *
 */
public class InteractiveNode extends CustomNode {

	/**
	 * 
	 */
	private static final String INTERACTIVE_NODE = "interactive";

	/**
	 * 
	 */
	public InteractiveNode() {
		super();
		this.setTypeName(InteractiveNode.INTERACTIVE_NODE);
	}
	
	/**
	 * @param pId
	 */
	public InteractiveNode(String pId) {
		super(pId);
	}
	
	/**
	 * @param pId
	 * @param pTypeName
	 */
	public InteractiveNode(String pId, String pTypeName) {
		super(pId, pTypeName);
	}
}
