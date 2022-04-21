package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class allReportsDB {
	private final StringProperty patient;
	private final StringProperty modality;
	private final StringProperty technician;
	private final StringProperty radiologist;
	private final StringProperty notes;
	
	public allReportsDB(String patient, String modality, String technician, String radiologist, String notes) {
		this.patient = new SimpleStringProperty(patient);
		this.modality = new SimpleStringProperty(modality);
		this.technician = new SimpleStringProperty(technician);
		this.radiologist = new SimpleStringProperty(radiologist);
		this.notes = new SimpleStringProperty(notes);
		
	}
	
	//Getters
	public String getPatient() {return patient.get();}
	public String getModality() {return modality.get();}
	public String getTechnician() {return technician.get();}
	public String getRadiologist() {return radiologist.get();}
	public String getNotes() {return notes.get();}
	
	//Setters
	public void setPatient(String value) {patient.set(value);}
	public void setModality(String value) {modality.set(value);}
	public void setTechnician(String value) {technician.set(value);}
	public void setRadiologist(String value) {radiologist.set(value);}
	public void setNotes(String value) {notes.set(value);}

	//Property Values
	public StringProperty patientProperty() {return patient;}
	public StringProperty modalityProperty() {return modality;}
	public StringProperty technicianProperty() {return technician;}
	public StringProperty radiologistProperty() {return radiologist;}
	public StringProperty notesProperty() {return notes;}
	
}

