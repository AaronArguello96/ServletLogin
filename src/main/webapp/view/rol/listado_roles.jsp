<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, entities.*, dao.*"%>
<%@ page import="servlets.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado de roles</title>
</head>
<body>
	<!-- Header -->
	<%@ include file="../../header.jsp"%>
	
		<h2>Listado de roles:</h2>
					
				<table border="1">
					<tr>
						<th>ID</th>
						<th>Rol</th>
					
<%
	ArrayList<Roles> listado_roles = (ArrayList<Roles>) request.getAttribute("listadoRoles");
	
	if(listado_roles!=null) {
		for(int i=0; i<listado_roles.size(); i++) {
			Roles r = listado_roles.get(i);
			Integer id = r.getId();
			String rol = r.getRol();
%>
					</tr>
					<tr>
						<td><%= id %></td>
						<td><%= rol %></td>
					</tr>
				</table>
<%	
	}
	}else{
		System.out.println("La lista esta vacia");
	}
%>
</body>
</html>