package aut.utcluj.isp.ex1;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author stefan
 */
public class ShopTest {
    @Test
    public void testCreate() {
        final Shop shop = new Shop("eMag", "Cluj");
        assertEquals("Name should be 'eMag'", "eMag", shop.getName());
        assertEquals("City should be 'Cluj'", "Cluj", shop.getCity());
    }

    @Test
    public void testCreate2() {
        final Shop shop = new Shop("eMag");
        assertEquals("Name should be 'eMag'", "eMag", shop.getName());
        assertEquals("City should be empty", "", shop.getCity());
    }

    @Test
    public void testShopEqualsAndToString() {
        final Shop firstShop = new Shop("eMag", "Cluj");
        final Shop secondShop = new Shop("eMag", "Cluj");
        assertTrue("Instances should be equal", firstShop.equals(secondShop));
        assertEquals("Shop info should be 'Shop: eMag City: Cluj'", "Shop: eMag City: Cluj", firstShop.toString());
    }
}