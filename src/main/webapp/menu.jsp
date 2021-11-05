<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, entities.*, dao.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menú principal</title>
</head>
<body>
	<!-- Header -->
	<%@ include file="header.jsp"%>
	<!-- Hipervinculos a otras páginas -->
	<div>
		<p><a href="./view/rol/alta_nuevo_rol.jsp">Alta de nuevo Rol</a></p>
		<p><a href="<%=request.getContextPath()%>/ListadoRoles">Listado de usuarios</a></p>
		<p><a href="./view/categoria/addCategorias.jsp">Alta de nueva Categoría</a></p>
		<p><a href="<%=request.getContextPath()%>/ListadoCategorias">Listado de categorias</a></p>
	</div>
</body>
</html>