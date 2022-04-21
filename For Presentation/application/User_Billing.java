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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class User_Billing {
	
	@FXML
	private Button btnLogout;
	@FXML
	private Button btnHome;
	@FXML
	private Button btnUserInfo;
	@FXML
	private Button btnNext;
	@FXML
	private TableView<User_BillingDB> table1;
	@FXML
	private TableColumn<User_BillingDB, String> colOrder;
	@FXML
	private TableColumn<User_BillingDB, String> colPrice;
	@FXML
	private TableColumn<User_BillingDB, String> colInsurance;
	@FXML
	private TableColumn<User_BillingDB, String> colTaxes;
	@FXML
	private TableColumn<User_BillingDB, String> colBalance;
	@FXML
	private TableColumn<User_BillingDB, String> colDate;
	
	private ObservableList<User_BillingDB> data;

	
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
	
	public void btnRefreshClicked(ActionEvent event) throws IOException
	{
		sql_conn sql = new sql_conn();

		try (Connection conn = (Connection) sql.establishConn()) {
			data = FXCollections.observableArrayList();
			Statement stmnt = conn.createStatement();
			ResultSet rs = stmnt.executeQuery(
					"select orders.order_id, modalities.price, patients.insurance, appointments.date_time FROM orders, modalities, patients, appointments WHERE orders.patient=patients.patient_id AND appointments.order_id = orders.order_id AND modalities.modality_id = orders.modality");
			
			while (rs.next()) {
				String order = rs.getString(1);
				String price = rs.getString(2);
				float pricef = Float.parseFloat(price);
				String insurer = rs.getString(3);
				String date = rs.getString(4);
				String tax = String.valueOf((pricef*.07));
				ResultSet rs2 = stmnt.executeQuery("SELECT coverage FROM insurance WHERE insurer=\""+insurer+"\"");
				rs2.next();
				float cov = rs2.getFloat(1);
				String balance = String.valueOf(pricef - (pricef*(cov/100)));
				data.add(new User_BillingDB(order, price, insurer, tax, balance, date));

			}
		} catch (SQLException ex) {
			System.err.println("Error" + ex);
		}

		// Set cell value factory to tableview
		colOrder.setCellValueFactory(new PropertyValueFactory<>("order"));
		colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
		colInsurance.setCellValueFactory(new PropertyValueFactory<>("insurer"));
		colTaxes.setCellValueFactory(new PropertyValueFactory<>("taxes"));
		colBalance.setCellValueFactory(new PropertyValueFactory<>("balance"));
		colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
		

		table1.setItems(null);

		table1.setItems(data);
	}

}
