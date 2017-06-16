package VandRC.views.historyview;

import com.vaadin.server.ExternalResource;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Kamil on 25.05.2017.
 */
public class SingleHistoryRow extends HorizontalLayout {

    private Image image;
    private Label title;
    private Label dateField;
    private Label description;
    private Label size;
    private Label price;
    private Button orderAgain;
    private Label status;

    private String path = "https://www.bbcgoodfood.com/sites/default/files/styles/recipe/public/recipe_images/recipe-image-legacy-id--1960_11.jpg?itok=U2w8rr7o";
    private String loremIpsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ante risus," +
            " consectetur scelerisque ipsum sit amet, luctus dictum enim. Nullam cursus suscipit porttitor." +
            " Maecenas ultricies tincidunt porta. Curabitur sagittis diam vitae suscipit finibus. " +
            "Aliquam et nunc eget erat commodo tempor et non lacus. Sed feugiat, tortor sed dapibus sodales, " +
            "tellus erat maximus metus, sed pharetra sapien dolor elementum sapien. Sed semper venenatis fermentum. " +
            "Praesent ut ullamcorper tortor. Proin mattis id tellus non pharetra. Suspendisse ipsum nisi," +
            " aliquet gravida lobortis id, facilisis id turpis. Cras ullamcorper nisl ut nisl pharetra suscipit. " +
            "Interdum et malesuada fames ac ante ipsum primis in faucibus.";

    SingleHistoryRow(){
        setSpacing(true);

        image = new Image();
        image.setSource(new ExternalResource(path)); // galleryid getPAth
        image.setHeight(250, Unit.PIXELS);


        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();

        title = new Label("Randomowy tytuł");
        title.setStyleName(ValoTheme.LABEL_BOLD);
        dateField = new Label(dateFormat.format(date));
        description = new Label(loremIpsum);
        description.setSizeFull();
        size = new Label("12 sztuk");
        price = new Label("milion złotych");
        orderAgain = new Button("Zamów ponownie");
        status = new Label("STATUS");
        status.setImmediate(true);
        status.setStyleName(ValoTheme.LABEL_COLORED);

        GridLayout gridLayout = new GridLayout(3,4);
        gridLayout.setWidth(700, Unit.PIXELS);
        gridLayout.addComponent(dateField, 0,0);
        gridLayout.addComponent(status, 1,0);
        gridLayout.addComponent(title, 2,0);
        gridLayout.addComponent(description, 0,1,2,1);
        gridLayout.addComponent(size, 0,2);
        gridLayout.addComponent(price, 0,3);
        gridLayout.addComponent(orderAgain, 2,3);

        gridLayout.setComponentAlignment(dateField, Alignment.MIDDLE_RIGHT);
        gridLayout.setComponentAlignment(orderAgain, Alignment.MIDDLE_RIGHT);
        gridLayout.setComponentAlignment(status, Alignment.MIDDLE_RIGHT);
        gridLayout.setColumnExpandRatio(0, 0.2F);
        gridLayout.setColumnExpandRatio(1, 0.15F);
        gridLayout.setColumnExpandRatio(2, 0.65F);

        addComponents(image,gridLayout);

        setComponentAlignment(image, Alignment.MIDDLE_CENTER);

        setComponentAlignment(gridLayout, Alignment.MIDDLE_CENTER);
    }
}
