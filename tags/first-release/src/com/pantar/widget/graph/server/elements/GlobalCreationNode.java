/**
 * 
 */
package com.pantar.widget.graph.server.elements;

import com.pantar.widget.graph.server.CustomNode;

/**
 * @author mauro.monti
 *
 */
public class GlobalCreationNode extends CustomNode {

	/**
	 * 
	 */
	private static final String GLOBAL_AUTOMATIC_NODE = "global-automatic";

	/**
	 * 
	 */
	public GlobalCreationNode() {
		super();
		this.setTypeName(GlobalCreationNode.GLOBAL_AUTOMATIC_NODE);
	}
	
	/**
	 * @param pId
	 */
	public GlobalCreationNode(String pId) {
		super(pId);
	}
	
	/**
	 * @param pId
	 * @param pTypeName
	 */
	public GlobalCreationNode(String pId, String pTypeName) {
		super(pId, pTypeName);
	}
}
