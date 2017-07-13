package VandRC.models;

import javax.persistence.*;

/**
 * Created by Kamil on 24.06.2017.
 */

@Entity
@Table(name = "toolsInOrder")
public class ToolsInOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int tioID;
    private int orderID;
    private int toolID;

    public ToolsInOrder() {
    }

    public int getTioID() {
        return tioID;
    }

    public void setTioID(int tioID) {
        this.tioID = tioID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getToolID() {
        return toolID;
    }

    public void setToolID(int toolID) {
        this.toolID = toolID;
    }
}
