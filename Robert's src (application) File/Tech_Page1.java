package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Tech_Page1 {
	private final StringProperty patient_id;
	private final StringProperty modality;
	private final StringProperty date_time;
	private final StringProperty radiologist;
	private final StringProperty technician;
	
	public Tech_Page1(String patient_id, String modality, String date_time, String radiologist, String technician) {
		this.patient_id = new SimpleStringProperty(patient_id);
		this.modality = new SimpleStringProperty(modality);
		this.date_time = new SimpleStringProperty(date_time);
		this.radiologist = new SimpleStringProperty(radiologist);
		this.technician = new SimpleStringProperty(technician);
	}
	
	//Getters
	public String getPatient_id() {return patient_id.get();}
	public String getModality() {return modality.get();}
	public String getDate_time() {return date_time.get();}
	public String getRadiologist() {return radiologist.get();}
	public String getTechnician() {return technician.get();}
	
	//Setters
	public void setPatient_id(String value) {patient_id.set(value);}
	public void setModality(String value) {modality.set(value);}
	public void setDate_time(String value) {date_time.set(value);}
	public void setRadiologist(String value) {radiologist.set(value);}
	public void setTechnician(String value) {technician.set(value);}

	//Property Values
	public StringProperty patient_idProperty() {return patient_id;}
	public StringProperty modalityProperty() {return modality;}
	public StringProperty date_timeProperty() {return date_time;}
	public StringProperty radiologistProperty() {return radiologist;}
	public StringProperty technicianProperty() {return technician;}
	
}
