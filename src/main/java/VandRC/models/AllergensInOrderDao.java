package VandRC.models;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Kamil on 24.06.2017.
 */
@Repository
@Transactional
public class AllergensInOrderDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void addAllergensToOrder(AllergensInOrder allergen){
        entityManager.persist(allergen);
    }
}
