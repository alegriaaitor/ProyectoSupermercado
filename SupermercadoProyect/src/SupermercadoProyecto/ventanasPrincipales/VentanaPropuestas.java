package SupermercadoProyecto.ventanasPrincipales;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ConexionBD.DBException;
import ConexionBD.DBManager;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaPropuestas extends JFrame {

	private JPanel contentPane;
	private DBManager dbManager;
	private JList<Carnico> listaPropuestas;
	private DefaultListModel<Carnico> modeloLista;
	
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
		try {
			dbManager = new DBManager();
			dbManager.connect();
		}catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 727, 454);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		modeloLista = new DefaultListModel<Carnico>();
		listaPropuestas = new JList<Carnico>(modeloLista);
		
		listaPropuestas.setBounds(39, 118, 393, 263);
		contentPane.add(listaPropuestas);
		
		JLabel lblNewLabel = new JLabel("\u00BFQUE PRODUCTOS TE GUSTARIA VER EN NUESTROS SUPERMERCADOS?");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(39, 23, 457, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("D\u00E9janos tus sugerencias aqu\u00ED abajo");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(39, 58, 249, 25);
		contentPane.add(lblNewLabel_1);
		
		JButton botonVolcar = new JButton("A\u00F1adir al Almacen");
		botonVolcar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					volcarProductosDeFormaRecursiva(modeloLista, 0, 0);
				} catch (DBException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		botonVolcar.setBounds(442, 349, 148, 21);
		contentPane.add(botonVolcar);
		
		JButton btnNewButton = new JButton("Volver al Carrito");
        btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaCarrito vc = new VentanaCarrito();
				vc.setVisible(true);
				dispose();
			}
		});
        btnNewButton.setBounds(442, 380, 148, 21);
        contentPane.add(btnNewButton);
		
        JButton botonAtras = new JButton("Atras");
        botonAtras.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		VentanaMenu vm = new VentanaMenu();
        		vm.setVisible(true);
        		dispose();
        	}
        });
        botonAtras.setBounds(10, 391, 85, 21);
        contentPane.add(botonAtras);
        
        
		JLabel labelFondo = new JLabel("");
		labelFondo.setHorizontalAlignment(SwingConstants.TRAILING);
		
		labelFondo.setBounds(0, 0, 713, 417);
		contentPane.add(labelFondo);
		ImageIcon ico4 = new ImageIcon("imagenes/fondos.jpg");
        ImageIcon img4 = new ImageIcon(ico4.getImage().getScaledInstance(labelFondo.getWidth(), labelFondo.getHeight(), Image.SCALE_SMOOTH));
        labelFondo.setIcon(img4);
        
        
        
        
		
		setVisible(true);

		
		//Añadir Productos insertados por el usuario
				int resp = JOptionPane.showConfirmDialog(null, "¿Quieres dejar alguna recomendacion?");
				while(resp == JOptionPane.OK_OPTION) {
					String c = JOptionPane.showInputDialog("Introduce el nombre del producto");
					String precio = JOptionPane.showInputDialog("Introduce lo que consideres que deberia valer el producto");
					String imagen = JOptionPane.showInputDialog("Introduce la ruta del producto carnico con formato : imagenes/nombre.jpg");

					if(!buscarProductoDeFormaRecursiva(modeloLista, 0, 0, c)) {
						Carnico cr = new Carnico(c, Double.parseDouble(precio), imagen);
						modeloLista.addElement(cr);
					}else {
						JOptionPane.showMessageDialog(null, "No se pueden insertar productos repetidos");
						resp = JOptionPane.showConfirmDialog(null, "¿Quieres insertar otro producto?");
					}
					resp = JOptionPane.showConfirmDialog(null, "¿Quieres dejar alguna recomendacion?");
				}
		}
	
		public void volcarProductosDeFormaRecursiva(DefaultListModel<Carnico> modeloLista, int i, int a) throws DBException {
			if(i<modeloLista.size()) {
				Carnico c = modeloLista.get(i);
				dbManager.insertarNuevoProducto(c);
				volcarProductosDeFormaRecursiva(modeloLista, i+1, a+1);
			}
		}
	
		public boolean buscarProductoDeFormaRecursiva(DefaultListModel<Carnico> modeloLista, int i,int a, String p) {
			if(i<modeloLista.size()) {
				if(modeloLista.get(i).getNombre().equals(p)) {
					return true;
				}else {
					return buscarProductoDeFormaRecursiva(modeloLista, i+1, a+1, p);
				}
			}else {
				return false;
			}
		
		
	}
}
