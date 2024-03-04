package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import bean.GeographicClassification;
import dao.DBUtil;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/geoClassificationServlet")
public class GeoClassificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String levelParam = req.getParameter("level");
		int level = Integer.parseInt(levelParam);
		List<GeographicClassification> geoClass = new ArrayList<>();

		try {
			geoClass = DBUtil.getGeoAreaClassList(level);
			RequestDispatcher rd;
			req.setAttribute("geoClassList", geoClass);

			rd = req.getRequestDispatcher("geoClassList.jsp");
			rd.forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
