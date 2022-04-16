package application;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User_BillingDB {
	private final IntegerProperty order_id;
	private final FloatProperty original_price;
	private final FloatProperty insurance;
	private final FloatProperty taxes;
	private final FloatProperty balance;
	private final StringProperty due_date;
	
	public User_BillingDB(Integer order_id, Float original_price, Float insurance, Float taxes, Float balance, String due_date) {
		this.order_id = new SimpleIntegerProperty(order_id);
		this.original_price = new SimpleFloatProperty(original_price);
		this.insurance = new SimpleFloatProperty(insurance);
		this.taxes = new SimpleFloatProperty(taxes);
		this.balance = new SimpleFloatProperty(balance);
		this.due_date = new SimpleStringProperty(due_date);
		
	}
	
	//Getters
	public Integer getOrder_id() {return order_id.get();}
	public Float getOriginal_price() {return original_price.get();}
	public Float getInsurance() {return insurance.get();}
	public Float getTaxes() {return taxes.get();}
	public Float getBalance() {return balance.get();}
	public String getDue_date() {return due_date.get();}
	
	//Setters
	public void setOrder_id(int value) {order_id.set(value);}
	public void setOriginal_price(float value) {original_price.set(value);}
	public void setInsurance(float value) {insurance.set(value);}
	public void setTaxes(float value) {taxes.set(value);}
	public void setBalance(float value) {balance.set(value);}
	public void setDue_date(String value) {due_date.set(value);}

	//Property Values
	public IntegerProperty order_idProperty() {return order_id;}
	public FloatProperty original_priceProperty() {return original_price;}
	public FloatProperty insuranceProperty() {return insurance;}
	public FloatProperty taxesProperty() {return taxes;}
	public FloatProperty balanceProperty() {return balance;}
	public StringProperty due_dateProperty() {return due_date;}
	
}
