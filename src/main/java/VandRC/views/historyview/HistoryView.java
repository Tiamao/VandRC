package VandRC.views.historyview;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.VerticalLayout;

import javax.annotation.PostConstruct;

/**
 * Created by Kamil on 25.05.2017.
 */
@SpringView(name = HistoryView.VIEW_NAME)
public class HistoryView extends VerticalLayout implements View {
    public static final String VIEW_NAME = "history";
    private VerticalLayout layout;

    @PostConstruct
    void init(){
        setSpacing(true);

        layout = new VerticalLayout();
        layout.setSizeFull();
        layout.setSpacing(true);
        layout.setMargin(new MarginInfo(true, false));

        SingleHistoryRow hr = new SingleHistoryRow();
        SingleHistoryRow hr1 = new SingleHistoryRow();
        SingleHistoryRow hr2 = new SingleHistoryRow();
        SingleHistoryRow hr3 = new SingleHistoryRow();

        layout.addComponent(hr);
        layout.addComponent(hr1);
        layout.addComponent(hr2);
        layout.addComponent(hr3);

        layout.setComponentAlignment(hr, Alignment.MIDDLE_CENTER);
        layout.setComponentAlignment(hr1, Alignment.MIDDLE_CENTER);
        layout.setComponentAlignment(hr2, Alignment.MIDDLE_CENTER);
        layout.setComponentAlignment(hr3, Alignment.MIDDLE_CENTER);

        layout.setWidth(80, Unit.PERCENTAGE);
        addComponent(layout);
        setComponentAlignment(layout, Alignment.MIDDLE_CENTER);
    }



    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

    }
}
