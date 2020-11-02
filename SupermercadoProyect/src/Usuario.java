
public class Usuario {
	private String nombreUsuario, contrase�a, direccion,email; //incluimos el email para utilizar lo explicado en clase de la @

	public Usuario(String nombreUsuario, String contrase�a, String direccion, String email) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.contrase�a = contrase�a;
		this.direccion = direccion;
		this.email = email;
	}
	public Usuario() {
		super();
		this.nombreUsuario = " ";
		this.contrase�a = " ";
		this.direccion = " ";
		this.email = " ";
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getContrase�a() {
		return contrase�a;
	}
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
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
		return "Usuario [nombreUsuario=" + nombreUsuario + ", contrase�a=" + contrase�a + ", direccion=" + direccion
				+ ", email=" + email + "]";
	}*/
	
	
	
}
