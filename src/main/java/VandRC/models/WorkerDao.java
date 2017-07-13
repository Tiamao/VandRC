package VandRC.models;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Kamil on 05.04.2017.
 */

@Transactional
@Repository
public class WorkerDao {
    @PersistenceContext
    private EntityManager entityManager;

    public String getWorkerPassword(String workerEmail){
        Worker worker = (Worker) entityManager.createQuery("from Worker where mail =:workerEmail").setParameter("workerEmail", workerEmail).getSingleResult();
        return worker.getPassword();
    }
}
