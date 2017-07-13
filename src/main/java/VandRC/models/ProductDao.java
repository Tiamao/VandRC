package VandRC.models;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Mikołaj on 27.04.2017.
 */
@Repository
@Transactional
public class ProductDao {

    @PersistenceContext
    private EntityManager entityManager;

    public String getImagePath(int productID){
        Product product = (Product) entityManager.createQuery("from Product where productID = :productID").setParameter("productID", productID).getSingleResult();
        return entityManager.find(Gallery.class, product.getGalleryID()).getPhotoPath();
    }

    public List<Product> getAll() {
        return entityManager.createQuery("from Product").getResultList();
    }

    public String getTitle(int productID) {
        Product product = (Product) entityManager.createQuery("from Product where productID = :productID").setParameter("productID", productID).getSingleResult();
        return entityManager.find(Gallery.class, product.getGalleryID()).getTitle();
    }
}
