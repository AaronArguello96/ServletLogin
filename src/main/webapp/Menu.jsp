<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, entities.*, dao.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Men� principal</title>
</head>
<body>
	<!-- Header -->
	<%@ include file="Header.jsp"%>
	<!-- Hipervinculos a otras p�ginas -->
	<div>
		<p><a href="Alta_nuevo_rol.jsp">Alta de nuevo Rol</a></p>
		<p><a href="Listado_roles.jsp">Listado de usuarios</a></p>
		<p><a href="AddCategorias.jsp">Alta de nueva Categor�a</a></p>
		<p><a href="Listado_categorias.jsp">Listado de categorias</a></p>
	</div>
</body>
</html>