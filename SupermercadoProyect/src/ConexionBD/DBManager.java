package ConexionBD;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.*;
import SupermercadoProyecto.ventanasPrincipales.*;

public class DBManager {
	private Connection conexion = null;

	
	public void connect() throws DBException { //Sirve para crear la conexión con la bd
		try {
			Class.forName("org.sqlite.JDBC");
			conexion = DriverManager.getConnection("jdbc:sqlite:data/DB");
		} catch (ClassNotFoundException e) {
			throw new DBException("Error cargando el driver de la BD", e);
		} catch (SQLException e) {
			throw new DBException("Error conectando a la BD", e);
		}
	}
	
	
	public void disconnect() throws DBException { //Sirve para cerrar la conexión con la bd
		try {
			conexion.close();
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
		
		
		try (Statement s= conexion.createStatement()) {
			
			s.executeUpdate("INSERT INTO usuario (nombreUsuario, contrasena, email, direccion) VALUES (' " + nombreUsuario + " ', ' "+ contrasena + " ', ' " + email + " ', ' " + direccion + " ')");
		} catch (SQLException e) {
			throw new DBException("No ha sido posible ejecutar la query");
		}
		
	}
	
	//LOGIN
	public boolean loginUsuario (String nombreUsuario, String contrasena) throws DBException{
		
		boolean acceso = false;
			
		try (PreparedStatement stmt = conexion.prepareStatement("SELECT id_usuario, nombreUsuario, contrasena, email, direccion FROM usuario WHERE nombreUsuario = ? AND contrasena = ?")) {
				stmt.setString(1, nombreUsuario);
				stmt.setString(2, contrasena);
				
				ResultSet rs = stmt.executeQuery();
				
				if (rs.next()) {
					acceso = true;
				}else {
					acceso = false;
				}
				
			} catch (SQLException e) {
				throw new DBException("Error obteniendo datos de la query", e);
			}
		
		
		return acceso;
	}
	
	public int obtenerId (String nombreUsuario) throws DBException{
		int idUsuario = 0;
		if (!nombreUsuario.contains("@")) {
			try (PreparedStatement stmt = conexion.prepareStatement("SELECT id_usuario, nombreUsuario, contrasena, email, direccion FROM usuario WHERE nombreUsuario = ?")) {
				stmt.setString(1, nombreUsuario);
				ResultSet rs = stmt.executeQuery();
				rs.next();
				idUsuario = rs.getInt("id");
				
			} catch (SQLException e) {
				throw new DBException("Error obteniendo todos los usuarios'", e);
			}	
		}else {
			try (PreparedStatement stmt = conexion.prepareStatement("SELECT id_usuario, nombreUsuario, contrasena, email, direccion FROM usuario WHERE email = ?")) {
				stmt.setString(1, nombreUsuario);
				ResultSet rs = stmt.executeQuery();
				rs.next();
				idUsuario = rs.getInt("id");
				
			} catch (SQLException e) {
				throw new DBException("Error obteniendo todos los usuarios'", e);
			}	
		}
		
			
		return idUsuario;
	}
	
	public void obtenerProducto(String nombreProducto, double precio) throws DBException{

		try (PreparedStatement stmt = conexion.prepareStatement("SELECT nombre, precio FROM producto WHERE nombre = ? AND precio = ?")) {
			stmt.setString(1, nombreProducto);
			stmt.setDouble(2, precio);
			
			ResultSet rs = stmt.executeQuery();
			rs.next();
			
			
		} catch (SQLException e) {
			throw new DBException("Error obteniendo todos los usuarios'", e);
		}	
	}
}
