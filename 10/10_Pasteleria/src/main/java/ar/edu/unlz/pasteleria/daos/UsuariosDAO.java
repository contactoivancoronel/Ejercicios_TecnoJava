package ar.edu.unlz.pasteleria.daos;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unlz.pasteleria.factorys.ConexionFactory;
import ar.edu.unlz.pasteleria.models.Usuario;

public class UsuariosDAO {

	public void insert(Usuario usuario) throws SQLException {

		var con = ConexionFactory.getConexion();

		var sQuery = "insert into usuarios";
		sQuery += " (username, password)";
		sQuery += " values (?, ?)";

		var ps = con.prepareStatement(sQuery);

		ps.setString(1, usuario.getUsername());
		ps.setString(2, usuario.getPassword());

		ps.executeUpdate();

		con.close();

	}

	public Usuario getByUsername(String username) throws SQLException {
		Usuario usuario = null;

		var con = ConexionFactory.getConexion();

		var sQuery = "select * from usuarios ";
		sQuery += " where username = ?";

		var ps = con.prepareStatement(sQuery);

		ps.setString(1, username);
		
		System.out.println(ps);
		
		var rs = ps.executeQuery();
		
		if(rs.next()) {
			var userName = rs.getString("username");
			var password = rs.getString("password");
			var id = rs.getInt("id");

			usuario = new Usuario();
			usuario.setId(id);
			usuario.setUsername(userName);
			usuario.setPassword(password);
		}		
		
		con.close();

		return usuario;

	}

	public List<Usuario> all() throws SQLException {
		var listaUsuarios = new ArrayList<Usuario>();

		var con = ConexionFactory.getConexion();

		var sQuery = "select * from usuarios";

		var ps = con.prepareStatement(sQuery);

		var results = ps.executeQuery();

		while (results.next()) {
			var userName = results.getString("username");
			var password = results.getString("password");
			var id = results.getInt("id");

			var usuario = new Usuario();
			usuario.setId(id);
			usuario.setUsername(userName);
			usuario.setPassword(password);

			listaUsuarios.add(usuario);

		}

		con.close();

		return listaUsuarios;
	}

}
