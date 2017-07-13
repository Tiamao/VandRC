package VandRC.models;

import javax.persistence.*;

/**
 * Created by Kamil on 24.06.2017.
 */

@Entity
@Table(name = "toolsWithTags")
public class ToolsWithTags {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int toolsWithTagsID;
    private int toolID;
    private int tagID;

    public ToolsWithTags() {
    }

    public int getToolsWithTagsID() {
        return toolsWithTagsID;
    }

    public void setToolsWithTagsID(int toolsWithTagsID) {
        this.toolsWithTagsID = toolsWithTagsID;
    }

    public int getToolID() {
        return toolID;
    }

    public void setToolID(int toolID) {
        this.toolID = toolID;
    }

    public int getTagID() {
        return tagID;
    }

    public void setTagID(int tagID) {
        this.tagID = tagID;
    }
}
