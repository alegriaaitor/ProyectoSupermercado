package SupermercadoProyecto.ventanasPrincipales;

public class Supermercado implements Comparable<Supermercado>{
	
		private String localidad; 
		private String direccion;
		private int codigo;
		private String horario;
		
		public Supermercado(String localidad, String direccion, int codigo, String horario) {
			super();
			this.localidad = localidad;
			this.direccion = direccion;
			this.codigo = codigo;
			this.horario = horario;
		}

		public String getLocalidad() {
			return localidad;
		}

		public void setLocalidad(String localidad) {
			this.localidad = localidad;
		}

		public String getDireccion() {
			return direccion;
		}

		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}
		
		public int getCodigo() {
			return codigo;
		}

		public void setCodigo(int codigo) {
			this.codigo = codigo;
		}

		public String getHorario() {
			return horario;
		}

		public void setHorario(String horario) {
			this.horario = horario;
		}

		@Override
		public String toString() {
			return localidad + ", " + direccion + ", Abrimos de: " + horario ;
		}

		@Override
		public int compareTo(Supermercado arg0) {
			// TODO Auto-generated method stub
			return 0;
		}
		
		
		
}
