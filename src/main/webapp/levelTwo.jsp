<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="bean.GeographicClassification" %>
<%@ page import="java.util.List" %>
<jsp:include page="Banner.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Census metropolitan areas (CMA) and census agglomerations (CA)</title>
</head>
<body>
<%
    List<GeographicClassification> geoClassList = (List<GeographicClassification>) request.getAttribute("geoClassList");
%>
<h3>Level 2</h3>
<% for (GeographicClassification geoClass : geoClassList) { %>
    <p><%= geoClass.getName() %></p>
<% } %>
</body>
</html>
<jsp:include page="footer.jsp" />