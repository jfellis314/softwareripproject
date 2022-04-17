package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class FileUploadsDB {
	private StringProperty ID;
	private StringProperty name;
	private StringProperty type;
	private StringProperty order;
	
	public FileUploadsDB(String ID, String name, String type, String order)
	{
		this.ID = new SimpleStringProperty(ID);
		this.name = new SimpleStringProperty(name);
		this.type = new SimpleStringProperty(type);
		this.order = new SimpleStringProperty(order);
	}
	
	//orderID
    public String getOrder() {
        return order.get();
    }
    public void setOrder(String orderId){
        this.order.set(orderId);
    }
    
    public StringProperty orderProperty(){
        return order;
    }
    
  //name
  	public void setname(String name)
  	{
  		this.name.set(name);
  	}
  	public String getname()
  	{
  		return name.get();
  	}
  	public StringProperty nameProperty()
  	{
  		return name;
  	}
  	
  //type
  	public void settype(String type)
  	{
  		this.type.set(type);
  	}
  	public String gettype()
  	{
  		return type.get();
  	}
  	public StringProperty typeProperty()
  	{
  		return type;
  	}
  	
  //ID
  	public void setID(String ID)
  	{
  		this.ID.set(ID);
  	}
  	public String getID()
  	{
  		return ID.get();
  	}
  	public StringProperty IDProperty()
  	{
  		return ID;
  	}
    
}
