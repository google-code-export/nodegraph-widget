/**
 * 
 */
package com.pantar.widget.graph.server.elements;

import com.pantar.widget.graph.server.CustomNode;

/**
 * @author mauro.monti
 *
 */
public class GlobalNode extends CustomNode {

	/**
	 * 
	 */
	private static final String GLOBAL_NODE = "global";

	/**
	 * 
	 */
	public GlobalNode() {
		super();
		this.setTypeName(GlobalNode.GLOBAL_NODE);
	}
	
	/**
	 * @param pId
	 */
	public GlobalNode(String pId) {
		super(pId);
	}
	
	/**
	 * @param pId
	 * @param pTypeName
	 */
	public GlobalNode(String pId, String pTypeName) {
		super(pId, pTypeName);
	}
}
