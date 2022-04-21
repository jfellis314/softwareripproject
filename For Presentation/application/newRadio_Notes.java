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

public class newRadio_Notes {
	@FXML
	private Button btnCancel;
	@FXML
	private Button btnSubmit;
	@FXML
	private TextField text1;
	@FXML
	private TextField text2;
	
	public void btnCancelClicked(ActionEvent event) throws IOException{
		Parent userInfo = FXMLLoader.load(getClass().getResource("newRadio_Notes.fxml"));
		Scene scene = new Scene(userInfo);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(scene);
		window.close();
	}

	
	public void btnSubmitClicked(ActionEvent event) throws IOException {
		String imag_datetime = text1.getText();
		String imag_notes = text2.getText();

		sql_conn sc = new sql_conn();
		try(Connection conn = (Connection) sc.establishConn())
		{
			Statement stmnt = conn.createStatement();
			stmnt.executeUpdate("UPDATE appointments SET notes='"+imag_notes+"' WHERE date_time='"+imag_datetime+"';");
		}catch(Exception e) {System.out.println(e);}
		
		text1.clear();	
		text2.clear();	
	}
}
