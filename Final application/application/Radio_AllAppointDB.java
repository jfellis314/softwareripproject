package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Radio_AllAppointDB {
	private final IntegerProperty patient;
	private final StringProperty name;
	private final StringProperty image_datetime;
	private final IntegerProperty technician;
	private final StringProperty image_url;
	private final StringProperty image_notes;
	
	public Radio_AllAppointDB(Integer patient, String name, String image_datetime, Integer technician, String image_url, String image_notes) {
		this.patient = new SimpleIntegerProperty(patient);
		this.name = new SimpleStringProperty(name);
		this.image_datetime = new SimpleStringProperty(image_datetime);
		this.technician = new SimpleIntegerProperty(technician);
		this.image_url = new SimpleStringProperty(image_url);
		this.image_notes = new SimpleStringProperty(image_notes);
		
	}
	
	//Getters
	public Integer getPatient() {return patient.get();}
	public String getName() {return name.get();}
	public String getImage_datetime() {return image_datetime.get();}
	public Integer getTechnician() {return technician.get();}
	public String getImage_url() {return image_url.get();}
	public String getImage_Notes() {return image_notes.get();}
	
	//Setters
	public void setPatient(int value) {patient.set(value);}
	public void setName(String value) {name.set(value);}
	public void setImage_datetime(String value) {image_datetime.set(value);}
	public void setTechnician(int value) {technician.set(value);}
	public void setImage_url(String value) {image_url.set(value);}
	public void setImage_Notes(String value) {image_notes.set(value);}

	//Property Values
	public IntegerProperty patientProperty() {return patient;}
	public StringProperty nameProperty() {return name;}
	public StringProperty image_datetimeProperty() {return image_datetime;}
	public IntegerProperty technicianProperty() {return technician;}
	public StringProperty image_urlProperty() {return image_url;}
	public StringProperty image_notesProperty() {return image_notes;}
	
}
