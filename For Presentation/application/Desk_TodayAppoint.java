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


public class Desk_TodayAppoint {
	
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
	private Button btnNew;
	@FXML
	private TableView<Desk_TodayDB> tableToday;
	@FXML
	private TableColumn<Desk_TodayDB, String> colPatient;
	@FXML
	private TableColumn<Desk_TodayDB, String> colName;
	@FXML
	private TableColumn<Desk_TodayDB, String> colPrice;
	@FXML
	private TableColumn<Desk_TodayDB, String> colDate_time;
	@FXML
	private TableColumn<Desk_TodayDB, String> colIssuer;
	@FXML
	private TableColumn<Desk_TodayDB, String> colTechnician;
	@FXML
	private TableColumn<Desk_TodayDB, String> colStatus;
	@FXML
	private TableColumn<Desk_TodayDB, String> colPriority;

	
	private ObservableList<Desk_TodayDB>data;
	private sql_conn sc;
	
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		sc = new sql_conn();
		
	}
	
	@FXML
	private void btnRefreshClicked(ActionEvent event) throws SQLException {
		
		sql_conn sql = new sql_conn();
			
		try(Connection conn = (Connection) sql.establishConn()){
			data = FXCollections.observableArrayList();
			Statement todayappoint = conn.createStatement();
			ResultSet rs = todayappoint.executeQuery("select patient, name, price, date_time, issuer, technician, enrollee_id, priority from appointments, modalities;");
			while(rs.next()) {
				data.add(new Desk_TodayDB(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
			}
		} catch (SQLException ex) {
			System.err.println("Error"+ex);
		}
		
		//Set cell value factory to tableview 
		colPatient.setCellValueFactory(new PropertyValueFactory<>("patient"));
		colName.setCellValueFactory(new PropertyValueFactory<>("name"));
		colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
		colDate_time.setCellValueFactory(new PropertyValueFactory<>("date_time"));
		colIssuer.setCellValueFactory(new PropertyValueFactory<>("issuer"));
		colTechnician.setCellValueFactory(new PropertyValueFactory<>("technician"));
		colStatus.setCellValueFactory(new PropertyValueFactory<>("enrollee_id"));
		colPriority.setCellValueFactory(new PropertyValueFactory<>("priority"));
		
		tableToday.setItems(null);
		tableToday.setItems(data);
	}


	
	public void btnLogoutClicked(ActionEvent event) throws IOException{
		Parent login = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
		Scene scene = new Scene(login);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(scene);
		window.show();
	}
	
	
	public void btnHomeClicked(ActionEvent event) throws IOException{
		Parent systemUser = FXMLLoader.load(getClass().getResource("Desk_TodayAppoint.fxml"));
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
		Parent admin = FXMLLoader.load(getClass().getResource("Desk_NewPatient.fxml"));
		Scene scene = new Scene(admin);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(scene);
		window.show();
		}

	
	public void btnNewClicked(ActionEvent event) throws IOException{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("updateToday.fxml"));
        Parent newAppointments = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(newAppointments)); 
        stage.setTitle("Update");
        stage.show();
		
	}
}
