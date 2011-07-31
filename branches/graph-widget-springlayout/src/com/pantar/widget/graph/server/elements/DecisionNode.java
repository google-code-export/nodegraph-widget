/**
 * 
 */
package com.pantar.widget.graph.server.elements;

import com.pantar.widget.graph.server.CustomNode;

/**
 * @author mauro.monti
 *
 */
public class DecisionNode extends CustomNode {

	/**
	 * 
	 */
	private static final String DECISION_NODE = "decision";

	/**
	 * 
	 */
	public DecisionNode() {
		super();
		this.setTypeName(DecisionNode.DECISION_NODE);
	}
	
	/**
	 * @param pId
	 */
	public DecisionNode(String pId) {
		super(pId);
	}
	
	/**
	 * @param pId
	 * @param pTypeName
	 */
	public DecisionNode(String pId, String pTypeName) {
		super(pId, pTypeName);
	}
}
