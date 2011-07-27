/**
 * 
 */
package com.pantar.widget.graph.shared.component;


/**
 * @author mauro.monti
 * 
 */
public enum NodeTypeEnum implements Type {

	/**
	 * 
	 */
	NODE("node"), 
			
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
	private NodeTypeEnum(String pTypeName) {
		this.typeName = pTypeName;
	}

	/**
	 * @return
	 */
	public String getTypeName() {
		return typeName;
	}
	
	/**
	 * {@inheritdoc}
	 */
	@Override
	public String getType() {
		return this.typeName;
	}
	
}
