package VandRC.controllers;

import VandRC.models.Order;
import VandRC.models.OrderDao;
import VandRC.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Kamil on 10.05.2017.
 */
public class OrderController {
    @Autowired
    private OrderDao orderDao;

    @RequestMapping(value="/orders", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Order> getAll() {
        return orderDao.getAll();
    }

    public void makerOwnOrder(Order order){

    }

    public void makePredefinitedOrder(Product product){

    }

    public void makeOwnOrder(Order order){

    }

    public List<Order> getOrdersOnDay(){
        return orderDao.getOrdersOnDay();
    }
}
