package VandRC.controllers;

import VandRC.models.AllergensInOrder;
import VandRC.models.AllergensInOrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Kamil on 01.07.2017.
 */
@Controller
public class AllergensInOrderController {
    @Autowired
    private AllergensInOrderDao aioDao;

    @RequestMapping(value = "/json/aio/{orderID}/{allergenID}", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public AllergensInOrder allergensInOrder(@PathVariable("orderID") int orderID, @PathVariable("allergenID") int allergenID){

        AllergensInOrder aio = new AllergensInOrder();

        aio.setAllergenID(allergenID);
        aio.setOrderID(orderID);
        aioDao.addAllergensToOrder(aio);
        return aio;
    }

//    @RequestMapping(value = "/json/aio/{orderID}/{allergenID}", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
//    @ResponseBody
//    public List<AllergensInOrder> getAllergensInOrder(){
//
//        AllergensInOrder aio = new AllergensInOrder();
//
//        aio.setAllergenID(allergenID);
//        aio.setOrderID(orderID);
//        aioDao.addAllergensToOrder(aio);
//        return aio;
//    }



}
