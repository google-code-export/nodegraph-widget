/**
 * 
 */
package com.pantar.graph.widget.customs;

import com.pantar.widget.graph.server.CustomNode;

/**
 * @author mauro.monti
 * 
 */
public class ConsoleNode extends CustomNode {

	/**
	 * 
	 */
	private static final String CONSOLE_NODE = "console";

	/**
	 * 
	 */
	public ConsoleNode() {
		super();
		this.setTypeName(CONSOLE_NODE);
	}

	/**
	 * @param pId
	 */
	public ConsoleNode(String pId) {
		super(pId);
	}

	/**
	 * @param pId
	 * @param pTypeName
	 */
	public ConsoleNode(String pId, String pTypeName) {
		super(pId, pTypeName);
	}
}
