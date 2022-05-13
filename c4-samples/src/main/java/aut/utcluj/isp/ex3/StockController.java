package aut.utcluj.isp.ex3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author stefan
 */
public class StockController  {
    /**
     * Add product to catalogue
     *
     * @param product  - product information
     * @param quantity - number of times the product should be added
     * @apiNote: if products with the same products id already exists, assume that @param product has the same data
     */

    private Map<Product, Integer> catalogue= new HashMap<Product, Integer>();
     private int totalQuantityOfProd;

    public void addProductToCatalogue(final Product product, final int quantity) {
        catalogue.put(product, quantity);
        totalQuantityOfProd = totalQuantityOfProd+quantity;
    }

    /**
     * Return catalogue information
     *
     * @return dictionary where the key is the product id and the value is an array of products with the same id
     */
    public Map<Product, Integer> getCatalogue() {
        return catalogue;
    }

    /**
     * Return all the products with particular id
     *
     * @param productId - unique product id
     * @return - list of existing products with same id or null if not found
     */
    public List<Product> getProductsWithSameId(final String productId) {

        List<Product> productsWithSameId = new ArrayList<>();
        int found = 0;
        for(Map.Entry<Product,Integer> p : catalogue.entrySet()){
            if(p.getKey().getId().equals(productId)){
                for( int i=0; i < p.getValue() ; i++){
                    productsWithSameId.add(p.getKey());
                    found=1;
                }

            }
        }
        if(found==0){
            return null;
        }
        else{
            return productsWithSameId;
        }

    }

    /**
     * Get total number of products from catalogue
     *
     * @return
     */
    public int getTotalNumberOfProducts() {
       return totalQuantityOfProd;
    }

    /**
     * Remove all products with same product id
     *
     * @param productId - unique product id
     * @return true if at least one product was deleted or false instead
     */
    public boolean removeAllProductsWitProductId(final String productId) {
        List<Product> productsWithSameId = new ArrayList<>();
        int found = 0;
        for(Map.Entry<Product,Integer> p : catalogue.entrySet()){
            if(p.getKey().getId().equals(productId)){

                    catalogue.remove(p);
                    totalQuantityOfProd = totalQuantityOfProd - p.getValue();
                    found=1;


            }
        }
        if(found==0){
            return false;
        }
        else{
            return true;
        }
    }

    /**
     * Update the price for all the products with same product id
     *
     * @param productId - unique product id
     * @param price     - new price to be added
     * @return true if at least one product was updated or false instead
     */
    public boolean updateProductPriceByProductId(final String productId, final Double price) {
        List<Product> productsWithSameId = new ArrayList<>();
        int found = 0;
        for(Map.Entry<Product,Integer> p : catalogue.entrySet()){
            if(p.getKey().getId().equals(productId)){

              p.getKey().setPrice(price);
              found=1;


            }
        }
        if(found==0){
            return false;
        }
        else{
            return true;
        }
    }

    public int getTotalQuantityOfProd() {
        return totalQuantityOfProd;
    }

    public StockController() {
        super();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
