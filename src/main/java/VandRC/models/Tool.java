package VandRC.models;

import javax.persistence.*;

/**
 * Created by Adam on 13.04.2017.
 */
@Entity
@Table(name = "tools")
public class Tool {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int toolID;
    private String name;
    private String path;
    private boolean status;

    public Tool() {
    }

    public Tool(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public int getToolID() {
        return toolID;
    }

    public void setToolID(int toolID) {
        this.toolID = toolID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
