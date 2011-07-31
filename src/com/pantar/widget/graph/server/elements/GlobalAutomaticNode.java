/**
 * 
 */
package com.pantar.widget.graph.server.elements;

import com.pantar.widget.graph.server.CustomNode;

/**
 * @author mauro.monti
 *
 */
public class GlobalAutomaticNode extends CustomNode {

	/**
	 * 
	 */
	private static final String GLOBAL_CREATION_NODE = "global-creation";

	/**
	 * 
	 */
	public GlobalAutomaticNode() {
		super();
		this.setTypeName(GlobalAutomaticNode.GLOBAL_CREATION_NODE);
	}
	
	/**
	 * @param pId
	 */
	public GlobalAutomaticNode(String pId) {
		super(pId);
	}
	
	/**
	 * @param pId
	 * @param pTypeName
	 */
	public GlobalAutomaticNode(String pId, String pTypeName) {
		super(pId, pTypeName);
	}
}
