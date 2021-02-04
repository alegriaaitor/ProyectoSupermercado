package SupermercadoProyecto.ventanasPrincipales;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ConexionBD.DBManager;

public class VentanaPanelProductosCarnicos extends JPanel {

	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public VentanaPanelProductosCarnicos(String textoNombre, String foto, double textoPrecio) {
		
		setBackground(Color.BLACK);
		setLayout(null);
		
		JLabel lblFoto = new JLabel(foto);
		lblFoto.setForeground(Color.WHITE);
		lblFoto.setBounds(32, 10, 170, 124);
		add(lblFoto);
		ImageIcon ico = new ImageIcon(foto);
        ImageIcon img = new ImageIcon(ico.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_SMOOTH));
        lblFoto.setIcon(img);
		
		JLabel lblCarnico= new JLabel(textoNombre);
		lblCarnico.setForeground(Color.WHITE);
		lblCarnico.setBounds(32, 144, 130, 13);
		add(lblCarnico);
		
		JLabel lblPrecio = new JLabel(Double.toString(textoPrecio )+ " €");
		lblPrecio.setForeground(Color.WHITE);
		lblPrecio.setBounds(32, 166, 44, 13);
		add(lblPrecio);
	
		
		JButton botonAnadir = new JButton("Añadir al Carrito");
		botonAnadir.setBounds(30, 200, 130, 23);
		add(botonAnadir);
		
		DBManager dbmanager = new DBManager();
		
		botonAnadir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					dbmanager.connect();
					Carnico c = new Carnico();
					c.setNombre(textoNombre);
					c.setPrecio(textoPrecio);
					dbmanager.anadirCarnicoACarrito(c);
					dbmanager.disconnect();
					
					dbmanager.disconnect();
				} catch (Exception e2) {
					// TODO: handle exception
				}
					
				
			}
		});
		
		
	
	}

}
