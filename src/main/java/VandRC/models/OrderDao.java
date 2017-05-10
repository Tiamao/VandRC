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
public class OrderDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Order> getAll() {
        return entityManager.createQuery("from Order").getResultList();
    }

    public void makePredefinitedOrder(Product product){

    }

    public void makeOwnOrder(Order order){

    }

    public List<Order> getOrdersOnDay(){
        return entityManager.createQuery("").getResultList();
    }

}
