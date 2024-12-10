package Backend;
import java.util.List;
enum enOrderType{indoor,delivery,special}
enum enOrderStatus{inPreparation,delivered,canceled}
public class Order {
    public int num;
    public List<MealsForOrder> meals;
    private double totalPrice;
    private enOrderType orderType;
    private enOrderStatus orderStatus;
    private String mealsRead;
    private String typeRead;
    private String statusRead;
    public Order(int num, List<MealsForOrder> meals , double totalPrice , enOrderType orderType , enOrderStatus orderStatus)
    {
        this.num=num;
        this.meals = meals;
        this.totalPrice = totalPrice;
        this.orderType = orderType;
        this.orderStatus = orderStatus;
    }

    public Order(int num, String mealsRead, double price, String typeRead, String statusRead) {
        this.num=num;
        this.mealsRead = mealsRead;
        this.totalPrice = totalPrice;
        this.typeRead =typeRead;
        this.statusRead =statusRead;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public List<MealsForOrder> getMeals() {
        return meals;
    }

    public void setMeals(List<MealsForOrder> meals) {
        this.meals = meals;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public enOrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(enOrderType orderType) {
        this.orderType = orderType;
    }

    public enOrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(enOrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}