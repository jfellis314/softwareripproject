import java.sql.*;
/*
 * General methods for getting and setting info in the database - will (probably) change later to return objects for easier access to data
 */
public class RIS_Funcs extends sql_conn {

	// Method for one-way encryption of password to compare to already encrypted
	// password in database:
	public String encrypt(String pass) {
		// TODO - Password encryption code
		return "";
	}

	// User info component unique to every user - uses ID - returns username, display
	// name, email, and allows for a password change:
	public void selfInfo(int ID) {
		String username;
		String display_name;
		String email;
		try (Connection conn = (Connection) establishConn()) {

			Statement stmnt = conn.createStatement();
			ResultSet rs = stmnt.executeQuery("SELECT * FROM users WHERE user_id = \"" + ID + "\"");
			while (rs.next()) {
				username = rs.getString(4);
				display_name = rs.getString(3);
				email = rs.getString(2);
			}
		} catch (Exception e) {
		}
		;

	}

	// Method for admin page to display all system users
	public void displayUsers() throws SQLException {
		Connection conn = (Connection) establishConn();
		String statement = "SELECT * FROM users";
		Statement stmnt = conn.createStatement();
		ResultSet rs = stmnt.executeQuery(statement);
		while (rs.next()) {
			System.out.println(rs.getInt(1) + rs.getString(2) + rs.getString(3) + rs.getString(4) + rs.getString(5)
					+ rs.getInt(6));
		}
		conn.close();
	}

	public void getOrders() {
		int OID;
		int patient;
		int refmd;
		int modality;
		String notes;
		int status;

		try (Connection conn = (Connection) establishConn()) {
			Statement stmnt = conn.createStatement();
			ResultSet rs = stmnt.executeQuery("SELECT * FROM orders");
			while (rs.next()) {
				OID = rs.getInt(1);
				patient = rs.getInt(2);
				refmd = rs.getInt(3);
				modality = rs.getInt(4);
				notes = rs.getString(5);
				status = rs.getInt(6);
			}
		} catch (Exception e) {
		}
	}

	public void getAppointments() {
		int AID;
		int patient;
		int OID;
		Date date;
		int tech;
		int radio;

		try (Connection conn = (Connection) establishConn()) {
			Statement stmnt = conn.createStatement();
			ResultSet rs = stmnt.executeQuery("SELECT * FROM appointments");
			while (rs.next()) {
				AID = rs.getInt(1);
				patient = rs.getInt(2);
				OID = rs.getInt(3);
				// Normalize Date !
				date = rs.getDate(5);
				tech = rs.getInt(7);
				radio = rs.getInt(6);
			}
		} catch (Exception e) {
		}
	}

	//Get patient info
	public void getPatients() {
		int PID;
		Date DOB;
		String last_name;
		String first_name;

		try (Connection conn = (Connection) establishConn()) {
			Statement stmnt = conn.createStatement();
			ResultSet rs = stmnt.executeQuery("SELECT * FROM patients");
			while (rs.next()) {
				PID = rs.getInt(1);
				DOB = rs.getDate(4);
				last_name = rs.getString(3);
				first_name = rs.getString(2);
			}
		} catch (Exception e) {
		}
	}

	public boolean changePassword(int ID, String newPass) {
		try(Connection conn = (Connection) establishConn())
		{
			Statement stmnt = conn.createStatement();
			String new_password = encrypt(newPass);
			stmnt.executeUpdate("UPDATE users SET password = \"" + new_password + "\" WHERE user_id = " + ID);
			return true;
		}catch(Exception e) {return false;}
	}
	
	public void getCheckedAppointments() {
		int modality;
		int price;
		int patient;
		Date date;
		int tech;
		int radio;

		try (Connection conn = (Connection) establishConn()) {
			Statement stmnt = conn.createStatement();
			ResultSet rs = stmnt.executeQuery("SELECT * FROM appointments WHERE checked_in = 1");
			while (rs.next()) {
				modality = rs.getInt(4);
				patient = rs.getInt(2);
				// Normalize Date !
				date = rs.getDate(5);
				tech = rs.getInt(7);
				radio = rs.getInt(6);
			}
		} catch (Exception e) {
		}
	}

}
