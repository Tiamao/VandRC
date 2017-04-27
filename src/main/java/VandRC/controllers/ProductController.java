package VandRC.controllers;

import VandRC.models.Product;
import VandRC.models.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Mikołaj on 27.04.2017.
 */
@Controller
public class ProductController {

    @Autowired
    private ProductDao productDao;

    @RequestMapping(value="/products", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Product> getAll() {
        return productDao.getAll();
    }

    @RequestMapping(value = "/products/{productID}/photoPath}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public String getImagePath(@PathVariable("productID") int productID){
        return productDao.getImagePath(productID);
    }

    @RequestMapping(value = "/products/{productID}/title}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public String getTitle(@PathVariable("productID") int productID){
        return productDao.getTitle(productID);
    }
}
