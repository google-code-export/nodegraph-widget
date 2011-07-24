/**
 * 
 */
package com.pantar.widget.graph.shared.model;

/**
 * @author mauro.monti
 * 
 */
public enum TypeEnum {

	/**
	 * 
	 */
	START_NODE("start-node"), 
	
	/**
	 * 
	 */
	NODE("node"), 
	
	/**
	 * 
	 */
	END_NODE("end-node"), 
	
	/**
	 * 
	 */
	RELATION("relation"), 
	
	/**
	 * 
	 */
	CUSTOM_NODE("custom-node");

	/**
	 * 
	 */
	private String typeName = null;
	
	/**
	 * @param pTypeName
	 */
	private TypeEnum(String pTypeName) {
		this.typeName = pTypeName;
	}
	
	/**
	 * @return
	 */
	public String getTypeName() {
		return typeName;
	}
}
