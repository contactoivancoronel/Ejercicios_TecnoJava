package ar.edu.unlz.pasteleria.daos;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unlz.pasteleria.factorys.ConexionFactory;
import ar.edu.unlz.pasteleria.models.Ingrediente;

public class IngredientesDAO implements DAO<Ingrediente> {

	@Override
	public void insert(Ingrediente ingrediente) throws SQLException {

		var conn = ConexionFactory.getConexion();

		String query = "insert into ingredientes";
		query += " (descripcion, unidad)";
		query += " values (?, ?)";

		var ps = conn.prepareStatement(query);

		ps.setString(1, ingrediente.getDetalle());
		ps.setString(2, ingrediente.getUnidad());

		ps.executeUpdate();

		conn.close();

	}

	@Override
	public void update(Ingrediente ingrediente) throws SQLException {
		var conn = ConexionFactory.getConexion();

		String query = "update ingredientes";
		query += " set descripcion = ?,";
		query += " unidad = ?";
		query += " where id = ?";

		var ps = conn.prepareStatement(query);

		ps.setString(1, ingrediente.getDetalle());
		ps.setString(2, ingrediente.getUnidad());
		ps.setInt(3, ingrediente.getId());

		ps.executeUpdate();

		conn.close();

	}

	@Override
	public void delete(Ingrediente ingrediente) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public Ingrediente getById(int id) throws SQLException {
		var conn = ConexionFactory.getConexion();

		String query = "select  id, descripcion, unidad";
		query += " from ingredientes";
		query += " where id = ?";

		var ps = conn.prepareStatement(query);
		
		ps.setInt(1, id);
		
		var lista = getListByQuery(ps);

		conn.close();
		return lista.stream().findAny().orElse(null);
	}

	@Override
	public List<Ingrediente> all() throws SQLException {

		var conn = ConexionFactory.getConexion();

		String query = "select  id, descripcion, unidad";
		query += " from ingredientes";

		var ps = conn.prepareStatement(query);

		List<Ingrediente> listado = getListByQuery(ps);
		conn.close();

		return listado;

	}

	private List<Ingrediente> getListByQuery(PreparedStatement ps) throws SQLException {

		var listado = new ArrayList<Ingrediente>();

		var rs = ps.executeQuery();

		while (rs.next()) {
			var ingrediente = new Ingrediente();
			ingrediente.setId(rs.getInt("id"));
			ingrediente.setDetalle(rs.getString("descripcion"));
			ingrediente.setUnidad(rs.getString("unidad"));

			listado.add(ingrediente);
		}

		return listado;

	}

}
