package aut.utcluj.isp.ex4;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author stefan
 */
public class UserCartTest {
    @Test
    public void testCreate() {
        final UserCart userCart = new UserCart();
        assertNotNull("Cart details should not be null", userCart.getCardProducts());
        assertEquals("Default total price should be 0", 0, userCart.getTotalPrice(), 0);
    }

    @Test
    public void testAddProductToCart() {
        final Product product = new Product("p_1", 100d);
        final UserCart userCart = new UserCart();
        userCart.addProductToCart(product, 2);

        assertEquals("Cart size should be 2", 2, userCart.getCardProducts().size());
        assertEquals("Total price should be 200", 200d, userCart.getTotalPrice(), 0);
    }

    @Test
    public void testRemoveProductFromCart() {
        final Product firstProduct = new Product("p_1", 100d);
        final Product secondProduct = new Product("p_2", 200d);
        final UserCart userCart = new UserCart();
        userCart.addProductToCart(firstProduct, 2);
        userCart.addProductToCart(secondProduct, 2);

        final List<Product> productsBeforeRemove = userCart.getCardProducts();
        assertEquals("Cart size should be 4", 4, productsBeforeRemove.size());
        userCart.removeProductFromCart("p_2");
        final List<Product> productsAfterRemove = userCart.getCardProducts();
        assertEquals("Cart size should be 3", 3, productsAfterRemove.size());
        assertEquals("First product should have p_1 id", "p_1", productsAfterRemove.get(0).getProductId());
        assertEquals("Second product should have p_1 id", "p_1", productsAfterRemove.get(1).getProductId());
        assertEquals("Third product should have p_2 id", "p_2", productsAfterRemove.get(2).getProductId());
        assertEquals("Total price should be 400", 400d, userCart.getTotalPrice(), 0);
    }

    @Test(expected = ProductNotFoundException.class)
    public void testRemoveProductFromCartThrowsExceptionWhenNoProductFound() {
        final UserCart userCart = new UserCart();
        userCart.removeProductFromCart("p_1");
    }

    @Test
    public void testGetCartDetails() {
        final Product firstProduct = new Product("p_1", 100d);
        final Product secondProduct = new Product("p_2", 200d);
        final UserCart userCart = new UserCart();
        userCart.addProductToCart(firstProduct, 2);
        userCart.addProductToCart(secondProduct, 1);

        try {
            final String expectedResult = "Product id: p_1, Items: 2\n" +
                    "Product id: p_2, Items: 1\n" +
                    "Total price: 400.0";
            final String cartDetails = ((ICartDetails)userCart).getCartDetails();
            assertNotNull("Cart details should not be null", cartDetails);
            assertEquals("Cart details should be the same", expectedResult, cartDetails);
        } catch (ClassCastException ex) {
            fail("Show not fail on casting UserCart instance to ICartDetails");
        }
    }

    @Test
    public void testResetCart() {
        final Product product = new Product("p_1", 100d);
        final UserCart userCart = new UserCart();
        userCart.addProductToCart(product, 2);

        final List<Product> productsBeforeReset = userCart.getCardProducts();
        assertEquals("2 products in cart", 2, productsBeforeReset.size());
        assertEquals("Total price is 200", 200d, userCart.getTotalPrice(), 0);

        userCart.resetCart();

        final List<Product> productsAfterReset = userCart.getCardProducts();
        assertEquals("0 products in cart", 0, productsAfterReset.size());
        assertEquals("Total price is 0", 0, userCart.getTotalPrice(), 0);
    }
}