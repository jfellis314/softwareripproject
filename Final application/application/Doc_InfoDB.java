package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Doc_InfoDB {
	private final IntegerProperty order_id;
	private final StringProperty first_name;
	private final StringProperty last_name;
	private final StringProperty patient_condition;
	private final StringProperty prior_exam;
	private final StringProperty order_name;
	
	public Doc_InfoDB(Integer order_id, String first_name, String last_name, String patient_condition, String prior_exam, String order_name) {
		this.order_id = new SimpleIntegerProperty(order_id);
		this.first_name = new SimpleStringProperty(first_name);
		this.last_name = new SimpleStringProperty(last_name);
		this.patient_condition = new SimpleStringProperty(patient_condition);
		this.prior_exam = new SimpleStringProperty(prior_exam);
		this.order_name = new SimpleStringProperty(order_name);
	}
	
	//Getters
	public Integer getOrder_id() {return order_id.get();}
	public String getFirst_name() {return first_name.get();}
	public String getLast_name() {return last_name.get();}
	public String getPatient_condition() {return patient_condition.get();}
	public String getPrior_exam() {return prior_exam.get();}
	public String getOrder_name() {return order_name.get();}
	
	//Setters
	public void setOrder_id(int value) {order_id.set(value);}
	public void setFirst_name(String value) {first_name.set(value);}
	public void setLast_name(String value) {last_name.set(value);}
	public void setPatient_condition(String value) {patient_condition.set(value);}
	public void setPrior_exam(String value) {prior_exam.set(value);}
	public void setOrder_name(String value) {order_name.set(value);}

	//Property Values
	public IntegerProperty order_idProperty() {return order_id;}
	public StringProperty first_nameProperty() {return first_name;}
	public StringProperty last_nameProperty() {return last_name;}
	public StringProperty patient_conditionProperty() {return patient_condition;}
	public StringProperty prior_examProperty() {return prior_exam;}
	public StringProperty order_nameProperty() {return order_name;}
	
}
