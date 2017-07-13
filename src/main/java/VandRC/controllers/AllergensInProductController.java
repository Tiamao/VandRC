package VandRC.controllers;

import VandRC.models.AllergensInProduct;
import VandRC.models.AllergensInProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Kamil on 06.07.2017.
 */
@Controller
public class AllergensInProductController {

    @Autowired
    private AllergensInProductDao aipDao;


    @RequestMapping(value = "/json/aip/{productID}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<AllergensInProduct> getAllergensForProduct(@PathVariable("productID") int productID) {
        return aipDao.getAllergensForProduct(productID);
    }
}
