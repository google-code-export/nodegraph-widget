/**
 * 
 */
package com.pantar.widget.graph.server;

import com.pantar.widget.graph.server.styles.CustomNodeStyle;
import com.pantar.widget.graph.shared.component.NodeTypeEnum;

/**
 * @author mauro.monti
 *
 */
public class CustomNode extends DefaultNode {

	/**
	 * 
	 */
	private String typeName;
	
	/**
	 * 
	 */
	public CustomNode() {
		super();
	}

	/**
	 * @param pId
	 */
	public CustomNode(String pId) {
		super(pId);
	}
	
	/**
	 * @param pTypeName
	 */
	public CustomNode(String pId, String pTypeName) {
		this(pId);
		this.typeName = pTypeName;
	}
	
    /**
     * {@inheritdoc}
     */
    @Override
    void initialize() {
    	this.type = NodeTypeEnum.CUSTOM_NODE;
    	this.typeName = this.getClass().getSimpleName().toLowerCase();
    	
    	this.nodeStyle = new CustomNodeStyle(this);
    }
    	
	/**
	 * @return
	 */
	public String getTypeName() {
		return typeName;
	}
}
