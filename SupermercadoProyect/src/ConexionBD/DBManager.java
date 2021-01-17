package ConexionBD;

import java.sql.*;

import java.util.ArrayList;

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
			//Añadimos en la base de datos los campos de infomacion introducidos en la ventana(recibido como objeto de la clase usuario)
			s.executeUpdate("INSERT INTO usuario (nombreUsuario, contrasena, email, direccion) VALUES (' " + nombreUsuario + " ', ' "+ contrasena + " ', ' " + email + " ', ' " + direccion + " ')");
		} catch (SQLException e) {
			throw new DBException("No ha sido posible ejecutar la query");
		}
		
	}
	
	//LOGIN
	public boolean loginUsuario (String nombreUsuario, String contrasena) throws DBException{
		
		boolean acceso = false;
			
		try (PreparedStatement stmt = conexion.prepareStatement("'SELECT id_usuario, nombreUsuario, contrasena, email, direccion FROM usuario WHERE nombreUsuario = ? AND contrasena = ?;'")) {
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
	
	//OBTENER EL PRECIO DE UN PRODUCTO CONCRETO
	public double obtenerPrecioProducto(String nombreProducto) throws DBException{
		double precio = 0;
		try (PreparedStatement stmt = conexion.prepareStatement("SELECT nombre, precio FROM producto WHERE nombre = ? ")) {
			stmt.setString(1, nombreProducto);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			precio = rs.getDouble("precio");
			
			
		} catch (SQLException e) {
			throw new DBException("Error obteniendo todos los usuarios'", e);
		}	
		return precio;
	}
	//AÑADIR PRODUCTO A CARRITO
	public void anadirProductoACarrito(Producto producto) throws DBException{
				
		String nombre = producto.getNombre();
		double precio = producto.getPrecio();
				
		try (Statement s= conexion.createStatement()) {
			//Añadimos en la base de datos los producto que queremos añadir al carrito
			s.executeUpdate("INSERT INTO carrito (nombre, precio) VALUES (' " + nombre + " ', ' "+ precio + "')");
		} catch (SQLException e) {
			throw new DBException("No ha sido posible ejecutar la query");
		}
				
	}
	//MOSTRAR LOS PRODUCTOS AÑADIDOS AL CARRITO
	public ArrayList<Producto> obtenerCarrito(){
		String sentSQL = "SELECT * FROM carrito";
		ArrayList<Producto> al = new ArrayList<>();
		try {
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery(sentSQL);
			while(rs.next()) {
				String nombre = rs.getString("nombre");
				double precio = rs.getDouble("precio");
				Producto p = new Producto(nombre,precio);
				al.add(p);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				throw new DBException("No se han obtenido productos", e);
			} catch (DBException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return al;
	}
	public void vaciarCarrito() {
        String sentSQL = "DELETE from carrito";
        try {
            Statement st = conexion.createStatement();
            st.executeUpdate(sentSQL);
            st.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	
	public boolean existeProducto(String p) throws DBException {
		boolean existe = false;
		String sentSQL = "SELECT * FROM producto WHERE nombre ='"+ p +"'";
		try {
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery(sentSQL);
			if(rs.next()) 
				existe = true;
			rs.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DBException("No se ha podido buscar el produtco en la tabla Productos");
		}
		return existe;
	}
	
	public void insertarNuevoProducto(Producto p) throws DBException {
		if(!existeProducto(p.getNombre())) {
			String sentSQL = "INSERT INTO producto VALUES('"+ p.getNombre() +"'," +p.getPrecio() +")";
			try {
				Statement st = conexion.createStatement();
				st.executeUpdate(sentSQL);
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new DBException("No se ha podido insertar el producto en la tabla producto");
			}
		}
	}
	
	public double obtenerTotalCarrito() throws DBException {
		double precioTotal = 0;
		String sentSQL = "SELECT SUM(precio) FROM carrito";
		try {
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery(sentSQL);
			if(rs.next()) {
				precioTotal = rs.getDouble(1);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DBException("No se ha podido ejecutar la query");
		}
		return precioTotal;
	}
	
	
	
	public int obtenerPrecioTotal() throws DBException{
		
		
		return 0;
		
	}


	public void open() {
		// TODO Auto-generated method stub
		
	}


	public void crearTablas() {
		// TODO Auto-generated method stub
		
	}
	
	
}
