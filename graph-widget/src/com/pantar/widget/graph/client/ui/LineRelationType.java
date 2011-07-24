/**
 * 
 */
package com.pantar.widget.graph.client.ui;

import org.vectomatic.dom.svg.OMSVGLineElement;
import org.vectomatic.dom.svg.utils.OMSVGParser;
import org.vectomatic.dom.svg.utils.SVGConstants;

import com.google.gwt.dom.client.Element;
import com.google.gwt.touch.client.Point;

/**
 * @author mauro.monti
 * 
 */
public class LineRelationType extends AbstractRelationType {

	/**
	 * 
	 */
	protected OMSVGLineElement omsvgLineElement;

	/**
	 * 
	 */
	public LineRelationType() {
		this.omsvgLineElement = OMSVGParser.currentDocument().createSVGLineElement(0, 0, 0, 0);
//		this.omsvgLineElement.setAttribute(SVGConstants.CSS_STROKE_WIDTH_PROPERTY, "2");
//		this.omsvgLineElement.setAttribute(SVGConstants.CSS_STROKE_VALUE, "black");
	}
	
	/**
	 * @param pRelationStyle
	 */
	public LineRelationType(RelationStyle pRelationStyle) {
		this();
		
		// = Apply SVG Style Attributes.
		super.applyAttributes(omsvgLineElement, pRelationStyle);
	}

	/**
	 * {@inheritdoc}
	 */
	@Override
	public void applyAttributes(RelationStyle pRelationStyle) {
		super.applyAttributes(omsvgLineElement, pRelationStyle);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(final Point pFromPoint, final Point pToPoint) {
		final int x1 = (int) Math.round(pFromPoint.getX());
		final int y1 = (int) Math.round(pFromPoint.getY());
		final int x2 = (int) Math.round(pToPoint.getX());
		final int y2 = (int) Math.round(pToPoint.getY());

		this.omsvgLineElement.setAttribute(SVGConstants.SVG_X1_ATTRIBUTE, String.valueOf(x1));
		this.omsvgLineElement.setAttribute(SVGConstants.SVG_Y1_ATTRIBUTE, String.valueOf(y1));
		this.omsvgLineElement.setAttribute(SVGConstants.SVG_X2_ATTRIBUTE, String.valueOf(x2));
		this.omsvgLineElement.setAttribute(SVGConstants.SVG_Y2_ATTRIBUTE, String.valueOf(y2));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Element getElement() {
		return this.omsvgLineElement.getElement();
	}
}
