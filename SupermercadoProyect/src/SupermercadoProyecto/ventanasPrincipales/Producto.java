package SupermercadoProyecto.ventanasPrincipales;

public class Producto implements Comparable<Producto>{
		
	private String nombre;
	private double precio;
	
	
	public Producto(String nombre, double precio) {
		super();
		this.nombre = nombre;
		this.precio = precio;
	}
	public Producto() {
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
	@Override
	public int compareTo(Producto arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	
	
}
