package SupermercadoProyecto.ventanasPrincipales;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ConexionBD.DBException;
import ConexionBD.DBManager;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class VentanaPropuestas extends JFrame {

	private JPanel contentPane;
	private DBManager dbManager;
	private JList<String> listaPropuestas;
	private DefaultListModel<String> modeloLista;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPropuestas frame = new VentanaPropuestas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPropuestas() {
		
		dbManager = new DBManager();
		dbManager.open();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 727, 454);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		modeloLista = new DefaultListModel<String>();
		listaPropuestas = new JList<String>(modeloLista);
		
		listaPropuestas.setBounds(39, 118, 393, 263);
		contentPane.add(listaPropuestas);
		
		JLabel lblNewLabel = new JLabel("\u00BFQUE PRODUCTOS TE GUSTARIA VER EN NUESTROS SUPERMERCADOS?");
		lblNewLabel.setBounds(39, 23, 367, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("D\u00E9janos tus sugerencias aqu\u00ED abajo");
		lblNewLabel_1.setBounds(39, 58, 249, 25);
		contentPane.add(lblNewLabel_1);
		
		JButton botonVolcar = new JButton("A\u00F1adir al Almacen");
		botonVolcar.setBounds(442, 349, 85, 21);
		contentPane.add(botonVolcar);
		
		setVisible(true);

		
		//Añadir fechas insertadas por el usuario
				int resp = JOptionPane.showConfirmDialog(null, "¿Quieres dejar alguna recomendacion?");
				while(resp == JOptionPane.OK_OPTION) {
					String f = JOptionPane.showInputDialog("Introduce el nombre del producto");
					if(!buscarProductoDeFormaRecursiva(modeloLista, 0, f))
						modeloLista.addElement(f);
					else
					resp = JOptionPane.showConfirmDialog(null, "¿Quieres insertar otra fecha?");
				}
		}
	
		public void volcarProductosDeFormaRecursiva(DefaultListModel<String> modeloLista, int i) throws DBException {
			if(i<modeloLista.size()) {
				String p = modeloLista.get(i);
				dbManager.insertarNuevaProducto(p);
				volcarProductosDeFormaRecursiva(modeloLista, i+1);
			}
		}
	
		public boolean buscarProductoDeFormaRecursiva(DefaultListModel<String> modeloLista, int i, String p) {
			if(i<modeloLista.size()) {
				if(modeloLista.get(i).equals(p)) {
					return true;
				}else {
					return buscarProductoDeFormaRecursiva(modeloLista, i+1, p);
				}
			}else {
				return false;
			}
		
		
	}
}
