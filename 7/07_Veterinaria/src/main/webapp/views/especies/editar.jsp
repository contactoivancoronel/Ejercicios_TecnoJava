<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="EspeciesController" method="POST">
		<input name="accion" value="editar" />
			 <input name="id" value="${especie.id }" />
		<p>
			Nombre: <input name="nombre" value="${especie.nombre }" />
		</p>
		<p>
			Vertebrado: <select name="vertebrado">
				<option value="S" ${especie.vertebrado? "selected":"" }>Si</option>
				<option value="N" ${!especie.vertebrado? "selected":"" }>No</option>
			</select>
		</p>
		<p>
			Subcategoria: <select name="subcategoria">
				<option value="Mamifero">Mamifero</option>
				<option value="Ave">Ave</option>
				<option value="Pez">Pez</option>
				<option value="Anfibio">Anfibio</option>
				<option value="Reptil">Reptil</option>
			</select>

		<p>
			<input type="submit" value="Editar" />
	</p></form>

</body>
</html>