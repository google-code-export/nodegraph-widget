/**
 * 
 */
package com.pantar.widget.graph.server;

/**
 * @author mauro.monti
 * 
 */
public class EndGraphNode extends DefaultNode {

    public EndGraphNode() {
        super();
    }

    public EndGraphNode(String pId) {
        super(pId);
    }

    @Override
    public TypeEnum getType() {
        return TypeEnum.END_NODE;
    }

}
