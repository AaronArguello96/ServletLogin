<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.time.*, java.time.format.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

	<div class="headerText center">
		<div>Bienvenido, ${sessionScope.nombre}
			${sessionScope.apellido1} ${sessionScope.apellido2}</div>
		<div>
			Hora del login =&nbsp<%=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:SS"))%></div>
	</div>
	<form>
		<p class="center">
			<button type="submit" formaction="Menu.jsp">Volver al menu</button>
		</p>
	</form>

</body>
</html>