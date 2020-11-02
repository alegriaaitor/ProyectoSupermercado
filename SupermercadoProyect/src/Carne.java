
public class Carne extends Producto {

		private String tipo;
		private double peso;
		
		public Carne(String nombre, double precio, String tipo, double peso) {
			super(nombre, precio);
			this.tipo = tipo;
			this.peso = peso;
		}
		public Carne() {
			super();
			this.tipo = " ";
			this.peso = 0.0;
		}
		
		/*public String toString() {
			return "Carne [tipo=" + tipo + ", peso=" + peso + "]";
		}*/
		
		
		
}
