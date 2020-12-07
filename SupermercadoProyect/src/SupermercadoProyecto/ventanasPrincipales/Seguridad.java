package SupermercadoProyecto.ventanasPrincipales;

import javax.swing.JOptionPane;

public class Seguridad {
	
	String respuesta;
	
	public boolean validarUsuario(String usuarios[], String usuario, String contrasena, int intentos) {
		boolean encontrado= false;
		
		for(int i = 0;i< usuarios.length;i++) {
			if(usuarios[i].equalsIgnoreCase(usuario) && usuarios[i+1].equals(contrasena)){
				respuesta = "Bienvenido " + usuario;
				encontrado = true;
				JOptionPane.showMessageDialog(null, respuesta,"Inicio de Sesion", JOptionPane.INFORMATION_MESSAGE);
				intentos = 0;
				break;
			}
		}
		if(encontrado == false) {
			respuesta = "Usuario o contraseña invalidas, van " + intentos + " intentos" ;
			JOptionPane.showMessageDialog(null, respuesta,"Inicio de Sesion", JOptionPane.ERROR_MESSAGE);
		}
		if(intentos>2) {
			JOptionPane.showMessageDialog(null, "3 intentos fallidos, el sistema se cerrara","Inicio de Sesion", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
		return encontrado;
	}
}
