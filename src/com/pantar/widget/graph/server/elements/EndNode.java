/**
 * 
 */
package com.pantar.widget.graph.server.elements;

import com.pantar.widget.graph.server.CustomNode;

/**
 * @author mauro.monti
 *
 */
public class EndNode extends CustomNode {

	/**
	 * 
	 */
	private static final String END_NODE = "end";

	/**
	 * 
	 */
	public EndNode() {
		super();
		this.setTypeName(EndNode.END_NODE);
	}
	
	/**
	 * @param pId
	 */
	public EndNode(String pId) {
		super(pId);
	}
	
	/**
	 * @param pId
	 * @param pTypeName
	 */
	public EndNode(String pId, String pTypeName) {
		super(pId, pTypeName);
	}
}
