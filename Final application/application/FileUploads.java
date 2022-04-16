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
	private TableView<FileUploadsDB> tableFileUpload;
	@FXML
	private TableColumn<FileUploadsDB, Integer> colFileUpload;
	@FXML
	private TableColumn<FileUploadsDB, String> colFileName;
	@FXML
	private TableColumn<FileUploadsDB, String> colFileType;
	@FXML
	private TableColumn<FileUploadsDB, Integer> colOrder;
	
	
	private ObservableList<FileUploadsDB>data;
	private sql_conn sc;
	
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		sc = new sql_conn();
		
	}
	
	@FXML
	private void btnRefreshClicked(ActionEvent event) throws SQLException {
		
		sql_conn sql = new sql_conn();
			
		try(Connection conn = (Connection) sql.establishConn()){
			data = FXCollections.observableArrayList();
			Statement fileuploads = conn.createStatement();
			ResultSet rs = fileuploads.executeQuery("select file_upload_id, file_name, file_type, order_id from file_uploads;");
			while(rs.next()) {
				data.add(new FileUploadsDB(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
			}
		} catch (SQLException ex) {
			System.err.println("Error"+ex);
		}
		
		//Set cell value factory to tableview 
		colFileUpload.setCellValueFactory(new PropertyValueFactory<>("file_upload_id"));
		colFileName.setCellValueFactory(new PropertyValueFactory<>("file_name"));
		colFileType.setCellValueFactory(new PropertyValueFactory<>("file_type"));
		colOrder.setCellValueFactory(new PropertyValueFactory<>("order_id"));
		
		tableFileUpload.setItems(null);
		tableFileUpload.setItems(data);
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

}
