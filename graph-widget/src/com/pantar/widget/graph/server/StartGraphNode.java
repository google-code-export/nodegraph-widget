/**
 * 
 */
package com.pantar.widget.graph.server;

/**
 * @author mauro.monti
 * 
 */
public class StartGraphNode extends DefaultNode {

    public StartGraphNode() {
        super();
    }

    public StartGraphNode(String pId) {
        super(pId);
    }

    @Override
    public TypeEnum getType() {
        return TypeEnum.START_NODE;
    }

}