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
import java.sql.*;
import java.util.ResourceBundle;

public class Doc_Schedule {
	
	@FXML
	private Button btnLogout;
	@FXML
	private Button btnHome;
	@FXML
	private Button btnUserInfo;
	@FXML
	private Button btnReport;
	@FXML
	private Button btnPrior;
	@FXML
	private Button btnNew;
	@FXML
	private Button btnRefresh;
	@FXML
	private TableView<Doc_ScheduleDB> tablePOrders;
	@FXML
	private TableColumn<Doc_ScheduleDB, String> colPatient_id;
	@FXML
	private TableColumn<Doc_ScheduleDB, String> colModality;
	@FXML
	private TableColumn<Doc_ScheduleDB, String> colCondition;
	@FXML
	private TableColumn<Doc_ScheduleDB, String> colDate_time;
	@FXML
	private TableColumn<Doc_ScheduleDB, String> colNotes;
	@FXML
	private TableColumn<Doc_ScheduleDB, String> colStatus;

	
	private ObservableList<Doc_ScheduleDB>data;
	private sql_conn sc;
	
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		sc = new sql_conn();
		
	}
	
	@FXML
	private void btnRefreshClicked(ActionEvent event) throws SQLException {
		
		sql_conn sql = new sql_conn();
			
		try(Connection conn = (Connection) sql.establishConn()){
			data = FXCollections.observableArrayList();
			Statement schedule = conn.createStatement();
			ResultSet rs = schedule.executeQuery("select patient, modality, patient_condition, date_time, notes, status from patients, orders;");
			while(rs.next()) {
				data.add(new Doc_ScheduleDB(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
			}
		} catch (SQLException ex) {
			System.err.println("Error"+ex);
		}
		
		//Set cell value factory to tableview 
		colPatient_id.setCellValueFactory(new PropertyValueFactory<>("patient"));
		colModality.setCellValueFactory(new PropertyValueFactory<>("modality"));
		colCondition.setCellValueFactory(new PropertyValueFactory<>("patient_condition"));
		colDate_time.setCellValueFactory(new PropertyValueFactory<>("date_time"));
		colNotes.setCellValueFactory(new PropertyValueFactory<>("notes"));
		colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
		
		tablePOrders.setItems(null);
		tablePOrders.setItems(data);
	}


	
	public void btnLogoutClicked(ActionEvent event) throws IOException{
		Parent login = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
		Scene scene = new Scene(login);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(scene);
		window.show();
	}
	
	
	public void btnHomeClicked(ActionEvent event) throws IOException{
		Parent systemUser = FXMLLoader.load(getClass().getResource("Doc_Info.fxml"));
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
	
	
	public void btnReportClicked(ActionEvent event) throws IOException{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("allReports.fxml"));
        Parent userInfo = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(userInfo)); 
        stage.setTitle("User Info");
        stage.show();	
	}
	
	
	public void btnPriorClicked(ActionEvent event) throws IOException{
	Parent admin = FXMLLoader.load(getClass().getResource("Doc_Info.fxml"));
	Scene scene = new Scene(admin);
	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	
	window.setScene(scene);
	window.show();
	}
	
	
	public void btnNewClicked(ActionEvent event) throws IOException{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("newDoc_Schedule.fxml"));
        Parent newSchedule = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(newSchedule)); 
        stage.setTitle("New Order");
        stage.show();
		
	}
	

}

