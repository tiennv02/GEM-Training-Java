package JavaClasses;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class OrderDetailId implements Serializable{
    @Column(name = "ordernumber")
    private int orderNumber;

    @Column(name = "productcode")
    private String productCode;

    public OrderDetailId() {
    }

    public OrderDetailId(int orderNumber, String productCode) {
        this.orderNumber = orderNumber;
        this.productCode = productCode;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (!this.getClass().equals(o.getClass())) return false;
        OrderDetailId orderDetailId = (OrderDetailId) o;
        if((this.orderNumber == orderDetailId.getOrderNumber()) && this.productCode.equals(orderDetailId.getProductCode())){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (productCode + orderNumber).hashCode();
    }
}
