package aut.utcluj.isp.ex4;

/**
 * @author stefan
 */
public class NotEnoughMoneyException extends Exception {
    private double amount;
    
    public NotEnoughMoneyException(Double amount){
        this.amount = amount;
    }
    
    public double getAmount(){
        return amount;
    }
}
