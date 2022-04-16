package application;
import java.sql.*;
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
import java.sql.Connection;
import java.sql.SQLException;

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


public void btnLoginClicked(ActionEvent event) throws IOException, SQLException{ 
		
		sql_conn sql = new sql_conn();
		
		if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
			
			try(Connection conn = (Connection) sql.establishConn()){
				Statement login = conn.createStatement();
				ResultSet rs = login.executeQuery("select password from users where username=\""+ username.getText().toString() + "\"");
				rs.next();
				
			}
			
			wrongLogin.setText("Success!");
			
			Parent systemUser = FXMLLoader.load(getClass().getResource("SystemUser.fxml"));
			Scene scene = new Scene(systemUser);
			Stage sysUser = (Stage)((Node)event.getSource()).getScene().getWindow();
			
			sysUser.setScene(scene);
			sysUser.setTitle("Admin");
			sysUser.show();
			sysUser.setMaximized(true);
		}
		
		if(username.getText().toString().equals("tech") && password.getText().toString().equals("tech")) {
			
			try(Connection conn = (Connection) sql.establishConn()){
				Statement login = conn.createStatement();
				ResultSet rs = login.executeQuery("select password from users where username=\""+ username.getText().toString() + "\"");
				rs.next();
				
			}
			
			wrongLogin.setText("Success!");
			
			Parent systemUser = FXMLLoader.load(getClass().getResource("Tech_AllAppoint.fxml"));
			Scene scene = new Scene(systemUser);
			Stage sysUser = (Stage)((Node)event.getSource()).getScene().getWindow();
			
			sysUser.setScene(scene);
			sysUser.setTitle("Technician");
			sysUser.show();
			sysUser.setMaximized(true);
		}
		
		if(username.getText().toString().equals("radio") && password.getText().toString().equals("radio")) {
			
			try(Connection conn = (Connection) sql.establishConn()){
				Statement login = conn.createStatement();
				ResultSet rs = login.executeQuery("select password from users where username=\""+ username.getText().toString() + "\"");
				rs.next();
				
			}
			
			wrongLogin.setText("Success!");
			
			Parent systemUser = FXMLLoader.load(getClass().getResource("Radio_AllAppoint.fxml"));
			Scene scene = new Scene(systemUser);
			Stage sysUser = (Stage)((Node)event.getSource()).getScene().getWindow();
			
			sysUser.setScene(scene);
			sysUser.setTitle("Radiologist");
			sysUser.show();
			sysUser.setMaximized(true);
		}
		
		if(username.getText().toString().equals("desk") && password.getText().toString().equals("desk")) {
			
			try(Connection conn = (Connection) sql.establishConn()){
				Statement login = conn.createStatement();
				ResultSet rs = login.executeQuery("select password from users where username=\""+ username.getText().toString() + "\"");
				rs.next();
				
			}
			
			wrongLogin.setText("Success!");
			
			Parent systemUser = FXMLLoader.load(getClass().getResource("Desk_TodayAppoint.fxml"));
			Scene scene = new Scene(systemUser);
			Stage sysUser = (Stage)((Node)event.getSource()).getScene().getWindow();
			
			sysUser.setScene(scene);
			sysUser.setTitle("Receptionist");
			sysUser.show();
			sysUser.setMaximized(true);
		}
		
		if(username.getText().toString().equals("user") && password.getText().toString().equals("user")) {
			
			try(Connection conn = (Connection) sql.establishConn()){
				Statement login = conn.createStatement();
				ResultSet rs = login.executeQuery("select password from users where username=\""+ username.getText().toString() + "\"");
				rs.next();
			
			}
			
			wrongLogin.setText("Success!");
			
			Parent systemUser = FXMLLoader.load(getClass().getResource("User_All.fxml"));
			Scene scene = new Scene(systemUser);
			Stage sysUser = (Stage)((Node)event.getSource()).getScene().getWindow();
			
			sysUser.setScene(scene);
			sysUser.setTitle("User");
			sysUser.show();
			sysUser.setMaximized(true);
		}
		
		
		if(username.getText().toString().equals("doc") && password.getText().toString().equals("doc")) {
			
			try(Connection conn = (Connection) sql.establishConn()){
				Statement login = conn.createStatement();
				ResultSet rs = login.executeQuery("select password from users where username=\""+ username.getText().toString() + "\"");
				rs.next();
				
			}
			
			wrongLogin.setText("Success!");
			
			Parent systemUser = FXMLLoader.load(getClass().getResource("Doc_Info.fxml"));
			Scene scene = new Scene(systemUser);
			Stage sysUser = (Stage)((Node)event.getSource()).getScene().getWindow();
			
			sysUser.setScene(scene);
			sysUser.setTitle("Referral Doctor");
			sysUser.show();
			sysUser.setMaximized(true);
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