package VandRC.controllers;

import VandRC.models.Worker;
import VandRC.models.WorkerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Kamil on 10.05.2017.
 */
public class WorkerController {
    @Autowired
    private WorkerDao workerDao;

    @RequestMapping(value="/workers", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Worker> getAll() {
        return workerDao.getAll();
    }
}
