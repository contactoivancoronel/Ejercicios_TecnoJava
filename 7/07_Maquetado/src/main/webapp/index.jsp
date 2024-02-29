<%@page import="ar.com.gniglio.models.Rectangulo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%

ArrayList<String> lista = new ArrayList<String>();

lista.add("Cobayo");
lista.add("Perro");
lista.add("Gato");
lista.add("Tiburon");
lista.add("Camaleon");



ArrayList<Rectangulo> listaRectangulos = new ArrayList<Rectangulo>();

listaRectangulos.add(Rectangulo.getRandom());
listaRectangulos.add(Rectangulo.getRandom());
listaRectangulos.add(Rectangulo.getRandom());
listaRectangulos.add(Rectangulo.getRandom());
listaRectangulos.add(Rectangulo.getRandom());
listaRectangulos.add(Rectangulo.getRandom());


request.setAttribute("atributo1", 12);
request.setAttribute("listaAnimales", lista);
request.setAttribute("listaRectangulos", listaRectangulos);

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>
		<c:out value="${param.id}" default="No hay parametro ID" />
	</p>

	<c:if test="${atributo1 == 12}">
		<c:out value="${atributo1}" />
	</c:if>

	<c:if test="${param.id==0}">
		<c:out value="La id es cero" />
	</c:if>

	<c:forEach items="${listaAnimales }" var="animal">
		<p>
			Animal:
			<c:out value="${animal }" />
		</p>
	</c:forEach>

	<table border="1">
		<thead>
			<th>Nombre</th>
		</thead>
		<tbody>
			<c:forEach items="${listaAnimales}" var="animal">
				<tr>
					<td><c:out value="${animal }" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	
	<table border="1">
		<thead>
			<th>Base</th>
			<th>Altura</th>
			<th>Area</th>
			<th>Perimetro</th>
		</thead>
		<tbody>
			<c:forEach items="${listaRectangulos}" var="rectangulo">
				<tr>
					<td><c:out value="${rectangulo.base }" /></td>
					<td><c:out value="${rectangulo.altura }" /></td>
					<td><c:out value="${rectangulo.area }" /></td>
					<td><c:out value="${rectangulo.perimetro }" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>