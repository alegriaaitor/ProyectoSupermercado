package SupermercadoProyecto.ventanasPrincipales;

import java.util.regex.Pattern;

public class Usuario {
	private String nombreUsuario, contrasena, direccion,email; //incluimos el email para utilizar lo explicado en clase de la @
	private int id_usuario;
	public Usuario(int id_usuario, String nombreUsuario, String contrasena, String direccion, String email) {
		this.id_usuario = id_usuario;
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
		this.direccion = direccion;
		Pattern patron = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		//Pattern pattern = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
		if(email != null && patron.matcher(email).matches()){
			this.email = email;
		}else {
			this.email = "INCORRECTO";
		} 
		
	}
	public Usuario() {
		
	}
	public Usuario(String nombreUsuario,String contrasena) {
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
	}
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getcontrasena() {
		return contrasena;
	}
	public void setcontrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	/*public String toString() {
		return "Usuario [nombreUsuario=" + nombreUsuario + ", contrasena=" + contrasena + ", direccion=" + direccion
				+ ", email=" + email + "]";
	}*/
	
	
	
}
