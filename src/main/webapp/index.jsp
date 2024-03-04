<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="Banner.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Geographic Area Classification List</title>
</head>
<body>
<h3>Geographic Area Classification List</h3>
<ol>
	<li><a href="geoClassificationServlet?level=0">The Country of Canada</a></li>
	<li><a href="geoClassificationServlet?level=1">Provinces and Territories</a></li>
	<li><a href="geoClassificationServlet?level=2">Census metropolitan areas (CMA) and census agglomerations (CA)</a></li>
	<li><a href="geoClassificationServlet?level=3">One CMA and three CAs are divided between adjacent provinces</a></li>
</ol>
</body>
</html>
<jsp:include page="footer.jsp" />