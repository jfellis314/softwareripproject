package application;

import java.sql.*;

public class sql_conn {

    public static void main(String[] args)
    {
        System.out.println(establishConn());
    }
	public static Object establishConn() {
		String url = "jdbc:mysql://localhost:3306/db_ris";
		String username = "root";
		String password = "Rd24194!";

		try {
			Connection connection = DriverManager.getConnection(url, username, password);
			System.out.println("Connection Made!");
			return connection;
		} catch (Exception e) {

		}
		return new String("Error connecting!");
	}
public void insertAppointmentData() throws SQLException{
	int rowCount = 0;

	 try(Connection conn = (Connection) establishConn())
        {
            Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            Statement stmnt2 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs3 = stmnt.executeQuery("SELECT * FROM appointments");
            if(rs3.last())
            {
                rowCount = rs3.getRow();
            }
            System.out.println(rowCount);
            Object[][] data = new Object[rowCount][14];
            ResultSet rs = stmnt.executeQuery("SELECT * FROM appointments");
            rs.next();
            for(int i = 0; i < rowCount; i++)
            {
                int appointmentId = rs.getInt(1);
                int patient = rs.getInt(2);
                int orderId = rs.getInt(3);
                Date date = rs.getDate(5);
                int technican = rs.getInt(7);
                int radiologist = rs.getInt(6);
                String phone = rs.getString(8);
                String email = rs.getString(9);
                String enrollee_id = rs.getString(10);
                String issuer = rs.getString(11);
                String notes = rs.getString(12);
                float price = rs.getFloat(13);
                int priority = rs.getInt(14);
                String modality = rs.getString(15);
                data[i][0] = appointmentId;
                data[i][1] = patient;
                data[i][2] = orderId;
                data[i][3] = date;
                data[i][4] = technican;
                data[i][5] = radiologist;
                data[i][6] = phone;
                data[i][7] = email;
                data[i][8] = enrollee_id;
                data[i][9] = issuer;
                data[i][10] = notes;
                data[i][11] = price;
                data[i][12] = priority;
                data[i][13] = modality;              
                rs.next();
            }
        }
}
	
public void insertDiagnosticReportData() throws SQLException{
	int rowCount = 0;

	try(Connection conn = (Connection) establishConn())
		{
			Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			Statement stmnt2 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs3 = stmnt.executeQuery("SELECT * FROM diagnostic_reports");
			if(rs3.last())
			{
				rowCount = rs3.getRow();
			}
			System.out.println(rowCount);
			Object[][] data = new Object[rowCount][4];
			ResultSet rs = stmnt.executeQuery("SELECT * FROM diagnostic_reports");
			rs.next();
			for(int i = 0; i < rowCount; i++)
			{
				int diagnostic_report_id = rs.getInt(1);
				int order_id = rs.getInt(2);
				int radiologist = rs.getInt(4);
				String diagnostic = rs.getString(5);
				data[i][0] = diagnostic_report_id;
				data[i][1] = order_id;
				data[i][2] =radiologist;
				data[i][3] = diagnostic;
				rs.next();
			}
		}
	}
public void insertOrders() throws SQLException{
	int rowCount = 0;

	try(Connection conn = (Connection) establishConn())
		{
			Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			Statement stmnt2 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs3 = stmnt.executeQuery("SELECT * FROM orders");
			if(rs3.last())
			{
				rowCount = rs3.getRow();
			}
			System.out.println(rowCount);
			Object[][] data = new Object[rowCount][6];
			ResultSet rs = stmnt.executeQuery("SELECT * FROM orders");
			rs.next();
			for(int i = 0; i < rowCount; i++)
			{
				int orderID = rs.getInt(1);
				int patient = rs.getInt(2);
				int referral_md = rs.getInt(3);
				int modality = rs.getInt(4);
				String notes = rs.getString(6);
				int report = rs.getInt(7);
				
				data[i][0] = orderID;
				data[i][1] = patient;
				data[i][2] = referral_md;
				data[i][3] = modality;
				data[i][4] = notes;
				data[i][5] = report;
				
				rs.next();
			}
		}
			
}
public void insertpatientAlerts() throws SQLException{
	int rowCount = 0;

	try(Connection conn = (Connection) establishConn())
		{
			Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			Statement stmnt2 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs3 = stmnt.executeQuery("SELECT * FROM patients_alerts");
			if(rs3.last())
			{
				rowCount = rs3.getRow();
			}
			System.out.println(rowCount);
			Object[][] data = new Object[rowCount][2];
			ResultSet rs = stmnt.executeQuery("SELECT * FROM patients_alerts");
			rs.next();
			for(int i = 0; i < rowCount; i++)
			{
				int alertId = rs.getInt(2);
				int alert = rs.getInt(4);
				data[i][0] = alertId;
				data[i][1] = alert;
				rs.next();
			}
		}
			
}
public void insertPatient(){
	int rowCount = 0;
	
	try(Connection conn = (Connection) establishConn())
		{
			Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			Statement stmnt2 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs3 = stmnt.executeQuery("SELECT * FROM patients");
			if(rs3.last())
			{
				rowCount = rs3.getRow();
			}
			System.out.println(rowCount);
			Object[][] data = new Object[rowCount][5];
			ResultSet rs = stmnt.executeQuery("SELECT * FROM patients");
			rs.next();
			for(int i = 0; i < rowCount; i++)
			{
				int patientId = rs.getInt(1);
				Date dob = rs.getDate(4);
				String last = rs.getString(3);
				String first = rs.getString(2);
				data[i][0] = patientId;
				data[i][1] = dob;
				data[i][2] = last;
				data[i][3] = first;
				rs.next();
			}
			
			
		}catch(Exception e) {e.printStackTrace();}
}
public void insertSystemUser(){
	int rowCount = 0;
	
	try(Connection conn = (Connection) establishConn())
		{
			Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			Statement stmnt2 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs3 = stmnt.executeQuery("SELECT * FROM users");
			if(rs3.last())
			{
				rowCount = rs3.getRow();
				System.out.println(rs3.getString(2));
			}
			System.out.println(rowCount);
			Object[][] data = new Object[rowCount][5];
			ResultSet rs = stmnt.executeQuery("SELECT * FROM users");
			rs.next();
			for(int i = 0; i < rowCount; i++)
			{
				int userId = rs.getInt(1);
				String email = rs.getString(2);
				String display_name = rs.getString(3);
				String userName = rs.getString(4);
				data[i][0] = userId;
				data[i][1] = userName;
				data[i][2] = display_name;
				data[i][3] = email;
				ResultSet rs2 = stmnt2.executeQuery("SELECT role_id FROM users_roles WHERE user_id=\"" + userId + "\"");
				rs2.first();
				data[i][4] = rs2.getString(1);
				rs.next();
			}
			
		
		}catch(Exception e) {e.printStackTrace();}
}


	
}
