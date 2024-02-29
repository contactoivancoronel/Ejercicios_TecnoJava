<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="/views/layouts/header.jsp" />
<h1>Ingredientes</h1>

<a href="ingredientes/create">Crear un nuevo ingrediente</a>

<table class="table">
	<thead>
		<tr>
			<th>ID</th>
			<th>Detalle</th>
			<th>Unidad</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${ingredientes }" var="ingrediente">

			<tr>
				<td> <c:out value="${ingrediente.id }"/>  </td>
				<td> <c:out value="${ingrediente.detalle }"/>  </td>
				<td> <c:out value="${ingrediente.unidad }"/>  </td>
			</tr>
		</c:forEach>
	</tbody>

</table>


<c:import url="/views/layouts/footer.jsp" />
