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

public class newOrders {
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
	
	private sql_conn sc;
	
	public void btnCancelClicked(ActionEvent event) throws IOException{
		Parent userInfo = FXMLLoader.load(getClass().getResource("newOrders.fxml"));
		Scene scene = new Scene(userInfo);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(scene);
		window.close();
	}

	public void btnSubmitClicked(ActionEvent event) throws IOException {
		String OID = text1.getText();
		String pat = text2.getText();
		String referralMD = text3.getText();
		String modality = text4.getText();
		String stat = text5.getText();
		String note = text6.getText();
		sc = new sql_conn();
		try(Connection conn = (Connection) sc.establishConn())
		{
			Statement stmnt = conn.createStatement();
			stmnt.executeUpdate("INSERT INTO orders(order_id, patient, referral_md, modality, notes, status) VALUES ('"+OID+"', '"+pat+"', '"+referralMD+"', '"+modality+"', '"+note+"', '"+stat+"');");
		}catch(Exception e) {System.out.println(e);}
		
		text1.clear();
		text2.clear();
		text3.clear();
		text4.clear();
		text5.clear();
		text6.clear();
		
	}
}