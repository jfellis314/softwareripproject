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
	private TableView<User_AllDB> table1;
	@FXML
	private TableColumn<User_AllDB, String> colID;
	@FXML
	private TableColumn<User_AllDB, String> colMD;
	@FXML
	private TableColumn<User_AllDB, String> colDate;
	@FXML
	private TableColumn<User_AllDB, String> colImage;
	@FXML
	private TableColumn<User_AllDB, String> colNotes;

	private ObservableList<User_AllDB> data;

	public void btnLogoutClicked(ActionEvent event) throws IOException {
		Parent login = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
		Scene scene = new Scene(login);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(scene);
		window.show();
	}

	public void btnHomeClicked(ActionEvent event) throws IOException {
		Parent systemUser = FXMLLoader.load(getClass().getResource("User_All.fxml"));
		Scene scene = new Scene(systemUser);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(scene);
		window.show();
	}

	public void btnUserInfoClicked(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UserInfo.fxml"));
		Parent userInfo = (Parent) fxmlLoader.load();
		Stage stage = new Stage();
		stage.setScene(new Scene(userInfo));
		stage.setTitle("User Info");
		stage.show();

	}

	public void btnNextClicked(ActionEvent event) throws IOException {
		Parent systemUser = FXMLLoader.load(getClass().getResource("User_Billing.fxml"));
		Scene scene = new Scene(systemUser);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

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
					"select orders.order_id, referral_md, appointments.date_time, upload_path, diagnostic FROM orders, appointments, file_uploads, diagnostic_reports WHERE orders.order_id = appointments.order_id AND orders.order_id = file_uploads.order_id AND orders.order_id = diagnostic_reports.order_id");
			
			while (rs.next()) {
			
				data.add(new User_AllDB(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));

			}
		} catch (SQLException ex) {
			System.err.println("Error" + ex);
		}
		
		// Set cell value factory to tableview
				colID.setCellValueFactory(new PropertyValueFactory<>("OID"));
				colMD.setCellValueFactory(new PropertyValueFactory<>("MD"));
				colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
				colImage.setCellValueFactory(new PropertyValueFactory<>("image"));
				colNotes.setCellValueFactory(new PropertyValueFactory<>("result"));
				

				table1.setItems(null);

				table1.setItems(data);

}
}
