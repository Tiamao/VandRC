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

    private String path = "https://i2.wp.com/vanillaandraspberrycakes.com/wp-content/uploads/2016/09/31.jpg";


    @PostConstruct
    void init() {
        layout = new VerticalLayout();
        layout.setWidth(60, Unit.PERCENTAGE);
        SectionLayout sl = new SectionLayout(path, true);
        sl.setStyleName("defaultPageContent_design1");
        SectionLayout sl1 = new SectionLayout(path, false);
        sl1.setStyleName("defaultPageContent_design2");
        SectionLayout sl2 = new SectionLayout(path, true);
        sl2.setStyleName("defaultPageContent_design1");
        sl.setWidth(85, Unit.PERCENTAGE);
        sl.setHeight(sl.getWidth(), Unit.PERCENTAGE);
        sl1.setWidth(85, Unit.PERCENTAGE);
        sl1.setHeight(sl.getWidth(), Unit.PERCENTAGE);

        sl2.setWidth(85, Unit.PERCENTAGE);
        sl2.setHeight(sl.getWidth(), Unit.PERCENTAGE);

        layout.addComponent(sl);
        layout.addComponent(sl1);
        layout.addComponent(sl2);

        layout.setComponentAlignment(sl, Alignment.MIDDLE_CENTER);
        layout.setComponentAlignment(sl1, Alignment.MIDDLE_CENTER);
        layout.setComponentAlignment(sl2, Alignment.MIDDLE_CENTER);

        addComponent(layout);
        setComponentAlignment(layout, Alignment.MIDDLE_CENTER);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        // This view is constructed in the init() method()
    }
}
