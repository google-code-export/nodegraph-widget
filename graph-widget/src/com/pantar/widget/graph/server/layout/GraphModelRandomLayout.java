/**
 * 
 */
package com.pantar.widget.graph.server.layout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.pantar.widget.graph.server.AbstractNode;
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
	private Random random = new Random(1000);
	
	/**
	 * 
	 */
	private GraphModel graphModel;
	
	/**
	 * {@inheritdoc}
	 */
	@Override
	public void layout(final GraphModel pGraphModel) {
		this.graphModel = pGraphModel;
		
		final List<Node> nodes = new ArrayList<Node>(this.graphModel.getNodes());
		
		for (final Node currentNode : nodes) {
			final AbstractNode abstractNode = (AbstractNode) currentNode;
			
			final Integer x = this.random.nextInt(1000);
			final Integer y = this.random.nextInt(1000);
			
			abstractNode.setX(x.doubleValue());
			abstractNode.setY(y.doubleValue());
		}
	}

}
