<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crear Especie</title>
</head>
<body>
	<form action="EspeciesController" method="Post">

		<input value="crear" name="accion" hidden=true />
		<p>
			Nombre: <input name="nombre" />
		</p>
		<p>
			Vertebrado: <select name="vertebrado">
				<option value="S">Si</option>
				<option value="N">No</option>
			</select>
		</p>
		<p>
			Subcategoria: <select name="subcategoria">
				<option value="Mamifero">Mamifero</option>
				<option value="Ave">Ave</option>
				<option value="Pez">Pez</option>
				<option value="Anfibio">Anfibio</option>
				<option value="Reptile">Reptile</option>
			</select>
		<p>
			<input type="submit" value="Crear" />
		</p>
		</p>

	</form>

<a  href="EspeciesController?accion=mostrar" >Ver listado completo</a>
<a href="EspeciesController?accion=mostrarmamiferos">Ver listado mamiferos</a>

</body>
</html>