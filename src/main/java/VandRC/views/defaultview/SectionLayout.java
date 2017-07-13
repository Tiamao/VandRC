package VandRC.views.defaultview;

import com.vaadin.server.ExternalResource;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;

/**
 * Created by Kamil on 22.04.2017.
 */
public class SectionLayout extends HorizontalLayout {

    private Label textField;
    private Image image;

    public SectionLayout(String imagePath, boolean isImageRight) {

        textField = new Label("Wiemy, że pieczenie jest sztuką. Nawet z najlepszymi intencjami nie każy ma czas, siłę czy zdolności by stworzyć przepyszne ciasta i desery.\n" + "Być może nastał czas by zaufać naszym umiejętnościom i doświadczeniu przy nadchodzących specjalnych okazjach.");
        textField.setSizeFull();
        image = new Image();
        image.setSource(new ExternalResource(imagePath));
//        image.setHeight(100, Unit.PERCENTAGE);
        image.setStyleName("defaultPageImage_design");


        if (isImageRight) {
            addComponents(textField, image);
            textField.setStyleName("defaultPageContent_design1");
        } else {
            addComponents(image, textField);
            textField.setStyleName("defaultPageContent_design2");
        }
    }
}
