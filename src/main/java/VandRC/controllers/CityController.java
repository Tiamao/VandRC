package VandRC.controllers;

import VandRC.models.City;
import VandRC.models.CityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Kamil on 01.04.2017.
 */
@Controller
public class CityController {

    @Autowired
    CityDao cityDao;

    @RequestMapping(value="/cities", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<City> getAll() {
        return cityDao.getAll();
    }
}
