package VandRC.views.menuview;

import VandRC.models.Product;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Created by Mikołaj on 27.04.2017.
 */
public class ProductSectionLayout extends HorizontalLayout {

    Image image;
    Label title;
    Label description;
    private String path = "https://www.bbcgoodfood.com/sites/default/files/styles/recipe/public/recipe_images/recipe-image-legacy-id--1960_11.jpg?itok=U2w8rr7o";
    private String loremIpsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ante risus," +
            " consectetur scelerisque ipsum sit amet, luctus dictum enim. Nullam cursus suscipit porttitor." +
            " Maecenas ultricies tincidunt porta. Curabitur sagittis diam vitae suscipit finibus. " +
            "Aliquam et nunc eget erat commodo tempor et non lacus. Sed feugiat, tortor sed dapibus sodales, " +
            "tellus erat maximus metus, sed pharetra sapien dolor elementum sapien. Sed semper venenatis fermentum. " +
            "Praesent ut ullamcorper tortor. Proin mattis id tellus non pharetra. Suspendisse ipsum nisi," +
            " aliquet gravida lobortis id, facilisis id turpis. Cras ullamcorper nisl ut nisl pharetra suscipit. " +
            "Interdum et malesuada fames ac ante ipsum primis in faucibus.";
    ProductSectionLayout(){
        setSpacing(true);

        image = new Image();
        image.setSource(new ExternalResource(path)); // galleryid getPAth
        image.setHeight(250, Unit.PIXELS);

        title = new Label("asdadadsasdasda");
        title.setStyleName(ValoTheme.LABEL_BOLD);

        description = new Label(loremIpsum);
//        description.setSizeFull();
        VerticalLayout descriptionLayout = new VerticalLayout(title,description);
        descriptionLayout.setComponentAlignment(title, Alignment.TOP_CENTER);
        descriptionLayout.setWidth(750, Unit.PIXELS);
        descriptionLayout.setHeight(250, Unit.PIXELS);

        addComponents(image,descriptionLayout);

        descriptionLayout.setExpandRatio(description, 1.0F);
        setComponentAlignment(image, Alignment.MIDDLE_CENTER);


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

    ProductSectionLayout(Product product){
        setSizeFull();
        image = new Image();
        image.setSource(new ExternalResource(path)); // galleryid getPAth
        title = new Label("asdadadsasdasda");
        description = new Label("11111111111111111111");
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
