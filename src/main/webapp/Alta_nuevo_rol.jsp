<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alta Rol</title>
</head>
<body>

	<%
 	if (session.getAttribute("rol").toString().equals("2")) { ///Si el usuario registrado tiene rol 2 (empleado) o rol 3 (cliente) se le devuelve al menu
		response.sendRedirect("Menu.jsp");
	}
	if (session.getAttribute("rol").toString().equals("3")) {
		response.sendRedirect("Menu.jsp");
	}
	%>
	
	<!-- Header -->
	<%@ include file="Header.jsp"%>
	<div class="altausuario">
		<h2>Bienvenido a la página para dar de alta un rol</h2>

		<form method="post" action="AltaRolServlet">
			<fieldset>
				<legend>Introduzca los datos</legend>
				<table>
					<tr>
						<td><label for="rol">Rol</label></td>
						<td><input type="text" id="nombreRol" name="nombreRol" /></td>
					</tr>
				</table>
			</fieldset>
			<button type="submit" value="Registrar">Registrar</button>
		</form>
	</div>
</body>
</html>