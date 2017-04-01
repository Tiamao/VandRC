package VandRC.views;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 * Created by Kamil on 01.04.2017.
 */
@SpringView(name = RegisterView.VIEW_NAME)
public class RegisterView extends VerticalLayout implements View {

    public static final String VIEW_NAME = "register";

    @Inject
    private MainUI myui;

    private Button test;

    @PostConstruct
    void init() {
        test = new Button("asdasd");
        test.addClickListener( e-> {
            myui.headerLayout.setVisible(true);
        });
        addComponent(test);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

    }
}
