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

public class newModalities {
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
	
	public void btnCancelClicked(ActionEvent event) throws IOException{
		Parent userInfo = FXMLLoader.load(getClass().getResource("newModalities.fxml"));
		Scene scene = new Scene(userInfo);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(scene);
		window.close();
	}
	
	public void btnSubmitClicked(ActionEvent event) throws IOException {
		String ID = text1.getText();
		String modality = text2.getText();
		String price = text3.getText();

		sql_conn sc = new sql_conn();
		try(Connection conn = (Connection) sc.establishConn())
		{
			Statement stmnt = conn.createStatement();
			stmnt.executeUpdate("INSERT INTO modalities VALUES ('"+ID+"', '"+modality+"', '"+price+"')");
		}catch(Exception e) {System.out.println(e);}
		
		text1.clear();
		text2.clear();
		text3.clear();
	

		
	}

}