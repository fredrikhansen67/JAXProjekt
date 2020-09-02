package Personell;

import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.*;


@XmlRootElement(name = "product")
//@XmlAccessorType(XmlAccessType.FIELD)

public class Product {

  @XmlAttribute(name = "id")
  private String productId;

  @XmlElement(name = "description")
  private String description;

  @XmlElement(name = "imageUrl")
  private String imageUrl;

  @XmlElement(name = "price")
  private BigDecimal price;

  @XmlElement(name = "createdBy")
  private User createdBy;
  
  @XmlElement(name = "creators")
  private List<?> creators;

  public Product(){}

  public Product(String productId, String description, String imageUrl,
      BigDecimal price, List<?> createdBy) {
      this.productId = productId;
      this.description = description;
      this.imageUrl = imageUrl;
      this.price = price;
      this.creators = createdBy;

  }

  @Override

  public String toString() {

      return "Product{" +
              "\n productId='" + productId + '\'' +
              ",\n description='" + description + '\'' +
              ",\n imageUrl='" + imageUrl + '\'' +
              ",\n price=" + price +
              ",\n createdBy=" + createdBy +"\n"+
              '}';
  }

}
