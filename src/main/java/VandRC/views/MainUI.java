package VandRC.views;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Created by Kamil on 01.04.2017.
 */
@Theme("valo")
@SpringUI
@SpringViewDisplay
public class MainUI extends UI implements ViewDisplay {

    private VerticalLayout root;
    private Panel springViewDisplay;

    private TextField email;
    private TextField password;
    private Button loginButton;
    private Button registerButton;
    private VerticalLayout loginLayout;
    public HorizontalLayout headerLayout;
    private CssLayout navigationBar;

    @Override
    protected void init(VaadinRequest request) {
//        setSizeFull();
        root = new VerticalLayout();
        root.setSizeFull();
        root.setMargin(true);

        headerLayout = new HorizontalLayout();
        headerLayout.setWidth(100, Unit.PERCENTAGE);
//        headerLayout.setSizeFull();

        navigationBar = new CssLayout();
        navigationBar.addStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
        navigationBar.addComponent(createNavigationButton("View Scoped View",
                ViewScopedView.VIEW_NAME));
        navigationBar.addComponent(createNavigationButton("View Scoped View",
                ViewScopedView.VIEW_NAME));
        navigationBar.addComponent(createNavigationButton("View Scoped View",
                ViewScopedView.VIEW_NAME));
        navigationBar.addComponent(createNavigationButton("View Scoped View",
                ViewScopedView.VIEW_NAME));
        navigationBar.addComponent(createNavigationButton("View Scoped View",
                ViewScopedView.VIEW_NAME));
        navigationBar.addComponent(createNavigationButton("View Scoped View",
                ViewScopedView.VIEW_NAME));
        navigationBar.addComponent(createNavigationButton("View Scoped View",
                ViewScopedView.VIEW_NAME));
        navigationBar.addComponent(createNavigationButton("View Scoped View",
                ViewScopedView.VIEW_NAME));
        navigationBar.addComponent(createNavigationButton("View Scoped View",
                ViewScopedView.VIEW_NAME));

        headerLayout.addComponent(navigationBar);
        headerLayout.setComponentAlignment(navigationBar, Alignment.MIDDLE_LEFT);

        springViewDisplay = new Panel();
        springViewDisplay.setSizeFull();
        loginLayout();

        root.addComponent(headerLayout);
        root.addComponent(springViewDisplay);
        root.setExpandRatio(springViewDisplay, 1.0f);

        setContent(root);
    }

    @Override
    public void showView(View view) {
        springViewDisplay.setContent((Component) view);
    }

    private void loginLayout() {
        loginLayout = new VerticalLayout();
        email = new TextField();
        password = new TextField();
        loginButton = new Button("Login");
        registerButton = new Button("Rejestracja");

        registerButton.addClickListener( e-> {
            headerLayout.setVisible(false);

            getUI().getNavigator().navigateTo(RegisterView.VIEW_NAME);
        });

        HorizontalLayout buttonsLayout = new HorizontalLayout(loginButton, registerButton);

        loginLayout.addComponents(email, password, buttonsLayout);
        loginLayout.setComponentAlignment(email, Alignment.MIDDLE_RIGHT);
        loginLayout.setComponentAlignment(password, Alignment.MIDDLE_RIGHT);
        loginLayout.setComponentAlignment(buttonsLayout, Alignment.MIDDLE_RIGHT);
        loginLayout.setMargin(true);
        headerLayout.addComponent(loginLayout);
        headerLayout.setExpandRatio(loginLayout, 0.1f);
//        headerLayout.setComponentAlignment(loginLayout, Alignment.MIDDLE_RIGHT);
    }

    private Button createNavigationButton(String caption,
                                          final String viewName) {
        Button button = new Button(caption);
        button.addStyleName(ValoTheme.BUTTON_SMALL);
        // If you didn't choose Java 8 when creating the project, convert this
        // to an anonymous listener class
        button.addClickListener(
                event -> getUI().getNavigator().navigateTo(viewName));
        return button;
    }
}
