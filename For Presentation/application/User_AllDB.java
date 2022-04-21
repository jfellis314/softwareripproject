package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User_AllDB {
	private StringProperty OID;
	private StringProperty MD;
	private StringProperty date;
	private StringProperty image;
	private StringProperty result;
	
	public User_AllDB(String OID, String MD, String date, String image, String result) {
		this.OID = new SimpleStringProperty(OID);
		this.MD = new SimpleStringProperty(MD);
		this.date = new SimpleStringProperty(date);
		this.image = new SimpleStringProperty(image);
		this.result = new SimpleStringProperty(result);
	}
	
	//order_id
	public String getOID () {
        return OID.get();
    }
    public void setOID (String OID){
        this.OID.set(OID);
    }
    public StringProperty OIDProperty() {
        return OID;
    }
    
    //md
    public String getMD () {
        return MD.get();
    }
    public void setMD (String MD){
        this.MD.set(MD);
    }
    public StringProperty MDProperty() {
        return MD;
    }
    
    //date
    public String getdate () {
        return date.get();
    }
    public void setdate (String date){
        this.date.set(date);
    }
    public StringProperty dateProperty() {
        return date;
    }
    
    //image
    public String getimage () {
        return image.get();
    }
    public void setimage (String image){
        this.image.set(image);
    }
    public StringProperty imageProperty() {
        return image;
    }
    
    //result
    public String getresult () {
        return result.get();
    }
    public void setresult (String result){
        this.result.set(result);
    }
    public StringProperty resultProperty() {
        return result;
    }
	
}
