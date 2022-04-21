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

public class newSystemUsers {
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
		Parent userInfo = FXMLLoader.load(getClass().getResource("newSystemUsers.fxml"));
		Scene scene = new Scene(userInfo);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(scene);
		window.close();
	}
	
	public void btnSubmitClicked(ActionEvent event) throws IOException {
		String UID = text1.getText();
		String username = text2.getText();
		String pw= text3.getText();
		String display = text4.getText();
		String email = text5.getText();
		String role = text6.getText();
		sql_conn sc = new sql_conn();


		try(Connection conn = (Connection) sc.establishConn())
		{
			Statement stmnt = conn.createStatement();			
			stmnt.executeUpdate("INSERT INTO users(user_id, username, password, full_name, email) VALUES ('"+UID+"', '"+username+"', '"+pw+"', '"+display+"', '"+email+ "');");
			stmnt.executeUpdate("INSERT INTO roles(name) VALUES ('"+role+"');");
			
		}catch(Exception e) {System.out.println(e);}
		
		text1.clear();
		text2.clear();
		text3.clear();
		text4.clear();
		text5.clear();
		text6.clear();
		
	}

}