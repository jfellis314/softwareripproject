package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;


public class Patients {
	
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
	@FXML
	private Button btnRefresh;
	@FXML
	private TableView<PatientDB> tablePatient;
	@FXML
	private TableColumn<PatientDB, String> colID;
	@FXML
	private TableColumn<PatientDB, String> colFirst;
	@FXML
	private TableColumn<PatientDB, String> colLast;
	@FXML
	private TableColumn<PatientDB, String> colDOB;
	@FXML
	private TableColumn<PatientDB, String> colSex;
	@FXML
	private TableColumn<PatientDB, String> colRace;
	@FXML
	private TableColumn<PatientDB, String> colEthnicity;
	@FXML
	private TableColumn<PatientDB, String> colInsurance;

	
	private ObservableList<PatientDB>data;
	private sql_conn sc;
	
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		sc = new sql_conn();
		
	}
	
	@FXML
	private void btnRefreshClicked(ActionEvent event) throws SQLException {
		
		sql_conn sql = new sql_conn();
			
		try(Connection conn = (Connection) sql.establishConn()){
			data = FXCollections.observableArrayList();
			Statement patient = conn.createStatement();
			ResultSet rs = patient.executeQuery("select patient_id, first_name, last_name, dob, sex, race, ethnicity, insurance from patients;");
			while(rs.next()) {
				data.add(new PatientDB(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
			}
		} catch (SQLException ex) {
			System.err.println("Error"+ex);
		}
		
		//Set cell value factory to tableview 
		colID.setCellValueFactory(new PropertyValueFactory<>("patient_id"));
		colFirst.setCellValueFactory(new PropertyValueFactory<>("first_name"));
		colLast.setCellValueFactory(new PropertyValueFactory<>("last_name"));
		colDOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
		colSex.setCellValueFactory(new PropertyValueFactory<>("sex"));
		colRace.setCellValueFactory(new PropertyValueFactory<>("race"));
		colEthnicity.setCellValueFactory(new PropertyValueFactory<>("ethnicity"));
		colInsurance.setCellValueFactory(new PropertyValueFactory<>("insurance"));
		
		tablePatient.setItems(null);
		tablePatient.setItems(data);
	}

	
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
	Parent admin = FXMLLoader.load(getClass().getResource("Orders.fxml"));
	Scene scene = new Scene(admin);
	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	
	window.setScene(scene);
	window.show();
	}
	
	
	public void btnPriorClicked(ActionEvent event) throws IOException{
	Parent admin = FXMLLoader.load(getClass().getResource("PatientAlerts.fxml"));
	Scene scene = new Scene(admin);
	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	
	window.setScene(scene);
	window.show();
	}

	
	public void btnNewClicked(ActionEvent event) throws IOException{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("newPatients.fxml"));
        Parent userInfo = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(userInfo)); 
        stage.setTitle("New Patients");
        stage.show();
		
	}
}
