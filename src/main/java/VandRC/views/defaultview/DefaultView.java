package VandRC.views.defaultview;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.VerticalLayout;

import javax.annotation.PostConstruct;

/**
 * Created by Kamil on 01.04.2017.
 */
@SpringView(name = DefaultView.VIEW_NAME)
public class DefaultView extends VerticalLayout implements View {
    public static final String VIEW_NAME = "";
    private VerticalLayout layout;

    private String path = "https://www.bbcgoodfood.com/sites/default/files/styles/recipe/public/recipe_images/recipe-image-legacy-id--1960_11.jpg?itok=U2w8rr7o";
    private String loremIpsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ante risus," +
            " consectetur scelerisque ipsum sit amet, luctus dictum enim. Nullam cursus suscipit porttitor." +
            " Maecenas ultricies tincidunt porta. Curabitur sagittis diam vitae suscipit finibus. " +
            "Aliquam et nunc eget erat commodo tempor et non lacus. Sed feugiat, tortor sed dapibus sodales, " +
            "tellus erat maximus metus, sed pharetra sapien dolor elementum sapien. Sed semper venenatis fermentum. " +
            "Praesent ut ullamcorper tortor. Proin mattis id tellus non pharetra. Suspendisse ipsum nisi," +
            " aliquet gravida lobortis id, facilisis id turpis. Cras ullamcorper nisl ut nisl pharetra suscipit. " +
            "Interdum et malesuada fames ac ante ipsum primis in faucibus.";

    @PostConstruct
    void init() {
        layout = new VerticalLayout();
        layout.setSizeFull();

        layout.addComponent(new SectionLayout(loremIpsum, path, true));
        layout.addComponent(new SectionLayout(loremIpsum, path, false));
        layout.addComponent(new SectionLayout(loremIpsum, path, true));

        layout.setWidth(80, Unit.PERCENTAGE);

        addComponent(layout);
        setComponentAlignment(layout, Alignment.MIDDLE_CENTER);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        // This view is constructed in the init() method()
    }
}
