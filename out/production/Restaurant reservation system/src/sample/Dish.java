package sample;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "dish")
@XmlAccessorType(XmlAccessType.FIELD)
public class Dish {
    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "price")
    private double price;

    @XmlElement(name = "type")
    private String type;

    private int quantity;

    public Dish() {
    }

    public String getDishName() {
        return name;
    }

    public void setDishName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() { return type; }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String printDishes(){

        String print;
        print = this.name +"\t"+ this.quantity +"\t" + "plates" + "\n";
        return print;
    }
}
