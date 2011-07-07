/**
 * 
 */
package com.pantar.widget.graph.client.ui;

/**
 * @author mauro.monti
 * 
 */
public class RelationTypeFactory {

	/**
	 * @param pRelationTypeEnum
	 * @return
	 */
	public static RelationType getRelation(final RelationTypeEnum pRelationTypeEnum) {
		RelationType relationType = null;

		if (RelationTypeEnum.LINE.equals(pRelationTypeEnum)) {
			relationType = new LineRelationType();

		} else if (RelationTypeEnum.BEZIER.equals(pRelationTypeEnum)) {
			relationType = new LineRelationType();
		}

		return relationType;
	}
}
