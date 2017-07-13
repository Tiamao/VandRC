package VandRC.models;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Kamil on 06.07.2017.
 */
@Repository
@Transactional
public class AllergensInProductDao {


    @PersistenceContext
    private EntityManager entityManager;

    public void addAllergensToOrder(AllergensInOrder allergen){
        entityManager.persist(allergen);
    }

    public List<AllergensInProduct> getAllergensForProduct(int productID){
        return entityManager.createQuery("from AllergensInProduct where productID =:productID").setParameter("productID", productID).getResultList();
    }

}
