<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="Banner.jsp" />
<%@ page import="bean.AgeList"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%
List<AgeList> ageList = (List<AgeList>) request.getAttribute("ageList");
%>
<title>Age List</title>
</head>
<body>
	<h3>Age List</h3>
	<div style="text-align: center; margin: 0 auto;">
		<table>
			<thead>
				<tr>
					<th>Year</th>
					<th>Male Population</th>
					<th>Female Population</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (AgeList age : ageList) {
				%>
				<tr>
					<td><%=age.getYear()%></td>
					<td><%=age.getMalePopulation()%></td>
					<td><%=age.getFemalePopulation()%></td>
				</tr>
				<%
				}
				%>

			</tbody>
		</table>
	</div>
</body>
</html>
<jsp:include page="footer.jsp" />