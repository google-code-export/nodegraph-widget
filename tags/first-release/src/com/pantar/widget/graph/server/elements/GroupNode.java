/**
 * 
 */
package com.pantar.widget.graph.server.elements;

import com.pantar.widget.graph.server.CustomNode;

/**
 * @author mauro.monti
 *
 */
public class GroupNode extends CustomNode {

	/**
	 * 
	 */
	private static final String GROUP_NODE = "group";

	/**
	 * 
	 */
	public GroupNode() {
		super();
		this.setTypeName(GroupNode.GROUP_NODE);
	}
	
	/**
	 * @param pId
	 */
	public GroupNode(String pId) {
		super(pId);
	}
	
	/**
	 * @param pId
	 * @param pTypeName
	 */
	public GroupNode(String pId, String pTypeName) {
		super(pId, pTypeName);
	}
}
