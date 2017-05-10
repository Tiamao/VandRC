package VandRC.models;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Kamil on 05.04.2017.
 */
public class WorkerDao {
    @PersistenceContext
    private EntityManager entityManager;

    public String getWorkerPassword(String workerEmail){
        return "";
    }
}
