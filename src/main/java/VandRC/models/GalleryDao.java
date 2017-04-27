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
public class GalleryDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Gallery> getAll() {
        return entityManager.createQuery("from Gallery").getResultList();
    }
}
