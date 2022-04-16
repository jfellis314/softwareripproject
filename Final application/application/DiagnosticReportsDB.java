package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DiagnosticReportsDB {
	private final IntegerProperty diagnostic_report_id;
	private final IntegerProperty order_id;
	private final IntegerProperty patient;
	private final IntegerProperty radiologist;
	private final StringProperty diagnostic;
	
	public DiagnosticReportsDB(Integer diagnostic_report_id, Integer order_id, Integer patient, Integer radiologist, String diagnostic) {
		this.diagnostic_report_id = new SimpleIntegerProperty(diagnostic_report_id);
		this.order_id = new SimpleIntegerProperty(order_id);
		this.patient = new SimpleIntegerProperty(patient);
		this.radiologist = new SimpleIntegerProperty(radiologist);
		this.diagnostic = new SimpleStringProperty(diagnostic);
	}
	
	//Getters
	public Integer getDiagnostic_report_id() {return diagnostic_report_id.get();}
	public Integer getOrder_id() {return order_id.get();}
	public Integer getPatient() {return patient.get();}
	public Integer getRadiologist() {return radiologist.get();}
	public String getDiagnostic() {return diagnostic.get();}
	
	//Setters
	public void setDiagnostic_report_id(int value) {diagnostic_report_id.set(value);}
	public void setOrder_id(int value) {order_id.set(value);}
	public void setPatient(int value) {patient.set(value);}
	public void setRadiologist(int value) {radiologist.set(value);}
	public void setDiagnostic(String value) {diagnostic.set(value);}

	//Property Values
	public IntegerProperty diagnostic_report_idProperty() {return diagnostic_report_id;}
	public IntegerProperty order_idProperty() {return order_id;}
	public IntegerProperty patientProperty() {return patient;}
	public IntegerProperty radiologistProperty() {return radiologist;}
	public StringProperty diagnosticProperty() {return diagnostic;}
	
}
