<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro</title>
</head>
<body>
<h1>Registrarse</h1>
<form action="usuarios" method="post">
	<input type="hidden" name="accion" value="register">
	<p> Usuario: <input name="usuario"/>  </p>
	<p> Clave: <input name="clave"/>  </p>
	<p> <input type="submit" value="Registrarse!"/>  </p>

</form>

</body>
</html>