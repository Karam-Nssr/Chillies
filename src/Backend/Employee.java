package Backend;

import java.util.List;

import Database.EmployeesFile;

public class Employee extends Person {
    
    private String _UserName;
    private String _Password;
    private boolean _IsAdmin = false;

    public String get_UserName() {return _UserName;}
    public void set_UserName(String _UserName) {this._UserName = _UserName;}

    public String get_Password() {return _Password;}
    public void set_Password(String _Password) {this._Password = _Password;}
    
    public boolean get_IsAdmin() {return _IsAdmin;}
    public void set_IsAdmin(boolean _IsAdmin) {this._IsAdmin = _IsAdmin;}

    public Employee(String _FullName , String _Phone , String _Address , String _UserName , String _Password , boolean _IsAdmin)
    {
        super(_FullName, _Phone, _Address);
        this._UserName = _UserName;
        this._Password = _Password;
        this._IsAdmin = _IsAdmin;
    }

    public boolean SaveToFile()
    {
        if(EmployeesFile.AddEmployeeToFile(this))
        {
            return true;
        }

        return false;
    }
    public static List<Employee> employees()
    {
        return EmployeesFile.ReadEmployeesFromFile();
    }

}