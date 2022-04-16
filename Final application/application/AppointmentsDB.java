package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AppointmentsDB {
	private final StringProperty appointment_id;
	private final StringProperty patient;
	private final StringProperty order_id;
	private final StringProperty date_time;
	private final StringProperty technician;
	private final StringProperty radiologist;
	
	public AppointmentsDB(String appointment_id, String patient, String order_id, String date_time, String technician, String radiologist) {
		this.appointment_id = new SimpleStringProperty(appointment_id);
		this.patient = new SimpleStringProperty(patient);
		this.order_id = new SimpleStringProperty(order_id);
		this.date_time = new SimpleStringProperty(date_time);
		this.technician = new SimpleStringProperty(technician);
		this.radiologist = new SimpleStringProperty(radiologist);
	}
	
	//Getters
	public String getAppointment_id() {return appointment_id.get();}
	public String getPatient() {return patient.get();}
	public String getOrder_id() {return order_id.get();}
	public String getDate_time() {return date_time.get();}
	public String getTechnician() {return technician.get();}
	public String getRadiologist() {return radiologist.get();}
	
	//Setters
	public void setAppointment_id(String value) {appointment_id.set(value);}
	public void setPatient(String value) {patient.set(value);}
	public void setOrder_id(String value) {order_id.set(value);}
	public void setDate_time(String value) {date_time.set(value);}
	public void setTechnician(String value) {technician.set(value);}
	public void setRadiologist(String value) {radiologist.set(value);}

	//Property Values
	public StringProperty appointment_idProperty() {return appointment_id;}
	public StringProperty patientProperty() {return patient;}
	public StringProperty order_idProperty() {return order_id;}
	public StringProperty date_timeProperty() {return date_time;}
	public StringProperty technicianProperty() {return technician;}
	public StringProperty radiologistProperty() {return radiologist;}
	
}
