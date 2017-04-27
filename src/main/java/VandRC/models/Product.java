package VandRC.models;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Mikołaj on 27.04.2017.
 */
@Entity
@Table(name ="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productID;
    private int galleryID;
    private String description;
    private int workerID;
    private Date dateModification;
    private String warnings;

    public Product() {
    }

    public Product(int productID, int galleryID, String description, int workerID, Date dateModification, String warnings) {
        this.productID = productID;
        this.galleryID = galleryID;
        this.description = description;
        this.workerID = workerID;
        this.dateModification = dateModification;
        this.warnings = warnings;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getGalleryID() {
        return galleryID;
    }

    public void setGalleryID(int galleryID) {
        this.galleryID = galleryID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getWorkerID() {
        return workerID;
    }

    public void setWorkerID(int workerID) {
        this.workerID = workerID;
    }

    public Date getDateModification() {
        return dateModification;
    }

    public void setDateModification(Date dateModification) {
        this.dateModification = dateModification;
    }

    public String getWarnings() {
        return warnings;
    }

    public void setWarnings(String warnings) {
        this.warnings = warnings;
    }
}
