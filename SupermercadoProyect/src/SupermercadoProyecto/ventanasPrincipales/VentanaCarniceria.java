package SupermercadoProyecto.ventanasPrincipales;

import java.awt.*;


import javax.swing.border.EmptyBorder;

import ConexionBD.DBException;
import ConexionBD.DBManager;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class VentanaCarniceria extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCarniceria frame = new VentanaCarniceria();
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
	public VentanaCarniceria() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 554, 495);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel nombreProducto1 = new JLabel("Chuleton de vaca (500g)");
		nombreProducto1.setForeground(Color.WHITE);
		nombreProducto1.setBounds(111, 62, 244, 13);
		contentPane.add(nombreProducto1);
		
		
		JLabel lblProducto = new JLabel("Solomillo de ternera (250g)");
		lblProducto.setForeground(Color.WHITE);
		lblProducto.setBounds(111, 139, 244, 13);
		contentPane.add(lblProducto);
		
		JLabel lblProducto_1 = new JLabel("Entrecot de ternera (300g)");
		lblProducto_1.setForeground(Color.WHITE);
		lblProducto_1.setBounds(111, 237, 244, 13);
		contentPane.add(lblProducto_1);
		
		JLabel lblProducto_2 = new JLabel("Chorizo criollo (250g)");
		lblProducto_2.setForeground(Color.WHITE);
		lblProducto_2.setBounds(111, 329, 236, 13);
		contentPane.add(lblProducto_2);
		
		DBManager con = new DBManager();
		JLabel labelPrecioChuleton;
		try {
			con.connect();
			labelPrecioChuleton = new JLabel("Precio: " + con.obtenerPrecioProducto("Chuleton de vaca")); //Pasamos por parametro "Chuleton de vaca 
			labelPrecioChuleton.setForeground(Color.WHITE);
			labelPrecioChuleton.setBounds(111, 98, 149, 13);    										  //y nos devuelve el precio del poducto pasado
			contentPane.add(labelPrecioChuleton);
			con.disconnect();
		} catch (DBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			con.connect();
			JLabel labelPrecioSolomillo = new JLabel("Precio: " + con.obtenerPrecioProducto("Solomillo de ternera"));
			labelPrecioSolomillo.setForeground(Color.WHITE);
			labelPrecioSolomillo.setBounds(111, 178, 149, 13);
			contentPane.add(labelPrecioSolomillo);
			con.disconnect();
		}catch(DBException e2) {
			e2.printStackTrace();
		}
		
		try {
			con.connect();	
			JLabel labelPrecioEntrecot = new JLabel("Precio: " + con.obtenerPrecioProducto("Entrecot de ternera"));
			labelPrecioEntrecot.setForeground(Color.WHITE);
			labelPrecioEntrecot.setBounds(111, 273, 149, 13);
			contentPane.add(labelPrecioEntrecot);
			con.disconnect();
		}catch(DBException e2) {
			e2.printStackTrace();
		}
		
		try {
			con.connect();
			JLabel labelPrecioCriollo = new JLabel("Precio: " + con.obtenerPrecioProducto("Chorizo criollo"));
			labelPrecioCriollo.setForeground(Color.WHITE);
			labelPrecioCriollo.setBounds(111, 371, 149, 13);
			contentPane.add(labelPrecioCriollo);
			con.disconnect();
		}catch(DBException e3) {
			e3.printStackTrace();
		}
		
		
		JButton botonAnadirChuleton = new JButton("A\u00F1adir");
		botonAnadirChuleton.setBounds(373, 75, 85, 21);
		contentPane.add(botonAnadirChuleton);
		botonAnadirChuleton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				try {
				con.connect();
				Producto carne1 = new Producto();
				carne1.setNombre("Chuleton de vaca");
				carne1.setPrecio(con.obtenerPrecioProducto("Chuleton de vaca"));
				con.anadirProductoACarrito(carne1);
				con.disconnect();
				}catch(DBException e) {
					e.printStackTrace();
				}
				
			}
		});
		
		JButton botonCriollo = new JButton("A\u00F1adir");
		botonCriollo.setBounds(373, 356, 85, 21);
		contentPane.add(botonCriollo);
		botonCriollo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					con.connect();
					Producto carne2 = new Producto();
					carne2.setNombre("Chorizo criollo");
					carne2.setPrecio(con.obtenerPrecioProducto(carne2.getNombre()));
					con.anadirProductoACarrito(carne2);
					con.disconnect();
					}catch(DBException e) {
						e.printStackTrace();
					}
			}
		});
		
		JButton botonSolomillo = new JButton("A\u00F1adir");
		botonSolomillo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		botonSolomillo.setBounds(373, 174, 85, 21);
		contentPane.add(botonSolomillo);
		botonSolomillo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					con.connect();
					Producto carne3 = new Producto();
					carne3.setNombre("Solomillo de ternera");
					carne3.setPrecio(con.obtenerPrecioProducto(carne3.getNombre()));
					con.anadirProductoACarrito(carne3);
					con.disconnect();
					}catch(DBException e) {
						e.printStackTrace();
					}
			}
		});
		
		JButton botonEntrecot = new JButton("A\u00F1adir");
		botonEntrecot.setBounds(373, 269, 85, 21);
		contentPane.add(botonEntrecot);
		botonEntrecot.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					con.connect();
					Producto carne4 = new Producto();
					carne4.setNombre("Entrecot de ternera");
					carne4.setPrecio(con.obtenerPrecioProducto(carne4.getNombre()));
					con.anadirProductoACarrito(carne4);
					con.disconnect();
					}catch(DBException e) {
						e.printStackTrace();
					}
			}
		});
		
		JButton btnNewButton_8 = new JButton("Volver");
		btnNewButton_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaMenu menu = new VentanaMenu();
				menu.setVisible(true);
				dispose();
			}
		});
		btnNewButton_8.setBounds(111, 425, 85, 21);
		contentPane.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("Ver carrito");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaCarrito carrito = new VentanaCarrito();
				carrito.setVisible(true);
				dispose();
			}
		});
		btnNewButton_9.setBounds(237, 425, 94, 21);
		contentPane.add(btnNewButton_9);
		
		JLabel labelPalmerita = new JLabel("Foto");
		labelPalmerita.setBounds(26, 139, 75, 75);
		contentPane.add(labelPalmerita);
		ImageIcon ico4 = new ImageIcon("imagenes/solomillo.png");
        ImageIcon img4 = new ImageIcon(ico4.getImage().getScaledInstance(labelPalmerita.getWidth(), labelPalmerita.getHeight(), Image.SCALE_SMOOTH));
        labelPalmerita.setIcon(img4);
		contentPane.add(labelPalmerita);
		
		JLabel labelBolloMantequilla = new JLabel("Foto");
		labelBolloMantequilla.setBounds(26, 237, 75, 75);
		contentPane.add(labelBolloMantequilla);
		ImageIcon ico3 = new ImageIcon("imagenes/entrecot.png");
        ImageIcon img3 = new ImageIcon(ico3.getImage().getScaledInstance(labelBolloMantequilla.getWidth(), labelBolloMantequilla.getHeight(), Image.SCALE_SMOOTH));
        labelBolloMantequilla.setIcon(img3);
		contentPane.add(labelBolloMantequilla);
		
		JLabel labelNapolitana = new JLabel("Foto");
		labelNapolitana.setBounds(26, 329, 75, 75);
		contentPane.add(labelNapolitana);
		ImageIcon ico2 = new ImageIcon("imagenes/criollo.png");
        ImageIcon img2 = new ImageIcon(ico2.getImage().getScaledInstance(labelNapolitana.getWidth(), labelNapolitana.getHeight(), Image.SCALE_SMOOTH));
        labelNapolitana.setIcon(img2);
		contentPane.add(labelNapolitana);
		
		JLabel labelPan = new JLabel("Foto");
		labelPan.setBounds(26, 48, 75, 75);
		contentPane.add(labelPan);
		ImageIcon ico1 = new ImageIcon("imagenes/chuleton.png");
        ImageIcon img1 = new ImageIcon(ico1.getImage().getScaledInstance(labelPan.getWidth(), labelPan.getHeight(), Image.SCALE_SMOOTH));
        labelPan.setIcon(img1);
		contentPane.add(labelPan);
		ImageIcon ico = new ImageIcon("imagenes/fondos.jpg");
		
		JButton btnNewButton = new JButton("Cambiar Seccion");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaFruteria fruteria = new VentanaFruteria();
				fruteria.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(372, 425, 136, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("PANADERIA");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel.setBounds(157, 25, 149, 27);
		contentPane.add(lblNewLabel);
		
		JLabel labelFondo = new JLabel("");
		labelFondo.setHorizontalAlignment(SwingConstants.TRAILING);
		labelFondo.setBounds(0, 0, 540, 458);
		ImageIcon ico7 = new ImageIcon("imagenes/fondos.jpg");
        ImageIcon img = new ImageIcon(ico7.getImage().getScaledInstance(labelFondo.getWidth(), labelFondo.getHeight(), Image.SCALE_SMOOTH));
        labelFondo.setIcon(img);
		contentPane.add(labelFondo);
		
		
	}
}
