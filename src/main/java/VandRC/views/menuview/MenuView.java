package VandRC.views.menuview;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.VerticalLayout;

import javax.annotation.PostConstruct;

/**
 * Created by Kamil on 23.04.2017.
 */
@SpringView(name = MenuView.VIEW_NAME)
public class MenuView extends VerticalLayout implements View {
    public static final String VIEW_NAME = "menu";

    @PostConstruct
    void init() {

    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        // This view is constructed in the init() method()
    }

}
