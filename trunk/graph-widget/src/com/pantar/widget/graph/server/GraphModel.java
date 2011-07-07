/**
 * 
 */
package com.pantar.widget.graph.server;

import java.util.Set;

/**
 * @author mauro.monti
 * 
 */
public interface GraphModel {

    /**
     * @param pNode
     */
    void addNode(Node pNode);

    /**
     * @param pRelation
     */
    void addRelation(Relation pRelation);

    /**
     * @param pFrom
     * @param pTo
     */
    void connect(final Node pFrom, final Node pTo);

    /**
     * @param pId
     * @return
     */
    Node getNodeById(final String pId);

    /**
     * @return
     */
    Set<Node> getNodes();

    /**
     * @return
     */
    Set<Relation> getRelations();

    /**
     * @param callback
     */
    void registerCallback(PropertyChangeCallback pCallback);
}
