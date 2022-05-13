package aut.utcluj.isp.ex2;

/**
 * @author stefan
 */
public class OnlineShop extends Shop{


    private String webAddress;


    public OnlineShop(String name, String city, String webAddress) {
        super(name, city);
        this.webAddress = webAddress;
    }

    public String getWebAddress() {
        return webAddress;
    }


    @Override
    public String toString() {
        return "Shop: " + getName() + " City: " + getCity() + " Web address: " + webAddress ;
    }
}
