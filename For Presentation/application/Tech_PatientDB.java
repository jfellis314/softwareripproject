package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Tech_PatientDB {
	private final StringProperty patient_id;
	private final StringProperty patient_condition;
	private final StringProperty prior_exam;
	private final StringProperty first_name;
	private final StringProperty last_name;
	private final StringProperty modality;
	private final StringProperty imaging_id;
	private final StringProperty image_url;
	
	public Tech_PatientDB(String patient_id, String patient_condition, String prior_exam, String first_name, String last_name, String modality, String imaging_id, String image_url) {
		this.patient_id = new SimpleStringProperty(patient_id);
		this.patient_condition = new SimpleStringProperty(patient_condition);
		this.prior_exam = new SimpleStringProperty(prior_exam);
		this.first_name = new SimpleStringProperty(first_name);
		this.last_name = new SimpleStringProperty(last_name);
		this.modality = new SimpleStringProperty(modality);
		this.imaging_id = new SimpleStringProperty(imaging_id);
		this.image_url = new SimpleStringProperty(image_url);
		
	}
	
	//Getters
	public String getPatient_id() {return patient_id.get();}
	public String getPatient_condition() {return patient_condition.get();}
	public String getPrior_exam() {return prior_exam.get();}
	public String getFirst_name() {return first_name.get();}
	public String getLast_name() {return last_name.get();}
	public String getModality() {return modality.get();}
	public String getImaging_id() {return imaging_id.get();}
	public String getImage_url() {return image_url.get();}
	
	//Setters
	public void setPatient_id(String value) {patient_id.set(value);}
	public void setPatient_condition(String value) {patient_condition.set(value);}
	public void setPrior_exam(String value) {prior_exam.set(value);}
	public void setFirst_name(String value) {first_name.set(value);}
	public void setLast_name(String value) {last_name.set(value);}
	public void setModality(String value) {modality.set(value);}
	public void setImaging_id(String value) {imaging_id.set(value);}
	public void setImage_url(String value) {image_url.set(value);}

	//Property Values
	public StringProperty patient_idProperty() {return patient_id;}
	public StringProperty patient_conditionProperty() {return patient_condition;}
	public StringProperty prior_examProperty() {return prior_exam;}
	public StringProperty first_nameProperty() {return first_name;}
	public StringProperty last_nameProperty() {return last_name;}
	public StringProperty modalityProperty() {return modality;}
	public StringProperty imaging_idProperty() {return imaging_id;}
	public StringProperty image_urlProperty() {return image_url;}
	
}
