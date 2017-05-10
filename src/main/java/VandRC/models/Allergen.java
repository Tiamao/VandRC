package VandRC.models;

import javax.persistence.*;

/**
 * Created by Adam on 13.04.2017.
 */
@Entity
@Table(name = "allergens")
public class Allergen {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int allergenID;
    private String name;
    private boolean status;

    public Allergen() {
    }

    public Allergen(String name) {
        this.name = name;
    }

    public int getAllergenID() {
        return allergenID;
    }

    public void setAllergenID(int allergenID) {
        this.allergenID = allergenID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
