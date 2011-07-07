/**
 * 
 */
package com.pantar.widget.graph.server;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * @author mauro.monti
 * 
 */
public abstract class AbstractNode implements Node {

    private String id;
    private TypeEnum type = TypeEnum.NODE;

    private String label;

    private Double x;
    private Double y;

    private Boolean selected;

    private Set<Relation> outgoing = new HashSet<Relation>();
    private Set<Relation> incoming = new HashSet<Relation>();

    public AbstractNode() {
        this.id = UUID.randomUUID().toString();
    }

    /**
     * @param pId
     */
    public AbstractNode(final String pId) {
        this();
        if (pId != null) {
            this.id = pId;
        }
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    void setId(String id) {
        this.id = id;
    }

    /**
     * @return the type
     */
    public TypeEnum getType() {
        return type;
    }

    /**
     * @param type
     *            the type to set
     */
    void setType(TypeEnum type) {
        this.type = type;
    }

    /**
     * @return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param label
     *            the label to set
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.pantar.widget.graph.server.Node#hasLabel()
     */
    @Override
    public Boolean hasLabel() {
        return (this.label != null && this.label.length() > 0);
    }

    /**
     * @return the x
     */
    public Double getX() {
        return x;
    }

    /**
     * @param x
     *            the x to set
     */
    void setX(Double x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public Double getY() {
        return y;
    }

    /**
     * @param y
     *            the y to set
     */
    void setY(Double y) {
        this.y = y;
    }

    /**
     * @return the selected
     */
    Boolean getSelected() {
        return selected;
    }

    /**
     * @param selected
     *            the selected to set
     */
    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.pantar.widget.graph.server.Node#isSelected()
     */
    @Override
    public Boolean isSelected() {
        return this.getSelected();
    }

    /**
     * @return the outgoing
     */
    Set<Relation> getOutgoing() {
        return outgoing;
    }

    /**
     * @param outgoing
     *            the outgoing to set
     */
    void setOutgoing(Set<Relation> outgoing) {
        this.outgoing = outgoing;
    }

    /**
     * @return the incoming
     */
    Set<Relation> getIncoming() {
        return incoming;
    }

    /**
     * @param incoming
     *            the incoming to set
     */
    void setIncoming(Set<Relation> incoming) {
        this.incoming = incoming;
    }

}
