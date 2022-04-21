package application;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Desk_TodayDB {
	private final StringProperty patient;
	private final StringProperty name;
	private final StringProperty price;
	private final StringProperty date_time;
	private final StringProperty issuer;
	private final StringProperty technician;
	private final StringProperty enrollee_id;
	private final StringProperty priority;
	
	public Desk_TodayDB(String patient, String name, String price, String date_time, String issuer, String technician, String enrollee_id, String priority) {
		this.patient = new SimpleStringProperty(patient);
		this.name = new SimpleStringProperty(name);
		this.price = new SimpleStringProperty(price);
		this.date_time = new SimpleStringProperty(date_time);
		this.issuer = new SimpleStringProperty(issuer);
		this.technician = new SimpleStringProperty(technician);
		this.enrollee_id = new SimpleStringProperty(enrollee_id);
		this.priority = new SimpleStringProperty(priority);
		
	}
	
	//Getters
	public String getPatient() {return patient.get();}
	public String getName() {return name.get();}
	public String getPrice() {return price.get();}
	public String getDate_time() {return date_time.get();}
	public String getIssuer() {return issuer.get();}
	public String getTechnician() {return technician.get();}
	public String getEnrollee_id() {return enrollee_id.get();}
	public String getPriority() {return priority.get();}
	
	//Setters
	public void setPatient(String value) {patient.set(value);}
	public void setName(String value) {name.set(value);}
	public void setPrice(String value) {price.set(value);}
	public void setDate_time(String value) {date_time.set(value);}
	public void setIssuer(String value) {issuer.set(value);}
	public void setTechnician(String value) {technician.set(value);}
	public void setEnrollee_id(String value) {enrollee_id.set(value);}
	public void setPriority(String value) {priority.set(value);}

	//Property Values
	public StringProperty patientProperty() {return patient;}
	public StringProperty nameProperty() {return name;}
	public StringProperty priceProperty() {return price;}
	public StringProperty date_timeProperty() {return date_time;}
	public StringProperty issuerProperty() {return issuer;}
	public StringProperty technicianProperty() {return technician;}
	public StringProperty enrollee_idProperty() {return enrollee_id;}
	public StringProperty priorityProperty() {return priority;}
	
}
