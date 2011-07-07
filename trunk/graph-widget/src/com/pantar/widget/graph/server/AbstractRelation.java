/**
 * 
 */
package com.pantar.widget.graph.server;

import java.util.UUID;

/**
 * @author mauro.monti
 * 
 */
public abstract class AbstractRelation implements Relation {

	private String id;
	private TypeEnum type = TypeEnum.RELATION;

	private Node from;
	protected String fromRef;

	private Node to;
	protected String toRef;

	protected RelationStyle relationStyle;

	/**
	 * 
	 */
	public AbstractRelation() {
		this.id = UUID.randomUUID().toString();
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
	 * @return the id
	 */
	@Override
	public String getId() {
		return this.id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	void setId(final String id) {
		this.id = id;
	}

	/**
	 * @return the type
	 */
	@Override
	public TypeEnum getType() {
		return this.type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	void setType(final TypeEnum type) {
		this.type = type;
	}

	/**
	 * @return the from
	 */
	Node getFrom() {
		return this.from;
	}

	/**
	 * @param from
	 *            the from to set
	 */
	void setFrom(final Node from) {
		this.from = from;
	}

	/**
	 * @return the fromRef
	 */
	String getFromRef() {
		return this.fromRef;
	}

	/**
	 * @param fromRef
	 *            the fromRef to set
	 */
	void setFromRef(final String fromRef) {
		this.fromRef = fromRef;
	}

	/**
	 * @return the to
	 */
	Node getTo() {
		return this.to;
	}

	/**
	 * @param to
	 *            the to to set
	 */
	void setTo(final Node to) {
		this.to = to;
	}

	/**
	 * @return the toRef
	 */
	String getToRef() {
		return this.toRef;
	}

	/**
	 * @param toRef
	 *            the toRef to set
	 */
	void setToRef(final String toRef) {
		this.toRef = toRef;
	}

	@Override
	public Node getNodeFrom() {
		return this.getFrom();
	}

	@Override
	public Node getNodeTo() {
		return this.getTo();
	}

}
