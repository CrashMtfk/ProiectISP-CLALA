package aut.utcluj.isp.ex4;

/**
 * @author stefan
 */
public class ProductNotFoundException extends Exception {
    private String nameOfProduct;
    
    public ProductNotFoundException(String name){
        this.nameOfProduct = name;
    }
    
    public String getNameOfProduct(){
        return nameOfProduct;
    }
}
