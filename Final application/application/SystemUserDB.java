package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SystemUserDB {
	private final IntegerProperty user_id;
	private final StringProperty username;
	private final StringProperty full_name;
	private final StringProperty email;
	private final StringProperty name;
	
	public SystemUserDB(Integer user_id, String username, String full_name, String email, String name) {
		this.user_id = new SimpleIntegerProperty(user_id);
		this.username = new SimpleStringProperty(username);
		this.full_name = new SimpleStringProperty(full_name);
		this.email = new SimpleStringProperty(email);
		this.name = new SimpleStringProperty(name);
	}
	
	//Getters
	public Integer getUser_id() {return user_id.get();}
	public String getUsername() {return username.get();}
	public String getFull_name() {return full_name.get();}
	public String getEmail() {return email.get();}
	public String getRole() {return name.get();}
	
	//Setters
	public void setUser_id(int value) {user_id.set(value);}
	public void setUsername(String value) {username.set(value);}
	public void setFull_name(String value) {full_name.set(value);}
	public void setEmail(String value) {email.set(value);}
	public void setRole(String value) {name.set(value);}

	//Property Values
	public IntegerProperty user_idProperty() {return user_id;}
	public StringProperty usernameProperty() {return username;}
	public StringProperty full_nameProperty() {return full_name;}
	public StringProperty emailProperty() {return email;}
	public StringProperty nameProperty() {return name;}
	
}
