/**
 * 
 */
package com.pantar.widget.graph.server.elements;

import com.pantar.widget.graph.server.CustomNode;

/**
 * @author mauro.monti
 *
 */
public class SplitNode extends CustomNode {

	/**
	 * 
	 */
	private static final String SPLIT_N_NODE = "split-n";

	/**
	 * 
	 */
	public SplitNode() {
		super();
		this.setTypeName(SplitNode.SPLIT_N_NODE);
	}
	
	/**
	 * @param pId
	 */
	public SplitNode(String pId) {
		super(pId);
	}
	
	/**
	 * @param pId
	 * @param pTypeName
	 */
	public SplitNode(String pId, String pTypeName) {
		super(pId, pTypeName);
	}
}
