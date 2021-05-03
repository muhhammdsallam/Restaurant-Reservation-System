
package sample;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "restaurant")
@XmlAccessorType(XmlAccessType.FIELD)

public class Restaurant {
    @XmlElement(name = "users")
    private Users users = null;
    @XmlElement(name = "tables")
    private Tables tables = null;
    @XmlElement(name = "dishes")
    private Dishes dishes = null;


    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
    public Tables getTablesInfo() {
        return tables;
    }

    public void setTablesInfo(Tables tables) {
        this.tables = tables;
    }
    public Dishes getDishesInfo() {
        return dishes;
    }

    public void setDishesInfo(Dishes dishes) {
        this.dishes = dishes;
    }
}
