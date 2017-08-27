package JavaClasses;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity(name = "ProductLine")
@Table(name = "productlines")
public class ProductLine extends Father implements Serializable{
    @Id
    @Column(name = "productline")
    private String id;

    @Column(name = "textdescription")
    private String textDescription;

    @Column(name = "htmldescription")
    private String htmlDescription;

    @Column(name = "image")
    private String image;

    public ProductLine() {
    }

    public ProductLine(String productLine, String textDescription, String htmlDescription, String image) {
        this.id = productLine;
        this.textDescription = textDescription;
        this.htmlDescription = htmlDescription;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTextDescription() {
        return textDescription;
    }

    public void setTextDescription(String textDescription) {
        this.textDescription = textDescription;
    }

    public String getHtmlDescription() {
        return htmlDescription;
    }

    public void setHtmlDescription(String htmlDescription) {
        this.htmlDescription = htmlDescription;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
