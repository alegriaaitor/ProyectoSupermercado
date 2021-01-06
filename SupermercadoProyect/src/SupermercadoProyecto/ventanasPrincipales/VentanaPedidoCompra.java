package SupermercadoProyecto.ventanasPrincipales;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.*;

public class VentanaPedidoCompra extends JFrame {

	
	private JPanel contentPane;
	private JTextField textoNombre;
	private JTextField textoPrecio;
	static PrintStream log;
	Logger logger = Logger.getLogger("LOGGER");
	private JTextField textField;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPedidoCompra frame = new VentanaPedidoCompra();
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
	public VentanaPedidoCompra() {
		
		//LOGGER
				logger.log(Level.INFO, "Ventana inicializada");
				
				
				//CREACION DE INTERFACE
				setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				setBounds(100, 100, 360, 550);
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				contentPane.setLayout(null);
				
				JPanel panel = new JPanel();
				panel.setLayout(null);
				panel.setBorder(new EmptyBorder(5, 5, 5, 5));
				panel.setBackground(new Color(135, 206, 250));
				panel.setBounds(0, 0, 338, 494);
				contentPane.add(panel);
				
				textoNombre = new JTextField();
				textoNombre.setBounds(15, 119, 305, 26);
				panel.add(textoNombre);
				textoNombre.setColumns(10);
				
				JLabel labelNewLabel = new JLabel("TITULO:");
				labelNewLabel.setBounds(15, 96, 159, 20);
				panel.add(labelNewLabel);
				
				JLabel labelInserteUnPrecio = new JLabel("Precio:");
				labelInserteUnPrecio.setBounds(15, 161, 130, 20);
				panel.add(labelInserteUnPrecio);
				
				JComboBox comboBox = new JComboBox();

				comboBox.setModel(new DefaultComboBoxModel(new String[] {"Carniceria", "Fruteria", "Pescaderia", "Panaderia"}));
				comboBox.setBounds(123, 197, 197, 26);
				panel.add(comboBox);
				
				JLabel lblCategoria = new JLabel("Seccion de supermercado:");
				lblCategoria.setBounds(15, 197, 93, 20);
				panel.add(lblCategoria);
				
				textoPrecio = new JTextField();
				textoPrecio.setBounds(92, 161, 180, 26);
				panel.add(textoPrecio);
				textoPrecio.setColumns(10);
				
				JLabel label_1 = new JLabel("\u20AC");
				label_1.setBounds(287, 161, 33, 20);
				panel.add(label_1);
				
				JButton botonGuardar = new JButton("Guardar");
				botonGuardar.setBounds(188, 458, 135, 29);
				panel.add(botonGuardar);
				
				JLabel lblNewLabel = new JLabel("IMAGEN:");
				lblNewLabel.setBounds(15, 387, 69, 20);
				panel.add(lblNewLabel);
				
				JLabel lblExplicanosComoDe = new JLabel("Añade tus productos a tu compra online");
				lblExplicanosComoDe.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblExplicanosComoDe.setBounds(15, 16, 305, 20);
				panel.add(lblExplicanosComoDe);
				
				JLabel lblYPonleUn = new JLabel("Nombrando el producto y pedido correspondiente");
				lblYPonleUn.setFont(new Font("Tahoma", Font.PLAIN, 11));
				lblYPonleUn.setBounds(15, 54, 271, 20);
				panel.add(lblYPonleUn);
				
				JButton botonAnyadir = new JButton("A\u00F1adir");
				botonAnyadir.setEnabled(false);
				botonAnyadir.setBounds(117, 383, 93, 29);
				panel.add(botonAnyadir);
				
				textField = new JTextField();
				textField.setBounds(92, 249, 96, 19);
				panel.add(textField);
				textField.setColumns(10);
				
				JLabel lblNewLabel_1 = new JLabel("Unidades");
				lblNewLabel_1.setBounds(21, 252, 45, 13);
				panel.add(lblNewLabel_1);
				
				botonAnyadir.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						JFileChooser filech = new JFileChooser();
					}
				});
				
				botonGuardar.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						int idUsuario;
						String nombreProducto;
						String precioProducto;
						String seccion;
						
						//int a = VentanaInicioSesion.getUsuarioId();
						
						//idUsuario = a;
						nombreProducto = textoNombre.getText();
						precioProducto = textoPrecio.getText();
						seccion = comboBox.getSelectedItem().toString();
						
						try {
							Class.forName("org.sqlite.JDBC");
							Connection conexion = DriverManager.getConnection("jdbc:sqlite:data/DB");
							Statement stat = conexion.createStatement();
							
							//String query = "INSERT INTO "
							
							
						} catch (Exception e) {
							// TODO: handle exception
						}
						
						
					}
				});
		
	}
}
