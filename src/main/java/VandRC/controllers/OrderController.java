package VandRC.controllers;

import VandRC.models.Order;
import VandRC.models.OrderDao;
import VandRC.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Kamil on 10.05.2017.
 */
@Controller
public class OrderController {

    public OrderController(){

    }

    @Autowired
    private OrderDao orderDao;

    @RequestMapping(value="/orders", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Order> getAll() {
        return orderDao.getAll();
    }

    public void makePredefinitedOrder(Product product){

    }


    @RequestMapping(value="/json/orders/{statusID}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Order> getOrdersBystatus(@PathVariable("statusID") int statusID){
        return orderDao.getOrdersByStatus(statusID);
    }

    @RequestMapping(value = "/json/makeOrder/{customerID}/{inDate}/{outDate}/{size}/{sizeType}/{description}/{phoneNumber}/{title}", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Order makeOwnOrder(@PathVariable("customerID") int customerID, @PathVariable("inDate") long inDate, @PathVariable("outDate") long outDate, @PathVariable("size") int size, @PathVariable("sizeType") String sizeType, @PathVariable("description") String description, @PathVariable("phoneNumber") String phoneNumber, @PathVariable("title") String title){

        Order order = new Order();

        order.setCustomerID(customerID);// wyciagnac z sesji??
        order.setInDate(inDate);
        order.setOutDate(outDate);
        order.setWorkerID(5); // temp
        order.setStatusID(1);
        order.setSize(size);
        order.setSizeType(sizeType);
        order.setDescription(description);
        order.setPhoneNumber(phoneNumber);
        order.setTitle(title);

        order.setProductID(10); //temp



        orderDao.makeOwnOrder(order);
        return order;
    }

    public List<Order> getOrdersOnDay(){
        return orderDao.getOrdersOnDay();
    }

    public List<Order> getOrderForUser(int userID){
        return  orderDao.getOrdersForUser(userID);
    }

    @RequestMapping(value="/json/orders/{orderID}/{orderStatus}/", method = RequestMethod.PUT, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Order updateStatus(int orderID, int orderStatus) {
        Order o = new Order();
        o.setOrderID(orderID);
        o.setStatusID(orderStatus);
        orderDao.updateStatusOrder(orderID, orderStatus);
        return o;
    }
}
