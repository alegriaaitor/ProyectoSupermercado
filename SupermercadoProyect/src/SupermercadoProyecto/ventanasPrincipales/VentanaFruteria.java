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



public class VentanaFruteria extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaFruteria frame = new VentanaFruteria();
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
	public VentanaFruteria() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel nombreProducto1 = new JLabel("Manzana (1kg)");
		nombreProducto1.setBounds(111, 44, 244, 13);
		contentPane.add(nombreProducto1);
		
		
		JLabel nombreProducto2 = new JLabel("Platano (1kg)");
		nombreProducto2.setBounds(111, 139, 244, 13);
		contentPane.add(nombreProducto2);
		
		JLabel nombreProducto3 = new JLabel("Pera (1kg)");
		nombreProducto3.setBounds(111, 237, 244, 13);
		contentPane.add(nombreProducto3);
		
		JLabel nombreProducto4 = new JLabel("Mel�n (1kg)");
		nombreProducto4.setBounds(111, 329, 244, 13);
		contentPane.add(nombreProducto4);
		
		DBManager con = new DBManager();
		JLabel labelPrecioManzana;
		try {
			con.connect();
			labelPrecioManzana = new JLabel("Precio: " + con.obtenerPrecioProducto("Manzana "));
			labelPrecioManzana.setBounds(111, 79, 149, 13);
			contentPane.add(labelPrecioManzana);
			con.disconnect();
		} catch (DBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		JLabel labelPrecioPlatano = new JLabel("Precio");
		try {
			con.connect();
			labelPrecioPlatano = new JLabel("Precio: " + con.obtenerPrecioProducto("Platano "));
			labelPrecioPlatano.setBounds(111, 79, 149, 13);
			contentPane.add(labelPrecioPlatano);
			con.disconnect();
		} catch (DBException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		JLabel labelPrecioPera = new JLabel("Precio");
		try {
			con.connect();
			labelPrecioPera = new JLabel("Precio: " + con.obtenerPrecioProducto("Pera "));
			labelPrecioPera.setBounds(111, 79, 149, 13);
			contentPane.add(labelPrecioPera);
			con.disconnect();
		} catch (DBException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		
		
		JLabel labelPrecioMelon = new JLabel("Precio");
		try {
			con.connect();
			labelPrecioMelon = new JLabel("Precio: " + con.obtenerPrecioProducto("Melon "));
			labelPrecioMelon.setBounds(111, 79, 149, 13);
			contentPane.add(labelPrecioMelon);
			con.disconnect();
		} catch (DBException e4) {
			// TODO Auto-generated catch block
			e4.printStackTrace();
		}
		
		JButton botonAnadir1 = new JButton("A\u00F1adir");
		botonAnadir1.setBounds(294, 75, 85, 21);
		contentPane.add(botonAnadir1);
		
		JButton botonAnadir4 = new JButton("A\u00F1adir");
		botonAnadir4.setBounds(294, 352, 85, 21);
		contentPane.add(botonAnadir4);
		
		JButton botonAnadir2 = new JButton("A\u00F1adir");
		botonAnadir2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		botonAnadir2.setBounds(294, 174, 85, 21);
		contentPane.add(botonAnadir2);
		
		JButton botonAnadir3 = new JButton("A\u00F1adir");
		botonAnadir3.setBounds(294, 269, 85, 21);
		contentPane.add(botonAnadir3);
		
		JButton botonVolver = new JButton("Volver");
		botonVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaMenu menu = new VentanaMenu();
				menu.setVisible(true);
				dispose();
			}
		});
		botonVolver.setBounds(111, 425, 85, 21);
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
		botonVerCarrito.setBounds(237, 425, 94, 21);
		contentPane.add(botonVerCarrito);
		
		JLabel labelPlatano = new JLabel("Foto");
		labelPlatano.setBounds(26, 139, 75, 75);
		contentPane.add(labelPlatano);
		ImageIcon ico4 = new ImageIcon("imagenes/solomillo.png");
        ImageIcon img4 = new ImageIcon(ico4.getImage().getScaledInstance(labelPlatano.getWidth(), labelPlatano.getHeight(), Image.SCALE_SMOOTH));
        labelPlatano.setIcon(img4);
		contentPane.add(labelPlatano);
		
		JLabel labelPera = new JLabel("Foto");
		labelPera.setBounds(26, 237, 75, 75);
		contentPane.add(labelPera);
		ImageIcon ico3 = new ImageIcon("imagenes/chuleton.png");
        ImageIcon img3 = new ImageIcon(ico3.getImage().getScaledInstance(labelPera.getWidth(), labelPera.getHeight(), Image.SCALE_SMOOTH));
        labelPera.setIcon(img3);
		contentPane.add(labelPera);
		
		JLabel labelMelon = new JLabel("Foto");
		labelMelon.setBounds(26, 329, 75, 75);
		contentPane.add(labelMelon);
		ImageIcon ico2 = new ImageIcon("imagenes/criollo.png");
        ImageIcon img2 = new ImageIcon(ico2.getImage().getScaledInstance(labelMelon.getWidth(), labelMelon.getHeight(), Image.SCALE_SMOOTH));
        labelMelon.setIcon(img2);
		contentPane.add(labelMelon);
		
		JLabel labelManzana = new JLabel("Foto");
		labelManzana.setBounds(26, 48, 75, 75);
		contentPane.add(labelManzana);
		ImageIcon ico1 = new ImageIcon("imagenes/chuleton.png");
        ImageIcon img1 = new ImageIcon(ico1.getImage().getScaledInstance(labelManzana.getWidth(), labelManzana.getHeight(), Image.SCALE_SMOOTH));
        labelManzana.setIcon(img1);
		contentPane.add(labelManzana);
	}
}
