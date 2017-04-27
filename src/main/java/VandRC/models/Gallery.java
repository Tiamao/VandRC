package VandRC.models;

import javax.persistence.*;

/**
 * Created by Mikołaj on 27.04.2017.
 */
@Entity
@Table(name = "gallery")
public class Gallery {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private int galleryID;
    private String title;
    private String photoPath;

    public Gallery() {
    }

    public Gallery(String title, String photoPath) {
        this.title = title;
        this.photoPath = photoPath;
    }

    public int getGalleryID() {
        return galleryID;
    }

    public void setGalleryID(int galleryID) {
        this.galleryID = galleryID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }
}
