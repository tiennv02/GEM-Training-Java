package JavaClasses;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "Product")
@Table(name = "products")
public class Product extends Father implements Serializable{
    @Id
    @Column(name = "productcode")
    private String productCode;

    @Column(name = "productname")
    private String productName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productline")
    private ProductLine productLine;

    @Column(name = "productdescription")
    private String productDescription;

    @Column(name = "quantityinstock")
    private int quantityInStock;

    @Column(name = "buyprice")
    private double buyPrice;

    public Product() {
    }

    public Product(String productCode, String productName, String productDescription, int quantityInStock, double buyPrice) {
        this.productCode = productCode;
        this.productName = productName;
        this.productDescription = productDescription;
        this.quantityInStock = quantityInStock;
        this.buyPrice = buyPrice;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public ProductLine getProductLine() {
        return productLine;
    }

    public void setProductLine(ProductLine productLine) {
        this.productLine = productLine;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product )) return false;
        return productCode != null && productCode.equals(((Product) o).productCode);
    }

    @Override
    public int hashCode() {
        return 31;
    }
}
