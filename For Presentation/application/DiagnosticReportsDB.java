package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DiagnosticReportsDB {
	private final StringProperty diagnostic_report_id;
	private final StringProperty order_id;
	private final StringProperty patient;
	private final StringProperty radiologist;
	private final StringProperty diagnostic;
	
	public DiagnosticReportsDB(String diagnostic_report_id, String order_id, String patient, String radiologist, String diagnostic) {
		this.diagnostic_report_id = new SimpleStringProperty(diagnostic_report_id);
		this.order_id = new SimpleStringProperty(order_id);
		this.patient = new SimpleStringProperty(patient);
		this.radiologist = new SimpleStringProperty(radiologist);
		this.diagnostic = new SimpleStringProperty(diagnostic);
	}
	
	//Getters
	public String getDiagnostic_report_id() {return diagnostic_report_id.get();}
	public String getOrder_id() {return order_id.get();}
	public String getPatient() {return patient.get();}
	public String getRadiologist() {return radiologist.get();}
	public String getDiagnostic() {return diagnostic.get();}
	
	//Setters
	public void setDiagnostic_report_id(String value) {diagnostic_report_id.set(value);}
	public void setOrder_id(String value) {order_id.set(value);}
	public void setPatient(String value) {patient.set(value);}
	public void setRadiologist(String value) {radiologist.set(value);}
	public void setDiagnostic(String value) {diagnostic.set(value);}

	//Property Values
	public StringProperty diagnostic_report_idProperty() {return diagnostic_report_id;}
	public StringProperty order_idProperty() {return order_id;}
	public StringProperty patientProperty() {return patient;}
	public StringProperty radiologistProperty() {return radiologist;}
	public StringProperty diagnosticProperty() {return diagnostic;}
	
}
