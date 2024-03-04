<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="bean.GeographicClassification" %>
<%@ page import="java.util.List" %>
<jsp:include page="Banner.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>One CMA and three CAs divided between adjacent provinces</title>
</head>
<body>
<%
    List<GeographicClassification> geoClassList = (List<GeographicClassification>) request.getAttribute("geoClassList");
%>
<h3>Level 3</h3>
<% for (GeographicClassification geoClass : geoClassList) { %>
    <p><%= geoClass.getName() %></p>
<% } %>
</body>
</html>
<jsp:include page="footer.jsp" />