/**
 * 
 */
package com.pantar.widget.graph.server.elements;

import com.pantar.widget.graph.server.CustomNode;

/**
 * @author mauro.monti
 *
 */
public class ProcessNotificationNode extends CustomNode {

	/**
	 * 
	 */
	private static final String PROCESS_NOTIFICATION_NODE = "process-notification";

	/**
	 * 
	 */
	public ProcessNotificationNode() {
		super();
		this.setTypeName(ProcessNotificationNode.PROCESS_NOTIFICATION_NODE);
	}
	
	/**
	 * @param pId
	 */
	public ProcessNotificationNode(String pId) {
		super(pId);
	}
	
	/**
	 * @param pId
	 * @param pTypeName
	 */
	public ProcessNotificationNode(String pId, String pTypeName) {
		super(pId, pTypeName);
	}
}
