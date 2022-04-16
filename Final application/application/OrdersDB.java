package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class OrdersDB {
	private final IntegerProperty order_id;
	private final IntegerProperty patient;
	private final StringProperty issuer;
	private final StringProperty name;
	private final StringProperty notes;
	private final StringProperty order_name;
	
	public OrdersDB(Integer order_id, Integer patient, String issuer, String name, String notes, String order_name) {
		this.order_id = new SimpleIntegerProperty(order_id);
		this.patient = new SimpleIntegerProperty(patient);
		this.issuer = new SimpleStringProperty(issuer);
		this.name = new SimpleStringProperty(name);
		this.notes = new SimpleStringProperty(notes);
		this.order_name = new SimpleStringProperty(order_name);
	}
	
	//Getters
	public int getOrder_id() {return order_id.get();}
	public int getPatient() {return patient.get();}
	public String getIssuer() {return issuer.get();}
	public String getName() {return name.get();}
	public String getNotes() {return notes.get();}
	public String getOrder_name() {return order_name.get();}
	
	//Setters
	public void setOrder_id(int value) {order_id.set(value);}
	public void setPatient(int value) {patient.set(value);}
	public void setIssuer(String value) {issuer.set(value);}
	public void setName(String value) {name.set(value);}
	public void setNotes(String value) {notes.set(value);}
	public void setOrder_name(String value) {order_name.set(value);}

	//Property Values
	public IntegerProperty order_idProperty() {return order_id;}
	public IntegerProperty patientProperty() {return patient;}
	public StringProperty issuerProperty() {return issuer;}
	public StringProperty nameProperty() {return name;}
	public StringProperty notesProperty() {return notes;}
	public StringProperty order_nameProperty() {return order_name;}
	
}

