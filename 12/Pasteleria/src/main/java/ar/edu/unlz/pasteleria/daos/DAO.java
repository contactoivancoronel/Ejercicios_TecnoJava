package ar.edu.unlz.pasteleria.daos;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import ar.edu.unlz.pasteleria.factorys.ConexionFactory;
import ar.edu.unlz.pasteleria.models.Usuario;

public interface DAO<T> {

	public void insert(T t) throws SQLException;

	public void update(T t) throws SQLException;

	public void delete(T t) throws SQLException;

	public T getById(int id) throws SQLException;
	
	public default Optional<T> getOptionalById(int id) throws SQLException{
		return Optional.ofNullable(this.getById(id));
	}

	public List<T> all() throws SQLException;
}
