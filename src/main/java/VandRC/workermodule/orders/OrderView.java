package VandRC.workermodule.orders;

import VandRC.controllers.CustomerController;
import VandRC.controllers.OrderController;
import VandRC.models.Customer;
import VandRC.models.Order;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Kamil on 05.07.2017.
 */
public class OrderView extends VerticalLayout{


    @Autowired
    private OrderController orderController;

    @Autowired
    private CustomerController customerController;


    public OrderView(){

        List<Order> orders = orderController.getOrdersBystatus(1);

        orders.forEach(o->{
            Customer customer = customerController.getCustomerById(o.getCustomerID());
            SingleOrder singleOrder = new SingleOrder(o, customer);
            addComponent(singleOrder);
        });

    }
}
