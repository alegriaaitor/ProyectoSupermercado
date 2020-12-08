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
		nombreProducto1.setBounds(150, 87, 244, 13);
		contentPane.add(nombreProducto1);
		
		
		JLabel lblProducto = new JLabel("Sardina de altamar (250g)");
		lblProducto.setBounds(150, 151, 244, 13);
		contentPane.add(lblProducto);
		
		JLabel lblProducto_1 = new JLabel("Salmonete (300g)");
		lblProducto_1.setBounds(150, 238, 244, 13);
		contentPane.add(lblProducto_1);
		
		JLabel lblProducto_2 = new JLabel("Lenguado (250g)");
		lblProducto_2.setBounds(150, 315, 244, 13);
		contentPane.add(lblProducto_2);
		
		DBManager con = new DBManager();
		JLabel labelPrecioChuleton;
		try {
			con.connect();
			labelPrecioChuleton = new JLabel("Precio: " + con.obtenerPrecioProducto("Chuleton de vaca"));
			labelPrecioChuleton.setBounds(150, 110, 149, 13);
			contentPane.add(labelPrecioChuleton);
			con.disconnect();
		} catch (DBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		JLabel lblNewLabel_2_1 = new JLabel("Precio");
		lblNewLabel_2_1.setBounds(160, 174, 45, 13);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Precio");
		lblNewLabel_2_2.setBounds(160, 261, 45, 13);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Precio");
		lblNewLabel_2_3.setBounds(160, 347, 45, 13);
		contentPane.add(lblNewLabel_2_3);
		
		JButton botonAnadir1 = new JButton("A\u00F1adir");
		botonAnadir1.setBounds(309, 106, 85, 21);
		contentPane.add(botonAnadir1);
		
		JButton btnNewButton_1 = new JButton("A\u00F1adir");
		btnNewButton_1.setBounds(309, 367, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("A\u00F1adir");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_2.setBounds(309, 174, 85, 21);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("A\u00F1adir");
		btnNewButton_3.setBounds(309, 269, 85, 21);
		contentPane.add(btnNewButton_3);
		
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
	}
}
