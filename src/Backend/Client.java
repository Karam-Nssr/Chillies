package Backend;

public class Client extends Person {
    
    private int _NumOfOrder;

    public int get_NumOfOrder() {return _NumOfOrder;}
    public void set_NumOfOrder(int _NumOfOrder) {this._NumOfOrder = _NumOfOrder;}

    public Client(String _FullName , String _Phone , String _Address , int _NumOfOrder)
    {
        super(_FullName, _Phone, _Address);
        this._NumOfOrder = _NumOfOrder;
    }

}