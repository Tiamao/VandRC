package VandRC.views.historyview.SingleStatusHistoryRow;

import VandRC.models.Order;
import VandRC.views.historyview.HistoryView;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by Adam on 06.07.2017.
 */
public class TakenToRealizeRow extends HorizontalLayout{
    private Label titleValue;
    private Label statusTitle;
    private Label statusValue;
    private Label descriptionTitle;
    private Label descriptionValue;
    private Label inDateTitle;
    private Label inDateValue;
    private Label outDateTitle;
    private Label outDateValue;
    private Label sizeTitle;
    private Label sizeValue;
    private Label priceTitle;
    private Label priceValue;
    private Button cancel;

    public TakenToRealizeRow(Order order, String status, HistoryView historyView){
        setSpacing(true);
        addStyleName("layout-with-border");
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

        titleValue = new Label(order.getTitle());
        titleValue.setStyleName("secondtitleLabel_design");

        statusTitle = new Label("Status: ");
        statusTitle.setStyleName("orderdetailslabel_design");
        statusValue = new Label(status);
        statusValue.setStyleName("standardtext_design");

        descriptionTitle = new Label("Opis zamówienia: ");
        descriptionTitle.setStyleName("orderdetailslabel_design");
        descriptionValue = new Label(order.getDescription());
        descriptionValue.setStyleName("standardtext_design");

        inDateTitle = new Label("Data złożenia zamównienia: ");
        inDateTitle.setStyleName("orderdetailslabel_design");
        inDateValue = new Label(dateFormat.format(order.getInDate()));
        inDateValue.setStyleName("standardtext_design");

        outDateTitle = new Label("Data odbioru zamówienia: ");
        outDateTitle.setStyleName("orderdetailslabel_design");
        outDateValue = new Label(dateFormat.format(order.getInDate()));
        outDateValue.setStyleName("standardtext_design");

        sizeTitle = new Label("Rozmiar: ");
        sizeTitle.setStyleName("orderdetailslabel_design");
        sizeValue = new Label(String.valueOf(order.getSize()) + " " + order.getSizeType());
        sizeValue.setStyleName("standardtext_design");

        priceTitle = new Label("Cena: ");
        priceTitle.setStyleName("orderdetailslabel_design");
        priceValue = new Label(String.valueOf(order.getPrice()));
        priceValue.setStyleName("standardtext_design");

        cancel = new Button("Anuluj");
        cancel.addStyleName("orderbtn_design");

        GridLayout gridLayout = new GridLayout(3,5);
        gridLayout.setSpacing(true);
        gridLayout.setSizeFull();
        gridLayout.setWidth(100, Sizeable.Unit.PERCENTAGE);

        gridLayout.addComponent(titleValue, 0,0);
        gridLayout.addComponent(new HorizontalLayout(statusTitle, statusValue), 2,0);
        gridLayout.addComponent(descriptionTitle,0,1);
        gridLayout.addComponent(descriptionValue,1,1, 2,2);
        gridLayout.addComponent(new VerticalLayout(inDateTitle, inDateValue), 0,3);
        gridLayout.addComponent(new VerticalLayout(outDateTitle, outDateValue), 2,3);
        gridLayout.addComponent(new HorizontalLayout(sizeTitle, sizeValue), 0, 4);
        gridLayout.addComponent(new HorizontalLayout(priceTitle, priceValue), 1, 4);
        gridLayout.addComponent(cancel, 2, 4);
        gridLayout.setComponentAlignment(cancel,Alignment.MIDDLE_RIGHT);

        cancel.addClickListener(cancel->{
            order.setStatusID(3);
            historyView.updateOrderStatus(order);
            getUI().getNavigator().navigateTo(HistoryView.VIEW_NAME);
        });

        addComponent(gridLayout);
    }
}
