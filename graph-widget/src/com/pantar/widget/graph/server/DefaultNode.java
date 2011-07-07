/**
 * 
 */
package com.pantar.widget.graph.server;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * @author mauro.monti
 * 
 */
public class DefaultNode extends AbstractNode {

    /**
     * 
     */
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    /**
     * 
     */
    public DefaultNode() {
        super();
    }

    /**
     * @param pId
     */
    public DefaultNode(String pId) {
        super(pId);
    }

    @Override
    public void setLabel(String label) {
        String oldLabel = this.getLabel();
        if (oldLabel != null && oldLabel.equals(label)) {
            return;
        }
        super.setLabel(label);
        this.propertyChangeSupport.firePropertyChange("label", oldLabel, this.getLabel());
    }

    @Override
    public void setPosition(Double pPosX, Double pPosY) {
        Double oldX = this.getX();
        Double oldY = this.getY();

        if ((oldX != null && oldX.equals(pPosX)) && (oldX != null && oldY.equals(pPosY))) {
            return;
        }

        this.setX(pPosX);
        this.setY(pPosY);

        Double[] oldPoints = { oldX, oldY };
        Double[] newPoints = { this.getX(), this.getY() };

        this.propertyChangeSupport.firePropertyChange("position", oldPoints, newPoints);
    }

    @Override
    public void setSelected(Boolean selected) {
        Boolean oldSelected = this.getSelected();
        if (oldSelected != null && oldSelected.equals(selected)) {
            return;
        }
        super.setSelected(selected);
        this.propertyChangeSupport.firePropertyChange("selected", oldSelected, selected);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        this.propertyChangeSupport.addPropertyChangeListener(propertyChangeListener);
    }
}
