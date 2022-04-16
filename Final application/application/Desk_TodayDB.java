package application;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Desk_TodayDB {
	private final IntegerProperty patient;
	private final StringProperty name;
	private final FloatProperty price;
	private final StringProperty date_time;
	private final StringProperty issuer;
	private final IntegerProperty technician;
	private final StringProperty enrollee_id;
	private final IntegerProperty priority;
	
	public Desk_TodayDB(Integer patient, String name, Float price, String date_time, String issuer, Integer technician, String enrollee_id, Integer priority) {
		this.patient = new SimpleIntegerProperty(patient);
		this.name = new SimpleStringProperty(name);
		this.price = new SimpleFloatProperty(price);
		this.date_time = new SimpleStringProperty(date_time);
		this.issuer = new SimpleStringProperty(issuer);
		this.technician = new SimpleIntegerProperty(technician);
		this.enrollee_id = new SimpleStringProperty(enrollee_id);
		this.priority = new SimpleIntegerProperty(priority);
		
	}
	
	//Getters
	public Integer getPatient() {return patient.get();}
	public String getName() {return name.get();}
	public Float getPrice() {return price.get();}
	public String getDate_time() {return date_time.get();}
	public String getIssuer() {return issuer.get();}
	public Integer getTechnician() {return technician.get();}
	public String getEnrollee_id() {return enrollee_id.get();}
	public Integer getPriority() {return priority.get();}
	
	//Setters
	public void setPatient(int value) {patient.set(value);}
	public void setName(String value) {name.set(value);}
	public void setPrice(float value) {price.set(value);}
	public void setDate_time(String value) {date_time.set(value);}
	public void setIssuer(String value) {issuer.set(value);}
	public void setTechnician(int value) {technician.set(value);}
	public void setEnrollee_id(String value) {enrollee_id.set(value);}
	public void setPriority(int value) {priority.set(value);}

	//Property Values
	public IntegerProperty patientProperty() {return patient;}
	public StringProperty nameProperty() {return name;}
	public FloatProperty priceProperty() {return price;}
	public StringProperty date_timeProperty() {return date_time;}
	public StringProperty issuerProperty() {return issuer;}
	public IntegerProperty technicianProperty() {return technician;}
	public StringProperty enrollee_idProperty() {return enrollee_id;}
	public IntegerProperty priorityProperty() {return priority;}
	
}
