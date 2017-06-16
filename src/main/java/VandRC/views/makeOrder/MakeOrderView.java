package VandRC.views.makeOrder;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;

/**
 * Created by Kamil on 25.05.2017.
 */
@SpringView(name = MakeOrderView.VIEW_NAME)
public class MakeOrderView extends VerticalLayout implements View {
    public static final String VIEW_NAME = "makeOrder";
    private VerticalLayout layout;

    private GridLayout gridLayout;
    private Label makeOrderTitle;
    private TextField phonenumber;
    private DateField dateField;
    private TextField size;
    private ComboBox sizeType;
    private TextArea description;
    private Label allergensTitle;
    private TextField search;
    private TwinColSelect allergensTable;
    private Button cancel;
    private Button confirm;

    private String loremIpsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ante risus," +
            " consectetur scelerisque ipsum sit amet, luctus dictum enim. Nullam cursus suscipit porttitor." +
            " Maecenas ultricies tincidunt porta. Curabitur sagittis diam vitae suscipit finibus. " +
            "Aliquam et nunc eget erat commodo tempor et non lacus. Sed feugiat, tortor sed dapibus sodales, " +
            "tellus erat maximus metus, sed pharetra sapien dolor elementum sapien. Sed semper venenatis fermentum. " +
            "Praesent ut ullamcorper tortor. Proin mattis id tellus non pharetra. Suspendisse ipsum nisi," +
            " aliquet gravida lobortis id, facilisis id turpis. Cras ullamcorper nisl ut nisl pharetra suscipit. " +
            "Interdum et malesuada fames ac ante ipsum primis in faucibus.";

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

        setSpacing(true);
        layout = new VerticalLayout();
        layout.setSizeFull();
        layout.setSpacing(true);
        layout.setMargin(new MarginInfo(true, false));


        gridLayout = new GridLayout(4,8);
        gridLayout.setSizeFull();
        gridLayout.setSpacing(true);

        makeOrderTitle = new Label("Złóż zamówienie");
        makeOrderTitle.setSizeFull();
        makeOrderTitle.addStyleName("color");
        phonenumber = new TextField();
        phonenumber.setSizeFull();
        dateField = new DateField();
        dateField.setSizeFull();
        size = new TextField();
        size.setSizeFull();
        sizeType = new ComboBox();
        sizeType.setSizeFull();
        description = new TextArea();
        description.setSizeFull();
        description.setRows(15);
        description.setValue(loremIpsum);
        allergensTitle = new Label("Alergeny");
        allergensTitle.setSizeFull();
        search = new TextField();
        search.setSizeFull();
        allergensTable = new TwinColSelect();
        allergensTable.setSizeFull();
        cancel = new Button("cancel");
        cancel.setSizeFull();
        confirm = new Button("confirm");
        confirm.setSizeFull();




        layout.addComponent(makeOrderTitle);
        gridLayout.addComponent(phonenumber,0,0);
        gridLayout.addComponent(dateField,1,0);
        gridLayout.addComponent(allergensTitle,2,0,3,0);
        gridLayout.addComponent(size,0,1);
        gridLayout.addComponent(sizeType,1,1);
        gridLayout.addComponent(search,2,1,3,1);
        gridLayout.addComponent(description,0,2,1,5);
        gridLayout.addComponent(allergensTable,2,2,3,5);
        gridLayout.addComponent(cancel,2,7);
        gridLayout.addComponent(confirm,3,7);

        layout.addComponent(gridLayout);
        layout.setComponentAlignment(gridLayout, Alignment.MIDDLE_CENTER);

        layout.setWidth(60, Unit.PERCENTAGE);
        addComponent(layout);
        setComponentAlignment(layout, Alignment.MIDDLE_CENTER);

        gridLayout.setRowExpandRatio(0, 0.2F);
        gridLayout.setRowExpandRatio(1, 0.2F);
        gridLayout.setRowExpandRatio(2, 0.2F);
        gridLayout.setRowExpandRatio(3, 0.2F);
        gridLayout.setRowExpandRatio(4, 0.2F);
        gridLayout.setRowExpandRatio(5, 0.2F);
        gridLayout.setRowExpandRatio(6, 0.2F);
        gridLayout.setRowExpandRatio(7, 0.2F);

    }
}
