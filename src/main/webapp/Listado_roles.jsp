<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, entities.*, dao.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado de roles</title>
</head>
<body>
	<!-- Header -->
	<%@ include file="Header.jsp"%>
	<%!List<Roles> listadoRoles = RolDAO.getRoles(); %>
	
	<%
		pageContext.setAttribute("listadoRoles", listadoRoles);
	%>
	
	<h2>Listado de roles:</h2>
		<form action="" method="post">
			<table>
				<tr>
					<th>ID</th>
					<th>Rol</th>
				</tr>
				<c:forEach items="${pageScope.listadoRoles}" var="rol">
					<tr>
						<td><c:out value = "${rol.id}"/></td>
						<td><c:out value = "${rol.rol}"/></td>
					</tr>
				</c:forEach>
			</table>
		</form>
</body>
</html>