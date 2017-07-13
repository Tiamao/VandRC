package VandRC.models;

import javax.persistence.*;

/**
 * Created by Kamil on 24.06.2017.
 */
@Entity
@Table(name = "allergensInProduct")
public class AllergensInProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int aipID;
    private int productID;
    private int allergenID;

    public AllergensInProduct() {
    }

    public int getAipID() {
        return aipID;
    }

    public void setAipID(int aipID) {
        this.aipID = aipID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getAllergenID() {
        return allergenID;
    }

    public void setAllergenID(int allergenID) {
        this.allergenID = allergenID;
    }
}
