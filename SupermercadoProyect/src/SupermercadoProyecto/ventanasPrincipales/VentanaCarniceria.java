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
		setBounds(100, 100, 452, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel nombreProducto1 = new JLabel("Chuleton de vaca (500g)");
		nombreProducto1.setBounds(111, 44, 244, 13);
		contentPane.add(nombreProducto1);
		
		JLabel lblProducto = new JLabel("Solomillo de ternera (250g)");
		lblProducto.setBounds(111, 139, 244, 13);
		contentPane.add(lblProducto);
		
		JLabel lblProducto_1 = new JLabel("Entrecot de ternera (300g)");
		lblProducto_1.setBounds(111, 237, 244, 13);
		contentPane.add(lblProducto_1);
		
		JLabel lblProducto_2 = new JLabel("Chorizo criollo (250g)");
		lblProducto_2.setBounds(111, 329, 244, 13);
		contentPane.add(lblProducto_2);
		
		DBManager con = new DBManager();
		JLabel labelPrecioChuleton;
		try {
			con.connect();
			labelPrecioChuleton = new JLabel("Precio: " + con.obtenerPrecioProducto("Chuleton de vaca"));
			labelPrecioChuleton.setBounds(111, 79, 149, 13);
			contentPane.add(labelPrecioChuleton);
			con.disconnect();
		} catch (DBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		JLabel lblNewLabel_2_1 = new JLabel("Precio");
		lblNewLabel_2_1.setBounds(111, 178, 45, 13);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Precio");
		lblNewLabel_2_2.setBounds(111, 273, 45, 13);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Precio");
		lblNewLabel_2_3.setBounds(111, 371, 45, 13);
		contentPane.add(lblNewLabel_2_3);
		
		JButton botonAnadir1 = new JButton("A\u00F1adir");
		botonAnadir1.setBounds(270, 75, 85, 21);
		contentPane.add(botonAnadir1);
		
		JButton btnNewButton_1 = new JButton("A\u00F1adir");
		btnNewButton_1.setBounds(237, 367, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("A\u00F1adir");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_2.setBounds(237, 174, 85, 21);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("A\u00F1adir");
		btnNewButton_3.setBounds(237, 269, 85, 21);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_8 = new JButton("Volver");
		btnNewButton_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaMenu menu = new VentanaMenu();
				menu.setVisible(true);
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
		
		JLabel labelChuleton = new JLabel("");
		//ImageIcon icono1 = new ImageIcon(getClass().getResource("../SupermercadoProyect/imagenes/carniceria.jpg"));
		//labelChuleton.setIcon(icono1);
	    
		labelChuleton.setBounds(26, 44, 75, 75);
		contentPane.add(labelChuleton);
		
		JLabel labelSolomillo = new JLabel("New label");
		labelSolomillo.setBounds(26, 139, 75, 75);
		contentPane.add(labelSolomillo);
		
		JLabel labelEntrecot = new JLabel("New label");
		labelEntrecot.setBounds(26, 237, 75, 75);
		contentPane.add(labelEntrecot);
		
		JLabel labelChorizo = new JLabel("New label");
		labelChorizo.setBounds(26, 329, 75, 75);
		contentPane.add(labelChorizo);
	}
}
