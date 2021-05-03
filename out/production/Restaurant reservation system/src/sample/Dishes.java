package sample;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "dishes")
@XmlAccessorType(XmlAccessType.FIELD)
public class Dishes {

    //Dish dish = new Dish();
    @XmlElement(name = "dish")

    private List<Dish> dishes;

    public List<Dish> getDishesInfo() {
        return dishes;
    }


    public void setDishesInfo(List<Dish> dishes) {
        this.dishes = dishes;
    }

}
