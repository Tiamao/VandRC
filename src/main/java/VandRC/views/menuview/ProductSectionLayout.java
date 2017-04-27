package VandRC.views.menuview;

import VandRC.models.Product;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by Mikołaj on 27.04.2017.
 */
public class ProductSectionLayout extends HorizontalLayout {

    Image image;
    Label title;
    Label description;

    ProductSectionLayout(Product product){
        setSizeFull();
        image = new Image();
        image.setSource(new ExternalResource("sadsd")); // galleryid getPAth
        title = new Label("asdadadsasdasda");
        description = new Label("11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
        VerticalLayout descriptionLayout = new VerticalLayout(title,description);
        descriptionLayout.setSizeFull();

        addComponents(image,descriptionLayout);


        //SHOULD WORKS
//        ProductController controller = new ProductController();
//
//        setSizeFull();
//        image = new Image();
//        image.setSource(new ExternalResource(controller.getImagePath(product.getProductID()))); // galleryid getPAth
//        title = new Label(controller.getTitle(product.getProductID()));
//        description = new Label(product.getDescription());
//        VerticalLayout descriptionLayout = new VerticalLayout(title,description);
//        descriptionLayout.setSizeFull();
//
//        addComponents(image,descriptionLayout);
    }
}
