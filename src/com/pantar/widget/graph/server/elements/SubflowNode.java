/**
 * 
 */
package com.pantar.widget.graph.server.elements;

import com.pantar.widget.graph.server.CustomNode;

/**
 * @author mauro.monti
 *
 */
public class SubflowNode extends CustomNode {

	/**
	 * 
	 */
	private static final String SUBFLOW_NODE = "subflow";

	/**
	 * 
	 */
	public SubflowNode() {
		super();
		this.setTypeName(SubflowNode.SUBFLOW_NODE);
	}
	
	/**
	 * @param pId
	 */
	public SubflowNode(String pId) {
		super(pId);
	}
	
	/**
	 * @param pId
	 * @param pTypeName
	 */
	public SubflowNode(String pId, String pTypeName) {
		super(pId, pTypeName);
	}
}
