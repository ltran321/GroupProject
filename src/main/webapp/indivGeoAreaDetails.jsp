<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="Banner.jsp" />
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Individual Geographical Area Details</title>
</head>
<body>
    <div id="areaDetails">
        <h2>Geographic Area Details</h2>
        <c:if test="${not empty areaDetails}">
            <p>Area Name: ${areaDetails.name}</p>
            <p>Area Code: ${areaDetails.code}</p>
            <p>Level: ${areaDetails.level}</p>
            <p>Total Population: ${areaDetails.population}</p>
        </c:if>
    </div>
</body>
</html>
<jsp:include page="footer.jsp" />