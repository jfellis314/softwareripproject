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


public class User_Billing {
	
	@FXML
	private Button btnLogout;
	@FXML
	private Button btnHome;
	@FXML
	private Button btnUserInfo;
	@FXML
	private Button btnPay;
	@FXML
	private Button btnPrior;
	@FXML
	private Button btnRefresh;
	@FXML
	private TableView<User_BillingDB> tableBilling;
	@FXML
	private TableColumn<User_BillingDB, Integer> colOrder_id;
	@FXML
	private TableColumn<User_BillingDB, Float> colPrice;
	@FXML
	private TableColumn<User_BillingDB, Float> colInsurance;
	@FXML
	private TableColumn<User_BillingDB, Float> colTax;
	@FXML
	private TableColumn<User_BillingDB, Float> colBalance;
	@FXML
	private TableColumn<User_BillingDB, String> colDue;

	
	private ObservableList<User_BillingDB>data;
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
			ResultSet rs = billing.executeQuery("select order_id, original_price, insurance, taxes, balance, due_date from billing, orders;");
			while(rs.next()) {
				data.add(new User_BillingDB(rs.getInt(1), rs.getFloat(2), rs.getFloat(3), rs.getFloat(4), rs.getFloat(5), rs.getString(6)));
			}
		} catch (SQLException ex) {
			System.err.println("Error"+ex);
		}
		
		//Set cell value factory to tableview 
		colOrder_id.setCellValueFactory(new PropertyValueFactory<>("order_id"));
		colPrice.setCellValueFactory(new PropertyValueFactory<>("original_price"));
		colInsurance.setCellValueFactory(new PropertyValueFactory<>("insurance"));
		colTax.setCellValueFactory(new PropertyValueFactory<>("taxes"));
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
		Parent systemUser = FXMLLoader.load(getClass().getResource("User_All.fxml"));
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
		Parent systemUser = FXMLLoader.load(getClass().getResource("User_All.fxml"));
		Scene scene = new Scene(systemUser);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(scene);
		window.show();
		
	}
	
	
	public void btnPayClicked(ActionEvent event) throws IOException{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("newPayment.fxml"));
        Parent newAppointments = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(newAppointments)); 
        stage.setTitle("New Payment");
        stage.show();
		
	}

}
