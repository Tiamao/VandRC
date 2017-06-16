package VandRC.controllers;

import VandRC.models.Tag;
import VandRC.models.TagDao;
import VandRC.models.Tool;
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
public class TagController {
    @Autowired
    private TagDao tagDao;

    @RequestMapping(value="/tags", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Tag> getAll() {
        return tagDao.getAll();
    }

    public List<Tag> getToolTags(Tool tool){
        return tagDao.getToolTags(tool);
    }
}
