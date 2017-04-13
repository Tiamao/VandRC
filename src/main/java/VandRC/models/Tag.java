package VandRC.models;

import javax.persistence.*;

/**
 * Created by Adam on 13.04.2017.
 */
@Entity
@Table(name = "tags")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int tagID;
    private int toolID;
    private String tagName;

    public Tag() {
    }

    public Tag(int toolID, String tagName) {
        this.toolID = toolID;
        this.tagName = tagName;
    }

    public int getTagID() {
        return tagID;
    }

    public void setTagID(int tagID) {
        this.tagID = tagID;
    }

    public int getToolID() {
        return toolID;
    }

    public void setToolID(int toolID) {
        this.toolID = toolID;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}
