package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User_BillingDB {
	private StringProperty order;
	private StringProperty price;
	private StringProperty insurer;
	private StringProperty taxes;
	private StringProperty balance;
	private StringProperty date;
	
	public User_BillingDB(String order, String price, String insurer, String taxes, String balance, String date) {
		this.order = new SimpleStringProperty(order);
		this.price = new SimpleStringProperty(price);
		this.insurer = new SimpleStringProperty(insurer);
		this.taxes = new SimpleStringProperty(taxes);
		this.balance = new SimpleStringProperty(balance);
		this.date = new SimpleStringProperty(date);
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
    
    //price
    public String getprice () {
        return price.get();
    }
    public void setprice (String price){
        this.price.set(price);
    }
    public StringProperty priceProperty() {
        return price;
    }
    
    //insurer
    public String getinsurer () {
        return insurer.get();
    }
    public void setinsurer (String insurer){
        this.insurer.set(insurer);
    }
    public StringProperty insurerProperty() {
        return insurer;
    }
    
    //taxes
    public String gettaxes () {
        return taxes.get();
    }
    public void settaxes (String taxes){
        this.taxes.set(taxes);
    }
    public StringProperty taxesProperty() {
        return taxes;
    }
    
    //balance
    public String getbalance () {
        return balance.get();
    }
    public void setbalance (String balance){
        this.balance.set(balance);
    }
    public StringProperty balanceProperty() {
        return balance;
    }
    
    //date
    public String getdate () {
        return date.get();
    }
    public void setdate (String date){
        this.date.set(date);
    }
    public StringProperty dateProperty() {
        return date;
    }
}
