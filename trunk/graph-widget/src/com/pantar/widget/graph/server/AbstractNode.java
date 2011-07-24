/**
 * 
 */
package com.pantar.widget.graph.server;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.pantar.widget.graph.shared.model.TypeEnum;

/**
 * @author mauro.monti
 * 
 */
public abstract class AbstractNode implements Node {

    /**
     * 
     */
    protected String id;
    
    /**
     * 
     */
    protected TypeEnum type = TypeEnum.NODE;

    /**
     * 
     */
    protected String label;

    /**
     * 
     */
    protected Double x;
    
    /**
     * 
     */
    protected Double y;

    /**
     * 
     */
    protected Boolean selected;
    
    /**
     * 
     */
    protected Boolean enabled;

    /**
     * 
     */
    protected Set<Relation> outgoing = new HashSet<Relation>();
    
    /**
     * 
     */
    protected Set<Relation> incoming = new HashSet<Relation>();

    /**
     * 
     */
    protected NodeStyle nodeStyle;
    
    /**
     * 
     */
    protected GraphModel graphModel;
    
    /**
     * 
     */
    public AbstractNode() {
        this.id = UUID.randomUUID().toString();
        this.enabled = Boolean.TRUE;
        this.selected = Boolean.FALSE;
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
	 * {@inheritdoc}
	 */
	@Override
	public String getId() {
		return this.id;
	}

	/**
	 * {@inheritdoc}
	 */
	@Override
	public TypeEnum getType() {
		return this.type;
	}

	/**
	 * {@inheritdoc}
	 */
	@Override
	public Double getX() {
		return this.x;
	}

	/**
	 * {@inheritdoc}
	 */
	@Override
	public Double getY() {
		return this.y;
	}

	/**
	 * {@inheritdoc}
	 */
	@Override
	public Boolean hasLabel() {
		return (this.label != null && !this.label.isEmpty());
	}

	/**
	 * {@inheritdoc}
	 */
	@Override
	public String getLabel() {
		return this.label;
	}

	/**
	 * {@inheritdoc}
	 */
	@Override
	public Boolean isSelected() {
		return this.selected;
	}

	/**
	 * {@inheritdoc}
	 */
	@Override
	public Boolean isEnabled() {
		return this.enabled;
	}

	/**
	 * {@inheritdoc}
	 */
	@Override
	public NodeStyle getStyle() {
		return this.nodeStyle;
	}

	/**
	 * {@inheritdoc}
	 */
	@Override
	public void setStyle(NodeStyle pNodeStyle) {
		this.nodeStyle = pNodeStyle;
	}
    
}
