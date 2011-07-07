/**
 * 
 */
package com.pantar.widget.graph.server;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashSet;
import java.util.Set;

/**
 * @author mauro.monti
 * 
 */
public class GraphModelImpl implements GraphModel, PropertyChangeListener {

    private final Set<PropertyChangeCallback> callbacks = new HashSet<PropertyChangeCallback>();
    private final Set<Node> nodes = new HashSet<Node>();
    private final Set<Relation> relations = new HashSet<Relation>();

    /**
     * @param pNode
     */
    public void addNode(final Node pNode) {
        pNode.addPropertyChangeListener(this);
        this.nodes.add(pNode);
    }

    /**
     * @param pRelationship
     */
    public void addRelation(final Relation pRelationship) {
        pRelationship.addPropertyChangeListener(this);
        this.relations.add(pRelationship);
    }

    /**
     * @param pFrom
     * @param pTo
     */
    public void connect(final Node pFrom, final Node pTo) {
        if (!this.nodes.contains(pFrom)) {
            this.addNode(pFrom);
        }
        if (!this.nodes.contains(pTo)) {
            this.addNode(pTo);
        }

        final Relation defaultRelation = new DefaultRelation();
        defaultRelation.setNodeFrom(pFrom);
        defaultRelation.setNodeTo(pTo);

        this.addRelation(defaultRelation);
    }

    /**
     * @return the nodes
     */
    public Set<Node> getNodes() {
        return this.nodes;
    }

    /**
     * @return the relations
     */
    public Set<Relation> getRelations() {
        return this.relations;
    }

    /**
     * @param pId
     * @return
     */
    public Node getNodeById(final String pId) {
        for (final Node currentNode : this.nodes) {
            if (currentNode.getId().equals(pId)) {
                return currentNode;
            }
        }
        return null;
    }

    @Override
    public void registerCallback(PropertyChangeCallback pCallback) {
        this.callbacks.add(pCallback);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String propertyName = evt.getPropertyName();
        for (PropertyChangeCallback currentCallbak : this.callbacks) {
            if (currentCallbak.evaluatePropertyName(propertyName)) {
                currentCallbak.onPropertyChange(evt);
            }
        }
    }
}
