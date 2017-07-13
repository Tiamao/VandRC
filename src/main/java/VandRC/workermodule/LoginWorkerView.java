package VandRC.workermodule;

import VandRC.controllers.WorkerController;
import VandRC.views.MainUI;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinSession;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * Created by Kamil on 31.05.2017.
 */
@SpringView(name = "work")
public class LoginWorkerView  extends VerticalLayout implements View {

    private VerticalLayout header;
    private Panel content;

    TextField login;
    PasswordField password;
    Button loginBtn;

    @Autowired
    private WorkerController workerController;

    @PostConstruct
    void init(){
        Window window = new Window();
        window.setWidth(800.0f, Unit.PIXELS);
        VerticalLayout workerLoginLayout = new VerticalLayout();
        workerLoginLayout.setSizeFull();
        workerLoginLayout.addStyleName("grey-background");

        VerticalLayout loginLayout = new VerticalLayout();

        login = new TextField("login");
        password = new PasswordField("password");
        loginBtn = new Button("login");

        loginLayout.addComponents(login, password, loginBtn);

        loginBtn.addClickListener(e->{
            String pass = workerController.getPassForWorker(login.getValue());

            if(password.getValue().equals(pass)){
                VaadinSession.getCurrent().setAttribute("user", login.getValue());
                window.close();
            } else {
                //TODO ERORRIX
            }
        });

        loginLayout.setComponentAlignment(login, Alignment.MIDDLE_CENTER);
        loginLayout.setComponentAlignment(password, Alignment.MIDDLE_CENTER);
        loginLayout.setComponentAlignment(loginBtn, Alignment.MIDDLE_CENTER);

        workerLoginLayout.addComponent(loginLayout);
        workerLoginLayout.setComponentAlignment(loginLayout, Alignment.MIDDLE_CENTER);

        window.setContent(workerLoginLayout);
        window.setSizeFull();

        window.center();
        window.setDraggable(false);
        window.setModal(true);
        window.setResizable(false);
        window.setClosable(false);
        MainUI.getCurrent().getUI().getUI().addWindow(window);

        MainUI.swapScene(new WorkerLayout());
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }
}
