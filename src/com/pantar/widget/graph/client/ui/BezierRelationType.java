/**
 * 
 */
package com.pantar.widget.graph.client.ui;

import org.vectomatic.dom.svg.OMSVGPathElement;
import org.vectomatic.dom.svg.OMSVGPathSegCurvetoCubicAbs;
import org.vectomatic.dom.svg.OMSVGPathSegMovetoAbs;
import org.vectomatic.dom.svg.utils.OMSVGParser;
import org.vectomatic.dom.svg.utils.SVGConstants;

import com.google.gwt.dom.client.Element;
import com.google.gwt.touch.client.Point;

/**
 * @author mauro.monti
 * 
 */
public class BezierRelationType extends AbstractRelationType {

	/**
	 * 
	 */
	protected OMSVGPathElement omsvgPathElement;

	/**
	 * 
	 */
	public BezierRelationType() {
		this.omsvgPathElement = OMSVGParser.currentDocument().createSVGPathElement();
		this.omsvgPathElement.setAttribute(SVGConstants.CSS_FILL_OPACITY_PROPERTY, "0");

		final OMSVGPathSegMovetoAbs moveAbs = this.omsvgPathElement.createSVGPathSegMovetoAbs(0, 0);
		final OMSVGPathSegCurvetoCubicAbs curve = this.omsvgPathElement.createSVGPathSegCurvetoCubicAbs(0, 0, 0, 0, 0, 0);

		this.omsvgPathElement.getPathSegList().appendItem(moveAbs);
		this.omsvgPathElement.getPathSegList().appendItem(curve);
	}

	/**
	 * {@inheritdoc}
	 */
	@Override
	public void applyAttributes(final RelationStyle pRelationStyle) {
		super.applyAttributes(omsvgPathElement, pRelationStyle);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(final Point pFromPoint, final Point pToPoint) {

		final float sx = Double.valueOf(pFromPoint.getX()).floatValue();
		final float sy = Double.valueOf(pFromPoint.getY()).floatValue();
		final float ex = Double.valueOf(pToPoint.getX()).floatValue();
		final float ey = Double.valueOf(pToPoint.getY()).floatValue();

		final OMSVGPathSegMovetoAbs move = this.omsvgPathElement.getPathSegList().getItem(0).cast();
		final OMSVGPathSegCurvetoCubicAbs curve = this.omsvgPathElement.getPathSegList().getItem(1).cast();

		move.setX(sx);
		move.setY(sy);
		curve.setX(ex);
		curve.setY(ey);

		if (pFromPoint.equals(pToPoint)) {

			final float constant = 100;

			final float cpX1 = sx - constant;
			float cpY1 = sy - constant;
			final float cpX2 = ex + constant;
			float cpY2 = ey - constant;

			if (pFromPoint.getY() < constant) {
				cpY1 = sy + constant;
				cpY2 = ey + constant;
			}

			curve.setX1(cpX1);
			curve.setY1(cpY1);
			curve.setX2(cpX2);
			curve.setY2(cpY2);

		} else {

			final float diffSXEX = ex - sx;
			final float middleSegment = (diffSXEX / 2);

			final float cpX1 = sx + middleSegment;
			final float cpY1 = sy;
			final float cpX2 = ex - middleSegment;
			final float cpY2 = ey;

			curve.setX1(cpX1);
			curve.setY1(cpY1);
			curve.setX2(cpX2);
			curve.setY2(cpY2);
		}

		this.omsvgPathElement.getPathSegList().clear();
		this.omsvgPathElement.getPathSegList().insertItemBefore(move, 0);
		this.omsvgPathElement.getPathSegList().insertItemBefore(curve,1);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Element getElement() {
		return this.omsvgPathElement.getElement();
	}
}
