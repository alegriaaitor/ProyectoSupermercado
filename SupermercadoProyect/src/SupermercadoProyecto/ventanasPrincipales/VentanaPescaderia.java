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



public class VentanaPescaderia extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPescaderia frame = new VentanaPescaderia();
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
	public VentanaPescaderia() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel nombreProducto1 = new JLabel("Merluza (500g)");
		nombreProducto1.setForeground(Color.WHITE);
		nombreProducto1.setBounds(150, 87, 244, 13);
		contentPane.add(nombreProducto1);
		
		
		JLabel lblProducto = new JLabel("Sardina (250g)");
		lblProducto.setForeground(Color.WHITE);
		lblProducto.setBounds(150, 151, 244, 13);
		contentPane.add(lblProducto);
		
		JLabel lblProducto_1 = new JLabel("Salmonete (300g)");
		lblProducto_1.setForeground(Color.WHITE);
		lblProducto_1.setBounds(150, 238, 244, 13);
		contentPane.add(lblProducto_1);
		
		JLabel lblProducto_2 = new JLabel("Lenguado (250g)");
		lblProducto_2.setForeground(Color.WHITE);
		lblProducto_2.setBounds(150, 315, 244, 13);
		contentPane.add(lblProducto_2);
		
		DBManager con = new DBManager();
		JLabel labelPrecioMerluza;
		try {
			con.connect();
			labelPrecioMerluza = new JLabel("Precio: " + con.obtenerPrecioProducto("Merluza"));
			labelPrecioMerluza.setForeground(Color.WHITE);
			labelPrecioMerluza.setBounds(150, 110, 149, 13);
			contentPane.add(labelPrecioMerluza);
			con.disconnect();
		} catch (DBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {			
			con.connect();
			JLabel labelPrecioSardina = new JLabel("Precio: " + con.obtenerPrecioProducto("Sardina"));
			labelPrecioSardina.setForeground(Color.WHITE);
			labelPrecioSardina.setBounds(150, 178, 138, 13);
			contentPane.add(labelPrecioSardina);
			con.disconnect();
		} catch (DBException e2) {
			// TODO Auto-generated catch block
						e2.printStackTrace();
		}
		
		try {			
			con.connect();
			JLabel labelPrecioSalmonete = new JLabel("Precio: " + con.obtenerPrecioProducto("Salmonete"));
			labelPrecioSalmonete.setForeground(Color.WHITE);
			labelPrecioSalmonete.setBounds(150, 256, 125, 13);
			contentPane.add(labelPrecioSalmonete);
			con.disconnect();
		} catch (DBException e2) {
			// TODO Auto-generated catch block
						e2.printStackTrace();
		}
			
		try {			
			con.connect();
			JLabel labelPrecioLenguado = new JLabel("Precio: " + con.obtenerPrecioProducto("Lenguado"));
			labelPrecioLenguado.setForeground(Color.WHITE);
			labelPrecioLenguado.setBounds(150, 347, 125, 13);
			contentPane.add(labelPrecioLenguado);
			con.disconnect();
		} catch (DBException e2) {
			// TODO Auto-generated catch block
						e2.printStackTrace();
		}
		
		JButton botonAnadir1 = new JButton("A\u00F1adir");
		botonAnadir1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					con.connect();
					Producto pescado1 = new Producto();
					pescado1.setNombre("Merluza");
					pescado1.setPrecio(con.obtenerPrecioProducto("Merluza"));
					con.anadirProductoACarrito(pescado1);
					con.disconnect();
					}catch(DBException e) {
						e.printStackTrace();
					}
					
			}
		});
		botonAnadir1.setBounds(309, 106, 85, 21);
		contentPane.add(botonAnadir1);
		
		JButton botonAnadir4 = new JButton("A\u00F1adir");
		botonAnadir4.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						try {
							con.connect();
							Producto pescado1 = new Producto();
							pescado1.setNombre("Lenguado");
							pescado1.setPrecio(con.obtenerPrecioProducto("Lenguado"));
							con.anadirProductoACarrito(pescado1);
							con.disconnect();
							}catch(DBException e) {
								e.printStackTrace();
							}
							
					}
				});
		botonAnadir4.setBounds(309, 367, 85, 21);
		contentPane.add(botonAnadir4);
		
		JButton botonAnadir2 = new JButton("A\u00F1adir");
		botonAnadir2.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						try {
							con.connect();
							Producto pescado1 = new Producto();
							pescado1.setNombre("Sardina");
							pescado1.setPrecio(con.obtenerPrecioProducto("Sardina"));
							con.anadirProductoACarrito(pescado1);
							con.disconnect();
							}catch(DBException e) {
								e.printStackTrace();
							}
							
					}
				});
		botonAnadir2.setBounds(309, 174, 85, 21);
		contentPane.add(botonAnadir2);
		
		JButton botonAnadir3 = new JButton("A\u00F1adir");
		botonAnadir3.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						try {
							con.connect();
							Producto pescado1 = new Producto();
							pescado1.setNombre("Salmonete");
							pescado1.setPrecio(con.obtenerPrecioProducto("Salmonete"));
							con.anadirProductoACarrito(pescado1);
							con.disconnect();
							}catch(DBException e) {
								e.printStackTrace();
							}
							
					}
				});
		botonAnadir3.setBounds(309, 269, 85, 21);
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
		
		JLabel labelSardina = new JLabel("Foto");
		labelSardina.setBounds(10, 160, 111, 48);
		contentPane.add(labelSardina);
		ImageIcon ico4 = new ImageIcon("imagenes/sardina.png");
        ImageIcon img4 = new ImageIcon(ico4.getImage().getScaledInstance(labelSardina.getWidth(), labelSardina.getHeight(), Image.SCALE_SMOOTH));
        labelSardina.setIcon(img4);
		contentPane.add(labelSardina);
		
		JLabel labelSalmonete = new JLabel("Foto");
		labelSalmonete.setBounds(10, 238, 111, 48);
		contentPane.add(labelSalmonete);
		ImageIcon ico3 = new ImageIcon("imagenes/salmonete.png");
        ImageIcon img3 = new ImageIcon(ico3.getImage().getScaledInstance(labelSalmonete.getWidth(), labelSalmonete.getHeight(), Image.SCALE_SMOOTH));
        labelSalmonete.setIcon(img3);
		contentPane.add(labelSalmonete);
		
		JLabel labelLenguado = new JLabel("Foto");
		labelLenguado.setBounds(10, 329, 111, 48);
		contentPane.add(labelLenguado);
		ImageIcon ico2 = new ImageIcon("imagenes/lenguado.png");
        ImageIcon img2 = new ImageIcon(ico2.getImage().getScaledInstance(labelLenguado.getWidth(), labelLenguado.getHeight(), Image.SCALE_SMOOTH));
        labelLenguado.setIcon(img2);
		contentPane.add(labelLenguado);
		
		JLabel labelMerluza = new JLabel("Foto");
		labelMerluza.setBounds(10, 75, 111, 48);
		contentPane.add(labelMerluza);
		ImageIcon ico1 = new ImageIcon("imagenes/merluza.png");
        ImageIcon img1 = new ImageIcon(ico1.getImage().getScaledInstance(labelMerluza.getWidth(), labelMerluza.getHeight(), Image.SCALE_SMOOTH));
        labelMerluza.setIcon(img1);
		contentPane.add(labelMerluza);
		
		JButton btnNewButton = new JButton("Cambiar Seccion");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaPanaderia panaderia = new VentanaPanaderia();
				panaderia.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(282, 425, 138, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("PESCADERIA");
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