package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class updateToday {
	@FXML
	private Button btnCancel;
	@FXML
	
	public void btnCancelClicked(ActionEvent event) throws IOException{
		Parent userInfo = FXMLLoader.load(getClass().getResource("updateToday.fxml"));
		Scene scene = new Scene(userInfo);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(scene);
		window.close();
	}

}
