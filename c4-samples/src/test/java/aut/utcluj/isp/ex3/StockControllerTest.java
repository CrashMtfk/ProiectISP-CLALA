package aut.utcluj.isp.ex3;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author stefan
 */
public class StockControllerTest {

    @Test
    public void testAddProductToCatalogue() {
        final Product firstProduct = new Product("p_1", "Dell", 100d);
        final Product secondProduct = new Product("p_2", "Toshiba", 200d);
        final StockController stockController = new StockController();
        stockController.addProductToCatalogue(firstProduct, 2);
        assertEquals("Number of products should be 2", 2, stockController.getTotalNumberOfProducts());

        stockController.addProductToCatalogue(secondProduct, 1);
        assertEquals("Number of products should be 3", 3, stockController.getTotalNumberOfProducts());
    }

    @Test
    public void testGetProductsWithSameId() {
        final Product firstProduct = new Product("p_1", "Dell", 100d);
        final Product secondProduct = new Product("p_2", "Toshiba", 200d);
        final StockController stockController = new StockController();
        stockController.addProductToCatalogue(firstProduct, 1);
        stockController.addProductToCatalogue(secondProduct, 2);

        final List<Product> notFoundProducts = stockController.getProductsWithSameId("p_3");
        assertNull("No products should be found", notFoundProducts);

        final List<Product> productsFound = stockController.getProductsWithSameId("p_2");
        assertNotNull("Products should be found", productsFound);
        assertEquals("Number of products found should be 2", 2, productsFound.size());
        assertEquals("First product should be 'secondProduct' instance", secondProduct, productsFound.get(0));
        assertEquals("Second product should be 'secondProduct' instance", secondProduct, productsFound.get(1));
    }

    @Test
    public void testGetTotalNumberOfProducts() {
        final Product firstProduct = new Product("p_1", "Dell", 100d);
        final Product secondProduct = new Product("p_2", "Toshiba", 200d);
        final StockController stockController = new StockController();
        stockController.addProductToCatalogue(firstProduct, 2);
        stockController.addProductToCatalogue(secondProduct, 3);

        final int totalNumberOfProducts = stockController.getTotalNumberOfProducts();
        assertEquals("Total number of products should be 5", 5, totalNumberOfProducts);
    }

    @Test
    public void testRemoveAllProductsWitProductId() {
        final Product firstProduct = new Product("p_1", "Dell", 100d);
        final Product secondProduct = new Product("p_2", "Toshiba", 200d);
        final StockController stockController = new StockController();
        stockController.addProductToCatalogue(firstProduct, 1);
        stockController.addProductToCatalogue(secondProduct, 2);

        assertEquals("Number of products before deletion", 3, stockController.getTotalNumberOfProducts());
        boolean deletionStatus = stockController.removeAllProductsWitProductId("p_3");
        assertFalse("No product was deleted", deletionStatus);
        assertEquals("Number of products after first deletion", 3, stockController.getTotalNumberOfProducts());

        deletionStatus = stockController.removeAllProductsWitProductId("p_2");
        assertTrue("Two products were deleted", deletionStatus);
        assertEquals("Number of products should be 1", 1, stockController.getTotalNumberOfProducts());
    }

    @Test
    public void testUpdateProductPriceByProductId() {
        final Product product = new Product("p_1", "Dell", 100d);
        final Product secondProduct = new Product("p_2", "Toshiba", 200d);
        final StockController stockController = new StockController();
        stockController.addProductToCatalogue(product, 2);
        stockController.addProductToCatalogue(secondProduct, 3);

        boolean updateStatus = stockController.updateProductPriceByProductId("p_3", 500d);
        assertFalse("No product should be updated", updateStatus);

        List<Product> p2Products = stockController.getProductsWithSameId("p_2");
        assertNotNull("p2 products should not be null", p2Products);
        for (Product prod : p2Products) {
            assertEquals("Price should be 200d", Double.valueOf(200d), prod.getPrice());
        }

        // update p2 price
        updateStatus = stockController.updateProductPriceByProductId("p_2", 500d);
        assertTrue("Status should be true", updateStatus);
        List<Product> p2ProductsAfterUpdate = stockController.getProductsWithSameId("p_2");
        for (Product prod : p2ProductsAfterUpdate) {
            assertEquals("Price should be 500d", Double.valueOf(500d), prod.getPrice());
        }

        // p_1 products should not be updated
        List<Product> p1Products = stockController.getProductsWithSameId("p_1");
        for (Product prod : p1Products) {
            assertEquals("Price should be 100d", Double.valueOf(100d), prod.getPrice());
        }
    }
}