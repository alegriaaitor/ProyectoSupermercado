package SupermercadoProyecto.ventanasPrincipales;
import java.awt.*;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
import SupermercadoProyecto.ventanasPrincipales.*;

import ConexionBD.*;

public class VentanaRegistro extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField texto_email;
	private JPasswordField texto_contrasena;
	private JTextField textField_3;
	private JTextField texto_usuario;
	private JTextField texto_direccion;
	private ButtonGroup sexo = new ButtonGroup();
	final VentanaPrincipal principal = new VentanaPrincipal();
	
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistro frame = new VentanaRegistro();
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
	public VentanaRegistro() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 582, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Introduzca los siguientes datos:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(31, 54, 200, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Registrar nuevo usuario");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(31, 23, 179, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(31, 97, 70, 17);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(101, 97, 118, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Apellido");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_1.setBounds(31, 137, 70, 17);
		contentPane.add(lblNewLabel_2_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(101, 137, 118, 19);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Correo electr\u00F3nico");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_1_1.setBounds(31, 181, 112, 17);
		contentPane.add(lblNewLabel_2_1_1);
		
		texto_email = new JTextField();
		texto_email.setColumns(10);
		texto_email.setBounds(156, 181, 169, 19);
		contentPane.add(texto_email);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Contrase\u00F1a");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_1_1_1.setBounds(31, 223, 82, 17);
		contentPane.add(lblNewLabel_2_1_1_1);
		
		texto_contrasena = new JPasswordField();
		texto_contrasena.setBounds(123, 223, 144, 19);
		contentPane.add(texto_contrasena);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Numero de contacto");
		lblNewLabel_2_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_1_1_1_1.setBounds(31, 265, 136, 17);
		contentPane.add(lblNewLabel_2_1_1_1_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(161, 265, 169, 19);
		contentPane.add(textField_3);
		
		JLabel lblNewLabel_2_2 = new JLabel("Usuario");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_2.setBounds(260, 97, 70, 17);
		contentPane.add(lblNewLabel_2_2);
		
		texto_usuario = new JTextField();
		texto_usuario.setColumns(10);
		texto_usuario.setBounds(334, 97, 118, 19);
		contentPane.add(texto_usuario);
		
		JLabel lblNewLabel_2_3 = new JLabel("Sexo");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_3.setBounds(260, 137, 70, 17);
		contentPane.add(lblNewLabel_2_3);
		
		JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setBounds(327, 136, 98, 21);
		contentPane.add(rdbtnMasculino);
		
		JRadioButton rdbtnFemenino = new JRadioButton("Femenino");
		rdbtnFemenino.setBounds(427, 136, 82, 21);
		contentPane.add(rdbtnFemenino);
		
		sexo.add(rdbtnFemenino);
		sexo.add(rdbtnMasculino);
		
		
		JLabel lblNewLabel_2_1_1_1_1_1 = new JLabel("Direcci\u00F3n de contacto");
		lblNewLabel_2_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_1_1_1_1_1.setBounds(31, 304, 136, 17);
		contentPane.add(lblNewLabel_2_1_1_1_1_1);
		
		texto_direccion = new JTextField();
		texto_direccion.setColumns(10);
		texto_direccion.setBounds(161, 304, 169, 19);
		contentPane.add(texto_direccion);
		
		
		JButton btnRegistrar = new JButton("Finalizar registro");
		btnRegistrar.setBounds(388, 303, 153, 33);
		contentPane.add(btnRegistrar);
		btnRegistrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String nombreUsuario;
				String contrasena;
				String email;
				String direccion;
				
				nombreUsuario = texto_usuario.getText();
				contrasena = String.valueOf(texto_contrasena.getPassword());
				email = texto_email.getText();
				direccion = texto_direccion.getText();
				
				if (nombreUsuario.equals("") || contrasena.equals("") || email.equals("") || direccion.equals("")) {
					JOptionPane.showMessageDialog(null, "Es necesario rellenar todos los campos", "Error", 0);
					
				}else {
					
					if (email.contains("@") && email.contains(".")) {
				
						Usuario usuario = new Usuario();
						usuario.setNombreUsuario(nombreUsuario);
						usuario.setcontrasena(contrasena);
						usuario.setEmail(email);
						usuario.setDireccion(direccion);
						
						DBManager conexion = new DBManager();
						
						try {
							conexion.connect();
							
								conexion.registrarUsuario(usuario);
								
								JOptionPane.showMessageDialog(null, "Cuenta creada correctamente", "Correcto", 1);					
							
								
								VentanaInicioSesion ini = new VentanaInicioSesion(); 
								setVisible(false);
								ini.setVisible(true);
							conexion.disconnect();
							
						} catch (DBException e1) {
							e1.printStackTrace();
						}
				
					}else {
						JOptionPane.showMessageDialog(null, "Direccion de correo no validaa", "Error", 0);
						
					}
				}
			}
			
		});
		
		JLabel lblNewLabel_3 = new JLabel("\u00BFYa dispone de una cuenta?");
		lblNewLabel_3.setBounds(270, 29, 161, 13);
		contentPane.add(lblNewLabel_3);
		
		JButton btnIniciarSesion = new JButton("Iniciar Sesion");
		
		
		btnIniciarSesion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaInicioSesion inicio = new VentanaInicioSesion();
				inicio.setVisible(true);
				setVisible(false);
			}
		});
		btnIniciarSesion.setBounds(441, 27, 117, 17);
		contentPane.add(btnIniciarSesion);
		
		
		
	}
}
