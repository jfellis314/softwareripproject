package application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.IOException;

public class Login {
	@FXML
	private Button btnLogin;
	@FXML
	private Button btnReset;
	@FXML
	private Button btnExit;
	@FXML
	private Label wrongLogin;
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;
	@FXML


public void btnLoginClicked(ActionEvent event) throws IOException{  
		if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
			wrongLogin.setText("Success!");
			
			Parent systemUser = FXMLLoader.load(getClass().getResource("SystemUser.fxml"));
			Scene scene = new Scene(systemUser);
			Stage sysUser = (Stage)((Node)event.getSource()).getScene().getWindow();
			
			sysUser.setScene(scene);
			sysUser.setTitle("Admin");
			sysUser.show();
			sysUser.setMaximized(true);
			
		} else if (password.getText().isEmpty() && username.getText().isEmpty()) {
			wrongLogin.setText("Please Enter in your Login Information");
		} else if (password.getText().toString().equals("")) {
			wrongLogin.setText("Wrong Password. Try Again.");
			password.setText("");
		} else if (username.getText().toString().equals("")) {
			wrongLogin.setText("Wrong Username. Try Again.");
			username.setText("");
		} else {
			wrongLogin.setText("Wrong Username & Password. Try Again.");
			username.setText("");
			password.setText("");
		}
}

public void btnResetClicked(ActionEvent event) throws IOException{  
	username.setText("");
	password.setText("");
}

public void btnExitClicked(ActionEvent event) throws IOException{  
	System.exit(0);
}

}