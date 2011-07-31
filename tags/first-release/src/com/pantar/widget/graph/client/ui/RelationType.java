/**
 * 
 */
package com.pantar.widget.graph.client.ui;

import com.google.gwt.dom.client.Element;
import com.google.gwt.touch.client.Point;

/**
 * @author mauro.monti
 * 
 */
public interface RelationType {

	/**
	 * @return
	 */
	Element getElement();

	/**
	 * @param pFromPoint
	 * @param pToPoint
	 */
	void update(final Point pFromPoint, final Point pToPoint);

}
