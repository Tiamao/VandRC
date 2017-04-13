package VandRC.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Adam on 13.04.2017.
 */
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderID;
    private int workerID;
    private int customerID;
    private Date inDate;
    private Date outDate;
    private String status;
    private double price;
    private int size;
    private String sizeType;
    private String description;
    private String allergenDescription;
    private String phoneNumber;

    public Order() {
    }

    public Order(int workerID, int customerID, Date inDate, Date outDate, String status, double price, int size, String sizeType, String description, String allergenDescription, String phoneNumber) {
        this.workerID = workerID;
        this.customerID = customerID;
        this.inDate = inDate;
        this.outDate = outDate;
        this.status = status;
        this.price = price;
        this.size = size;
        this.sizeType = sizeType;
        this.description = description;
        this.allergenDescription = allergenDescription;
        this.phoneNumber = phoneNumber;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getWorkerID() {
        return workerID;
    }

    public void setWorkerID(int workerID) {
        this.workerID = workerID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    public Date getOutDate() {
        return outDate;
    }

    public void setOutDate(Date outDate) {
        this.outDate = outDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getSizeType() {
        return sizeType;
    }

    public void setSizeType(String sizeType) {
        this.sizeType = sizeType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAllergenDescription() {
        return allergenDescription;
    }

    public void setAllergenDescription(String allergenDescription) {
        this.allergenDescription = allergenDescription;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
