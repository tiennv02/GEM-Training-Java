package JavaClasses;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "Order")
@Table(name = "orders")
public class Order extends Father{
    @Id
    @Column(name = "ordernumber")
    private int orderNumber;

    @Column(name = "orderdate")
    private Date orderDate;

    @Column(name = "requireddate")
    private Date requiredDate;

    @Column(name = "shippeddate")
    private Date shippedDate;

    @Column(name = "status")
    private String status;

    public Order() {
    }

    public Order(int orderNumber, Date orderDate, Date requiredDate, Date shippedDate, String status) {
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.requiredDate = requiredDate;
        this.shippedDate = shippedDate;
        this.status = status;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(Date requiredDate) {
        this.requiredDate = requiredDate;
    }

    public Date getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
