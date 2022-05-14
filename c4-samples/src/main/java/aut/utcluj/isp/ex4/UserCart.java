package aut.utcluj.isp.ex4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author stefan
 */
public class UserCart implements ICartDetails {
    private List<Product> cartProducts ;
    private double totalPrice;

    public double getTotalPrice() {
        return totalPrice;
    }

    public List<Product> getCardProducts() {
        return cartProducts;
    }

    public void setCartProducts(List<Product> cartProducts) {
        this.cartProducts = cartProducts;
    }

    public UserCart() {
        totalPrice=0;
        cartProducts = new ArrayList<>();

        
    }

    /**
     * Add new product to user cart
     *
     * @param product  - product to be added
     * @param quantity - number of products of the same type to be added
     */
    public void addProductToCart(final Product product, int quantity) {

        for(int i=0; i < quantity ; i++){
          cartProducts.add(product);
          totalPrice = totalPrice+product.getPrice();
      }

    }

    /**
     * Remove one product with product id from cart
     * If the product with desired id not found in the card, an {@link ProductNotFoundException} exception will be thrown
     *
     * @param productId - unique product id
     */
    public void removeProductFromCart(final String productId) {

        boolean check = false;
        for(int i = 0; i < cartProducts.size(); i++){
            if(cartProducts.get(i).getProductId().equals(productId)){
                cartProducts.remove(i);
                check = true;
            }
        }

    }

    /**
     * Reset user cart
     * Reset products and total price to default values
     */
    public void resetCart() {
        if(cartProducts.size() != 0){
            cartProducts.clear();
            totalPrice = 0;
        }
    }

    @Override
    public String getCartDetails() {


        return "Item:" + cartProducts + "price" + totalPrice;
    }
}
