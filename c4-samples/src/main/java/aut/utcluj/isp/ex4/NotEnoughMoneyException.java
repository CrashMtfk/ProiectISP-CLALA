package aut.utcluj.isp.ex4;

/**
 * @author stefan
 */
public class NotEnoughMoneyException extends Exception {
    private int amount;
    
    public NotEnoughMoneyException(int amount){
        this.amount = amount;
    }
    
    public int getAmount(){
        return amount;
    }
}
