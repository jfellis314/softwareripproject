package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class FileUploadsDB {
	private final IntegerProperty file_upload_id;
	private final StringProperty file_name;
	private final StringProperty file_type;
	private final IntegerProperty order_id;
	
	public FileUploadsDB(Integer file_upload_id, String file_name, String file_type, Integer order_id) {
		this.file_upload_id = new SimpleIntegerProperty(file_upload_id);
		this.file_name = new SimpleStringProperty(file_name);
		this.file_type = new SimpleStringProperty(file_type);
		this.order_id = new SimpleIntegerProperty(order_id);
	}
	
	//Getters
	public Integer getFile_upload_id() {return file_upload_id.get();}
	public String getFile_name() {return file_name.get();}
	public String getFile_type() {return file_type.get();}
	public Integer getOrder_id() {return order_id.get();}

	//Setters
	public void setFile_upload_id(int value) {file_upload_id.set(value);}
	public void setFile_name(String value) {file_name.set(value);}
	public void setFile_type(String value) {file_type.set(value);}
	public void setOrder_id(int value) {order_id.set(value);}

	//Property Values
	public IntegerProperty file_upload_idProperty() {return file_upload_id;}
	public StringProperty file_nameProperty() {return file_name;}
	public StringProperty file_typeProperty() {return file_type;}
	public IntegerProperty order_idProperty() {return order_id;}
	
}
