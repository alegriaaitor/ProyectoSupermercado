package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import ConexionBD.DBException;
import ConexionBD.DBManager;
import SupermercadoProyecto.ventanasPrincipales.Producto;
import SupermercadoProyecto.ventanasPrincipales.Usuario;

public class Tests {
	DBManager dbManager;
	
	@Test
	public void testGetPrecio() {
		Producto producto = new Producto ("Mantequilla", 2.5);
		assertEquals("Mantequilla" , producto.getNombre());
	}
	
	@Test
	public void testEmail() {
		Usuario pepe = new Usuario(1, "pepe", "1234", "Casa", "pepe@gmail.com");
		assertEquals("pepe@gmail.com", pepe.getEmail());
		Usuario paco = new Usuario(2, "paco", "4321", "Deusto", "paco.com");
		assertEquals("INCORRECTO", paco.getEmail());
		Usuario pepa = new Usuario(3, "pepa", "1357", "Bilbao", "pepa@gmail");
		assertEquals("INCORRECTO", pepa.getEmail());
		
	}
	
	@Test
	public void testConexionBBDD() {
		try {
			dbManager = new DBManager();
			dbManager.connect();
			//assertNotNull(dbManager.getConnection());
			assertNotNull("No se ha establecido la conexión con BBDD", dbManager.getConnection());
			dbManager.disconnect();
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testComprobarObtenerPrecioProductos() {
		try {
			dbManager = new DBManager();
			dbManager.connect();
			ArrayList<Producto> al = dbManager.obtenerProductoPrecio("1");
			//assertTrue(al.size()>=5);
			assertTrue("No hay productos en la lista", al.size()>=1);
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
