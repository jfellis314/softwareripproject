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

public class newFileUploads {
	@FXML
	private Button btnCancel;
	@FXML
	private Button btnSubmit;
	@FXML
	private TextField text1;
	@FXML
	private TextField text2;
	@FXML
	private TextField text3;
	@FXML
	private TextField text4;
	
	public void btnCancelClicked(ActionEvent event) throws IOException{
		Parent userInfo = FXMLLoader.load(getClass().getResource("newFileUploads.fxml"));
		Scene scene = new Scene(userInfo);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(scene);
		window.close();
	}
	
	public void btnSubmitClicked(ActionEvent event) throws IOException {
		String FID = text1.getText();
		String name = text2.getText();
		String type = text3.getText();
		String order = text4.getText();
		sql_conn sc = new sql_conn();

		try(Connection conn = (Connection) sc.establishConn())
		{
			Statement stmnt = conn.createStatement();
			stmnt.executeUpdate("INSERT INTO file_uploads(file_upload_id, file_name, file_type, order_id) VALUES ('"+FID+"', '"+name+"', '"+type+"', '"+order+"');");
			
		}catch(Exception e) {System.out.println(e);}
		
		text1.clear();
		text2.clear();
		text3.clear();
		text4.clear();
		
	}

}