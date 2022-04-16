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

public class Doc_Info {
	
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
	private TableView<Doc_InfoDB> tableInfo;
	@FXML
	private TableColumn<Doc_InfoDB, Integer> colOrder;
	@FXML
	private TableColumn<Doc_InfoDB, String> colFirstName;
	@FXML
	private TableColumn<Doc_InfoDB, String> colLastName;
	@FXML
	private TableColumn<Doc_InfoDB, String> colCondition;
	@FXML
	private TableColumn<Doc_InfoDB, String> colExams;
	@FXML
	private TableColumn<Doc_InfoDB, String> colStatus;

	
	private ObservableList<Doc_InfoDB>data;
	private sql_conn sc;
	
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		sc = new sql_conn();
		
	}
	
	@FXML
	private void btnRefreshClicked(ActionEvent event) throws SQLException {
		
		sql_conn sql = new sql_conn();
			
		try(Connection conn = (Connection) sql.establishConn()){
			data = FXCollections.observableArrayList();
			Statement info = conn.createStatement();
			ResultSet rs = info.executeQuery("select order_id, first_name, last_name, patient_condition, prior_exam, order_name from patients, orders, order_status;");
			while(rs.next()) {
				data.add(new Doc_InfoDB(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
			}
		} catch (SQLException ex) {
			System.err.println("Error"+ex);
		}
		
		//Set cell value factory to tableview 
		colOrder.setCellValueFactory(new PropertyValueFactory<>("order_id"));
		colFirstName.setCellValueFactory(new PropertyValueFactory<>("first_name"));
		colLastName.setCellValueFactory(new PropertyValueFactory<>("last_name"));
		colCondition.setCellValueFactory(new PropertyValueFactory<>("patient_condition"));
		colExams.setCellValueFactory(new PropertyValueFactory<>("prior_exam"));
		colStatus.setCellValueFactory(new PropertyValueFactory<>("order_name"));
		
		tableInfo.setItems(null);
		tableInfo.setItems(data);
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
	
	
	public void btnNextClicked(ActionEvent event) throws IOException{
	Parent admin = FXMLLoader.load(getClass().getResource("Doc_Schedule.fxml"));
	Scene scene = new Scene(admin);
	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	
	window.setScene(scene);
	window.show();
	}
	
	
	

}

