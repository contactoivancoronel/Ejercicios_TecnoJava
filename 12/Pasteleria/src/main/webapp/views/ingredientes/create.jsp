<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="/views/layouts/header.jsp" />

<form method="Post" action='<c:url value = "/ingredientes" />'>
	<input type="hidden" name="accion" value="insert">
	<p>
		Detalle: <input name="detalle" />
	</p>
	<p>
		unidad:<select name="unidad">
			<c:forEach items="${unidades}" var="unidad">
				<option value=${unidad }>${unidad }</option>
			</c:forEach>
		</select>
	</p>

		Detalle: <input type="submit" value="Crear" />
		
</form>
<a href='<c:url value = "/ingredientes" />'>Volver</a>
<c:import url="/views/layouts/footer.jsp" />
