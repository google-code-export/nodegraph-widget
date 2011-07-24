/**
 * 
 */
package com.pantar.widget.graph.server.layout;

import java.util.Random;
import java.util.Set;

import com.pantar.widget.graph.server.GraphModel;
import com.pantar.widget.graph.server.Node;

/**
 * @author mauro.monti
 *
 */
public class GraphModelRandomLayout implements GraphModelLayout {

	/**
	 * 
	 */
	private Set<Node> nodes;
	
	/**
	 * 
	 */
	private Random random = new Random(1000);
	
	/**
	 * {@inheritdoc}
	 */
	@Override
	public void layout(GraphModel pGraphModel) {
		this.nodes = pGraphModel.getNodes();
		
		for (Node currentNode : this.nodes) {
			Integer x = this.random.nextInt(1000);
			Integer y = this.random.nextInt(1000);
			currentNode.setPosition(x.doubleValue(), y.doubleValue());
		}
	}

}
