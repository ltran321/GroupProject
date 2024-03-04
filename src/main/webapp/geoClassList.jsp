<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="bean.GeographicClassification" %>
<%@ page import="java.util.List" %>
<jsp:include page="Banner.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%
    List<GeographicClassification> geoClassList = (List<GeographicClassification>) request.getAttribute("geoClassList");
%>
<title>Level <%= geoClassList.get(0).getLevel() %></title>
</head>
<body>
<h3>Level <%= geoClassList.get(0).getLevel() %></h3>
<% for (GeographicClassification geoClass : geoClassList) { %>
    <p><%= geoClass.getName() %></p>
<% } %>
</body>
</html>
<jsp:include page="footer.jsp" />