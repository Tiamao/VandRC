package VandRC.controllers;

import VandRC.models.WorkerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Kamil on 10.05.2017.
 */
@Controller
public class WorkerController {
    @Autowired
    private WorkerDao workerDao;

    @RequestMapping(value="/json/workers/{mail}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public String getPassForWorker(@PathVariable("mail") String mail) {
        return workerDao.getWorkerPassword(mail);
    }
}
