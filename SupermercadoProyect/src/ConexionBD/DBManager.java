package ConexionBD;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.*;
import SupermercadoProyecto.ventanasPrincipales.*;

public class DBManager {
	private Connection conect = null;

	
	public void connect() throws DBException { //Sirve para crear la conexión con la bd
		try {
			Class.forName("org.sqlite.JDBC");
			conect = DriverManager.getConnection("jdbc:sqlite:data/BD.db");
		} catch (ClassNotFoundException e) {
			throw new DBException("Error cargando el driver de la BD", e);
		} catch (SQLException e) {
			throw new DBException("Error conectando a la BD", e);
		}
	}
	
	
	public void disconnect() throws DBException { //Sirve para cerrar la conexión con la bd
		try {
			conect.close();
		} catch (SQLException e) {
			throw new DBException("Error cerrando la conexiÃ³n con la BD", e);
		}
	}
	
	//REGISTRAR NUEVO USUARIO
	public void registrarUsuario(Usuario usuario) throws DBException{
	
		String nombreUsuario = usuario.getNombreUsuario();
		String contrasena = usuario.getcontrasena();
		String email= usuario.getEmail();
		String direccion = usuario.getDireccion();
		
		
		try (Statement stmt= conect.createStatement()) {
			stmt.executeUpdate("INSERT INTO usuario (nomUsuario, contrasenya, correo, direccionIP) VALUES ('" + nombreUsuario + "', '"+ contrasena + "', '" + email + "', '" + direccion + "')");
		} catch (SQLException e) {
			throw new DBException("No ha sido posible ejecutar la query");
		}
		
	}
}
