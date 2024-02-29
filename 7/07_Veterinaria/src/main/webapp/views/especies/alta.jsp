<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alta de especie</title>
</head>
<body>
	<form action="EspeciesController" method="POST">
		<input name="accion" value="alta" /> 
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
				<option value="Reptil">Reptil</option>
			</select>
		<p>
			<input type="submit" value="Crear" />
		</p>
	</form>

</body>
</html>