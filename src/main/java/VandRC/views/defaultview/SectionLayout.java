package VandRC.views.defaultview;

import com.vaadin.server.ExternalResource;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;

/**
 * Created by Kamil on 22.04.2017.
 */
public class SectionLayout extends HorizontalLayout{

    private Label textField;
    private Image image;

    public SectionLayout(String text, String imagePath, boolean isImageRight){
        setSizeFull();
        textField = new Label(text);
        image = new Image();
        image.setSource(new ExternalResource(imagePath));

        if(isImageRight){
            addComponents(textField, image);
            setExpandRatio(textField, 0.5F);
            setExpandRatio(image, 0.5F);
        } else {
            addComponents(image, textField);
            setExpandRatio(textField, 0.5F);
            setExpandRatio(image, 0.5F);
        }
    }
}
