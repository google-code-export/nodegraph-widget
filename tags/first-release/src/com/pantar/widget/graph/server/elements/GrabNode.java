/**
 * 
 */
package com.pantar.widget.graph.server.elements;

import com.pantar.widget.graph.server.CustomNode;

/**
 * @author mauro.monti
 *
 */
public class GrabNode extends CustomNode {

	/**
	 * 
	 */
	private static final String GRAB_NODE = "grab";

	/**
	 * 
	 */
	public GrabNode() {
		super();
		this.setTypeName(GrabNode.GRAB_NODE);
	}
	
	/**
	 * @param pId
	 */
	public GrabNode(String pId) {
		super(pId);
	}
	
	/**
	 * @param pId
	 * @param pTypeName
	 */
	public GrabNode(String pId, String pTypeName) {
		super(pId, pTypeName);
	}
}
