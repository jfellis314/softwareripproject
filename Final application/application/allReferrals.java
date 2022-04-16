package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class allReferrals implements Initializable{
	@FXML
	private Button btnRefresh;
	@FXML
	private TableView<allReferralsDB> tableAllReferrals;
	@FXML
	private TableColumn<allReferralsDB, String> colIssuer;
	@FXML
	private TableColumn<allReferralsDB, String> colPatient;
	@FXML
	private TableColumn<allReferralsDB, String> colEmail;
	@FXML
	private TableColumn<allReferralsDB, String> colStatus;

	
	private ObservableList<allReferralsDB>data;
	private sql_conn sc;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		sc = new sql_conn();
		
	}
	
	@FXML
	private void btnRefreshClicked(ActionEvent event) throws SQLException {
		
		sql_conn sql = new sql_conn();
			
		try(Connection conn = (Connection) sql.establishConn()){
			data = FXCollections.observableArrayList();
			Statement allReferral = conn.createStatement();
			ResultSet rs = allReferral.executeQuery("select issuer, patient, email_address, order_name from appointments, order_status;");
			while(rs.next()) {
				data.add(new allReferralsDB(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4)));
			}
		} catch (SQLException ex) {
			System.err.println("Error"+ex);
		}
		
		//Set cell value factory to tableview 
		colIssuer.setCellValueFactory(new PropertyValueFactory<>("issuer"));
		colPatient.setCellValueFactory(new PropertyValueFactory<>("patient"));
		colEmail.setCellValueFactory(new PropertyValueFactory<>("email_address"));
		colStatus.setCellValueFactory(new PropertyValueFactory<>("order_name"));
		
		tableAllReferrals.setItems(null);
		tableAllReferrals.setItems(data);
	}

	


}
