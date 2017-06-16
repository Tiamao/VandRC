package VandRC.views.menuview;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.VerticalLayout;

import javax.annotation.PostConstruct;

/**
 * Created by Kamil on 23.04.2017.
 */
@SpringView(name = MenuView.VIEW_NAME)
public class MenuView extends VerticalLayout implements View {
    public static final String VIEW_NAME = "menu";

    private VerticalLayout layout;

    @PostConstruct
    void init() {
        setSpacing(true);
        layout = new VerticalLayout();
        layout.setSizeFull();
        layout.setSpacing(true);
        layout.setMargin(new MarginInfo(true, false));

        ProductSectionLayout psl = new ProductSectionLayout();
        ProductSectionLayout psl1 = new ProductSectionLayout();
        ProductSectionLayout psl2 = new ProductSectionLayout();
        ProductSectionLayout psl3 = new ProductSectionLayout();

        layout.addComponent(psl);
        layout.addComponent(psl1);
        layout.addComponent(psl2);
        layout.addComponent(psl3);

        layout.setComponentAlignment(psl, Alignment.MIDDLE_CENTER);
        layout.setComponentAlignment(psl1, Alignment.MIDDLE_CENTER);
        layout.setComponentAlignment(psl2, Alignment.MIDDLE_CENTER);
        layout.setComponentAlignment(psl3, Alignment.MIDDLE_CENTER);

        layout.setWidth(80, Unit.PERCENTAGE);
        addComponent(layout);
        setComponentAlignment(layout, Alignment.MIDDLE_CENTER);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        // This view is constructed in the init() method()
    }

}
