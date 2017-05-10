package VandRC.models;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Adam on 13.04.2017.
 */
@Repository
@Transactional
public class TagDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Tag> getAll() {
        return entityManager.createQuery("from Tag").getResultList();
    }

    public List<Tag> getToolTags(Tool tool){
        return entityManager.createQuery("").getResultList();
    }
}
