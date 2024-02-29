package ar.edu.unlz.pasteleria.factorys;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexionFactory {

	private static final String SERVER_URL = "jdbc:mysql://localhost:3306/tecnojcom1";

	private static final String USER = "root";

	private static final String PASSWORD = "";

	public static Connection getConexion() throws SQLException {



		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection conn = DriverManager.getConnection(SERVER_URL, USER, PASSWORD);

		return conn;
	}

}
