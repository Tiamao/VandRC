package VandRC.models;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Adam on 13.04.2017.
 */

@Repository
@Transactional
public class AllergenDao {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Allergen> getAll() {
        return entityManager.createQuery("from Allergen").getResultList();
    }

}