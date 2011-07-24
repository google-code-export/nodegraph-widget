/**
 * 
 */
package com.pantar.widget.graph.server;

import java.util.UUID;

import com.pantar.widget.graph.shared.model.RelationTypeEnum;
import com.pantar.widget.graph.shared.model.TypeEnum;

/**
 * @author mauro.monti
 * 
 */
public abstract class AbstractRelation implements Relation {

	/**
	 * 
	 */
	protected String id;

	/**
	 * 
	 */
	protected TypeEnum type = TypeEnum.RELATION;

	/**
	 * 
	 */
	protected Node from;

	/**
	 * 
	 */
	protected String fromRef;

	/**
	 * 
	 */
	protected Node to;

	/**
	 * 
	 */
	protected String toRef;

	/**
	 * 
	 */
	protected RelationStyle relationStyle;

	/**
	 * 
	 */
	protected RelationTypeEnum relationType;

	/**
	 * 
	 */
	public AbstractRelation() {
		this.id = UUID.randomUUID().toString();
		this.relationType = RelationTypeEnum.LINE;
		this.relationStyle = new DefaultRelationStyle();
	}

	/**
	 * @param pId
	 */
	public AbstractRelation(final String pId) {
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
	public Node getNodeFrom() {
		return this.from;
	}

	/**
	 * {@inheritdoc}
	 */
	@Override
	public String getFromRef() {
		return this.fromRef;
	}
	
	/**
	 * {@inheritdoc}
	 */
	@Override
	public Node getNodeTo() {
		return this.to;
	}

	/**
	 * {@inheritdoc}
	 */
	@Override
	public String getToRef() {
		return this.toRef;
	}
	
	/**
	 * {@inheritdoc}
	 */
	@Override
	public RelationStyle getStyle() {
		return this.relationStyle;
	}

	/**
	 * {@inheritdoc}
	 */
	@Override
	public void setStyle(RelationStyle pRelationStyle) {
		this.relationStyle = pRelationStyle;
	}
	
	/**
	 * {@inheritdoc}
	 */
	@Override
	public RelationTypeEnum getRelationType() {
		return this.relationType;
	}
	
	/**
	 * {@inheritdoc}
	 */
	@Override
	public void setRelationType(RelationTypeEnum pRelationTypeEnum) {
		this.relationType = pRelationTypeEnum;
	}
}
