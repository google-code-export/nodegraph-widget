package com.pantar.widget.graph.client.ui;

import com.google.gwt.touch.client.Point;
import com.pantar.widget.graph.shared.GraphConstants;

/**
 * @author mauro.monti
 * 
 */
public class Relation {

	/**
	 * 
	 */
	protected String id;

	/**
	 * 
	 */
	protected Node from = null;

	/**
	 * 
	 */
	protected Node to = null;

	/**
	 * 
	 */
	protected VGraphComponent parent;

	/**
	 * 
	 */
	protected RelationTypeEnum relationTypeEnum;

	/**
	 * 
	 */
	protected RelationType relationType;

	/**
	 * 
	 */
	protected RelationStyle relationStyle;

	/**
	 * @param pParent
	 * @param pNodeFrom
	 * @param pNodeTo
	 */
	public Relation(final VGraphComponent pParent, final Node pNodeFrom, final Node pNodeTo) {
		this(pParent, pNodeFrom, pNodeTo, RelationTypeEnum.LINE, new DefaultRelationStyle());
	}

	/**
	 * @param pParent
	 * @param pNodeFrom
	 * @param pNodeTo
	 * @param pRelationTypeEnum
	 * @param pRelationStyle
	 */
	public Relation(final VGraphComponent pParent, final Node pNodeFrom, final Node pNodeTo, final RelationTypeEnum pRelationTypeEnum, final RelationStyle pRelationStyle) {
		if (pNodeFrom == null) {
			throw new IllegalArgumentException("Node FROM cannot be null");
		}
		if (pNodeTo == null) {
			throw new IllegalArgumentException("Node TO cannot be null");
		}

		this.parent = pParent;
		this.from = pNodeFrom;
		this.to = pNodeTo;
		this.relationStyle = pRelationStyle;
		this.relationTypeEnum = pRelationTypeEnum;

		this.initializeRelation();
	}

	/**
	 * 
	 */
	private void initializeRelation() {
		this.id = GraphConstants.RELATION_NAME + "-" + this.from.getId() + "-" + this.to.getId();

		if (this.isSelfRelation()) {
			this.relationType = RelationTypeFactory.getRelation(RelationTypeEnum.BEZIER);
		} else {
			this.relationType = RelationTypeFactory.getRelation(this.relationTypeEnum);
		}

		this.relationType.getElement().setId(this.id);

		this.from.addOutgoing(this);
		this.to.addIncoming(this);

		for (final String key : this.relationStyle.getKeys()) {
			this.relationType.getElement().setAttribute(key, this.relationStyle.getStyleValue(key));
		}

		this.parent.add(this.relationType.getElement());
	}

	/**
	 * 
	 */
	void update() {
		final double x1 = this.from.getCenterX();
		final double y1 = this.from.getCenterY();
		final double x2 = this.to.getCenterX();
		final double y2 = this.to.getCenterY();

		final Point fromPoint = new Point(x1, y1);
		final Point toPoint = new Point(x2, y2);

		this.relationType.update(fromPoint, toPoint);
	}

	/**
	 * 
	 */
	private Boolean isSelfRelation() {
		final double x1 = this.from.getCenterX();
		final double y1 = this.from.getCenterY();
		final double x2 = this.to.getCenterX();
		final double y2 = this.to.getCenterY();

		if ((x1 == x2) && (y1 == y2)) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
}
