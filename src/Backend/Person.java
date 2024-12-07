package Backend;

abstract public class Person {

    private String _FullName;
    private String _Phone;
    private String _Address;

    public String get_FullName() {return _FullName;}
    public void set_FullName(String _FullName) {this._FullName = _FullName;}
    
    public String get_Phone() {return _Phone;}
    public void set_Phone(String _Phone) {this._Phone = _Phone;}
    
    public String get_Address() {return _Address;}
    public void set_Address(String _Address) {this._Address = _Address;}
   
    public Person(String _FullName , String _Phone , String _Address)
    {
        this._FullName = _FullName;
        this._Phone = _Phone;
        this._Address = _Address;
    }
}