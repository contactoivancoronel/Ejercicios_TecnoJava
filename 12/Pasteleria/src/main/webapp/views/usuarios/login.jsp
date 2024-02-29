<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ingresar</title>
</head>
<body>
<h1>Ingresar</h1>
<form action="usuarios" method="post">
	<input type="hidden" name="accion" value="login">
	<p> Usuario: <input name="usuario"/>  </p>
	<p> Clave: <input name="clave" type="password"/>  </p>
	<p> <input type="submit" value="Ingresar"/>  </p>

</form>
<p>No tenes cuenta? Registrate <a href="usuarios?accion=register">aqui</a></p>

</body>
</html>