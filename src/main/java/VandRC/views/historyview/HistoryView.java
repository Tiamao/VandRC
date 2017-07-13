package VandRC.views.historyview;

import VandRC.controllers.AllergenController;
import VandRC.controllers.CustomerController;
import VandRC.controllers.OrderController;
import VandRC.controllers.StatusController;
import VandRC.models.Order;
import VandRC.views.historyview.SingleStatusHistoryRow.EvaluatedOrderRow;
import VandRC.views.historyview.SingleStatusHistoryRow.TakenToRealizeRow;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinSession;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by Kamil on 25.05.2017.
 */
@SpringView(name = HistoryView.VIEW_NAME)
public class HistoryView extends VerticalLayout implements View {
    public static final String VIEW_NAME = "history";
    private VerticalLayout layout;
    private Label Title;
    private String username = String.valueOf(VaadinSession.getCurrent().getAttribute("user"));

    @Autowired
    private CustomerController customerController;

    @Autowired
    private OrderController orderController;

    @Autowired
    private StatusController statusController;

    @Autowired
    private AllergenController allergenController;

    @PostConstruct
    void init() {
        int userID = customerController.getUserIDbyMail(username);
        List<Order> orders = orderController.getOrderForUser(userID);

        Title = new Label("Historia zamówień");
        Title.setStyleName("titleFormLabel_design");
        setSpacing(true);

        layout = new VerticalLayout();
        layout.setSizeFull();
        layout.setSpacing(true);
        layout.setMargin(new MarginInfo(true, false));
        layout.addComponent(Title);
        layout.setComponentAlignment(Title, Alignment.MIDDLE_LEFT);

        if (orders.isEmpty()) {
            Label lbl = new Label("Brak zamówień");
            layout.addComponent(lbl);
            layout.setComponentAlignment(lbl, Alignment.MIDDLE_CENTER);
        } else {
            orders.forEach(e -> {
                String status = statusController.getDescription(e.getStatusID());
                switch (e.getStatusID()){
                    case 1:

                        TakenToRealizeRow przyjeteDoRealizacji = new TakenToRealizeRow(e, status, this);
                        przyjeteDoRealizacji.setWidth(80, Unit.PERCENTAGE);
                        layout.addComponent(przyjeteDoRealizacji);
                        layout.setComponentAlignment(przyjeteDoRealizacji, Alignment.MIDDLE_CENTER);
                        break;
                    case 2:
                        SingleHistoryRow odrzucone = new SingleHistoryRow(e,status,this, allergenController,orderController,customerController);
                        odrzucone.setWidth(80, Unit.PERCENTAGE);
                        layout.addComponent(odrzucone);
                        layout.setComponentAlignment(odrzucone, Alignment.MIDDLE_CENTER);
                        break;
                    case 3:
                        SingleHistoryRow anulowane = new SingleHistoryRow(e,status,this, allergenController,orderController,customerController);
                        anulowane.setWidth(80, Unit.PERCENTAGE);
                        layout.addComponent(anulowane);
                        layout.setComponentAlignment(anulowane, Alignment.MIDDLE_CENTER);
                        break;
                    case 4:
                        SingleHistoryRow wprzygotowaniu = new SingleHistoryRow(e,status,this, allergenController,orderController,customerController);
                        wprzygotowaniu.setWidth(80, Unit.PERCENTAGE);
                        layout.addComponent(wprzygotowaniu);
                        layout.setComponentAlignment(wprzygotowaniu, Alignment.MIDDLE_CENTER);
                        break;
                    case 5:
                        SingleHistoryRow gotowedoodbioru = new SingleHistoryRow(e,status,this, allergenController,orderController,customerController);
                        gotowedoodbioru.setWidth(80, Unit.PERCENTAGE);
                        layout.addComponent(gotowedoodbioru);
                        layout.setComponentAlignment(gotowedoodbioru, Alignment.MIDDLE_CENTER);
                        break;
                    case 6:
                        EvaluatedOrderRow wycenione = new EvaluatedOrderRow(e,status,this);
                        wycenione.setWidth(80, Unit.PERCENTAGE);
                        layout.addComponent(wycenione);
                        layout.setComponentAlignment(wycenione, Alignment.MIDDLE_CENTER);
                }
            });
        }

        layout.setWidth(80, Unit.PERCENTAGE);
        addComponent(layout);
        setComponentAlignment(layout, Alignment.MIDDLE_CENTER);
    }


    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

    }

    public void updateOrderStatus(Order order) {
        orderController.updateStatus(order.getOrderID(), order.getStatusID());
    }
}
