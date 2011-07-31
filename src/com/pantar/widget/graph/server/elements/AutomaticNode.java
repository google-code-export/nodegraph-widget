/**
 * 
 */
package com.pantar.widget.graph.server.elements;

import com.pantar.widget.graph.server.CustomNode;

/**
 * @author mauro.monti
 *
 */
public class AutomaticNode extends CustomNode {
	
	/**
	 * 
	 */
	private static final String AUTOMATIC_NODE = "automatic";

	/**
	 * 
	 */
	public AutomaticNode() {
		super();
		this.setTypeName(AutomaticNode.AUTOMATIC_NODE);
	}
	
	/**
	 * @param pId
	 */
	public AutomaticNode(String pId) {
		super(pId);
	}
	
	/**
	 * @param pId
	 * @param pTypeName
	 */
	public AutomaticNode(String pId, String pTypeName) {
		super(pId, pTypeName);
	}
}
