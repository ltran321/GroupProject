package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.GeographicAreaDetails;
import bean.AgeList;
import bean.GeographicClassification;

public class DBUtil {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/canadacensusdb";
	private final static String USER = "root";
	private final static String PASS = "Secret55!";
	
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
	
	// get a list of geographic area IDs
	public static List<Integer> getGeographicAreaIDs() throws SQLException {
        List<Integer> areaIDs = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
             PreparedStatement preparedStatement = conn.prepareStatement("SELECT geographicAreaID FROM geographicarea");
             ResultSet rs = preparedStatement.executeQuery()) {
            while (rs.next()) {
                areaIDs.add(rs.getInt("geographicAreaID"));
            }
        }
        return areaIDs;
    }
	
	public static GeographicAreaDetails getGeographicAreaDetails(String areaID) throws SQLException {
		String query = "SELECT ga.name, ga.code, ga.level, SUM(age.combined) AS total_population " +
                		"FROM geographicarea ga " +
                		"JOIN age ON ga.geographicAreaID = age.geographicArea " +
                		"JOIN censusyear cy ON age.censusYear = cy.censusYearID " +
                		"WHERE ga.geographicAreaID = ? AND cy.censusYear = 2021 " +
                		"GROUP BY ga.name, ga.code, ga.level";
	    try (Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
	         PreparedStatement preparedStatement = conn.prepareStatement(query)) {
	    	preparedStatement.setString(1, areaID);
	        ResultSet rs = preparedStatement.executeQuery();
	        if (rs.next()) {
	            String name = rs.getString("name");
	            int code = rs.getInt("code");
	            int level = rs.getInt("level");
	            int totalPopulation = rs.getInt("total_population");
	            GeographicAreaDetails area = new GeographicAreaDetails(name, code, level, totalPopulation);
	            return area;
	        } else {
	            return null;
	        }
	    }
	}

	public static List<AgeList> getAgeList() throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		List<AgeList> ageList = new ArrayList<>();
		
		String query = "SELECT "
				+ "    CASE WHEN C.censusYear = 2016 THEN '2016' "
				+ "         WHEN C.censusYear = 2021 THEN '2021' "
				+ "    END AS Year, "
				+ "    SUM(A.male) AS MalePopulation, "
				+ "    SUM(A.female) AS FemalePopulation "
				+ "FROM "
				+ "    AGE A "
				+ "JOIN "
				+ "    GEOGRAPHICAREA G ON A.geographicArea = G.geographicAreaID "
				+ "JOIN "
				+ "    CENSUSYEAR C ON A.censusYear = C.censusYearID "
				+ "WHERE "
				+ "    C.censusYear IN (2016, 2021) "
				+ "GROUP BY "
				+ "    C.censusYear;";
		
		try(Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
				PreparedStatement ps = conn.prepareStatement(query);) {
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int year = rs.getInt("Year");
				int malePop = rs.getInt("MalePopulation");
				int femalePop = rs.getInt("FemalePopulation");
				
				AgeList age = new AgeList(year,malePop,femalePop);
				ageList.add(age);
			}
			
		}  catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ageList;
	}
}
