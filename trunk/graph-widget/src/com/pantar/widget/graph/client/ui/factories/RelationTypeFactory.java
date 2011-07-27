/**
 * 
 */
package com.pantar.widget.graph.client.ui.factories;

import com.pantar.widget.graph.client.ui.AbstractRelationType;
import com.pantar.widget.graph.client.ui.BezierRelationType;
import com.pantar.widget.graph.client.ui.LineRelationType;
import com.pantar.widget.graph.client.ui.RelationStyle;
import com.pantar.widget.graph.client.ui.RelationType;
import com.pantar.widget.graph.shared.component.RelationTypeEnum;

/**
 * @author mauro.monti
 * 
 */
public class RelationTypeFactory {

	/**
	 * @param pRelationTypeEnum
	 * @return
	 */
	public static RelationType getRelation(final RelationTypeEnum pRelationTypeEnum, final RelationStyle pRelationStyle) {
		AbstractRelationType relationType = null;
		if (RelationTypeEnum.LINE.equals(pRelationTypeEnum)) {
			relationType = new LineRelationType();

		} else if (RelationTypeEnum.BEZIER.equals(pRelationTypeEnum)) {
			relationType = new BezierRelationType();
		}
		relationType.applyAttributes(pRelationStyle);
		
		return relationType;
	}
		
}
