package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Doc_ScheduleDB {
	private final StringProperty patient;
	private final StringProperty modality;
	private final StringProperty patient_condition;
	private final StringProperty date_time;
	private final StringProperty notes;
	private final StringProperty status;
	
	public Doc_ScheduleDB(String patient, String modality, String patient_condition, String date_time, String notes, String status) {
		this.patient = new SimpleStringProperty(patient);
		this.modality = new SimpleStringProperty(modality);
		this.patient_condition = new SimpleStringProperty(patient_condition);
		this.date_time = new SimpleStringProperty(date_time);
		this.notes = new SimpleStringProperty(notes);
		this.status = new SimpleStringProperty(status);
		
	}
	
	//Getters
	public String getPatient() {return patient.get();}
	public String getModality() {return modality.get();}
	public String getPatient_condition() {return patient_condition.get();}
	public String getDate_time() {return date_time.get();}
	public String getNotes() {return notes.get();}
	public String getStatus() {return status.get();}
	
	//Setters
	public void setPatient(String value) {patient.set(value);}
	public void setModality(String value) {modality.set(value);}
	public void setPatient_condition(String value) {patient_condition.set(value);}
	public void setDate_time(String value) {date_time.set(value);}
	public void setNotes(String value) {notes.set(value);}
	public void setStatus(String value) {status.set(value);}

	//Property Values
	public StringProperty patientProperty() {return patient;}
	public StringProperty modalityProperty() {return modality;}
	public StringProperty patient_conditionProperty() {return patient_condition;}
	public StringProperty date_timeProperty() {return date_time;}
	public StringProperty notesProperty() {return notes;}
	public StringProperty statusProperty() {return status;}
	
}
