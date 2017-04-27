package VandRC.controllers;

import VandRC.models.Gallery;
import VandRC.models.GalleryDao;
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
public class GalleryController {

    @Autowired
    private GalleryDao galleryDao;

    @RequestMapping(value="/photos", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Gallery> getAll() {
        return galleryDao.getAll();
    }
}
