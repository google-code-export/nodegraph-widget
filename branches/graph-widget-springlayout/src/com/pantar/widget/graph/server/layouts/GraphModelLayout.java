/**
 * 
 */
package com.pantar.widget.graph.server.layouts;

import com.pantar.widget.graph.server.GraphModel;

/**
 * @author mauro.monti
 *
 */
public interface GraphModelLayout {

	/**
	 * @param pGraphModel
	 */
	void layout(final GraphModel pGraphModel);
	
	/**
	 * @return
	 */
	GraphModel getModel();
}
