package VandRC.views;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by Kamil on 01.04.2017.
 */

public class RegisterView extends VerticalLayout{


    private TextField name;
    private TextField surname;
    private TextField mail;
    private TextField password;
    private TextField repeatPassword;

    RegisterView() {
        setSizeFull();
        setSpacing(true);

        name = new TextField();
        surname = new TextField();
        mail = new TextField();
        password = new TextField();
        repeatPassword = new TextField();

        addComponents(name, surname,mail,password,repeatPassword);
        setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
    }
}
