package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class OrdersDB {
	private final StringProperty order_id;
	private final StringProperty patient;
	private final StringProperty referral_md;
	private final StringProperty modality;
	private final StringProperty notes;
	private final StringProperty status;
	
	
	public OrdersDB(String order_id, String patient, String referral_md, String modality, String notes, String status) {
		this.order_id = new SimpleStringProperty(order_id);
		this.patient = new SimpleStringProperty(patient);
		this.referral_md = new SimpleStringProperty(referral_md);
		this.modality = new SimpleStringProperty(modality);
		this.notes = new SimpleStringProperty(notes);
		this.status = new SimpleStringProperty(status);
	}
	
	//Getters
	public String getOrder_id() {return order_id.get();}
	public String getPatient() {return patient.get();}
	public String getReferral_md() {return referral_md.get();}
	public String getModality() {return modality.get();}
	public String getNotes() {return notes.get();}
	public String getStatus() {return status.get();}
	
	//Setters
	public void setOrder_id(String value) {order_id.set(value);}
	public void setPatient(String value) {patient.set(value);}
	public void setReferral_md(String value) {referral_md.set(value);}
	public void setModality(String value) {modality.set(value);}
	public void setNotes(String value) {notes.set(value);}
	public void setStatus(String value) {status.set(value);}

	//Property Values
	public StringProperty order_idProperty() {return order_id;}
	public StringProperty patientProperty() {return patient;}
	public StringProperty referral_mdProperty() {return referral_md;}
	public StringProperty modalityProperty() {return modality;}
	public StringProperty notesProperty() {return notes;}
	public StringProperty statusProperty() {return status;}
	
}

