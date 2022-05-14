package aut.utcluj.isp.ex4;

/**
 * @author stefan
 */
public class User {
    private UserCart userCart = new UserCart();
    private Double userMoney;

    public User(Double userMoney) {
        this.userMoney = userMoney;
    }

    public UserCart getUserCart() {
        return userCart;
    }

    public Double getUserMoney() {
        return userMoney;
    }

    /**
     * Add product to the cart
     *
     * @param product  - product to be added
     * @param quantity - quantity to be added
     */
    public void addProductToCart(Product product, int quantity) {

        userCart.addProductToCart(product, quantity);

    }

    /**
     * Remove product from cart
     * An {@link ProductNotFoundException} exception should be thrown if no product with desired productId is found
     *
     * @param productId - unique product id
     */
    public void removeProductFromCart(final String productId) throws ProductNotFoundException {

        boolean found = false;
        for(int i=0; i<userCart.getCardProducts().size(); i++){
            if(userCart.getCardProducts().get(i).getProductId().equals(productId)){
                userCart.removeProductFromCart(productId);
                found=true;
            }

        }
        if(found==false) {

                throw new ProductNotFoundException();

        }




    }

    /**
     * Submit cart details
     * Total price of the products should be extracted from userMoney
     * If userMoney is less than total price of the products, an {@link NotEnoughMoneyException} exception will be thrown
     * If userMoney is greater or equal to the total price of the products, total price should be extracted from total money and cart to be reset to default values
     */
    public void submitCart() throws NotEnoughMoneyException {
        userMoney = userMoney - userCart.getTotalPrice();
        if(userMoney < 0){
            throw new NotEnoughMoneyException(userMoney);
        }

        userCart.resetCart();

    }
}
