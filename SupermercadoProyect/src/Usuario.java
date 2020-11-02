
public class Usuario {
	private String nombreUsuario, contraseña, direccion,email; //incluimos el email para utilizar lo explicado en clase de la @

	public Usuario(String nombreUsuario, String contraseña, String direccion, String email) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.contraseña = contraseña;
		this.direccion = direccion;
		this.email = email;
	}
	public Usuario() {
		super();
		this.nombreUsuario = " ";
		this.contraseña = " ";
		this.direccion = " ";
		this.email = " ";
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
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
		return "Usuario [nombreUsuario=" + nombreUsuario + ", contraseña=" + contraseña + ", direccion=" + direccion
				+ ", email=" + email + "]";
	}*/
	
	
	
}
