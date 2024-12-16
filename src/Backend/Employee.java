package Backend;
import Database.EmployeesFile;

import java.util.List;

public class Employee{
    private String Name;
    private String password;
    private boolean isAdmin = false;
    public Employee(String Name, String password, boolean isAdmin)
    {
        this.Name=Name;
        this.password = password;
        this.isAdmin=isAdmin;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name=Name;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getIsAdmin(){
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}