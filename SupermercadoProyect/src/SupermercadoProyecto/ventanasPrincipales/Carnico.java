package SupermercadoProyecto.ventanasPrincipales;

public class Carnico  {
	
	private String nombre;
	private double precio;
	private String ruta;
	
	public Carnico(String nombre, double precio, String ruta) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.ruta = ruta;
	}
	public Carnico() {
		super();
		this.nombre = " ";
		this.precio = 0.0;
		this.ruta = " ";
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
	
	
	public String getRuta() {
		return ruta;
	}
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	@Override
	public String toString() {
		return nombre + ", " + precio + " €";
	}
}
