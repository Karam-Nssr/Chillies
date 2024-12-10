package Backend;
import Database.EmployeesFile;

import java.util.List;

public class Employee{
    private String firstName;
    private String secondName;
    private String password;
    private boolean isAdmin = false;
    public Employee(String firstName, String secondName, String password, boolean isAdmin)
    {
        this.firstName=firstName;
        this.secondName = secondName;
        this.password = password;
        this.isAdmin=isAdmin;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
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