package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PatientAlertsDB {
	private final IntegerProperty alert_id;
	private final StringProperty alert_name;
		
	public PatientAlertsDB(Integer alert_id, String alert_name) {
		this.alert_id = new SimpleIntegerProperty(alert_id);
		this.alert_name = new SimpleStringProperty(alert_name);
	}
	
	//Getters
	public Integer getAlert_id() {return alert_id.get();}
	public String getAlert_name() {return alert_name.get();}
	
	//Setters
	public void setAlert_id(int value) {alert_id.set(value);}
	public void setAlert_name(String value) {alert_name.set(value);}
	
	//Property Values
	public IntegerProperty alert_idProperty() {return alert_id;}
	public StringProperty alert_nameProperty() {return alert_name;}
	
}
