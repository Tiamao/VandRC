package VandRC.models;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Kamil on 01.04.2017.
 */
@Repository
@Transactional
public class CityDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<City> getAll() {
        return entityManager.createQuery("from City").getResultList();
    }
}
