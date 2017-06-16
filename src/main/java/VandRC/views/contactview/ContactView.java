package VandRC.views.contactview;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import javax.annotation.PostConstruct;

/**
 * Created by Kamil on 25.05.2017.
 */
@SpringView(name = ContactView.VIEW_NAME)
public class ContactView extends VerticalLayout implements View {
    public static final String VIEW_NAME = "contact";
    private VerticalLayout root;
    private HorizontalLayout layout;

    private Label title;
    //    private GoogleMap map;
    private Label address;
    private Label phoneNumber;
    private Label email;
    private VerticalLayout dataLayout;

    @PostConstruct
    void init() {

        root = new VerticalLayout();
        root.setSizeFull();
        title = new Label("Kontakt");

//        GoogleMap map = new GoogleMap("apiKey", null, "english");
//        map.setSizeFull();
//        map.addMarker("tu jesteśmy", new LatLon(60.442423, 22.26044), true, null);
//        map.setMinZoom(4);
//        map.setMaxZoom(16);
//        LMap map = new LMap();
//        map.addBaseLayer(new LOpenStreetMapLayer(), "CloudMade");
//        map.setSizeFull();
//        map.setMaxZoom(16);
//        map.setMinZoom(4);

                address = new Label("asdasdasdasdasdasdaadres");
        phoneNumber = new Label("asdasdasdasdasdasdanumer");
        email = new Label("asdasdasdasdasdasdamail");
        dataLayout = new VerticalLayout();
        dataLayout.setSizeFull();

        dataLayout.addComponents(address, phoneNumber, email);


        root.addComponent(title);
        layout = new HorizontalLayout();
        layout.setSizeFull();
        layout.addComponents( dataLayout);


        root.setWidth(80, Unit.PERCENTAGE);
        addComponent(root);
        root.addComponent(layout);
        root.setComponentAlignment(layout, Alignment.MIDDLE_CENTER);

    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

    }
}
