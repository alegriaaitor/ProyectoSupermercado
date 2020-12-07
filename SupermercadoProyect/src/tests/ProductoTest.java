package tests;

import static org.junit.Assert.*;
import org.junit.Test;

import SupermercadoProyecto.ventanasPrincipales.Producto;
public class ProductoTest {
	@Test
	public void testGetPrecio() {
		Producto producto = new Producto ("Mantequilla", 2.5);
		assertEquals("Mantequilla" , producto.getNombre());
	}

}
