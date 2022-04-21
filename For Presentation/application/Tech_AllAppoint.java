package application;

import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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


public class Tech_AllAppoint implements Initializable{
	
	@FXML
	private Button btnLogout;
	@FXML
	private Button btnHome;
	@FXML
	private Button btnUserInfo;
	@FXML
	private Button btnNext;
	@FXML
	private Button btnRefresh;
	@FXML
	private TableView<Tech_AllAppointDB> tableTech_Page1;
	@FXML
	private TableColumn<Tech_AllAppointDB, String> colPatient_id;
	@FXML
	private TableColumn<Tech_AllAppointDB, String> colModality;
	@FXML
	private TableColumn<Tech_AllAppointDB, String> colDate_time;
	@FXML
	private TableColumn<Tech_AllAppointDB, String> colRadiologist;
	@FXML
	private TableColumn<Tech_AllAppointDB, String> colIssuer;

	
	private ObservableList<Tech_AllAppointDB>data;
	private sql_conn sc;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		sc = new sql_conn();
		
	}
	
	@FXML
	private void btnRefreshClicked(ActionEvent event) throws SQLException {
		
		sql_conn sql = new sql_conn();
			
		try(Connection conn = (Connection) sql.establishConn()){
			data = FXCollections.observableArrayList();
			Statement tech_allappoint = conn.createStatement();
			ResultSet rs = tech_allappoint.executeQuery("select patient_id, modality, date_time, radiologist, issuer from patients, appointments;");
			while(rs.next()) {
				data.add(new Tech_AllAppointDB(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
			}
		} catch (SQLException ex) {
			System.err.println("Error"+ex);
		}
		
		//Set cell value factory to tableview 
		colPatient_id.setCellValueFactory(new PropertyValueFactory<>("patient_id"));
		colModality.setCellValueFactory(new PropertyValueFactory<>("modality"));
		colDate_time.setCellValueFactory(new PropertyValueFactory<>("date_time"));
		colRadiologist.setCellValueFactory(new PropertyValueFactory<>("radiologist"));
		colIssuer.setCellValueFactory(new PropertyValueFactory<>("issuer"));
		
		tableTech_Page1.setItems(null);
		tableTech_Page1.setItems(data);
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
	
	
	public void btnNextClicked(ActionEvent event) throws IOException{
	Parent admin = FXMLLoader.load(getClass().getResource("Tech_PatientResults.fxml"));
	Scene scene = new Scene(admin);
	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	
	window.setScene(scene);
	window.show();
	}
	

}
