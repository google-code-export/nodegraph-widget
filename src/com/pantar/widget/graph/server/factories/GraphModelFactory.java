/**
 * 
 */
package com.pantar.widget.graph.server.factories;

import com.pantar.widget.graph.server.GraphModel;
import com.pantar.widget.graph.server.GraphModelImpl;

/**
 * @author mauro.monti
 * 
 */
public class GraphModelFactory {

    /**
     * @return
     */
    public static GraphModel getGraphModelInstance() {
        return new GraphModelImpl();
    }
}
