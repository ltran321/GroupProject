package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import bean.AgeList;
import dao.DBUtil;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ageListServlet")
public class AgeListServlet  extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		List<AgeList> ageList = new ArrayList<>();
		
		try {
			
			ageList = DBUtil.getAgeList();
			RequestDispatcher rd;
			req.setAttribute("ageList", ageList);
			rd = req.getRequestDispatcher("ageList.jsp");
			rd.forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
