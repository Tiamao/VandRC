package VandRC.controllers;

import VandRC.models.StatusDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Kamil on 02.07.2017.
 */
@Controller
public class StatusController {

    @Autowired
    private StatusDao statusDao;

    @RequestMapping(value = "/json/status/{statusID}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public String getDescription(@PathVariable("statusID") int statusID){
        return statusDao.getDescription(statusID);
    }
}
