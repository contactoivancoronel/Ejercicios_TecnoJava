import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {

		var listado = DriverManager.getDrivers();
		

		while (listado.hasMoreElements()) {

			System.out.println(listado.nextElement());
		}
		
		var url = "jdbc:mysql://localhost:3306/tecnojcom1";
		
		try {
			var conn = DriverManager.getConnection(url,"root","");
			
			var statement = conn.createStatement();
			
			//var sQuery = "insert into especies(nombre) values ('Tiburon')";
			
			//statement.executeUpdate(sQuery);
			
			var especie = new Especie("T-'rex' ", true, "reptil");
			
			var ps = conn
				.prepareStatement("insert into "
						+ "especies(nombre, vertebrado, sub_especie) "
						+ "values (?,?,?)");
			
			//insert into especies(nombre, vertebrado, sub_especie) 
			//values ('T-rex',1,'reptil')
			
			ps.setString(1, especie.getNombre().replace("'", "''"));
			ps.setInt(2, especie.isVertebrado() ? 1 : 0 ); 
			ps.setString(3, especie.getSubCategoria());
			
			ps.executeUpdate();
			
			System.out.println(ps);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		

		System.out.println("Fin");
	}

}
