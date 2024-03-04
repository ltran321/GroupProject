<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="Banner.jsp" />
<%@ page import="bean.GeographicArea" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.DBUtil" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Geographic Area IDs</title>
</head>
<body>
<h1>Geographic Area IDs with Names</h1>
    <ol>
        <% List<GeographicArea> areaList = DBUtil.getGeographicAreaIDsWithNames();
           for (GeographicArea area : areaList) { %>
            <li><a href="geoAreaDetailsServlet?areaID=<%= area.getAreaID() %>"><%= area.getAreaID() %> - <%= area.getName() %></a></li>
        <% } %>
    </ol>
</body>
</html>
<jsp:include page="footer.jsp" />