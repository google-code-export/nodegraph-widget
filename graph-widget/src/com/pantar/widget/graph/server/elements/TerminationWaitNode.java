/**
 * 
 */
package com.pantar.widget.graph.server.elements;

import com.pantar.widget.graph.server.CustomNode;

/**
 * @author mauro.monti
 *
 */
public class TerminationWaitNode extends CustomNode {

	/**
	 * 
	 */
	private static final String TERMINATION_WAIT_NODE = "termination-wait";

	/**
	 * 
	 */
	public TerminationWaitNode() {
		super();
		this.setTypeName(TerminationWaitNode.TERMINATION_WAIT_NODE);
	}
	
	/**
	 * @param pId
	 */
	public TerminationWaitNode(String pId) {
		super(pId);
	}
	
	/**
	 * @param pId
	 * @param pTypeName
	 */
	public TerminationWaitNode(String pId, String pTypeName) {
		super(pId, pTypeName);
	}
}
