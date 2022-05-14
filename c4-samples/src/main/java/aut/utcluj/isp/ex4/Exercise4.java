/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aut.utcluj.isp.ex4;

/**
 *
 * @author Clau
 */
public class Exercise4 {
    public static void main(String[] args) {
        Product bread = new Product("14", 200.0);
        Product lemon = new Product("13", 100.0);
        UserCart userCart = new UserCart();
        
        userCart.addProductToCart(bread, 1);
        userCart.addProductToCart(lemon, 1);
        
       // userCart.getCardProducts();
        userCart.getTotalPrice();
    }
}
