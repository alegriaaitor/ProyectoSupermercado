package SupermercadoProyecto.ventanasPrincipales;

public class Hilo extends Thread{
	
	public void run() {
		while (true) {
			String texto = VentanaCarniceria.labelTitulo.getText();
			char primercaracter = texto.charAt(0);
			String textoNuevo = texto.substring(1)+String.valueOf(primercaracter);
			VentanaCarniceria.labelTitulo.setText(textoNuevo);
			try {
				sleep(400);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
