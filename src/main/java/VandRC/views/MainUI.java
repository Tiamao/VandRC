package VandRC.views;

import VandRC.views.menuview.MenuView;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.ui.*;

@Theme("valo")
@SpringUI
@SpringViewDisplay
public class MainUI extends UI implements ViewDisplay {

    private Panel springViewDisplay;

    public HorizontalLayout headerLayout;

    //++++++++++++++++++++++++++++++++++++++
    private VerticalLayout root;
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

    @Override
    protected void init(VaadinRequest request) {
        initt();

        loginBtn.addClickListener(e->{
            loginLayout.setVisible(false);
            initLoggedMenuBar(menuBar.getItems().get(menuBar.getItems().size()-1));
            loginLayout.removeAllComponents();
            Label hello = new Label("Witaj, Grażyna!");
            loginLayout.addComponent(hello);
            loginLayout.setComponentAlignment(hello, Alignment.TOP_RIGHT);
        });
    }

    private void initt(){
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

    private void initLoginLayout(){
        Image logo = new Image();
        logo.setSource(new ExternalResource("http://vanillaandraspberrycakes.com/wp-content/uploads/2017/02/cakes_circleXS.png"));
        logo.setHeight("190px");
        loginLayout = new VerticalLayout();
        loginLayout.setSizeFull();
        loginLayout.setSpacing(true);

        HorizontalLayout buttonsLayout = new HorizontalLayout();

        email = new TextField();
        password = new TextField();

        registerBtn = new Button("Rejestracja");
        loginBtn = new Button("Login");

        buttonsLayout.addComponents(registerBtn,loginBtn);

        GridLayout headerHeader = new GridLayout(3,1);
        headerHeader.setSizeFull();
        headerHeader.addComponent(logo, 1,0);
        headerHeader.addComponent(loginLayout,2,0);

        loginLayout.addComponents(email,password,buttonsLayout);
        loginLayout.setComponentAlignment(email, Alignment.TOP_RIGHT);
        loginLayout.setComponentAlignment(password, Alignment.TOP_RIGHT);
        loginLayout.setComponentAlignment(buttonsLayout, Alignment.TOP_RIGHT);
        header.addComponents(headerHeader);
        headerHeader.setComponentAlignment(loginLayout, Alignment.MIDDLE_RIGHT);
        headerHeader.setComponentAlignment(logo, Alignment.MIDDLE_CENTER);
        headerHeader.setSpacing(true);
    }

    private void initVisitorMenuBar(){
        menuBar = new MenuBar();
        header.addComponent(menuBar);
        header.setComponentAlignment(menuBar, Alignment.MIDDLE_CENTER);

        MenuBar.MenuItem defaultItem =menuBar.addItem("cakes.", null, null);
        defaultItem.setCommand( e-> {
            System.out.println("comanddddddddd");
        });

        MenuBar.MenuItem galleryItem = menuBar.addItem("Galeria", null,null);

        MenuBar.MenuItem menuItem = menuBar.addItem("Menu", null,null);
        menuItem.setCommand(e-> getUI().getNavigator().navigateTo(MenuView.VIEW_NAME));

        MenuBar.MenuItem contactItem = menuBar.addItem("Kontakt", null,null);
    }

    private void initLoggedMenuBar(MenuBar.MenuItem menuItem){
        MenuBar.MenuItem historyItem = menuBar.addItemBefore("Historia zakupów", null,null, menuItem);
        MenuBar.MenuItem makeOrderItem = menuBar.addItemBefore("Złóż zamówienie", null,null, menuItem);
    }

    private void initFooterLayout(){
        footer.addComponent(new Label("asdasdasd"));
        footer.addComponent(new Label("dfghfghfgh"));
        footer.addComponent(new Label("24562542"));
    }

    @Override
    public void showView(View view) {
        springViewDisplay.setContent((Component)view);
    }
}
