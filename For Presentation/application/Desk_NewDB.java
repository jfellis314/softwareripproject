package application;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Desk_NewDB {
	private final StringProperty patient;
	private final StringProperty modality;
	private final StringProperty price;
	private final StringProperty date_time;
	private final StringProperty issuer;
	private final StringProperty technician;
	
	public Desk_NewDB(String patient, String modality, String price, String date_time, String issuer, String technician) {
		this.patient = new SimpleStringProperty(patient);
		this.modality = new SimpleStringProperty(modality);
		this.price = new SimpleStringProperty(price);
		this.date_time = new SimpleStringProperty(date_time);
		this.issuer = new SimpleStringProperty(issuer);
		this.technician = new SimpleStringProperty(technician);
		
	}
	
	//Getters
	public String getPatient() {return patient.get();}
	public String getModality() {return modality.get();}
	public String getPrice() {return price.get();}
	public String getDate_time() {return date_time.get();}
	public String getIssuer() {return issuer.get();}
	public String getTechnician() {return technician.get();}
	
	//Setters
	public void setPatient(String value) {patient.set(value);}
	public void setModality(String value) {modality.set(value);}
	public void setPrice(String value) {price.set(value);}
	public void setDate_time(String value) {date_time.set(value);}
	public void setIssuer(String value) {issuer.set(value);}
	public void setTechnician(String value) {technician.set(value);}

	//Property Values
	public StringProperty patientProperty() {return patient;}
	public StringProperty modalityProperty() {return modality;}
	public StringProperty priceProperty() {return price;}
	public StringProperty date_timeProperty() {return date_time;}
	public StringProperty issuerProperty() {return issuer;}
	public StringProperty technicianProperty() {return technician;}
	
}
