package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import ConexionBD.DBException;
import ConexionBD.DBManager;
import SupermercadoProyecto.ventanasPrincipales.Producto;

public class JUnits {

	@Test
	void testConexionBBDD() {
		try {
			DBManager dbManager = new DBManager();
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
	void testComprobarObtenerPrecioProductos() {
		try {
			DBManager db = new DBManager();
			db.connect();
			ArrayList<Producto> al = db.obtenerProductoPrecio("1.00");
			//assertTrue(al.size()>=5);
			assertTrue("No hay productos en la lista", al.size()>=1);
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
