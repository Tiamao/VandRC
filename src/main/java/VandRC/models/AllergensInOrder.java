package VandRC.models;

import javax.persistence.*;

/**
 * Created by Kamil on 24.06.2017.
 */
@Entity
@Table(name = "allergensInOrder")
public class AllergensInOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int aioID;
    private int orderID;
    private int allergenID;

    public AllergensInOrder() {
    }

    public int getAioID() {
        return aioID;
    }

    public void setAioID(int aioID) {
        this.aioID = aioID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getAllergenID() {
        return allergenID;
    }

    public void setAllergenID(int allergenID) {
        this.allergenID = allergenID;
    }
}
