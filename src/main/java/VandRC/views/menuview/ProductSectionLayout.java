package VandRC.views.menuview;

import VandRC.controllers.CustomerController;
import VandRC.controllers.OrderController;
import VandRC.models.Allergen;
import VandRC.models.Gallery;
import VandRC.models.Product;
import VandRC.views.makeOrder.MakePredefinitedOrder;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.*;

import java.util.List;

/**
 * Created by Mikołaj on 27.04.2017.
 */
public class ProductSectionLayout extends HorizontalLayout {

    private Image image;
    private Label title;
    private Label description;
    private Button makePredefinitedOrder;

    ProductSectionLayout(Product product, Gallery gallery, List<Allergen> allergens, OrderController controller, CustomerController customerController, int customerID){
        setSpacing(true);
        makePredefinitedOrder = new Button("Zamów teraz!");
        makePredefinitedOrder.setStyleName("orderbtn_design");

        image = new Image();
        image.setSource(new ExternalResource(gallery.getPhotoPath()));
        image.setHeight(250, Unit.PIXELS);
        title = new Label(gallery.getTitle());
        title.setStyleName("productTitle_design");
       // title.setStyleName(ValoTheme.LABEL_BOLD);

        description = new Label(product.getDescription());


        VerticalLayout descriptionLayout = new VerticalLayout(title,description);
        descriptionLayout.setComponentAlignment(title, Alignment.TOP_CENTER);
        //descriptionLayout.setWidth(750, Unit.PIXELS);
        descriptionLayout.setWidth(100, Unit.PERCENTAGE);
        descriptionLayout.setHeight(250, Unit.PIXELS);
        descriptionLayout.addComponent(makePredefinitedOrder);
        descriptionLayout.setComponentAlignment(makePredefinitedOrder, Alignment.MIDDLE_RIGHT);

        addComponents(image,descriptionLayout);
        setExpandRatio(descriptionLayout,1.0F);

        descriptionLayout.setExpandRatio(description, 1.0F);
        setComponentAlignment(image, Alignment.MIDDLE_CENTER);
        addStyleName("layout-with-border");

        makePredefinitedOrder.addClickListener(clickEvent -> {
//            getUI().getNavigator().navigateTo(MakePredefinitedOrder.VIEW_NAME);
//            MakePredefinitedOrder mpo = new MakePredefinitedOrder();

            Window window = new Window();
            window.setWidth(60, Unit.PERCENTAGE);

            window.setContent(new MakePredefinitedOrder(product, gallery, allergens, controller, customerController, customerID, window));

            window.setHeight(80, Unit.PERCENTAGE);

            window.center();
            window.setDraggable(false);
            window.setModal(true);
            window.setResizable(false);
            window.setClosable(true);
            getUI().getUI().addWindow(window);


        });
    }
}
