package VandRC.views.galleryview;

import VandRC.controllers.GalleryController;
import VandRC.models.Gallery;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.ExternalResource;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Image;
import com.vaadin.ui.VerticalLayout;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by Mikołaj on 27.04.2017.
 */
@SpringView(name = GalleryView.VIEW_NAME)
public class GalleryView extends VerticalLayout implements View {

    public static final String VIEW_NAME = "gallery";

    private Image image;
    @PostConstruct
    void init() {
        GalleryController controller = new GalleryController();
        List<Gallery> galleryList = controller.getAll();

        galleryList.forEach( g->{
            image = new Image(g.getTitle());
            image.setSource(new ExternalResource(g.getPhotoPath()));
            addComponent(image);
        });
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        // This view is constructed in the init() method()
    }
}
