import java.util.ArrayList;

public class Order {
    public int id;
    ArrayList<MealsForOrder>meals;
    public double price;
    String type;
    Order(int id,ArrayList<MealsForOrder>meals,double price,String type){
        this.id=id;
        this.meals=meals;
        this.price=price;
        this.type=type;
    }
}
