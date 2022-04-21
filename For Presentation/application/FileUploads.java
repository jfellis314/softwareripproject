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



public class FileUploads {
	
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
	private TableView<FileUploadsDB> table1; 
	@FXML
	private TableColumn<FileUploadsDB, String> colFID;
	@FXML
	private TableColumn<FileUploadsDB, String> colName;
	@FXML
	private TableColumn<FileUploadsDB, String> colType;
	@FXML
	private TableColumn<FileUploadsDB, String> colOrder;
	
	private ObservableList<FileUploadsDB> data;
	

	
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
	Parent admin = FXMLLoader.load(getClass().getResource("DiagnosticReports.fxml"));
	Scene scene = new Scene(admin);
	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	
	window.setScene(scene);
	window.show();
	}
	
	
	public void btnPriorClicked(ActionEvent event) throws IOException{
	Parent admin = FXMLLoader.load(getClass().getResource("Appointments.fxml"));
	Scene scene = new Scene(admin);
	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	
	window.setScene(scene);
	window.show();
	}
	
	
	public void btnNewClicked(ActionEvent event) throws IOException{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("newFileUploads.fxml"));
        Parent newAppointments = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(newAppointments)); 
        stage.setTitle("New File Uploads");
        stage.show();
		
	}
	
	public void btnRefreshClicked(ActionEvent event) throws IOException
	{
		sql_conn sql = new sql_conn();

		try (Connection conn = (Connection) sql.establishConn()) {
			data = FXCollections.observableArrayList();
			Statement stmnt = conn.createStatement();
			ResultSet rs = stmnt.executeQuery("select file_upload_id, file_name, file_type, order_id from file_uploads");
			while (rs.next()) {

				data.add(new FileUploadsDB(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));

			}
		} catch (SQLException ex) {
			System.err.println("Error" + ex);
		}

		// Set cell value factory to tableview
		colFID.setCellValueFactory(new PropertyValueFactory<>("ID"));
		colName.setCellValueFactory(new PropertyValueFactory<>("name"));
		colType.setCellValueFactory(new PropertyValueFactory<>("type"));
		colOrder.setCellValueFactory(new PropertyValueFactory<>("order"));
		

		table1.setItems(null);

		table1.setItems(data);
	}

}
