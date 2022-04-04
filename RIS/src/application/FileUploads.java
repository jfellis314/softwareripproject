package application;

import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.IOException;



public class FileUploads {
	
	@FXML
	private Button btnLogout;
	@FXML
	private Button btnHome;
	@FXML
	private Button btnUserInfo;
	@FXML
	private Button btnAdmin;
	@FXML
	private Button btnReferrals;
	@FXML
	private Button btnAppointments;
	@FXML
	private Button btnOrders;
	@FXML
	private Button btnNext;
	@FXML
	private Button btnPrior;
	@FXML
	private Button btnNew;

	
	public void btnLogoutClicked(ActionEvent event) throws IOException{
		Parent login = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
		Scene scene = new Scene(login);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(scene);
		window.show();
	}
	
	
	public void btnHomeClicked(ActionEvent event) throws IOException{
		Parent systemUser = FXMLLoader.load(getClass().getResource("SystemUser.fxml"));
		Scene scene = new Scene(systemUser);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(scene);
		window.show();
	}
	
	
	public void btnUserInfoClicked(ActionEvent event) throws IOException{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UserInfo.fxml"));
        Parent userInfo = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(userInfo)); 
        stage.setTitle("User Info");
        stage.show();
		
	}
	
	
	public void btnReferralsClicked(ActionEvent event) throws IOException{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("allReferrals.fxml"));
        Parent userInfo = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(userInfo)); 
        stage.setTitle("All Referrals");
        stage.show();
	}
	
	
	public void btnAppointmentsClicked(ActionEvent event) throws IOException{
	Parent admin = FXMLLoader.load(getClass().getResource("Appointments.fxml"));
	Scene scene = new Scene(admin);
	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	
	window.setScene(scene);
	window.show();
	}
	
	
	public void btnOrdersClicked(ActionEvent event) throws IOException{
	Parent admin = FXMLLoader.load(getClass().getResource("Orders.fxml"));
	Scene scene = new Scene(admin);
	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	
	window.setScene(scene);
	window.show();
	}
	
	
	public void btnNextClicked(ActionEvent event) throws IOException{
	Parent admin = FXMLLoader.load(getClass().getResource("DiagnosticReports.fxml"));
	Scene scene = new Scene(admin);
	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	
	window.setScene(scene);
	window.show();
	}
	
	
	public void btnPriorClicked(ActionEvent event) throws IOException{
	Parent admin = FXMLLoader.load(getClass().getResource("Appointments.fxml"));
	Scene scene = new Scene(admin);
	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	
	window.setScene(scene);
	window.show();
	}
	
	
	public void btnNewClicked(ActionEvent event) throws IOException{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("newFileUploads.fxml"));
        Parent newAppointments = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(newAppointments)); 
        stage.setTitle("New File Uploads");
        stage.show();
		
	}

}
