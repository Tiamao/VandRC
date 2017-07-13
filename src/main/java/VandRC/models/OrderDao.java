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
        entityManager.persist(order);
    }

    public List<Order> getOrdersOnDay(){
        return entityManager.createQuery("").getResultList();
    }

    public List<Order> getOrdersForUser(int userID){
        return entityManager.createQuery("from Order where customerID =:userID").setParameter("userID", userID).getResultList();
    }

    public List<Order> getOrdersByStatus(int statusID){
        return entityManager.createQuery("from Order where statusID = :statusID").setParameter("statusID", statusID).getResultList();
    }

    public Order updateStatusOrder(int orderID, int orderStatus) {
        Order order = entityManager.find(Order.class, orderID);
        order.setStatusID(orderStatus);
        return entityManager.merge(order);
    }
}
