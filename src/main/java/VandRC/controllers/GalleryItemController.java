package VandRC.controllers;

import VandRC.models.GalleryItem;
import VandRC.models.GalleryItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Mikołaj on 27.04.2017.
 */
@Controller
public class GalleryItemController {

    @Autowired
    private GalleryItemDao galleryItemDao;

    @RequestMapping(value="/photos", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<GalleryItem> getAll() {
        return galleryItemDao.getAll();
    }
}
