package aut.utcluj.isp.ex4;

import java.util.List;

/**
 * @author stefan
 */
public class UserCart {
    private List<Product> cardProducts;
    private double totalPrice;

    public double getTotalPrice() {
        return totalPrice;
    }

    public List<Product> getCardProducts() {
        return cardProducts;
    }

    /**
     * Add new product to user cart
     *
     * @param product  - product to be added
     * @param quantity - number of products of the same type to be added
     */
    public void addProductToCart(final Product product, int quantity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Remove one product with product id from cart
     * If the product with desired id not found in the card, an {@link ProductNotFoundException} exception will be thrown
     *
     * @param productId - unique product id
     */
    public void removeProductFromCart(final String productId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Reset user cart
     * Reset products and total price to default values
     */
    public void resetCart() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
