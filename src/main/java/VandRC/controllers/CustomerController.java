package VandRC.controllers;

import VandRC.models.Customer;
import VandRC.models.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Kamil on 02.04.2017.
 */
@Controller
public class CustomerController {

    public CustomerController(){

    }

    @Autowired
    CustomerDao customerDao;

    @RequestMapping(value="/json/customer/{customerEmail}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public String getCustomerPassword(@PathVariable("customerEmail") String customerEmail){
        return customerDao.getCustomerPassword(customerEmail);
    }

    @RequestMapping(value="/json/customer/new/{name}/{surname}/{mail}/{password}", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Customer newCustomer(@PathVariable("name") String name, @PathVariable("surname") String surname, @PathVariable("mail") String mail, @PathVariable("password") String password){
        Customer customer = new Customer();
        customer.setName(name);
        customer.setSurname(surname);
        customer.setMail(mail);
        customer.setPassword(password);
        customerDao.createNewCustomer(customer);

        return customer;
    }

    @RequestMapping(value="/json/customer/exists/{mail}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public boolean mailExists(String mail) {
        return customerDao.mailExists(mail);
    }


    @RequestMapping(value="/json/customer/id/{mail}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public int getUserIDbyMail(@PathVariable("mail") String mail) {
        return customerDao.getUserIDbyMail(mail);
    }

    @RequestMapping(value="/json/customer/name/{mail}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public String getNameByMail(@PathVariable("mail") String mail) {
        return customerDao.getNameByMail(mail);
    }

    @RequestMapping(value="/json/customer/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Customer getCustomerById(@PathVariable("id") int id){
        return customerDao.getCustomerById(id);
    }

}
