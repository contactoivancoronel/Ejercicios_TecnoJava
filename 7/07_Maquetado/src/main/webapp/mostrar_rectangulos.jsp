<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mostrar Rectangulo</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<style type="text/css">
* {
	font-family: Roboto;
}

.rojo {
	background-color: salmon;
}

.azul {
	background-color: skyblue;
	font-family: cursive;
}
</style>

</head>
<body>

	<p>Hola soy una vista</p>

	<table border="1" class="table">
		<thead>
			<th>Base</th>
			<th>Altura</th>
			<th>Area</th>
			<th>Perimetro</th>
		</thead>
		<tbody>
			<c:forEach items="${listaRectangulos}" var="rectanguloActual">
				<tr class='${rectanguloActual.base < 10 ? "rojo":"azul"}'>
					<td><c:out value="${rectanguloActual.base}"></c:out></td>
					<td><c:out value="${rectanguloActual.altura}"></c:out></td>
					<td><c:out value="${rectanguloActual.area}"></c:out></td>
					<td><c:out value="${rectanguloActual.perimetro}"></c:out></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>




</body>
</html>