package web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.GeographicAreaDetails;
import bean.GeographicClassification;
import dao.DBUtil;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/geoAreaDetailsServlet")
public class GeoAreaDetailsServlet extends HttpServlet {

	public GeoAreaDetailsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		String areaID = req.getParameter("areaID");

		if (areaID != null && !areaID.isEmpty()){
			try {
	            GeographicAreaDetails area = DBUtil.getGeographicAreaDetails(areaID);
	            req.setAttribute("areaDetails", area); 
                req.getRequestDispatcher("indivGeoAreaDetails.jsp").forward(req, resp);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		}
        
	}
}
