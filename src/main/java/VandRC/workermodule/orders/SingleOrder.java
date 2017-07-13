package VandRC.workermodule.orders;

import VandRC.models.Customer;
import VandRC.models.Order;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;


public class SingleOrder extends VerticalLayout {

    private Label id;
    private Label title;
    private Button manage;

    SingleOrder(Order order, Customer customer){

        HorizontalLayout root = new HorizontalLayout();

        id = new Label(String.valueOf(order.getOrderID()));
        title = new Label(order.getTitle());
        manage = new Button("Zarządzaj");

        root.addComponents(id,title,manage);

        addComponent(root);

    }
}
