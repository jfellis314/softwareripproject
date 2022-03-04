import java.util.Scanner;

import java.sql.*;

public class LoginPage extends RIS_Funcs {

	public enum AUTHS {
		USER, REFERRALDOCTOR
	};

	public static void main(String[] args) {
		Connection conn;

		Scanner in = new Scanner(System.in);

		try {
			conn = (Connection) establishConn();
			System.out.println("Connected");
			System.out.println(loginPage(conn));
			conn.close();
		} catch (Exception e) {
			System.out.println("Error encountered - " + e);
		}

	}

	public static String loginPage(Connection conn) throws SQLException {
		String username;
		String password;
		Scanner in = new Scanner(System.in);

		System.out.println("Enter username: ");
		username = in.nextLine();
		System.out.println("Enter password: ");
		password = in.nextLine();

		Statement stmnt = conn.createStatement();
		String statement = "SELECT password FROM users WHERE username = \"" + username + "\"";
		ResultSet rs = stmnt.executeQuery(statement);
		rs.next();
		if (rs.getString(1) == password) {
			return "Correct Password!";
		}
		return "Wrong Password!" + rs.getString(1);

	}

}
