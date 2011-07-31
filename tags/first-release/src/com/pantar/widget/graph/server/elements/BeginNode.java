/**
 * 
 */
package com.pantar.widget.graph.server.elements;

import com.pantar.widget.graph.server.CustomNode;

/**
 * @author mauro.monti
 *
 */
public class BeginNode extends CustomNode {

	/**
	 * 
	 */
	private static final String BEGIN_NODE = "begin";

	/**
	 * 
	 */
	public BeginNode() {
		super();
		this.setTypeName(BeginNode.BEGIN_NODE);
	}
	
	/**
	 * @param pId
	 */
	public BeginNode(String pId) {
		super(pId);
	}
	
	/**
	 * @param pId
	 * @param pTypeName
	 */
	public BeginNode(String pId, String pTypeName) {
		super(pId, pTypeName);
	}
}
