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
public class Orders {
	
	@FXML
	private Button btnLogout;
	@FXML
	private Button btnHome;
	@FXML
	private Button btnUserInfo;
	@FXML
	private Button btnReferrals;
	@FXML
	private Button btnAppointments;
	@FXML
	private Button btnNext;
	@FXML
	private Button btnPrior;
	@FXML
	private Button btnNew;
	@FXML
	private Button btnRefresh;
	@FXML
	private TableView<OrdersDB> tableOrders;
	@FXML
	private TableColumn<OrdersDB, String> colOrderID;
	@FXML
	private TableColumn<OrdersDB, String> colPatient;
	@FXML
	private TableColumn<OrdersDB, String> colReferral_md;
	@FXML
	private TableColumn<OrdersDB, String> colModality;
	@FXML
	private TableColumn<OrdersDB, String> colNotes;
	@FXML
	private TableColumn<OrdersDB, String> colStatus;

	
	private ObservableList<OrdersDB>data;
	private sql_conn sc;
	
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		sc = new sql_conn();
		
	}
	
	@FXML
	private void btnRefreshClicked(ActionEvent event) throws SQLException {
		
		sql_conn sql = new sql_conn();
			
		try(Connection conn = (Connection) sql.establishConn()){
			data = FXCollections.observableArrayList();
			Statement orders = conn.createStatement();
			ResultSet rs = orders.executeQuery("select order_id, patient, referral_md, modality, notes, status from orders;");
			while(rs.next()) {
				data.add(new OrdersDB(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
			}
		} catch (SQLException ex) {
			System.err.println("Error"+ex);
		}
		
		//Set cell value factory to tableview 
		colOrderID.setCellValueFactory(new PropertyValueFactory<>("order_id"));
		colPatient.setCellValueFactory(new PropertyValueFactory<>("patient"));
		colReferral_md.setCellValueFactory(new PropertyValueFactory<>("referral_md"));
		colModality.setCellValueFactory(new PropertyValueFactory<>("modality"));
		colNotes.setCellValueFactory(new PropertyValueFactory<>("notes"));
		colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
		
		tableOrders.setItems(null);
		tableOrders.setItems(data);
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
	
	
	public void btnNextClicked(ActionEvent event) throws IOException{
	Parent admin = FXMLLoader.load(getClass().getResource("Appointments.fxml"));
	Scene scene = new Scene(admin);
	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	
	window.setScene(scene);
	window.show();
	}
	
	
	public void btnPriorClicked(ActionEvent event) throws IOException{
	Parent admin = FXMLLoader.load(getClass().getResource("Patients.fxml"));
	Scene scene = new Scene(admin);
	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	
	window.setScene(scene);
	window.show();
	}
	
	
	public void btnNewClicked(ActionEvent event) throws IOException{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("newOrders.fxml"));
        Parent userInfo = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(userInfo));  
        stage.setTitle("New Orders");
        stage.show();
		
	}

}
