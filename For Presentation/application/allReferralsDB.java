package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class allReferralsDB {
	private final StringProperty issuer;
	private final IntegerProperty patient;
	private final StringProperty email_address;
	private final StringProperty order_name;
	
	public allReferralsDB(String issuer, Integer patient, String email_address, String order_name) {
		this.issuer = new SimpleStringProperty(issuer);
		this.patient = new SimpleIntegerProperty(patient);
		this.email_address = new SimpleStringProperty(email_address);
		this.order_name = new SimpleStringProperty(order_name);
	}
	
	//Getters
	public String getIssuer() {return issuer.get();}
	public Integer getPatient() {return patient.get();}
	public String getEmail_address() {return email_address.get();}
	public String getOrder_name() {return order_name.get();}
	
	//Setters
	public void setIssuer(String value) {issuer.set(value);}
	public void setPatient(int value) {patient.set(value);}
	public void setEmail_address(String value) {email_address.set(value);}
	public void setOrder_name(String value) {order_name.set(value);}

	//Property Values
	public StringProperty issuerProperty() {return issuer;}
	public IntegerProperty patientProperty() {return patient;}
	public StringProperty email_addressProperty() {return email_address;}
	public StringProperty order_nameProperty() {return order_name;}
	
}

