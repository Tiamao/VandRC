package VandRC.models;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * Created by Kamil on 02.04.2017.
 */
@Repository
@Transactional
public class CustomerDao {
    @PersistenceContext
    private EntityManager entityManager;

    public String getCustomerPassword(String customerEmail){
        return "";
    }

}
