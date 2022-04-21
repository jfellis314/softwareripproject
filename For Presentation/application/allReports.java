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

public class allReports implements Initializable{
	@FXML
	private Button btnRefresh;
	@FXML
	private TableView<allReportsDB> tableAllReports;
	@FXML
	private TableColumn<allReportsDB, String> colPatient;
	@FXML
	private TableColumn<allReportsDB, String> colModality;
	@FXML
	private TableColumn<allReportsDB, String> colTech;
	@FXML
	private TableColumn<allReportsDB, String> colRadio;
	@FXML
	private TableColumn<allReportsDB, String> colNotes;

	
	private ObservableList<allReportsDB>data;
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
			ResultSet rs = allReferral.executeQuery("select patient, modality, technician, radiologist, notes from appointments");
			while(rs.next()) {
				data.add(new allReportsDB(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
			}
		} catch (SQLException ex) {
			System.err.println("Error"+ex);
		}
		
		//Set cell value factory to tableview 
		colPatient.setCellValueFactory(new PropertyValueFactory<>("patient"));
		colModality.setCellValueFactory(new PropertyValueFactory<>("modality"));
		colTech.setCellValueFactory(new PropertyValueFactory<>("technician"));
		colRadio.setCellValueFactory(new PropertyValueFactory<>("radiologist"));
		colNotes.setCellValueFactory(new PropertyValueFactory<>("notes"));
		
		tableAllReports.setItems(null);
		tableAllReports.setItems(data);
	}

	


}
