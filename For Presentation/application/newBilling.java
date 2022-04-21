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

public class newBilling {
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
	@FXML
	private TextField text8;
	
	
	public void btnCancelClicked(ActionEvent event) throws IOException{
		Parent userInfo = FXMLLoader.load(getClass().getResource("newBilling.fxml"));
		Scene scene = new Scene(userInfo);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(scene);
		window.close();
	}
	
	public void btnSubmitClicked(ActionEvent event) throws IOException {
		String UID = text1.getText();
		String email = text2.getText();
		String phone = text3.getText();
		String price = text4.getText();
		String insurance = text5.getText();
		String taxes = text6.getText();
		String balance = text7.getText();
		String due = text8.getText();

		sql_conn sc = new sql_conn();
		try(Connection conn = (Connection) sc.establishConn())
		{
			Statement stmnt = conn.createStatement();
			stmnt.executeUpdate("INSERT INTO appointments(email_address, phone_number) VALUES ('"+email+"', '"+phone+"');");
			stmnt.executeUpdate("INSERT INTO billing(user_id, original_price, insurance, taxes, balance, due_date) VALUES ('"+UID+"', '"+price+"', '"+insurance+"', '"+taxes+"', '"+balance+"', '"+due+"');");
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