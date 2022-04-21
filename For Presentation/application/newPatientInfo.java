package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class newPatientInfo {
	@FXML
	private Button btnCancel;
	@FXML
	private TextField text1;
	@FXML
	private TextField text2;
	@FXML
	private TextField text3;
	@FXML
	private TextField text4;
	@FXML
	private TextField text5;
	@FXML
	private TextField text6;
	@FXML
	private TextField text7;
	@FXML
	private TextField text8;
	
	private sql_conn sc;
	
	public void btnCancelClicked(ActionEvent event) throws IOException{
		Parent userInfo = FXMLLoader.load(getClass().getResource("newPatientInfo.fxml"));
		Scene scene = new Scene(userInfo);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(scene);
		window.close();
	}
	
	public void btnSubmitClicked(ActionEvent event) throws IOException {
		String PID = text1.getText();
		String condition = text2.getText();
		String prior = text3.getText();
		String first = text4.getText();
		String last = text5.getText();
		String modal = text6.getText();
		String imagID = text7.getText();
		String imagURL = text8.getText();
		sc = new sql_conn();
		try(Connection conn = (Connection) sc.establishConn())
		{
			Statement stmnt = conn.createStatement();
			stmnt.executeUpdate("UPDATE patients SET patient_condition='"+condition+"', prior_exam='"+prior+"', first_name='"+first+"', last_name='"+last+"' WHERE patient_id='"+PID+"';");
			stmnt.executeUpdate("INSERT INTO imaging_info(modality, imaging_id, image_url) VALUES ('"+modal+"', '"+imagID+"', '"+imagURL+"');");
		}catch(Exception e) {System.out.println(e);}
		
		text1.clear();
		text2.clear();
		text3.clear();
		text4.clear();
		text5.clear();
		text6.clear();
		text7.clear();
		text8.clear();
		
	}

}
