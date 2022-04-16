package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PatientDB {
	private final IntegerProperty patient_id;
	private final StringProperty first_name;
	private final StringProperty last_name;
	private final StringProperty dob;
	private final StringProperty sex;
	private final StringProperty race;
	private final StringProperty ethnicity;
	
	
	public PatientDB(Integer patient_id, String first_name, String last_name, String dob, String sex, String race, String ethnicity) {
		this.patient_id = new SimpleIntegerProperty(patient_id);
		this.first_name = new SimpleStringProperty(first_name);
		this.last_name = new SimpleStringProperty(last_name);
		this.dob = new SimpleStringProperty(dob);
		this.sex = new SimpleStringProperty(sex);
		this.race = new SimpleStringProperty(race);
		this.ethnicity = new SimpleStringProperty(ethnicity);
	}
	
	//Getters
	public Integer getPatient_id() {return patient_id.get();}
	public String getFirst_name() {return first_name.get();}
	public String getLast_name() {return last_name.get();}
	public String getDob() {return dob.get();}
	public String getSex() {return sex.get();}
	public String getRace() {return race.get();}
	public String getEthnicity() {return ethnicity.get();}
	
	//Setters
	public void setPatient_id(int value) {patient_id.set(value);}
	public void setFirst_name(String value) {first_name.set(value);}
	public void setLast_name(String value) {last_name.set(value);}
	public void setDob(String value) {dob.set(value);}
	public void setSex(String value) {sex.set(value);}
	public void setRace(String value) {race.set(value);}
	public void setEthnicity(String value) {ethnicity.set(value);}

	//Property Values
	public IntegerProperty patient_idProperty() {return patient_id;}
	public StringProperty first_nameProperty() {return first_name;}
	public StringProperty last_nameProperty() {return last_name;}
	public StringProperty dobProperty() {return dob;}
	public StringProperty sexProperty() {return sex;}
	public StringProperty raceProperty() {return race;}
	public StringProperty ethnicityProperty() {return ethnicity;}
	
}
