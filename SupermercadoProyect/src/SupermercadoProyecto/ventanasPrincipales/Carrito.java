package SupermercadoProyecto.ventanasPrincipales;

import java.util.ArrayList;

public class Carrito {
	public ArrayList<Producto> productos;
	
	public Carrito() {
	productos = new ArrayList<Producto>();
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}
	//METODO QUE VACIA EL CARRITO
	public void vaciarCarrito() {
		for(int i=0;i<productos.size();i++)
			productos.remove(i);
	}
	//METODO QUE AÑADE UN PRODUCTO AL CARRITO
	public void aniadirArticuloAlCarrito(Producto p) {
		productos.add(p);
	}
	
}
