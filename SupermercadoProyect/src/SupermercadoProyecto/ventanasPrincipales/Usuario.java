package SupermercadoProyecto.ventanasPrincipales;
public class Usuario {
	private String id_usuario,nombreUsuario, contrasena, direccion,email; //incluimos el email para utilizar lo explicado en clase de la @

	public Usuario(String id_usuario, String nombreUsuario, String contrasena, String direccion, String email) {
		this.id_usuario = id_usuario;
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
		this.direccion = direccion;
		this.email = email;
	}
	public Usuario() {
		
	}
	public String getId_usuario(String id_usuario) {
		return id_usuario;
	}
	public void setId_usuario(String Id_usuario) {
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
