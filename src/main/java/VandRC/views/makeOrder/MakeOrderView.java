package VandRC.views.makeOrder;

import VandRC.controllers.AllergenController;
import VandRC.controllers.AllergensInOrderController;
import VandRC.controllers.CustomerController;
import VandRC.controllers.OrderController;
import VandRC.models.Allergen;
import VandRC.models.Order;
import VandRC.views.historyview.HistoryView;
import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.event.FieldEvents;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinSession;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

@SpringView(name = MakeOrderView.VIEW_NAME)
public class MakeOrderView extends VerticalLayout implements View {
    public static final String VIEW_NAME = "makeOrder";
    private VerticalLayout layout;

    @Autowired
    private OrderController controller;
    @Autowired
    private AllergenController allergenController;
    @Autowired
    private AllergensInOrderController allergensInOrderController;

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
    private TextField title;

    @Autowired
    CustomerController customerController;


    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

        setSpacing(true);
        layout = new VerticalLayout();
        layout.setSizeFull();
        layout.setSpacing(true);
        layout.setMargin(new MarginInfo(true, false));

        gridLayout = new GridLayout(4, 8);
        gridLayout.setSizeFull();
        gridLayout.setSpacing(true);

        makeOrderTitle = new Label("Złóż zamówienie");
        makeOrderTitle.setSizeFull();
        makeOrderTitle.setStyleName("titleFormLabel_design");
        phonenumber = new TextField();
        phonenumber.setInputPrompt("Nr telefonu");
        phonenumber.setSizeFull();
        dateField = new DateField();
        dateField.setDescription("Data odbioru");
//        dateField.setCaption("data odbioru zamówienia");
        dateField.setSizeFull();
        dateField.setRangeStart(new Date());

        size = new TextField();
        size.setInputPrompt("Podaj rozmiar");
        size.setSizeFull();

        sizeType = new ComboBox();
        sizeType.setSizeFull();
        sizeType.setNullSelectionAllowed(false);
        sizeType.setInputPrompt("Wybierz rozmiar");
        sizeType.setTextInputAllowed(false);
        sizeType.setNewItemsAllowed(false);
        sizeType.addItem("g");
        sizeType.addItem("porcja/e");

        description = new TextArea();
        description.setSizeFull();
        description.setInputPrompt("Dokładny opis zamówienia");
        description.setRows(15);
        allergensTitle = new Label("Alergeny");
        allergensTitle.setSizeFull();
        allergensTitle.addStyleName("secondtitleLabel_design");
        search = new TextField();
        search.setInputPrompt("Szukaj alergenu z listy");
        search.setSizeFull();

        List<Allergen> allergensList = allergenController.getAll();
        BeanItemContainer<Allergen> allrgensContainer = new BeanItemContainer<Allergen>(Allergen.class);
        allrgensContainer.addAll(allergensList);

        allergensTable = new TwinColSelect();
        allergensTable.setContainerDataSource(allrgensContainer);
        allergensTable.setItemCaptionMode(AbstractSelect.ITEM_CAPTION_MODE_EXPLICIT_DEFAULTS_ID);
        allergensTable.setLeftColumnCaption("Dostępne alergeny");
        allergensTable.setRightColumnCaption("Wybrane alergeny");


//        allergensList.forEach(all ->{
//            allergensTable.addItem(all);
//            allergensTable.setItemCaption(all, all.getName());
//        });

        allergensTable.setSizeFull();

        search.setTextChangeEventMode(AbstractTextField.TextChangeEventMode.LAZY);
        search.addTextChangeListener(new FieldEvents.TextChangeListener() {
            @Override
            public void textChange(FieldEvents.TextChangeEvent event) {

                allrgensContainer.removeAllContainerFilters();
                allrgensContainer.addContainerFilter(new Container.Filter() {

                    @Override
                    public boolean passesFilter(Object itemId, Item item) throws UnsupportedOperationException {
                        if (((Allergen) itemId).getName().toLowerCase().contains(event.getText().toLowerCase())
                                || ((Collection) allergensTable.getValue()).contains(itemId))
                            return true;
                        else
                            return false;
                    }

                    @Override
                    public boolean appliesToProperty(Object propertyId) {
                        return true;
                    }
                });
            }
        });

