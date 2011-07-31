/**
 * 
 */
package com.pantar.widget.graph.server.elements;

import com.pantar.widget.graph.server.CustomNode;

/**
 * @author mauro.monti
 *
 */
public class OrSplitNode extends CustomNode {

	/**
	 * 
	 */
	private static final String NOTIFICTION_WAIT_NODE = "notification-wait";

	/**
	 * 
	 */
	public OrSplitNode() {
		super();
		this.setTypeName(OrSplitNode.NOTIFICTION_WAIT_NODE);
	}
	
	/**
	 * @param pId
	 */
	public OrSplitNode(String pId) {
		super(pId);
	}
	
	/**
	 * @param pId
	 * @param pTypeName
	 */
	public OrSplitNode(String pId, String pTypeName) {
		super(pId, pTypeName);
	}
}
