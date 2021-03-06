package SupermercadoProyecto.ventanasPrincipales;

import javax.swing.JOptionPane;

public class Seguridad {
	
	String respuesta;
	
	public boolean validarUsuario(String usuarios[], String usuario, String contrasena, int intentos) {
		boolean encontrado= false;
		
		for(int i = 0;i< usuarios.length;i++) {
			if(usuarios[i].equalsIgnoreCase(usuario) && usuarios[i+1].equals(contrasena)){//Cogemos el nombre de usuario y la siguiente linea, para la contraseņa
				respuesta = "Bienvenido " + usuario;
				encontrado = true;
				JOptionPane.showMessageDialog(null, respuesta,"Inicio de Sesion", JOptionPane.INFORMATION_MESSAGE);
				intentos = 0;
				break;
			}
		}
		if(encontrado == false) {
			respuesta = "Usuario o contraseņa invalidas, van " + intentos + " intentos" ;
			JOptionPane.showMessageDialog(null, respuesta,"Inicio de Sesion", JOptionPane.ERROR_MESSAGE);
		}
		if(intentos>2) { //Comprobamos el numero de intentos, si es mayor a dos el sistema se cierra
			JOptionPane.showMessageDialog(null, "3 intentos fallidos, el sistema se cerrara","Inicio de Sesion", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
		return encontrado;
	}
}
