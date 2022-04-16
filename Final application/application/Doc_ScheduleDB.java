package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Doc_ScheduleDB {
	private final IntegerProperty patient;
	private final IntegerProperty modality;
	private final StringProperty patient_condition;
	private final StringProperty date_time;
	private final StringProperty notes;
	private final IntegerProperty status;
	
	public Doc_ScheduleDB(Integer patient, Integer modality, String patient_condition, String date_time, String notes, Integer status) {
		this.patient = new SimpleIntegerProperty(patient);
		this.modality = new SimpleIntegerProperty(modality);
		this.patient_condition = new SimpleStringProperty(patient_condition);
		this.date_time = new SimpleStringProperty(date_time);
		this.notes = new SimpleStringProperty(notes);
		this.status = new SimpleIntegerProperty(status);
		
	}
	
	//Getters
	public Integer getPatient() {return patient.get();}
	public Integer getModality() {return modality.get();}
	public String getPatient_condition() {return patient_condition.get();}
	public String getDate_time() {return date_time.get();}
	public String getNotes() {return notes.get();}
	public Integer getStatus() {return status.get();}
	
	//Setters
	public void setPatient(int value) {patient.set(value);}
	public void setModality(int value) {modality.set(value);}
	public void setPatient_condition(String value) {patient_condition.set(value);}
	public void setDate_time(String value) {date_time.set(value);}
	public void setNotes(String value) {notes.set(value);}
	public void setStatus(int value) {status.set(value);}

	//Property Values
	public IntegerProperty patientProperty() {return patient;}
	public IntegerProperty modalityProperty() {return modality;}
	public StringProperty patient_conditionProperty() {return patient_condition;}
	public StringProperty date_timeProperty() {return date_time;}
	public StringProperty notesProperty() {return notes;}
	public IntegerProperty statusProperty() {return status;}
	
}
