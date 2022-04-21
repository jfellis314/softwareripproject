package application;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ModalitiesDB {
	private final IntegerProperty modality_id;
	private final StringProperty name;
	private final FloatProperty modality_price;
	
	public ModalitiesDB(Integer modality_id, String name, Float modality_price) {
		this.modality_id = new SimpleIntegerProperty(modality_id);
		this.name = new SimpleStringProperty(name);
		this.modality_price = new SimpleFloatProperty(modality_price);
	}
	
	//Getters
	public Integer getModality_id() {return modality_id.get();}
	public String getName() {return name.get();}
	public Float getModality_price() {return modality_price.get();}
	
	//Setters
	public void setModality_id(int value) {modality_id.set(value);}
	public void setName(String value) {name.set(value);}
	public void setModality_price(float value) {modality_price.set(value);}
	
	//Property Values
	public IntegerProperty modality_idProperty() {return modality_id;}
	public StringProperty nameProperty() {return name;}
	public FloatProperty modality_priceProperty() {return modality_price;}
}
