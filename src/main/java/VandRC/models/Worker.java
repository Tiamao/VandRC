package VandRC.models;

import javax.persistence.*;

/**
 * Created by Kamil on 05.04.2017.
 */
@Entity
@Table(name = "workers")
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int workerID;
    private String name;
    private String surname;
    private String mail;
    private String password;
    private boolean status;

    public Worker() {
    }

    public Worker(String name, String surname, String mail, String password, boolean status) {
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.password = password;
        this.status = status;
    }

    public int getWorkerID() {
        return workerID;
    }

    public void setWorkerID(int workerID) {
        this.workerID = workerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
