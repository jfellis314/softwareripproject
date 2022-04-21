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


public class Desk_Billing {
	
	@FXML
	private Button btnLogout;
	@FXML
	private Button btnHome;
	@FXML
	private Button btnUserInfo;
	@FXML
	private Button btnNext;
	@FXML
	private Button btnPrior;
	@FXML
	private Button btnRefresh;
	@FXML
	private Button btnNew;
	@FXML
	private TableView<Desk_BillingDB> tableBilling;
	@FXML
	private TableColumn<Desk_BillingDB, String> colPatient;
	@FXML
	private TableColumn<Desk_BillingDB, String> colEmail;
	@FXML
	private TableColumn<Desk_BillingDB, String> colPhone;
	@FXML
	private TableColumn<Desk_BillingDB, String> colPrice;
	@FXML
	private TableColumn<Desk_BillingDB, String> colInsurance;
	@FXML
	private TableColumn<Desk_BillingDB, String> colTaxes;
	@FXML
	private TableColumn<Desk_BillingDB, String> colBalance;
	@FXML
	private TableColumn<Desk_BillingDB, String> colDue;

	
	private ObservableList<Desk_BillingDB>data;
	private sql_conn sc;
	
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		sc = new sql_conn();
		
	}
	
	@FXML
	private void btnRefreshClicked(ActionEvent event) throws SQLException {
		
		sql_conn sql = new sql_conn();
			
		try(Connection conn = (Connection) sql.establishConn()){
			data = FXCollections.observableArrayList();
			Statement billing = conn.createStatement();
			ResultSet rs = billing.executeQuery("select user_id, email_address, phone_number, original_price, insurance, taxes, balance, due_date from appointments, billing;");
			while(rs.next()) {
				data.add(new Desk_BillingDB(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
			}
		} catch (SQLException ex) {
			System.err.println("Error"+ex);
		}
		
		//Set cell value factory to tableview 
		colPatient.setCellValueFactory(new PropertyValueFactory<>("user_id"));
		colEmail.setCellValueFactory(new PropertyValueFactory<>("email_address"));
		colPhone.setCellValueFactory(new PropertyValueFactory<>("phone_number"));
		colPrice.setCellValueFactory(new PropertyValueFactory<>("original_price"));
		colInsurance.setCellValueFactory(new PropertyValueFactory<>("insurance"));
		colTaxes.setCellValueFactory(new PropertyValueFactory<>("taxes"));
		colBalance.setCellValueFactory(new PropertyValueFactory<>("balance"));
		colDue.setCellValueFactory(new PropertyValueFactory<>("due_date"));
		
		tableBilling.setItems(null);
		tableBilling.setItems(data);
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
		Parent admin = FXMLLoader.load(getClass().getResource("Desk_NewAppoint.fxml"));
		Scene scene = new Scene(admin);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(scene);
		window.show();
		}

	
	public void btnPriorClicked(ActionEvent event) throws IOException{
		Parent admin = FXMLLoader.load(getClass().getResource("Desk_NewPatient.fxml"));
		Scene scene = new Scene(admin);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(scene);
		window.show();
		}
	
	
	public void btnNewClicked(ActionEvent event) throws IOException{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("newBilling.fxml"));
        Parent newAppointments = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(newAppointments)); 
        stage.setTitle("Update");
        stage.show();
		
	}
}
