package VandRC.models;

import javax.persistence.*;

/**
 * Created by Kamil on 10.05.2017.
 */
@Entity
@Table(name = "statuses")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int statusID;
    private String description;

    public Status() {
    }

    public Status(String description) {
        this.description = description;
    }

    public int getStatusID() {
        return statusID;
    }

    public void setStatusID(int statusID) {
        this.statusID = statusID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
