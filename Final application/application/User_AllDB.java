package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User_AllDB {
	private final IntegerProperty order_id;
	private final StringProperty issuer;
	private final StringProperty date_time;
	private final StringProperty image_url;
	private final StringProperty notes;
	
	public User_AllDB(Integer order_id, String issuer, String date_time, String image_url, String notes) {
		this.order_id = new SimpleIntegerProperty(order_id);
		this.issuer = new SimpleStringProperty(issuer);
		this.date_time = new SimpleStringProperty(date_time);
		this.image_url = new SimpleStringProperty(image_url);
		this.notes = new SimpleStringProperty(notes);
	}
	
	//Getters
	public Integer getOrder_id() {return order_id.get();}
	public String getIssuer() {return issuer.get();}
	public String getDate_time() {return date_time.get();}
	public String getImage_url() {return image_url.get();}
	public String getNotes() {return notes.get();}
	
	//Setters
	public void setOrder_id(int value) {order_id.set(value);}
	public void setIssuer(String value) {issuer.set(value);}
	public void setDate_time(String value) {date_time.set(value);}
	public void setImage_url(String value) {image_url.set(value);}
	public void setNotes(String value) {notes.set(value);}

	//Property Values
	public IntegerProperty order_idProperty() {return order_id;}
	public StringProperty issuerProperty() {return issuer;}
	public StringProperty date_timeProperty() {return date_time;}
	public StringProperty image_urlProperty() {return image_url;}
	public StringProperty notesProperty() {return notes;}
	
}
