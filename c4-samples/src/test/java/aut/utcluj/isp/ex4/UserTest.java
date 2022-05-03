package aut.utcluj.isp.ex4;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author stefan
 */
public class UserTest {

    @Test
    public void testAddProductToCart() {
        final User user = new User(200d);
        user.addProductToCart(new Product("p_1", 100d), 2);

        assertNotNull("Card products cannot be null", user.getUserCart().getCardProducts());
        assertEquals("Number of items should be 2", 2, user.getUserCart().getCardProducts().size());
    }

    @Test
    public void testRemoveProductFromCart() {
        final User user = new User(200d);
        user.addProductToCart(new Product("p_1", 100d), 2);
        user.addProductToCart(new Product("p_2", 100d), 1);

        final List<Product> productsBeforeDelete = user.getUserCart().getCardProducts();
        assertNotNull("Card products cannot be null", productsBeforeDelete);
        assertEquals("Number of items should be 3", 3, productsBeforeDelete.size());

        user.removeProductFromCart("p_2");

        final List<Product> productsAfterDelete = user.getUserCart().getCardProducts();
        assertNotNull("Card products cannot be null", productsAfterDelete);
        assertEquals("Number of items should be 3", 2, productsAfterDelete.size());
    }

    @Test(expected = ProductNotFoundException.class)
    public void testRemoveProductFromCartThrowsExceptionWhenProductNotFound() {
        final User user = new User(200d);
        user.addProductToCart(new Product("p_1", 100d), 2);

        assertNotNull("Card products cannot be null", user.getUserCart().getCardProducts());
        assertEquals("Number of items should be 2", 2, user.getUserCart().getCardProducts().size());

        user.removeProductFromCart("p_2");
    }

    @Test
    public void testSubmitCart() {
        final User user = new User(300d);
        user.addProductToCart(new Product("p_1", 100d), 2);
        user.addProductToCart(new Product("p_2", 100d), 1);

        assertEquals("User money before submit", 300d, user.getUserMoney(), 0);
        final List<Product> productsBeforeSubmit = user.getUserCart().getCardProducts();
        assertNotNull("Card products cannot be null", productsBeforeSubmit);
        assertEquals("Number of items should be 3", 3, productsBeforeSubmit.size());
        assertEquals("Products total", 300d, user.getUserCart().getTotalPrice(), 0);

        // submit cart
        user.submitCart();

        assertEquals("User total money", 0, user.getUserMoney(), 0);
        final List<Product> productsAfterSubmit = user.getUserCart().getCardProducts();
        assertNotNull("Card products cannot be null", productsAfterSubmit);
        assertEquals("Number of items should be 0", 0, productsAfterSubmit.size());
        assertEquals("Products total", 0, user.getUserCart().getTotalPrice(), 0);
    }

    @Test(expected = NotEnoughMoneyException.class)
    public void testSubmitCartExceptionThrowsExceptionWhenUserDoesNotHaveEnoughMoney() {
        final User user = new User(200d);
        user.addProductToCart(new Product("p_1", 100d), 2);
        user.addProductToCart(new Product("p_2", 100d), 1);

        assertEquals("User money before submit", 200d, user.getUserMoney(), 0);
        final List<Product> productsBeforeSubmit = user.getUserCart().getCardProducts();
        assertNotNull("Card products cannot be null", productsBeforeSubmit);
        assertEquals("Number of items should be 3", 3, productsBeforeSubmit.size());
        assertEquals("Products total", 300d, user.getUserCart().getTotalPrice(), 0);

        // submit cart
        user.submitCart();
    }
}