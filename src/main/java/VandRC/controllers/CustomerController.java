package VandRC.controllers;

import VandRC.models.Customer;
import VandRC.models.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Kamil on 02.04.2017.
 */
@Controller
public class CustomerController {

    @Autowired
    CustomerDao customerDao;

    @RequestMapping(value="/customers", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Customer> getAll() {
        return customerDao.getAll();
    }
}
