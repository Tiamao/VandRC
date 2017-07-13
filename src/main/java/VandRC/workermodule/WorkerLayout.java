package VandRC.workermodule;

import VandRC.workermodule.orders.OrderView;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.*;

/**
 * Created by Kamil on 31.05.2017.
 */
public class WorkerLayout extends VerticalLayout {

    private VerticalLayout root;

    private VerticalLayout header;
    private Panel content;

    private Image logo;
    private MenuBar menuBar;




    WorkerLayout(){
        root = new VerticalLayout();
        root.setSizeFull();
        header = new VerticalLayout();
        root.setSizeFull();
        content = new Panel();
        content.setSizeFull();

        logo = new Image();
        logo.setSource(new ExternalResource("http://vanillaandraspberrycakes.com/wp-content/uploads/2017/02/cakes_circleXS.png"));
        logo.setHeight("190px");

        menuBar = new MenuBar();
        MenuBar.MenuItem item = menuBar.addItem(" testLabel", null);

        MenuBar.MenuItem calendar = menuBar.addItem(" Kalendarz", null);
        MenuBar.MenuItem orders = menuBar.addItem(" Zamówienia", null);
        MenuBar.MenuItem tools = menuBar.addItem(" Narzędzia", null);


        item.setCommand(e-> content.setContent(new Label("asdasdasdasd")));
        calendar.setCommand(e-> content.setContent(new CalendarLayout()));
        orders.setCommand(e-> content.setContent(new OrderView()));

        header.addComponent(logo);
        header.addComponent(menuBar);
        header.setComponentAlignment(logo, Alignment.MIDDLE_CENTER);
        header.setComponentAlignment(menuBar, Alignment.MIDDLE_CENTER);
        header.setSpacing(true);

        root.addComponents(header, content);

        addComponent(root);
    }
}
