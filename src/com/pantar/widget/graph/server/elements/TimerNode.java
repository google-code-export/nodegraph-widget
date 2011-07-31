/**
 * 
 */
package com.pantar.widget.graph.server.elements;

import com.pantar.widget.graph.server.CustomNode;

/**
 * @author mauro.monti
 *
 */
public class TimerNode extends CustomNode {

	/**
	 * 
	 */
	private static final String TIMER_NODE = "timer";

	/**
	 * 
	 */
	public TimerNode() {
		super();
		this.setTypeName(TimerNode.TIMER_NODE);
	}
	
	/**
	 * @param pId
	 */
	public TimerNode(String pId) {
		super(pId);
	}
	
	/**
	 * @param pId
	 * @param pTypeName
	 */
	public TimerNode(String pId, String pTypeName) {
		super(pId, pTypeName);
	}
}
