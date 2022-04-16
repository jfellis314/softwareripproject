package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class newAppointments {
	@FXML
	private Button btnCancel;
	@FXML
	private Button btnSubmit;	
	@FXML
	private TextField txt_ID;
	@FXML
	private TextField txt_Patient;
	@FXML
	private TextField txt_Order;
	@FXML
	private TextField txt_Datetime;
	@FXML
	private TextField txt_Tech;
	@FXML
	private TextField txt_Radio;
	
	private sql_conn sc;
	String query = null;
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		sc = new sql_conn();
	}
	
	
	public void btnSubmitClicked(ActionEvent event) throws IOException, SQLException{
		String id = txt_ID.getText();
		String patient = txt_Patient.getText();
		String order = txt_Order.getText();
		String datetime = txt_Datetime.getText();
		String tech = txt_Tech.getText();
		String radio = txt_Radio.getText();
		
		
		if (id.isEmpty()||patient.isEmpty()||order.isEmpty()||datetime.isEmpty()||tech.isEmpty()||radio.isEmpty()) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setContentText("Please Fill All DATA");
			alert.showAndWait();
		}else {
			getQuery();
			insert();
		}
		
	}
	
	private void insert() throws SQLException {
		try{
			PreparedStatement ps = null;
			Connection conn = (Connection) sql_conn.establishConn();
			ps = conn.prepareStatement(query);
			ps.setString(1, txt_ID.getText());
			ps.setString(2, txt_Patient.getText());
			ps.setString(3, txt_Order.getText());
			ps.setString(4, txt_Datetime.getText());
			ps.setString(5, txt_Tech.getText());
			ps.setString(6, txt_Radio.getText());
			ps.execute();
		} catch (SQLException ex) {
			System.err.println("Error"+ex);
		}
	}
		

	private void getQuery(){
		query = "insert into appointments (appointment_id, patient, order_id, date_time, technician, radiologist) values(?,?,?,?,?,?);";
		
	}


	public void btnCancelClicked(ActionEvent event) throws IOException{
		Parent userInfo = FXMLLoader.load(getClass().getResource("newAppointments.fxml"));
		Scene scene = new Scene(userInfo);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(scene);
		window.close();
	}
	


}
