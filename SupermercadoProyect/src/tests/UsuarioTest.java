package tests;

import static org.junit.Assert.*;
import org.junit.Test;

import SupermercadoProyecto.ventanasPrincipales.Usuario;
public class UsuarioTest {
	@Test
	public void testGetDireccion() {
		Usuario u = new Usuario (1,"Maria","123","deusto","maria@gmail.com");
		assertEquals("maria@gmail.com" , u.getEmail());
	}
	@Test
	public void testGetEmail() {
		Usuario u = new Usuario (2,"Paco","123","deusto","paco@gmail.com");
		assertEquals("Paco" , u.getNombreUsuario());
	}

}
