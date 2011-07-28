/**
 * 
 */
package com.pantar.widget.graph.server.elements;

import com.pantar.widget.graph.server.CustomNode;

/**
 * @author mauro.monti
 *
 */
public class ProcessCreationNode extends CustomNode {

	/**
	 * 
	 */
	private static final String PROCESS_CREATION_NODE = "process-creation";

	/**
	 * 
	 */
	public ProcessCreationNode() {
		super();
		this.setTypeName(ProcessCreationNode.PROCESS_CREATION_NODE);
	}
	
	/**
	 * @param pId
	 */
	public ProcessCreationNode(String pId) {
		super(pId);
	}
	
	/**
	 * @param pId
	 * @param pTypeName
	 */
	public ProcessCreationNode(String pId, String pTypeName) {
		super(pId, pTypeName);
	}
}
