import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import SupermercadoProyecto.ventanasPrincipales.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.UIManager;
import javax.swing.border.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;

public class VentanaInicioSesion extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUsuario;
	final VentanaRegistro registro1 = new VentanaRegistro();
	private JPasswordField passwordFieldContrasena;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInicioSesion frame = new VentanaInicioSesion();
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
	public VentanaInicioSesion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 397, 533);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Inicio Sesion");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(45, 38, 133, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Usuario");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(45, 110, 88, 29);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Contrasena");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(45, 205, 88, 29);
		contentPane.add(lblNewLabel_1_1);
		
		passwordFieldContrasena = new JPasswordField();
		passwordFieldContrasena.setBounds(45, 244, 281, 29);
		contentPane.add(passwordFieldContrasena);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(45, 149, 281, 29);
		contentPane.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		JButton botonIniciarSesion = new JButton("Iniciar Sesion");
		botonIniciarSesion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String usuario = textFieldUsuario.getText();
				String contrasena = String.valueOf(passwordFieldContrasena.getPassword());
				
				//GestionUsuario gestionUsuario = new GestionUsuario();
				
				Usuario usuario2 = new Usuario();
				usuario2.setNombreUsuario(usuario);
				usuario2.setcontrasena(contrasena);
				
			//	Usuario u = gestionUsuario.obtenerUsuario(usuario2);
				
			/*	if(u != null) {
					JOptionPane.showMessageDialog(contentPane, "Bienvendo a SuperSupermercado!");
					VentanaMenu menu = new VentanaMenu();
					menu.setVisible(true);
					dispose();
				}else {
					JOptionPane.showMessageDialog(contentPane, "El usuario introducido no esta en la base de datos","Error",JOptionPane.ERROR_MESSAGE);
				}
			*/	
				
				
			}
		});
		botonIniciarSesion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		botonIniciarSesion.setBounds(118, 319, 133, 35);
		contentPane.add(botonIniciarSesion);
		
		JTextArea txtryaDisponesDe = new JTextArea();
		txtryaDisponesDe.setBackground(UIManager.getColor("Button.background"));
		txtryaDisponesDe.setEditable(false);
		txtryaDisponesDe.setForeground(Color.BLACK);
		txtryaDisponesDe.setText("\u00BFTodav\u00EDa no dispones de una cuenta?");
		txtryaDisponesDe.setBounds(10, 389, 295, 29);
		contentPane.add(txtryaDisponesDe);
		
		JButton btnRegistrarse = new JButton("Registrate");
		btnRegistrarse.setForeground(Color.BLACK);
		btnRegistrarse.setBackground(UIManager.getColor("Button.background"));
		btnRegistrarse.setBounds(20, 419, 140, 21);
		contentPane.add(btnRegistrarse);
		
		
		
		btnRegistrarse.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				registro1.setVisible(true);
				dispose();
				
				
			}
			
		});
	}
}
