import java.sql.*;

public class sql_conn {

	public static Object establishConn() {
		String url = "jdbc:mysql://localhost:3306/db_ris";
		String username = "root";
		String password = "toor";

		try {
			Connection connection = DriverManager.getConnection(url, username, password);
			return connection;
		} catch (Exception e) {

		}
		return new String("Error connecting!");
	}
}
