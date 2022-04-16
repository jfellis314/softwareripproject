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


public class User_All {
	
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
	private TableView<User_AllDB> tableAll;
	@FXML
	private TableColumn<User_AllDB, Integer> colOrder_id;
	@FXML
	private TableColumn<User_AllDB, String> colIssuer;
	@FXML
	private TableColumn<User_AllDB, String> colDate_time;
	@FXML
	private TableColumn<User_AllDB, String> colImage;
	@FXML
	private TableColumn<User_AllDB, String> colNotes;

	
	private ObservableList<User_AllDB>data;
	private sql_conn sc;
	
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		sc = new sql_conn();
		
	}
	
	@FXML
	private void btnRefreshClicked(ActionEvent event) throws SQLException {
		
		sql_conn sql = new sql_conn();
			
		try(Connection conn = (Connection) sql.establishConn()){
			data = FXCollections.observableArrayList();
			Statement user_all = conn.createStatement();
			ResultSet rs = user_all.executeQuery("select order_id, issuer, date_time, image_url, notes from appointments, imaging_info;");
			while(rs.next()) {
				data.add(new User_AllDB(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
			}
		} catch (SQLException ex) {
			System.err.println("Error"+ex);
		}
		
		//Set cell value factory to tableview 
		colOrder_id.setCellValueFactory(new PropertyValueFactory<>("order_id"));
		colIssuer.setCellValueFactory(new PropertyValueFactory<>("issuer"));
		colDate_time.setCellValueFactory(new PropertyValueFactory<>("date_time"));
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
	
	
	public void btnNextClicked(ActionEvent event) throws IOException{
		Parent systemUser = FXMLLoader.load(getClass().getResource("User_Billing.fxml"));
		Scene scene = new Scene(systemUser);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(scene);
		window.show();
		
	}

}
