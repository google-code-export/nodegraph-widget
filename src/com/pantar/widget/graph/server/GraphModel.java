/**
 * 
 */
package com.pantar.widget.graph.server;

import java.beans.PropertyChangeListener;
import java.util.Set;

import com.pantar.widget.graph.server.events.EventType;
import com.pantar.widget.graph.server.events.PropertyChangeCallback;
import com.pantar.widget.graph.server.layouts.GraphModelLayout;
import com.pantar.widget.graph.server.styles.RelationStyle;
import com.pantar.widget.graph.shared.component.RelationTypeEnum;

/**
 * @author mauro.monti
 * 
 */
public interface GraphModel {
	
    /**
     * @param pNode
     */
    void addNode(Node pNode);

    /**
     * @param pRelation
     */
    void addRelation(Relation pRelation);

    /**
     * @param pFrom
     * @param pTo
     */
    void connect(final Node pFrom, final Node pTo);

    /**
     * @param pFrom
     * @param pTo
     * @param pRelation
     */
    void connect(final Node pFrom, final Node pTo, Relation pRelation);
    
    /**
     * @param pFrom
     * @param pTo
     * @param pRelationStyle
     */
    void connect(final Node pFrom, final Node pTo, RelationStyle pRelationStyle);
    
    /**
     * @param pFrom
     * @param pTo
     * @param pRelationTypeEnum
     */
    void connect(final Node pFrom, final Node pTo, RelationTypeEnum pRelationTypeEnum); 
    		
    /**
     * @param pFrom
     * @param pTo
     * @param pRelationTypeEnum
     * @param pRelationStyle
     */
    void connect(final Node pFrom, final Node pTo, RelationTypeEnum pRelationTypeEnum, RelationStyle pRelationStyle);
    
    /**
     * @return
     */
    Boolean isInitialized();
    
    /**
     * @param pId
     * @return
     */
    Node getNodeById(final String pId);

    /**
     * @return
     */
    Set<Node> getNodes();

    /**
     * @return
     */
    Set<Relation> getRelations();

    /**
     * Set the default state to all nodes of the graph.
     */
    void reset();
    
    /**
     * 
     */
    void unselectAllNodes();
    
    /**
     * 
     */
    void disableAllNodes();
    
    /**
     * @param pSingleSelectionSupport
     */
    void setSingleSelectionSupport(Boolean pSingleSelectionSupport);
    
    /**
     * @return
     */
    Boolean isSingleSelectionSupport();
    
    /**
     * @param pEventType
     * @param pCallback
     */
    void registerCallback(EventType pEventType, PropertyChangeCallback pCallback);
    
    /**
     * @param eventType
     * @param pCallback
     */
    void registerCallbacks(EventType[] eventType, PropertyChangeCallback pCallback);

    /**
     * @param pPropertyChangeListener
     */
    void addPropertyChangeListener(PropertyChangeListener pPropertyChangeListener);
    
    /**
     * @param pLayout
     */
    void layout(GraphModelLayout pLayout);
}
