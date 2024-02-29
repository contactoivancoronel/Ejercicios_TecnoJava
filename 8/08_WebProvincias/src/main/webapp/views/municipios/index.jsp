<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Municipios</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

</head>
<body>
	<table class="table">
		<thead>
			<tr>
				<th>ID</th>
				<th>Nombre</th>
				<th>Provincia</th>
				<th>Longitud</th>
				<th>Latitud</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${municipios}" var="municipio">
				<tr>
				<td><c:out value="${municipio.id }"/> </td>
				<td><c:out value="${municipio.nombre }"/> </td>
				<td><c:out value="${municipio.provincia.nombre }"/> </td>
				<td><c:out value="${municipio.centroide.lon }"/> </td>
				<td><c:out value="${municipio.centroide.lat  }"/> </td>
				</tr>
				
			</c:forEach>
		</tbody>
	</table>

</body>
</html>