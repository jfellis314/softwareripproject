package application;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Desk_BillingDB {
	private final StringProperty user_id;
	private final StringProperty email_address;
	private final StringProperty phone_number;
	private final StringProperty original_price;
	private final StringProperty insurance;
	private final StringProperty taxes;
	private final StringProperty balance;
	private final StringProperty due_date;
	
	public Desk_BillingDB(String user_id, String email_address, String phone_number, String original_price, String insurance, String taxes, String balance, String due_date) {
		this.user_id = new SimpleStringProperty(user_id);
		this.email_address = new SimpleStringProperty(email_address);
		this.phone_number = new SimpleStringProperty(phone_number);
		this.original_price = new SimpleStringProperty(original_price);
		this.insurance = new SimpleStringProperty(insurance);
		this.taxes = new SimpleStringProperty(taxes);
		this.balance = new SimpleStringProperty(balance);
		this.due_date = new SimpleStringProperty(due_date);
		
	}
	
	//Getters
	public String getUser_id() {return user_id.get();}
	public String getEmail_address() {return email_address.get();}
	public String getPhone_number() {return phone_number.get();}
	public String getOriginal_price() {return original_price.get();}
	public String getInsurance() {return insurance.get();}
	public String getTaxes() {return taxes.get();}
	public String getBalance() {return balance.get();}
	public String getDue_date() {return due_date.get();}
	
	//Setters
	public void setUser_id(String value) {user_id.set(value);}
	public void setEmail_address(String value) {email_address.set(value);}
	public void setPhone_number(String value) {phone_number.set(value);}
	public void setOriginal_price(String value) {original_price.set(value);}
	public void setInsurance(String value) {insurance.set(value);}
	public void setTaxes(String value) {taxes.set(value);}
	public void setBalance(String value) {balance.set(value);}
	public void setDue_date(String value) {due_date.set(value);}

	//Property Values
	public StringProperty user_idProperty() {return user_id;}
	public StringProperty email_addressProperty() {return email_address;}
	public StringProperty phone_numberProperty() {return phone_number;}
	public StringProperty original_priceProperty() {return original_price;}
	public StringProperty insuranceProperty() {return insurance;}
	public StringProperty taxesProperty() {return taxes;}
	public StringProperty balanceProperty() {return balance;}
	public StringProperty due_dateProperty() {return due_date;}
	
}
