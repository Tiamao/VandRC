package VandRC.controllers;

import VandRC.models.Tool;
import VandRC.models.ToolDao;
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
public class ToolController {
    @Autowired
    private ToolDao toolDao;

    @RequestMapping(value="/tools", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Tool> getAll() {
        return toolDao.getAll();
    }
}
