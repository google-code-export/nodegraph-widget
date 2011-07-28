/**
 * 
 */
package com.pantar.widget.graph.server.elements;

import com.pantar.widget.graph.server.CustomNode;

/**
 * @author mauro.monti
 *
 */
public class CompensateNode extends CustomNode {
	
	/**
	 * 
	 */
	private static final String COMPENSATE_NODE = "compensate";

	/**
	 * 
	 */
	public CompensateNode() {
		super();
		this.setTypeName(CompensateNode.COMPENSATE_NODE);
	}
	
	/**
	 * @param pId
	 */
	public CompensateNode(String pId) {
		super(pId);
	}
	
	/**
	 * @param pId
	 * @param pTypeName
	 */
	public CompensateNode(String pId, String pTypeName) {
		super(pId, pTypeName);
	}
}
