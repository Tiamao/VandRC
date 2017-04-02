package VandRC.models;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Kamil on 02.04.2017.
 */
@Repository
@Transactional
public class CustomerDao {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Customer> getAll() {
        return entityManager.createQuery("from Customer").getResultList();
    }

}
