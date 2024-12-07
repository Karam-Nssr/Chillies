import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AppManagement {
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
