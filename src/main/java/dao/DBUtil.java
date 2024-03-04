package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import bean.GeographicClassification;

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

	//gets the geo area class list
	public static List<GeographicClassification> getGeoAreaClassList(int level) throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String query = "SELECT level, name FROM geographicarea "
				+ "WHERE level = ?; ";
		
		List<GeographicClassification> geoClass = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
				PreparedStatement ps = conn.prepareStatement(query);){
			
			ps.setInt(1, level);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
	            int geoLevel = rs.getInt("level");
	            String geoName = rs.getString("name");

	            GeographicClassification geoClassification = new GeographicClassification(geoLevel, geoName);

	            geoClass.add(geoClassification);
	        }
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return geoClass;
		
	}
}
