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


public class Tech_PatientResults {
	
	@FXML
	private Button btnLogout;
	@FXML
	private Button btnHome;
	@FXML
	private Button btnUserInfo;
	@FXML
	private Button btnPrior;
	@FXML
	private Button btnNew;
	@FXML
	private Button btnRefresh;
	@FXML
	private TableView<Tech_PatientDB> tableTech_Patient;
	@FXML
	private TableColumn<Tech_PatientDB, String> colPatient_id;
	@FXML
	private TableColumn<Tech_PatientDB, String> colCondition;
	@FXML
	private TableColumn<Tech_PatientDB, String> colExam;
	@FXML
	private TableColumn<Tech_PatientDB, String> colFirst;
	@FXML
	private TableColumn<Tech_PatientDB, String> colLast;
	@FXML
	private TableColumn<Tech_PatientDB, String> colModality;
	@FXML
	private TableColumn<Tech_PatientDB, String> colID;
	@FXML
	private TableColumn<Tech_PatientDB, String> colURL;

	
	private ObservableList<Tech_PatientDB>data;
	private sql_conn sc;
	
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		sc = new sql_conn();
		
	}
	
	@FXML
	private void btnRefreshClicked(ActionEvent event) throws SQLException {
		
		sql_conn sql = new sql_conn();
			
		try(Connection conn = (Connection) sql.establishConn()){
			data = FXCollections.observableArrayList();
			Statement tech_patient = conn.createStatement();
			ResultSet rs = tech_patient.executeQuery("select patient_id, patient_condition, prior_exam, first_name, last_name, modality, imaging_id, image_url from patients, imaging_info;");
			while(rs.next()) {
				data.add(new Tech_PatientDB(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
			}
		} catch (SQLException ex) {
			System.err.println("Error"+ex);
		}
		
		//Set cell value factory to tableview 
		colPatient_id.setCellValueFactory(new PropertyValueFactory<>("patient_id"));
		colCondition.setCellValueFactory(new PropertyValueFactory<>("patient_condition"));
		colExam.setCellValueFactory(new PropertyValueFactory<>("prior_exam"));
		colFirst.setCellValueFactory(new PropertyValueFactory<>("first_name"));
		colLast.setCellValueFactory(new PropertyValueFactory<>("last_name"));
		colModality.setCellValueFactory(new PropertyValueFactory<>("modality"));
		colID.setCellValueFactory(new PropertyValueFactory<>("imaging_id"));
		colURL.setCellValueFactory(new PropertyValueFactory<>("image_url"));
		
		tableTech_Patient.setItems(null);
		tableTech_Patient.setItems(data);
	}
	
	public void btnLogoutClicked(ActionEvent event) throws IOException{
		Parent login = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
		Scene scene = new Scene(login);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(scene);
		window.show();
	}
	
	
	public void btnHomeClicked(ActionEvent event) throws IOException{
		Parent systemUser = FXMLLoader.load(getClass().getResource("Tech_AllAppoint.fxml"));
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
	
	
	public void btnPriorClicked(ActionEvent event) throws IOException{
	Parent admin = FXMLLoader.load(getClass().getResource("Tech_AllAppoint.fxml"));
	Scene scene = new Scene(admin);
	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	
	window.setScene(scene);
	window.show();
	}
	
	public void btnNewClicked(ActionEvent event) throws IOException{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("newPatientInfo.fxml"));
        Parent newAppointments = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(newAppointments)); 
        stage.show();
		
	}

}
