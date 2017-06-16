package VandRC.views;

import VandRC.views.contactview.ContactView;
import VandRC.views.defaultview.DefaultView;
import VandRC.views.galleryview.GalleryView;
import VandRC.views.historyview.HistoryView;
import VandRC.views.makeOrder.MakeOrderView;
import VandRC.views.menuview.MenuView;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.ui.*;

@Theme("mytheme")
@SpringUI
@SpringViewDisplay
public class MainUI extends UI implements ViewDisplay {

    private Panel springViewDisplay;

    public HorizontalLayout headerLayout;

    //++++++++++++++++++++++++++++++++++++++
    private static VerticalLayout root;
    private VerticalLayout header;
    private HorizontalLayout footer;
    //+++++++++++++++++++++++++++++++++++++
    private VerticalLayout loginLayout;
    private TextField email;
    private TextField password;
    private Button loginBtn;
    private Button registerBtn;
    //++++++++++++++++++
    private MenuBar menuBar;

    //+++++++++
    private TextField nameReg;
    private TextField suernameReg;
    private TextField mailReg;
    private TextField passwordReg;
    private TextField repeatPasswordReg;
    private Button registeBtnReg;

    @Override
    protected void init(VaadinRequest request) {
        initt();

        loginBtn.addClickListener(e -> {
            loginLayout.setVisible(false);
            initLoggedMenuBar(menuBar.getItems().get(menuBar.getItems().size() - 1));
            loginLayout.removeAllComponents();
            Label hello = new Label("Witaj, Grażyna!");
            loginLayout.addComponent(hello);
            loginLayout.setComponentAlignment(hello, Alignment.TOP_RIGHT);
        });
    }

    private void initt() {
        root = new VerticalLayout();

        springViewDisplay = new Panel();
        springViewDisplay.setSizeFull();

        root.setSizeFull();
        header = new VerticalLayout();
        footer = new HorizontalLayout();

        initLoginLayout();
        initVisitorMenuBar();
        initFooterLayout();

        root.addComponents(header, springViewDisplay, footer);

        root.setExpandRatio(springViewDisplay, 0.80F);
        root.setExpandRatio(footer, 0.05F);

        setContent(root);
    }

    private void initLoginLayout() {
        Image logo = new Image();
        logo.setSource(new ExternalResource("http://vanillaandraspberrycakes.com/wp-content/uploads/2017/02/cakes_circleXS.png"));
        logo.setHeight("190px");
        loginLayout = new VerticalLayout();
        loginLayout.setSizeFull();
        loginLayout.setSpacing(true);

        HorizontalLayout buttonsLayout = new HorizontalLayout();
        buttonsLayout.setSpacing(true);

        email = new TextField();
        password = new TextField();

        registerBtn = new Button("Rejestracja");
        loginBtn = new Button("Login");

        buttonsLayout.addComponents(registerBtn, loginBtn);

        GridLayout headerHeader = new GridLayout(3, 1);
        headerHeader.setSizeFull();
        headerHeader.addComponent(logo, 1, 0);
        headerHeader.addComponent(loginLayout, 2, 0);

        loginLayout.addComponents(email, password, buttonsLayout);
        loginLayout.setComponentAlignment(email, Alignment.TOP_RIGHT);
        loginLayout.setComponentAlignment(password, Alignment.TOP_RIGHT);
        loginLayout.setComponentAlignment(buttonsLayout, Alignment.TOP_RIGHT);
        header.addComponents(headerHeader);
        headerHeader.setComponentAlignment(loginLayout, Alignment.MIDDLE_RIGHT);
        headerHeader.setComponentAlignment(logo, Alignment.MIDDLE_CENTER);
        headerHeader.setSpacing(true);

        registerBtn.addClickListener(e -> {

            Window window = new Window("Register");
            window.setWidth(400.0f, Unit.PIXELS);
            VerticalLayout regiView = new VerticalLayout();

            window.setContent(regiView);

            nameReg = new TextField("Imie");
            suernameReg = new TextField("Nazwisko");
            mailReg = new TextField("Adres e-mail");
            passwordReg = new TextField("Hasło");
            repeatPasswordReg = new TextField("Powtórz hasło");
            registeBtnReg = new Button("Załóż konto");

            regiView.addComponent(nameReg);
            regiView.addComponent(suernameReg);
            regiView.addComponent(mailReg);
            regiView.addComponent(passwordReg);
            regiView.addComponent(repeatPasswordReg);
            regiView.addComponent(registeBtnReg);

            regiView.setMargin(new MarginInfo(true));
            regiView.setSpacing(true);
            regiView.setComponentAlignment(nameReg, Alignment.MIDDLE_CENTER);
            regiView.setComponentAlignment(suernameReg, Alignment.MIDDLE_CENTER);
            regiView.setComponentAlignment(mailReg, Alignment.MIDDLE_CENTER);
            regiView.setComponentAlignment(passwordReg, Alignment.MIDDLE_CENTER);
            regiView.setComponentAlignment(repeatPasswordReg, Alignment.MIDDLE_CENTER);
            regiView.setComponentAlignment(registeBtnReg, Alignment.MIDDLE_CENTER);

            window.center();
            window.setDraggable(false);
            window.setModal(true);
            window.setResizable(false);
            getUI().getUI().addWindow(window);

        });
    }

    private void initVisitorMenuBar() {
        menuBar = new MenuBar();
        menuBar.setWidth(100, Unit.PERCENTAGE);
        menuBar.setStyleName("backgroundMenu");
        header.addComponent(menuBar);
        header.setComponentAlignment(menuBar, Alignment.MIDDLE_CENTER);

        MenuBar.MenuItem defaultViewItem = menuBar.addItem("cakes.", null, null);
        defaultViewItem.setCommand(e -> getUI().getNavigator().navigateTo(DefaultView.VIEW_NAME));

        MenuBar.MenuItem galleryItem = menuBar.addItem("Galeria", null, null);
        galleryItem.setCommand(e -> getUI().getNavigator().navigateTo(GalleryView.VIEW_NAME));

        MenuBar.MenuItem menuItem = menuBar.addItem("Menu", null, null);
        menuItem.setCommand(e -> getUI().getNavigator().navigateTo(MenuView.VIEW_NAME));

        MenuBar.MenuItem contactItem = menuBar.addItem("Kontakt", null, null);
        contactItem.setCommand(e -> getUI().getNavigator().navigateTo(ContactView.VIEW_NAME));


    }

    private void initLoggedMenuBar(MenuBar.MenuItem menuItem) {
        MenuBar.MenuItem historyItem = menuBar.addItemBefore("Historia zakupów", null, null, menuItem);
        historyItem.setCommand(e -> getUI().getNavigator().navigateTo(HistoryView.VIEW_NAME));
        MenuBar.MenuItem makeOrderItem = menuBar.addItemBefore("Złóż zamówienie", null, null, menuItem);
        makeOrderItem.setCommand(e -> getUI().getNavigator().navigateTo(MakeOrderView.VIEW_NAME));
    }

    private void initFooterLayout() {
        footer.addComponent(new Label("asdasdasd"));
        footer.addComponent(new Label("dfghfghfgh"));
        footer.addComponent(new Label("24562542"));
    }

    @Override
    public void showView(View view) {
        springViewDisplay.setContent((Component) view);
    }

    public static void swapScene(VerticalLayout layout) {
        root.removeAllComponents();
        root.addComponent(layout);
    }
}
