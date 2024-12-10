package Database;
import Backend.Meal;
import Backend.MealsForOrder;
import Backend.Order;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

abstract public class OrdersFile {
    private static String WriteOrdersFile(Order order)
    {
        String line="";
        line +=order.getNum()+"|";
        line +=order.getMeals()+"|";
        line +=order.getTotalPrice()+"|";
        line +=order.getOrderType()+"|";
        line+=order.getOrderStatus()+"|";
        return line;
    }
    public static boolean AddOrdersToFile(Order order)
    {
        try (BufferedWriter writer=new BufferedWriter(new FileWriter("Orders.txt")))
        {
            writer.write(WriteOrdersFile(order));
            writer.newLine();
            return true;
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
    public static List<Order>ReadOrdersFile()
    {
        List<Order>orders=new ArrayList<>();
        try (BufferedReader reader=new BufferedReader(new FileReader("Orders.txt"))) {
            String line;
            while ((line=reader.readLine()) !=null) {
                String[] OrdersInfo=line.split("\\|");
                if (OrdersInfo.length==5) {
                    int num=Integer.parseInt(OrdersInfo[0].trim());
                    String meals= OrdersInfo[1].trim();
                    double price= Double.parseDouble(OrdersInfo[2].trim());
                    String type=OrdersInfo[3].trim();
                    String status=OrdersInfo[4].trim();
                    orders.add(new Order(num,meals,price,type,status));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return orders;
    }
}