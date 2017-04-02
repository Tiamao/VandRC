package VandRC.models;

import javax.persistence.*;

/**
 * Created by Kamil on 02.04.2017.
 */
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerID;
    private String name;
    private String surname;
    private String mail;
    private String password;
    private double discount;

    public Customer() {
    }

    public Customer(int customerID, String name, String surname, String mail, String password, double discount) {
        this.customerID = customerID;
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.password = password;
        this.discount = discount;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
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

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
