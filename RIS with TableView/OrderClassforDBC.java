package sample.model;
import javafx.beans.property.*;


public class Order {
    //Declare Order Table Columns
    private IntegerProperty orderID;
    private IntegerProperty patient;
    private IntegerProperty referral_md;
    private IntegerProperty modality;
    private StringProperty notes;
    private IntegerProperty report;
    
    //Constructor
    public Order() {
        this.orderID = new SimpleIntegerProperty();
        this.patient = new SimpleIntegerProperty();
        this.referral_md = new SimpleIntegerProperty();
        this.modality = new SimpleIntegerProperty();
        this.notes = new SimpleStringProperty();
        this.report = new SimpleIntegerProperty();
    }
    //orderID
    public int getOrderId() {
        return orderID.get();
    }
    public void setOrderId(int orderId){
        this.orderID.set(orderId);
    }
    public IntegerProperty orderIdProperty(){
        return orderID;
    }
    //patient
    public int getPatient () {
        return patient.get();
    }
    public void setPatient(int patient){
        this.patient.set(patient);
    }
    public IntegerProperty patient() {
        return patient;
    }
    //referral_md
    public int getReferralMD () {
        return referral_md.get();
    }
    public void setReferralMD(int referralmd){
        this.referral_md.set(referralmd);
    }
    public IntegerProperty referralMDProperty() {
        return referral_md;
    }
    //modality
    public String getModality () {
        return modality.get();
    }
    public void setModality (String modality){
        this.modality.set(modality);
    }
    public IntegerProperty modalityProperty() {
        return modality;
    }
    //notes
    public String getNotes () {
        return notes.get();
    }
    public void setNotes (String notes){
        this.notes.set(notes);
    }
    public StringProperty notesProperty() {
        return notes;
    }
    //report
    public int getReport(){
        return report.get();
    }
    public void setReport(int report){
        this.report.set(report);
    }
    public IntegerProperty reportProperty(){
        return report;
    }
}
    
