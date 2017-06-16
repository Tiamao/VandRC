package VandRC.views.galleryview;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.ExternalResource;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mikołaj on 27.04.2017.
 */
@SpringView(name = GalleryView.VIEW_NAME)
public class GalleryView extends HorizontalLayout implements View {

    public static final String VIEW_NAME = "gallery";
    private String path = "https://www.bbcgoodfood.com/sites/default/files/styles/recipe/public/recipe_images/recipe-image-legacy-id--1960_11.jpg?itok=U2w8rr7o";

    private Image image;
    private Image image1;
    private Image image2;
    private Image image3;
    private Image image4;

    @PostConstruct
    void init() {
//        GalleryItemController controller = new GalleryItemController();
//        List<GalleryItem> galleryItemList = controller.getAll();
//
//        galleryItemList.forEach(g->{
//            image = new Image(g.getTitle());
//            image.setSource(new ExternalResource(g.getPhotoPath()));
//            addComponent(image);
//        });

        image1 = new Image();
        image1.setSource(new ExternalResource(path));

        image2 = new Image();
        image2.setSource(new ExternalResource(path));

        image3 = new Image();
        image3.setSource(new ExternalResource(path));

        image4 = new Image();
        image4.setSource(new ExternalResource(path));

        image = new Image();
        image.setSource(new ExternalResource(path));

        List<Image> images = new ArrayList<>();
        images.add(image);
        images.add(image1);
        images.add(image2);
        images.add(image3);
        images.add(image4);

        images.forEach(i ->{
            addComponent(i);
        });

        setWidth(100, Unit.PERCENTAGE);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        // This view is constructed in the init() method()
    }
}
