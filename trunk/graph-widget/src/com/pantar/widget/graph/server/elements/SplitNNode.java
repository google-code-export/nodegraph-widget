/**
 * 
 */
package com.pantar.widget.graph.server.elements;

import com.pantar.widget.graph.server.CustomNode;

/**
 * @author mauro.monti
 *
 */
public class SplitNNode extends CustomNode {

	/**
	 * 
	 */
	private static final String SPLIT_NODE = "split";

	/**
	 * 
	 */
	public SplitNNode() {
		super();
		this.setTypeName(SplitNNode.SPLIT_NODE);
	}
	
	/**
	 * @param pId
	 */
	public SplitNNode(String pId) {
		super(pId);
	}
	
	/**
	 * @param pId
	 * @param pTypeName
	 */
	public SplitNNode(String pId, String pTypeName) {
		super(pId, pTypeName);
	}
}
