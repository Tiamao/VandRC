package VandRC.models;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Kamil on 02.07.2017.
 */
@Repository
@Transactional
public class StatusDao {

    @PersistenceContext
    private EntityManager entityManager;

    public String getDescription(int statusID) {
        Status status = (Status) entityManager.createQuery("from Status where statusID = :statusID").setParameter("statusID", statusID).getSingleResult();
        return status.getDescription();
    }
}
