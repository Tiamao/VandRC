package VandRC.views;

import VandRC.controllers.CustomerController;
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
import com.vaadin.server.VaadinSession;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

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
    private PasswordField password;
    private Button loginBtn;
    private Button registerBtn;
    //++++++++++++++++++
    private MenuBar menuBar;

    //+++++++++
    private TextField nameReg;
    private TextField surnameReg;
    private TextField mailReg;
    private PasswordField passwordReg;
    private PasswordField repeatPasswordReg;
    private Button registerBtnReg;
    private Button logout;

    @Autowired
    private CustomerController customerController;

    @Override
    protected void init(VaadinRequest request) {
        initt();

        loginBtn.addClickListener(e -> {
//            String customerPass = customerController.getCustomerPassword(email.getValue());

            String pass = null;
            if (email.getValue().equals("")) {
                //email.setStyleName(ValoTheme.NOTIFICATION_ERROR);
                email.setStyleName("textfieldERROR_design");
            } else {

                try{
                    pass = customerController.getCustomerPassword(email.getValue());
                } catch (Exception ex){
                    //password.setStyleName(ValoTheme.NOTIFICATION_ERROR);
                    password.setStyleName("textfieldERROR_design");
                }

                if (password.getValue().equals(pass)) {
                    VaadinSession.getCurrent().setAttribute("user", email.getValue());

                    initLoggedMenuBar(menuBar.getItems().get(menuBar.getItems().size() - 1));
                    loginLayout.removeAllComponents();
                    String name = customerController.getNameByMail(email.getValue());
                    Label hello = new Label("Witaj, " + name + "!");
                    logout = new Button("Wyloguj");
                    logout.setStyleName("loginbtn_design");
                    hello.addStyleName("helloLabel_design");
                    loginLayout.addComponents(hello, logout);
                    loginLayout.setComponentAlignment(hello, Alignment.MIDDLE_CENTER);
                    loginLayout.setComponentAlignment(logout, Alignment.MIDDLE_CENTER);
                } else {
                    //email.setStyleName(ValoTheme.NOTIFICATION_ERROR);
                    //password.setStyleName(ValoTheme.NOTIFICATION_ERROR);
                    email.setStyleName("textfieldERROR_design");
                    password.setStyleName("textfieldERROR_design");
                }
            }





//            if (customerPass.equals("") || customerPass == null) {
//                //TODO error
//            } else if (password.getValue().equals(customerPass)) {
//                VaadinSession.getCurrent().setAttribute("user", email.getValue());
//                String name = customerController.getNameByMail(email.getValue());
//
////                loginLayout.setVisible(false);
//                initLoggedMenuBar(menuBar.getItems().get(menuBar.getItems().size() - 1));
//                loginLayout.removeAllComponents();
//                Label hello = new Label("Witaj, " + name + "!");
//                logout = new Button("Wyloguj");
//                logout.setStyleName("loginbtn_design");
//                hello.addStyleName("helloLabel_design");
//                loginLayout.addComponents(hello, logout);
//                loginLayout.setComponentAlignment(hello, Alignment.MIDDLE_CENTER);
//                loginLayout.setComponentAlignment(logout, Alignment.MIDDLE_CENTER);
//            } else {
//                //TODO error
//            }
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
        logo.addStyleName("logo_design");
        logo.setSource(new ExternalResource("http://vanillaandraspberrycakes.com/wp-content/uploads/2017/02/cakes_circleXS.png"));
        loginLayout = new VerticalLayout();
        loginLayout.setSizeFull();
        loginLayout.setSpacing(true);

        HorizontalLayout buttonsLayout = new HorizontalLayout();
        buttonsLayout.setSpacing(true);

        email = new TextField();
        email.setStyleName("textfield_design");
        email.setInputPrompt("Adres e-mail");
        password = new PasswordField();
        password.setStyleName("textfield_design");
        password.setInputPrompt("hasełko");

        registerBtn = new Button("Rejestracja");
        registerBtn.setStyleName("registrybtn_design");
        loginBtn = new Button("Login");
        loginBtn.setStyleName("loginbtn_design");

        buttonsLayout.addComponents(registerBtn, loginBtn);

        GridLayout headerHeader = new GridLayout(3, 1);
        headerHeader.addStyleName("header_design");
        headerHeader.setSizeFull();
        headerHeader.setHeight("190px");
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

            Window window = new Window("Rejestracja");
            window.setWidth(400.0f, Unit.PIXELS);
            VerticalLayout regiView = new VerticalLayout();

            window.setContent(regiView);

            nameReg = new TextField("Imie");
            surnameReg = new TextField("Nazwisko");
            mailReg = new TextField("Adres e-mail");
            passwordReg = new PasswordField("Hasło");
            repeatPasswordReg = new PasswordField("Powtórz hasło");
            registerBtnReg = new Button("Załóż konto");
            registerBtnReg.setStyleName("loginbtns_design");

            regiView.addComponent(nameReg);
            regiView.addComponent(surnameReg);
            regiView.addComponent(mailReg);
            regiView.addComponent(passwordReg);
            regiView.addComponent(repeatPasswordReg);
            regiView.addComponent(registerBtnReg);

            regiView.setMargin(new MarginInfo(true));
            regiView.setSpacing(true);
            regiView.setComponentAlignment(nameReg, Alignment.MIDDLE_CENTER);
            regiView.setComponentAlignment(surnameReg, Alignment.MIDDLE_CENTER);
            regiView.setComponentAlignment(mailReg, Alignment.MIDDLE_CENTER);
            regiView.setComponentAlignment(passwordReg, Alignment.MIDDLE_CENTER);
            regiView.setComponentAlignment(repeatPasswordReg, Alignment.MIDDLE_CENTER);
            regiView.setComponentAlignment(registerBtnReg, Alignment.MIDDLE_CENTER);

            registerBtnReg.addClickListener(click -> {

                if (customerController.mailExists(mailReg.getValue())) {
                    //TODO unlucky, inny nick
                } else if (passwordReg.getValue().equals(repeatPasswordReg.getValue())) {
                    customerController.newCustomer(nameReg.getValue(), surnameReg.getValue(), mailReg.getValue(), passwordReg.getValue());
                    window.close();
                } else {
                    //TODO unlucky
                }

            });

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
        menuBar.setStyleName("menustackbar_design");
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
        footer.addComponent(new Label("cakes. by Vanilla and Raspberry Cakes"));
        footer.addComponent(new Label("Poznań 2017"));
        footer.addComponent(new Label("Kamil Szulc, Adam Tokarczyk, Mikołaj Owczarczak"));
        footer.setWidth(100, Unit.PERCENTAGE);
        footer.setHeight(100, Unit.PERCENTAGE);
        footer.setStyleName("footer_design");
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
