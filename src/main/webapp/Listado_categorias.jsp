<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*, entities.*, dao.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- Header -->
	<%@ include file="Header.jsp"%>
	<%!List<Categorias> listadoCategorias = CategoriaDAO.getCategorias(); %>
	
	<%
		pageContext.setAttribute("listadoCategorias", listadoCategorias);
	%>
	
	<h2>Listado de categorias:</h2>
		<form action="" method="post">
			<table border="1">
				<tr>
					<th>ID</th>
					<th>Nombre</th>
					<th>Descripción</th>
				</tr>
				<c:forEach items="${pageScope.listadoCategorias}" var="categoria">
					<tr>
						<td><c:out value = "${categoria.id}"/></td>
						<td><c:out value = "${categoria.nombre}"/></td>
						<td><c:out value = "${categoria.descripcion}"/></td>
					</tr>
				</c:forEach>
			</table>
		</form>
</body>
</html>