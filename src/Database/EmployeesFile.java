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

    private final static String _FilePath = "./Employees.txt";
    private final static String _Separator = "#//#";

    private static String _FromEmployeeToString(Employee employee)
    {
        String line = "";
        line += employee.get_FullName() + _Separator;
        line += employee.get_Phone() + _Separator;
        line += employee.get_Address() + _Separator;
        line += employee.get_UserName() + _Separator;
        line += employee.get_Password() + _Separator;
        line += Boolean.toString(employee.get_IsAdmin()) + _Separator;

        return line;
    }
    private static Employee _FromStringToEmployee(String line)
    {
        String[] parts = line.split(_Separator);

        String fullName = parts[0];
        String phone = parts[1];
        String address = parts[2];
        String userName = parts[3];
        String password = parts[4];
        boolean isAdmin = Boolean.parseBoolean(parts[5]);

        return new Employee(fullName, phone, address, userName, password, isAdmin);
    }

    public static boolean AddEmployeeToFile(Employee employee)
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(_FilePath)))
        { 
            writer.write(_FromEmployeeToString(employee)); 
            writer.newLine();
            return true;
        } 
        catch (IOException e) 
        { 
            e.printStackTrace(); // Log the exception for debugging
            return false;
        }
    }
    public static List<Employee> ReadEmployeesFromFile()
    {
        List<Employee> employees = new ArrayList<Employee>();
        try (BufferedReader reader = new BufferedReader(new FileReader(_FilePath))) 
        { 
            String line = "";
            while ((line = reader.readLine()) != null) 
            { 
                employees.add(_FromStringToEmployee(line)); 
            } 
        }
        catch (IOException e)
        { 
            e.printStackTrace(); 
        } 
        return employees;
    }
}
