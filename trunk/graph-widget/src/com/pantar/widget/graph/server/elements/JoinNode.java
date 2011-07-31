/**
 * 
 */
package com.pantar.widget.graph.server.elements;

import com.pantar.widget.graph.server.CustomNode;

/**
 * @author mauro.monti
 *
 */
public class JoinNode extends CustomNode {

	/**
	 * 
	 */
	private static final String JOIN_NODE = "join";

	/**
	 * 
	 */
	public JoinNode() {
		super();
		this.setTypeName(JoinNode.JOIN_NODE);
	}
	
	/**
	 * @param pId
	 */
	public JoinNode(String pId) {
		super(pId);
	}
	
	/**
	 * @param pId
	 * @param pTypeName
	 */
	public JoinNode(String pId, String pTypeName) {
		super(pId, pTypeName);
	}
}
