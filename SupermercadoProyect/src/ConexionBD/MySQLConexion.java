package ConexionBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class MySQLConexion {
	public static Connection getConexion() {
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1/supersupermercado";
			String usuario = "root";
			String contrasena = "";
			
			con = DriverManager.getConnection(url, usuario, contrasena);
			
		} catch (ClassNotFoundException e) {
			System.out.println("Error al cargar el Driver");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Error al conectar BD");
			e.printStackTrace();
		}
		
		
		return con;
		
	}
}
