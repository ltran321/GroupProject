package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/canadacensusdb";
	private final static String USER = "root";
	private final static String PASS = "root";
	
	//checks if the db connected
	public static boolean isDBConnected(String username, String password) {
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, username, password);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}
    }

	
}
