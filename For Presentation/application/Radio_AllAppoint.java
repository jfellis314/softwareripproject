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


public class Radio_AllAppoint {
	
	@FXML
	private Button btnLogout;
	@FXML
	private Button btnHome;
	@FXML
	private Button btnUserInfo;
	@FXML
	private Button btnNew;
	@FXML
	private Button btnRefresh;
	@FXML
	private TableView<Radio_AllAppointDB> tableAll;
	@FXML
	private TableColumn<Radio_AllAppointDB, String> colPatient;
	@FXML
	private TableColumn<Radio_AllAppointDB, String> colName;
	@FXML
	private TableColumn<Radio_AllAppointDB, String> colDate_time;
	@FXML
	private TableColumn<Radio_AllAppointDB, String> colTechnician;
	@FXML
	private TableColumn<Radio_AllAppointDB, String> colImage;
	@FXML
	private TableColumn<Radio_AllAppointDB, String> colNotes;

	
	private ObservableList<Radio_AllAppointDB>data;
	private sql_conn sc;
	
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		sc = new sql_conn();
		
	}
	
	@FXML
	private void btnRefreshClicked(ActionEvent event) throws SQLException {
		
		sql_conn sql = new sql_conn();
			
		try(Connection conn = (Connection) sql.establishConn()){
			data = FXCollections.observableArrayList();
			Statement allappoint = conn.createStatement();
			ResultSet rs = allappoint.executeQuery("select patient , name, date_time, technician, image_url, notes from imaging_info, modalities, appointments;");
			while(rs.next()) {
				data.add(new Radio_AllAppointDB(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
			}
		} catch (SQLException ex) {
			System.err.println("Error"+ex);
		}
		
		//Set cell value factory to tableview 
		colPatient.setCellValueFactory(new PropertyValueFactory<>("patient"));
		colName.setCellValueFactory(new PropertyValueFactory<>("name"));
		colDate_time.setCellValueFactory(new PropertyValueFactory<>("date_time"));
		colTechnician.setCellValueFactory(new PropertyValueFactory<>("technician"));
		colImage.setCellValueFactory(new PropertyValueFactory<>("image_url"));
		colNotes.setCellValueFactory(new PropertyValueFactory<>("notes"));
		
		tableAll.setItems(null);
		tableAll.setItems(data);
	}
	
	public void btnLogoutClicked(ActionEvent event) throws IOException{
		Parent login = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
		Scene scene = new Scene(login);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(scene);
		window.show();
	}
	
	
	public void btnHomeClicked(ActionEvent event) throws IOException{
		Parent systemUser = FXMLLoader.load(getClass().getResource("Radio_AllAppoint.fxml"));
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
	
	
	public void btnNewClicked(ActionEvent event) throws IOException{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("newRadio_Notes.fxml"));
        Parent userInfo = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(userInfo)); 
        stage.setTitle("Notes");
        stage.show();
		
	}
	
	
	

}
