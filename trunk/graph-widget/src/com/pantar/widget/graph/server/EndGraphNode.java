/**
 * 
 */
package com.pantar.widget.graph.server;

import com.pantar.widget.graph.shared.model.TypeEnum;

/**
 * @author mauro.monti
 * 
 */
public class EndGraphNode extends DefaultNode {

    /**
     * {@inheritdoc}
     */
    @Override
    public TypeEnum getType() {
        return TypeEnum.END_NODE;
    }

}
