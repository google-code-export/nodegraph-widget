/**
 * 
 */
package com.pantar.widget.graph.server;

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
