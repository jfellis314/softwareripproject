package application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

public class UserInfo {
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
	@FXML
	private TextField text5;
	@FXML
	private TextField text6;
	@FXML
	private TextField text7;
	
	public void btnCancelClicked(ActionEvent event) throws IOException{
		Parent userInfo = FXMLLoader.load(getClass().getResource("UserInfo.fxml"));
		Scene scene = new Scene(userInfo);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(scene);
		window.close();
	}
	
	public void btnSubmitClicked(ActionEvent event) throws IOException {
		String role = text1.getText();
		String display = text2.getText();
		String ID = text3.getText();
		String email = text4.getText();
		String username = text5.getText();
		String newPass = text7.getText();
		String password = text6.getText();

		if (newPass!=password) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Password");
			alert.setContentText("Password Change Confirmed!");
		}
		
		sql_conn sc = new sql_conn();
		try(Connection conn = (Connection) sc.establishConn())
		{
			Statement stmnt = conn.createStatement();
			stmnt.executeUpdate("INSERT INTO users(full_name, user_id, email, username, password) VALUES ('"+display+"', '"+ID+"', '"+email+"', '"+username+"', '"+password+"');");
			stmnt.executeUpdate("INSERT INTO roles(name) VALUES ('"+role+"');");
			
		}catch(Exception e) {System.out.println(e);}
		
		text1.clear();
		text2.clear();
		text3.clear();
		text4.clear();
		text5.clear();
		text6.clear();
		text7.clear();
	}

}
