package JavaClasses;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "OrderDetail")
@Table(name = "orderdetails")
public class OrderDetail extends Father implements Serializable {
    @EmbeddedId
    private OrderDetailId id;

    @Column(name = "quatityorder")
    private int quantityOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ordernumber",insertable = false,updatable = false)
    private Order order;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productcode",insertable = false,updatable = false)
    private Product product;

    public OrderDetail() {
    }

    public OrderDetail(OrderDetailId id, int quantityOrder) {
        this.id = id;
        this.quantityOrder = quantityOrder;
    }

    public OrderDetailId getId() {
        return id;
    }

    public void setId(OrderDetailId id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantityOrder() {
        return quantityOrder;
    }

    public void setQuantityOrder(int quantityOrder) {
        this.quantityOrder = quantityOrder;
    }
}
