package Database;
import Backend.Employee;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
abstract public class EmployeesFile {
    private static String WriteEmployeesFile(Employee employee)
    {
        String line="";
        line += employee.getName()+"|";
        line += employee.getPassword() + "|";
        line += employee.getIsAdmin() + "|";
        return line;
    }
    public static boolean AddEmployeeToFile(Employee employee)
    {
        try (BufferedWriter writer=new BufferedWriter(new FileWriter("Users.txt")))
        {
            writer.write(WriteEmployeesFile(employee));
            writer.newLine();
            return true;
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
    public static List<Employee> ReadEmployeesFile()
    {
        List<Employee> employees = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("Users.txt")))
        {
            String line="";
            while((line=reader.readLine()) != null)
            {
                String[] EmployeeInfo=line.split("\\|");
                if(EmployeeInfo.length==3)
                {
                    String Name=EmployeeInfo[0];
                    String password=EmployeeInfo[1];
                    boolean isAdmin=Boolean.parseBoolean(EmployeeInfo[2]);
                    employees.add(new Employee(Name,password,isAdmin));
                }
            }
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        return employees;
    }
    public static boolean CheckForEmployee(List<Employee> employees,String Name,String password){
        for(Employee e:employees){
            if(e.getName().equals(Name) && e.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
}