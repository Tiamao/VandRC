package VandRC.controllers;

import VandRC.models.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by Kamil on 02.04.2017.
 */
@Controller
public class CustomerController {

    @Autowired
    CustomerDao customerDao;

    public String getCustomerPassword(String customerEmail){
        return "";
    }
}
