package Database;
import Backend.Employee;
import Backend.Meal;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

abstract public class MealsFile {
    private static String WriteMealsFile(Meal meal)
    {
        String line="";
        line +=meal.getId()+"|";
        line += meal.getName()+"|";
        line += meal.getPrice()+"|";
        line += meal.getDescription()+"|";
        return line;
    }
    public static boolean AddMealsToFile(Meal meal)
    {
        try (BufferedWriter writer=new BufferedWriter(new FileWriter("Meals.txt")))
        {
            writer.write(WriteMealsFile(meal));
            writer.newLine();
            return true;
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
    public static List<Meal> ReadMealsFile()
    {
        List<Meal>meals=new ArrayList<>();
        try (BufferedReader reader=new BufferedReader(new FileReader("Meals.txt"))) {
            String line;
            while ((line=reader.readLine()) !=null) {
                String[] MealsInfo=line.split("\\|");
                if (MealsInfo.length==4) {
                    int id=Integer.parseInt(MealsInfo[0].trim());
                    String name = MealsInfo[1].trim();
                    double price= Double.parseDouble(MealsInfo[2].trim());
                    String description = MealsInfo[3].trim();
                    meals.add(new Meal(id,name,price,description));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return meals;
    }
}