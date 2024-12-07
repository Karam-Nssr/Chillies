package Backend;

import java.util.List;

enum enOrderType { delivery , special , indoor }
enum enOrderStatus { inPreparation , delivered , canceled}

public class Order {
    
    public int orderNum;
    public List<Meal> meals;
    private double totalPrice;
    public enOrderType orderType;
    private enOrderStatus orderStatus;

    public double getTotalPrice() {return totalPrice;}
    public void setTotalPrice(double totalPrice) {this.totalPrice = totalPrice;}
    public enOrderStatus getOrderStatus() {return orderStatus;}
    public void setOrderStatus(enOrderStatus orderStatus) {this.orderStatus = orderStatus;}

    public Order(int orderNum , List<Meal> meals , double totalPrice , enOrderType orderType , enOrderStatus orderStatus)
    {
        this.orderNum = orderNum;
        this.meals = meals;
        this.totalPrice = totalPrice;
        this.orderType = orderType;
        this.orderStatus = orderStatus;
    }

}
