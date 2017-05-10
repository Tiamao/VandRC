package VandRC.controllers;

import VandRC.models.Allergen;
import VandRC.models.AllergenDao;
import VandRC.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Kamil on 10.05.2017.
 */
@Controller
public class AllergenController {

    @Autowired
    private AllergenDao allergenDao;

    @RequestMapping(value="/allergens", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Allergen> getAll() {
        return allergenDao.getAll();
    }

    public List<Allergen> getProducktAllergens(Product product){
        return allergenDao.getProducktAllergens(product);
    }

}
