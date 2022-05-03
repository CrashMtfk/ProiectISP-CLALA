package aut.utcluj.isp.ex2;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

/**
 * @author stefan
 */
public class OnlineShopTest {
    @Test
    public void testCreate() {
        final OnlineShop onlineShop = new OnlineShop("eMag", "Cluj", "https://www.emag.ro");
        assertEquals("Web address should be 'https://www.emag.ro'", "https://www.emag.ro", onlineShop.getWebAddress());
        assertThat("Instance should be 'Shop'", onlineShop, instanceOf(Shop.class));
        assertEquals("Should display correct information", "Shop: eMag City: Cluj Web address: https://www.emag.ro", onlineShop.toString());
    }
}