        title = new TextField();
        title.setSizeFull();
        title.setInputPrompt("Tytuł");

        cancel = new Button("Wyczyść");
        cancel.setSizeFull();
        cancel.setStyleName("cancelbtn_design");
        confirm = new Button("Wyślij zapytanie");
        confirm.setSizeFull();
        confirm.setStyleName("sendbtn_design");

        confirm.addClickListener(e -> {
//            List<Order> orders = controller.getAll();
            size.setConverter(Integer.class);


            if (title.getValue().equals("") || phonenumber.getValue().equals("") || dateField.getValue() == null || dateField.getValue().equals("") || size.getValue().equals("") || description.getValue().equals("") || sizeType.getValue() == null) {


                if (title.getValue().equals("")) {
                    title.setStyleName(ValoTheme.NOTIFICATION_ERROR);
                }

                if (phonenumber.getValue().equals("")) {
                    phonenumber.setStyleName(ValoTheme.NOTIFICATION_ERROR);
                }

                if (dateField.getValue() == null || dateField.getValue().equals("")) {
                    dateField.setStyleName(ValoTheme.NOTIFICATION_ERROR);
                }

                if (size.getValue().equals("")) {
                    size.setStyleName(ValoTheme.NOTIFICATION_ERROR);
                }

                if (description.getValue().equals("")) {
                    description.setStyleName(ValoTheme.NOTIFICATION_ERROR);
                }

                if (sizeType.getValue() == null) {
                    sizeType.setStyleName(ValoTheme.NOTIFICATION_ERROR);
                }



            } else {
                int c = customerController.getUserIDbyMail(String.valueOf(VaadinSession.getCurrent().getAttribute("user")));
                Order ord = controller.makeOwnOrder(c, new Date().getTime(), dateField.getValue().getTime(), (Integer) size.getConvertedValue(), sizeType.getValue().toString(), description.getValue(), phonenumber.getValue(), title.getValue());
                Set<Allergen> allergensSet = (Set<Allergen>) allergensTable.getValue();
                allergensSet.forEach(allergen -> {
                    allergensInOrderController.allergensInOrder(ord.getOrderID(), allergen.getAllergenID());
                });

                Notification.show("Wysłałeś zapytanie", "", Notification.TYPE_HUMANIZED_MESSAGE);
                getUI().getNavigator().navigateTo(HistoryView.VIEW_NAME);

            }

        });

        layout.addComponent(makeOrderTitle);
        gridLayout.addComponent(title, 0, 0, 1, 0);
        gridLayout.addComponent(phonenumber, 0, 1);
        gridLayout.addComponent(dateField, 1, 1);
        gridLayout.addComponent(allergensTitle, 2, 0, 3, 0);
        gridLayout.addComponent(size, 0, 2);
        gridLayout.addComponent(sizeType, 1, 2);
        gridLayout.addComponent(search, 2, 1, 3, 1);
        gridLayout.addComponent(description, 0, 3, 1, 6);
        gridLayout.addComponent(allergensTable, 2, 2, 3, 5);
        gridLayout.addComponent(cancel, 2, 7);
        gridLayout.addComponent(confirm, 3, 7);

        layout.addComponent(gridLayout);
        layout.setComponentAlignment(gridLayout, Alignment.MIDDLE_CENTER);

        layout.setWidth(80, Unit.PERCENTAGE);
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

        title.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent event) {
                title.removeStyleName(ValoTheme.NOTIFICATION_ERROR);
            }
        });

        phonenumber.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent event) {
                phonenumber.removeStyleName(ValoTheme.NOTIFICATION_ERROR);
            }
        });

        dateField.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent event) {
                dateField.removeStyleName(ValoTheme.NOTIFICATION_ERROR);
            }
        });

        size.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent event) {
                size.removeStyleName(ValoTheme.NOTIFICATION_ERROR);
            }
        });

        sizeType.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent event) {
                sizeType.removeStyleName(ValoTheme.NOTIFICATION_ERROR);
            }
        });

        description.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent event) {
                description.removeStyleName(ValoTheme.NOTIFICATION_ERROR);
            }
        });

    }
}
