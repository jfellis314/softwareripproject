
package databaseconn;



	import java.sql.*;
	import com.sun.rowset.CachedRowSetImpl;

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
				return connection;
			} catch (Exception e) {
				
			}
			return new String("Error connecting!");
		}
		
		
	public static ResultSet dbExecuteQuery(String queryStmt) throws SQLException, ClassNotFoundException {
		Statement stmt = null;
		ResultSet resultSet = null;
		CachedRowSetImpl crs = null;
		
		try {
			Connection conn = (Connection) establishConn();
			System.out.println("Select statement: " + queryStmt + "\n");
			stmt = conn.createStatement();
			resultSet = stmt.executeQuery(queryStmt);
			crs = new CachedRowSetImpl();
            crs.populate(resultSet);
		} catch (SQLException e){
            System.out.println("Problem occurred at executeQuery operation : " + e);
            throw e;
        } finally {
            if (resultSet != null) {
               
                resultSet.close();
            }
            if (stmt != null) {
                
                stmt.close();
            }
        }
		return crs;
	}

	public static void sqlExecuteUpdate(String sqlStmt) throws SQLException, ClassNotFoundException {
        Statement stmt = null;
        try {
            Connection conn = (Connection) establishConn();
            stmt = conn.createStatement();
            stmt.executeUpdate(sqlStmt);
        } catch (SQLException e) {
            System.out.println("Problem occurred at executeUpdate operation : " + e);
            throw e;
        }finally{
            if (resultSet != null) {
               
                resultSet.close();
            }
            if (stmt != null) {
                
                stmt.close();
            }
        }
    }
