package VandRC.controllers;

import VandRC.models.WorkerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by Kamil on 10.05.2017.
 */
@Controller
public class WorkerController {
    @Autowired
    private WorkerDao workerDao;

//    @RequestMapping(value="/workers", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
//    @ResponseBody
//    public List<Worker> getAll() {
//        return workerDao.getAll();
//    }
}
