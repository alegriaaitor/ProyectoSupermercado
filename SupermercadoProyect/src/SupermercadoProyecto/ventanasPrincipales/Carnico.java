package SupermercadoProyecto.ventanasPrincipales;

public class Carnico  {
	
	private String nombre;
	private double precio;
	
	
	public Carnico(String nombre, double precio) {
		super();
		this.nombre = nombre;
		this.precio = precio;
	}
	public Carnico() {
		super();
		this.nombre = " ";
		this.precio = 0.0;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}	
	
	@Override
	public String toString() {
		return nombre + ", " + precio + " €";
	}
}
