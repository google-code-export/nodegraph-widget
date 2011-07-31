/**
 * 
 */
package com.pantar.widget.graph.server.elements;

import com.pantar.widget.graph.server.CustomNode;

/**
 * @author mauro.monti
 *
 */
public class NotificationWaitNode extends CustomNode {

	/**
	 * 
	 */
	private static final String OR_SPLIT_NODE = "or-split";

	/**
	 * 
	 */
	public NotificationWaitNode() {
		super();
		this.setTypeName(NotificationWaitNode.OR_SPLIT_NODE);
	}
	
	/**
	 * @param pId
	 */
	public NotificationWaitNode(String pId) {
		super(pId);
	}
	
	/**
	 * @param pId
	 * @param pTypeName
	 */
	public NotificationWaitNode(String pId, String pTypeName) {
		super(pId, pTypeName);
	}
}
