<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Especies</h1>

	<table border="2px">
		<thead>
			<th>ID</th>
			<th>Nombre</th>
			<th>Verebrado</th>
			<th>SubEspecie</th>
		</thead>
		<tbody>
			<c:forEach items="${lista }" var="especie">
				<tr>
					<td><c:out value="${especie.id }"></c:out></td>
					<td><c:out value="${especie.nombre }"></c:out></td>
					<td><c:out value='${especie.vertebrado ? "Si" : "No"}'></c:out></td>
					<td><c:out value="${especie.subCategoria }"></c:out></td>
					<td><a
						href='EspeciesController?accion=formularioeditar&id=${especie.id }'>
							Editar </a>
				</td>
				</tr>
			</c:forEach>
		</tbody>


	</table>


	<a href="EspeciesController?accion=formularioalta">Crear especie </a>





</body>
</html>