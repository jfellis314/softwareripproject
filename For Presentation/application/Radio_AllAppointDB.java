package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Radio_AllAppointDB {
	private final StringProperty patient;
	private final StringProperty name;
	private final StringProperty date_time;
	private final StringProperty technician;
	private final StringProperty image_url;
	private final StringProperty notes;
	
	public Radio_AllAppointDB(String patient, String name, String date_time, String technician, String image_url, String notes) {
		this.patient = new SimpleStringProperty(patient);
		this.name = new SimpleStringProperty(name);
		this.date_time = new SimpleStringProperty(date_time);
		this.technician = new SimpleStringProperty(technician);
		this.image_url = new SimpleStringProperty(image_url);
		this.notes = new SimpleStringProperty(notes);
		
	}
	
	//Getters
	public String getPatient() {return patient.get();}
	public String getName() {return name.get();}
	public String getDate_time() {return date_time.get();}
	public String getTechnician() {return technician.get();}
	public String getImage_url() {return image_url.get();}
	public String getNotes() {return notes.get();}
	
	//Setters
	public void setPatient(String value) {patient.set(value);}
	public void setName(String value) {name.set(value);}
	public void setDate_time(String value) {date_time.set(value);}
	public void setTechnician(String value) {technician.set(value);}
	public void setImage_url(String value) {image_url.set(value);}
	public void setNotes(String value) {notes.set(value);}

	//Property Values
	public StringProperty patientProperty() {return patient;}
	public StringProperty nameProperty() {return name;}
	public StringProperty date_timeProperty() {return date_time;}
	public StringProperty technicianProperty() {return technician;}
	public StringProperty image_urlProperty() {return image_url;}
	public StringProperty notesProperty() {return notes;}
	
}
