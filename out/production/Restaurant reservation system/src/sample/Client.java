package sample;

public class Client extends User {

    private Table table = new Table();
    private Dishes dishes = new Dishes();
    //Dish dish = new Dish();
   // Tables tables = new Tables();
    private double money=0.0;

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public Dishes getDishes() {
        return dishes;
    }

    public void setDishes(Dishes dishes) {
        this.dishes = dishes;
    }

}
