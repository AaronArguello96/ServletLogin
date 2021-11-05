<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, entities.*, dao.*"%>
<%@ page import="servlets.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado de categorias</title>
</head>
<body>
	<!-- Header -->
	<%@ include file="../../header.jsp"%>
	<form  method="post" action="ListadoCategorias">
	<h2>Listado de categorias:</h2>
		
		<table border="1">
			<tr>
				<th>ID</th>
				<th>Nombre</th>
				<th>Descripción</th>
			</tr>
			<tr>
<%
	ArrayList<Categorias> listado_categorias = (ArrayList<Categorias>) request.getAttribute("listadoCategorias");
	
	if(listado_categorias!=null) {
		for(int i=0; i<listado_categorias.size(); i++) {
			Categorias c = listado_categorias.get(i);
			Integer id = c.getId();
			String nombre = c.getNombre();
			String descripcion = c.getDescripcion();
%>
			
				<td><%= id %></td>
				<td><%= nombre %></td>
				<td><%= descripcion %></td>
			</tr>
		</table>
<%	
	}
	}else{
		System.out.println("La lista esta vacia");
	}
%>
	</form>

</body>
</html>