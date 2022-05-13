package aut.utcluj.isp.ex2;

/**
 * @author stefan
 */
public class Shop {
    private String name;
    private String city;


    public Shop() {
    }

    public Shop(String name, String city) {
        super();
        this.name = name;
        this.city = city;
    }

    public Shop(String name) {
        this.city = "";
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public void setCity(String city) {
        this.city = city;
    }


    
    
}
