package VandRC.workermodule;

import VandRC.views.MainUI;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

import javax.annotation.PostConstruct;

/**
 * Created by Kamil on 31.05.2017.
 */
@SpringView(name = "work")
public class LoginWorkerView  extends VerticalLayout implements View {

    private VerticalLayout header;
    private Panel content;

    @PostConstruct
    void init(){
        MainUI.swapScene(new WorkerLayout());
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }
}
