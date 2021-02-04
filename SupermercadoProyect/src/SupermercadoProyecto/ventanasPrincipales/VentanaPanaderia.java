package SupermercadoProyecto.ventanasPrincipales;
import java.awt.*;


import javax.swing.border.EmptyBorder;

import ConexionBD.DBException;
import ConexionBD.DBManager;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class VentanaPanaderia extends JFrame {

	private JPanel contentPane;
	private JLabel labelPrecioDonuts;
	private JLabel labelPrecioNapolitana;
	private JLabel labelPrecioPalmeritas;
	private JLabel labelPrecioPan;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPanaderia frame = new VentanaPanaderia();
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
	public VentanaPanaderia() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel nombreProducto1 = new JLabel("Donuts (500g)");
		nombreProducto1.setForeground(Color.WHITE);
		nombreProducto1.setBounds(150, 87, 244, 13);
		contentPane.add(nombreProducto1);
		
		
		JLabel lblProducto = new JLabel("Palmeritas (250g)");
		lblProducto.setForeground(Color.WHITE);
		lblProducto.setBounds(150, 151, 244, 13);
		contentPane.add(lblProducto);
		
		JLabel lblProducto_1 = new JLabel("Napolitana (300g)");
		lblProducto_1.setForeground(Color.WHITE);
		lblProducto_1.setBounds(150, 238, 244, 13);
		contentPane.add(lblProducto_1);
		
		JLabel lblProducto_2 = new JLabel("Pan (250g)");
		lblProducto_2.setForeground(Color.WHITE);
		lblProducto_2.setBounds(150, 315, 244, 13);
		contentPane.add(lblProducto_2);
		
		DBManager con = new DBManager();
		//JLabel labelPrecioDonuts;	
		
		try {
			con.connect();
			JLabel labelPrecioDonuts = new JLabel("Precio: " + con.obtenerPrecioProducto("Donuts"));
			labelPrecioDonuts.setForeground(Color.WHITE);
			labelPrecioDonuts.setBounds(150, 110, 149, 13);
			contentPane.add(labelPrecioDonuts);
			con.disconnect();
		} catch (DBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {			
			con.connect();
			JLabel labelPrecioPalmeritas = new JLabel("Precio: " + con.obtenerPrecioProducto("Palmeritas"));
			labelPrecioPalmeritas.setForeground(Color.WHITE);
			labelPrecioPalmeritas.setBounds(150, 178, 138, 13);
			contentPane.add(labelPrecioPalmeritas);
			con.disconnect();
		} catch (DBException e2) {
			// TODO Auto-generated catch block
						e2.printStackTrace();
		}	
		
		try {			
			con.connect();
			JLabel labelPrecioNapolitana = new JLabel("Precio: " + con.obtenerPrecioProducto("Napolitana"));
			labelPrecioNapolitana.setForeground(Color.WHITE);
			labelPrecioNapolitana.setBounds(150, 256, 125, 13);
			contentPane.add(labelPrecioNapolitana);
			con.disconnect();
		} catch (DBException e2) {
			// TODO Auto-generated catch block
						e2.printStackTrace();
		}
			
		try {			
			con.connect();
			JLabel labelPrecioPan = new JLabel("Precio: " + con.obtenerPrecioProducto("Pan"));
			labelPrecioPan.setForeground(Color.WHITE);
			labelPrecioPan.setBounds(150, 347, 125, 13);
			contentPane.add(labelPrecioPan);
			con.disconnect();
		} catch (DBException e2) {
			// TODO Auto-generated catch block
						e2.printStackTrace();
		}
		
		JButton botonDonuts = new JButton("A\u00F1adir");
		botonDonuts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					con.connect();
					Producto bollo4 = new Producto();
					bollo4.setNombre("Donuts");
					bollo4.setPrecio(con.obtenerPrecioProducto(bollo4.getNombre()));
					con.anadirProductoACarrito(bollo4);
					con.disconnect();
					}catch(DBException e) {
						e.printStackTrace();
					}
			}
		});
		botonDonuts.setBounds(309, 106, 85, 21);
		contentPane.add(botonDonuts);
		
		JButton botonPan = new JButton("A\u00F1adir");
		botonPan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					con.connect();
					Producto bollo3 = new Producto();
					bollo3.setNombre("Pan");
					bollo3.setPrecio(con.obtenerPrecioProducto(bollo3.getNombre()));
					con.anadirProductoACarrito(bollo3);
					con.disconnect();
					}catch(DBException e) {
						e.printStackTrace();
					}
			}
		});
		botonPan.setBounds(309, 367, 85, 21);
		contentPane.add(botonPan);
		
		JButton botonPalmeritas = new JButton("A\u00F1adir");
		botonPalmeritas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					con.connect();
					Producto bollo1 = new Producto();
					bollo1.setNombre("Palmeritas");
					bollo1.setPrecio(con.obtenerPrecioProducto(bollo1.getNombre()));
					con.anadirProductoACarrito(bollo1);
					con.disconnect();
					}catch(DBException e) {
						e.printStackTrace();
					}
			}
		});
		botonPalmeritas.setBounds(309, 174, 85, 21);
		contentPane.add(botonPalmeritas);
		
		JButton botonNapolitana = new JButton("A\u00F1adir");
		botonNapolitana.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					con.connect();
					Producto bollo2 = new Producto();
					bollo2.setNombre("Napolitana");
					bollo2.setPrecio(con.obtenerPrecioProducto(bollo2.getNombre()));
					con.anadirProductoACarrito(bollo2);
					con.disconnect();
					}catch(DBException e) {
						e.printStackTrace();
					}
			}
		});
		botonNapolitana.setBounds(309, 269, 85, 21);
		contentPane.add(botonNapolitana);
		
		JButton botonVolver = new JButton("Volver");
		botonVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaMenu menu = new VentanaMenu();
				menu.setVisible(true);
				dispose();
			}
		});
		botonVolver.setBounds(50, 425, 85, 21);
		contentPane.add(botonVolver);
		
		JButton botonVerCarrito = new JButton("Ver carrito");
		botonVerCarrito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		botonVerCarrito.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaCarrito carrito = new VentanaCarrito();
				carrito.setVisible(true);
				dispose();
			}
		});
		botonVerCarrito.setBounds(164, 425, 94, 21);
		contentPane.add(botonVerCarrito);
		
		JLabel labelDonuts = new JLabel("Foto");
		labelDonuts.setBounds(10, 68, 85, 75);
		contentPane.add(labelDonuts);
		ImageIcon ico4 = new ImageIcon("imagenes/donuts.JPG");
        ImageIcon img4 = new ImageIcon(ico4.getImage().getScaledInstance(labelDonuts.getWidth(), labelDonuts.getHeight(), Image.SCALE_SMOOTH));
        labelDonuts.setIcon(img4);
		contentPane.add(labelDonuts);
		
		JLabel labelPalmeritas = new JLabel("Foto");
		labelPalmeritas.setBounds(10, 151, 85, 81);
		contentPane.add(labelPalmeritas);
		ImageIcon ico3 = new ImageIcon("imagenes/palmeritas.JPG");
        ImageIcon img3 = new ImageIcon(ico3.getImage().getScaledInstance(labelPalmeritas.getWidth(), labelPalmeritas.getHeight(), Image.SCALE_SMOOTH));
        labelPalmeritas.setIcon(img3);
		contentPane.add(labelPalmeritas);
		
		JLabel labelPan = new JLabel("Foto");
		labelPan.setBounds(10, 329, 85, 75);
		contentPane.add(labelPan);
		ImageIcon ico2 = new ImageIcon("imagenes/pan.JPG");
        ImageIcon img2 = new ImageIcon(ico2.getImage().getScaledInstance(labelPan.getWidth(), labelPan.getHeight(), Image.SCALE_SMOOTH));
        labelPan.setIcon(img2);
		contentPane.add(labelPan);
		
		JLabel labelNapolitana = new JLabel("Foto");
		labelNapolitana.setBounds(10, 238, 85, 75);
		contentPane.add(labelNapolitana);
		ImageIcon ico1 = new ImageIcon("imagenes/napolitana.JPG");
        ImageIcon img1 = new ImageIcon(ico1.getImage().getScaledInstance(labelNapolitana.getWidth(), labelNapolitana.getHeight(), Image.SCALE_SMOOTH));
        labelNapolitana.setIcon(img1);
		contentPane.add(labelNapolitana);
		
		JButton btnNewButton = new JButton("Cambiar Seccion");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaCarniceria carniceria = new VentanaCarniceria();
				carniceria.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(282, 425, 138, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("PANADERIA");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel.setBounds(100, 36, 116, 29);
		contentPane.add(lblNewLabel);
		
		JLabel labelFondo = new JLabel("");
		labelFondo.setHorizontalAlignment(SwingConstants.TRAILING);
		labelFondo.setBounds(0, 0, 438, 456);
		ImageIcon icon = new ImageIcon("imagenes/fondos.jpg");
        ImageIcon img5 = new ImageIcon(icon.getImage().getScaledInstance(labelFondo.getWidth(), labelFondo.getHeight(), Image.SCALE_SMOOTH));
        labelFondo.setIcon(img5);
		contentPane.add(labelFondo);
	}
}