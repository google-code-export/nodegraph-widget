/**
 * 
 */
package com.pantar.widget.graph.server;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.pantar.widget.graph.shared.component.Type;
import com.pantar.widget.graph.shared.component.NodeTypeEnum;
import com.pantar.widget.graph.shared.component.style.NodeStyle;

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
    protected Type type = NodeTypeEnum.NODE;
    
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
        
        this.initialize();
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
     * 
     */
    abstract void initialize();
    
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
	public Type getType() {
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
	 * @param x
	 */
	public void setX(final Double x) {
		this.x = x;
	}
	
	/**
	 * {@inheritdoc}
	 */
	@Override
	public Double getY() {
		return this.y;
	}

	/**
	 * @param y
	 */
	public void setY(final Double y) {
		this.y = y;
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
	public void setLabel(final String pLabel) {
		this.label = pLabel;
	}
	
	/**
	 * {@inheritdoc}
	 */
	@Override
	public Boolean isSelected() {
		return this.selected;
	}

	/**
	 * @param selected
	 */
	public void setSelected(Boolean selected) {
		this.selected = selected;
	}
	
	/**
	 * {@inheritdoc}
	 */
	@Override
	public Boolean isEnabled() {
		return this.enabled;
	}

	/**
	 * @param enabled
	 */
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
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
	public void setStyle(final NodeStyle pNodeStyle) {
		this.nodeStyle = pNodeStyle;
	}
    
	/**
	 * @param graphModel
	 */
	public void setGraphModel(final GraphModel graphModel) {
		this.graphModel = graphModel;
	}
}
