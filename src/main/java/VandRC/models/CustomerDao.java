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

    public String getCustomerPassword(String customerEmail){
        Customer customer = (Customer) entityManager.createQuery("from Customer where mail =:customerEmail").setParameter("customerEmail", customerEmail).getSingleResult();

        return  customer.getPassword();
    }

    public void createNewCustomer(Customer customer){
        entityManager.persist(customer);
    }

    public List<Customer> getAllCustomers(){
        return entityManager.createQuery("from Customer").getResultList();
    }

    public boolean mailExists(String mail) {
        List<Customer> customers = entityManager.createQuery("from Customer where mail =:mail").setParameter("mail", mail).getResultList();
        if(customers.size()>0){
            return true;
        }else {
            return false;
        }
    }

    public int getUserIDbyMail(String mail){
        Customer customer = (Customer)entityManager.createQuery("from Customer where mail =:mail").setParameter("mail", mail).getSingleResult();
        return customer.getCustomerID();
    }

    public String getNameByMail(String mail){
        Customer customer = (Customer)entityManager.createQuery("from Customer where mail =:mail").setParameter("mail", mail).getSingleResult();
        return customer.getName();
    }

    public Customer getCustomerById(int id){
        return (Customer) entityManager.createQuery("from Customer where customerID =:id").setParameter("id", id).getSingleResult();
    }
}
