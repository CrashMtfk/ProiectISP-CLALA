package aut.utcluj.isp.ex4;

/**
 * @author stefan
 */
public class Product  {
    private String productId;
    private Double price;

    public Product(String productId, Double price) {
        this.productId = productId;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public Double getPrice() {
        return price;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


}
