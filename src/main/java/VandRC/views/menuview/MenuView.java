package VandRC.views.menuview;

import VandRC.controllers.*;
import VandRC.models.Allergen;
import VandRC.models.AllergensInProduct;
import VandRC.models.Gallery;
import VandRC.models.Product;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinSession;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringView(name = MenuView.VIEW_NAME)
public class MenuView extends VerticalLayout implements View {
    public static final String VIEW_NAME = "menu";

    private VerticalLayout layout;
    private Label Title;
    @Autowired
    private ProductController productController;

    @Autowired
    private GalleryController galleryController;

    @Autowired
    private AllergenController allergenController;

    @Autowired
    private AllergensInProductController aipc;

    @Autowired
    private CustomerController customerController;

    @Autowired
    private OrderController orderController;

    @PostConstruct
    void init() {
        setSpacing(true);
        layout = new VerticalLayout();
        Title = new Label("Menu");
        Title.setStyleName("titleFormLabel_design");
        layout.setSizeFull();
        layout.setSpacing(true);
        layout.setMargin(new MarginInfo(true, false));
        layout.addComponent(Title);
        layout.setComponentAlignment(Title, Alignment.MIDDLE_LEFT);
        List<Product> products = productController.getAll();

        products.forEach(p->{
            if(p.getProductID()!=10){

                List<Allergen> allergens = new ArrayList<Allergen>();
                List<AllergensInProduct> aipList = aipc.getAllergensForProduct(p.getProductID());

                aipList.forEach(aipe->{
                    Allergen allergen = allergenController.getAllergenByID(aipe.getAllergenID());
                    allergens.add(allergen);
                });

                int customerID = customerController.getUserIDbyMail(String.valueOf(VaadinSession.getCurrent().getAttribute("user")));
                Gallery gallery = galleryController.getItemByID(p.getGalleryID());
                ProductSectionLayout ps = new ProductSectionLayout(p,gallery, allergens, orderController, customerController,customerID);
                layout.addComponent(ps);
                ps.setWidth(80, Unit.PERCENTAGE);
                ps.addStyleName("orderNOWborder_design");
                layout.setComponentAlignment(ps, Alignment.MIDDLE_CENTER);
            }
        });

//        ProductSectionLayout psl = new ProductSectionLayout();
//        ProductSectionLayout psl1 = new ProductSectionLayout();
//        ProductSectionLayout psl2 = new ProductSectionLayout();
//        ProductSectionLayout psl3 = new ProductSectionLayout();
//
//        layout.addComponent(psl);
//        layout.addComponent(psl1);
//        layout.addComponent(psl2);
//        layout.addComponent(psl3);
//
//        layout.setComponentAlignment(psl, Alignment.MIDDLE_CENTER);
//        layout.setComponentAlignment(psl1, Alignment.MIDDLE_CENTER);
//        layout.setComponentAlignment(psl2, Alignment.MIDDLE_CENTER);
//        layout.setComponentAlignment(psl3, Alignment.MIDDLE_CENTER);

//        layout.setWidth(80, Unit.PERCENTAGE);
        layout.setWidth(80, Unit.PERCENTAGE);
        addComponent(layout);
        setComponentAlignment(layout, Alignment.MIDDLE_CENTER);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        // This view is constructed in the init() method()
    }

}
