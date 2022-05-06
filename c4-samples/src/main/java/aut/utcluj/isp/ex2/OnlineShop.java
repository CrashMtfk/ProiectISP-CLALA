package aut.utcluj.isp.ex2;

/**
 * @author stefan
 */
public class OnlineShop {
    private String webAddress;

    public OnlineShop(String name, String city, String webAddress) {
        this.webAddress = webAddress;
    }

    public String getWebAddress() {
        return webAddress;
    }
}
