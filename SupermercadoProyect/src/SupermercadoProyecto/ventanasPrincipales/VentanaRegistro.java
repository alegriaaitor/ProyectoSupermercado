package SupermercadoProyecto.ventanasPrincipales;
import java.awt.*;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import javax.swing.JOptionPane;
import SupermercadoProyecto.ventanasPrincipales.*;

import ConexionBD.*;

public class VentanaRegistro extends JFrame {

	private JPanel contentPane;
	private JTextField textoNombre;
	private JTextField textoApellido;
	private JTextField texto_email;
	private JPasswordField texto_contrasena;
	private JTextField textNumero;
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
		
		JLabel labelIntroducirDatos = new JLabel("Introduzca los siguientes datos:");
		labelIntroducirDatos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelIntroducirDatos.setBounds(31, 54, 200, 33);
		contentPane.add(labelIntroducirDatos);
		
		JLabel labelRegistrarNuevoUsuario = new JLabel("Registrar nuevo usuario");
		labelRegistrarNuevoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelRegistrarNuevoUsuario.setBounds(31, 23, 179, 21);
		contentPane.add(labelRegistrarNuevoUsuario);
		
		JLabel labelNombre = new JLabel("Nombre");
		labelNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelNombre.setBounds(31, 97, 70, 17);
		contentPane.add(labelNombre);
		
		textoNombre = new JTextField();
		textoNombre.setBounds(101, 97, 118, 19);
		contentPane.add(textoNombre);
		textoNombre.setColumns(10);
		
		JLabel lableApellido = new JLabel("Apellido");
		lableApellido.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lableApellido.setBounds(31, 137, 70, 17);
		contentPane.add(lableApellido);
		
		textoApellido = new JTextField();
		textoApellido.setColumns(10);
		textoApellido.setBounds(101, 137, 118, 19);
		contentPane.add(textoApellido);
		
		JLabel labelEmail = new JLabel("Correo electr\u00F3nico");
		labelEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelEmail.setBounds(31, 181, 112, 17);
		contentPane.add(labelEmail);
		
		texto_email = new JTextField();
		texto_email.setColumns(10);
		texto_email.setBounds(156, 181, 169, 19);
		contentPane.add(texto_email);
		
		JLabel labelContrasena = new JLabel("Contrase\u00F1a");
		labelContrasena.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelContrasena.setBounds(31, 223, 82, 17);
		contentPane.add(labelContrasena);
		
		texto_contrasena = new JPasswordField();
		texto_contrasena.setBounds(123, 223, 144, 19);
		contentPane.add(texto_contrasena);
		
		JLabel labelDireccion = new JLabel("Numero de contacto");
		labelDireccion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelDireccion.setBounds(31, 265, 136, 17);
		contentPane.add(labelDireccion);
		
		textNumero = new JTextField();
		textNumero.setColumns(10);
		textNumero.setBounds(161, 265, 169, 19);
		contentPane.add(textNumero);
		
		JLabel labelUsuario = new JLabel("Usuario");
		labelUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelUsuario.setBounds(260, 97, 70, 17);
		contentPane.add(labelUsuario);
		
		texto_usuario = new JTextField();
		texto_usuario.setColumns(10);
		texto_usuario.setBounds(334, 97, 118, 19);
		contentPane.add(texto_usuario);
		
		JLabel labelSexo = new JLabel("Sexo");
		labelSexo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelSexo.setBounds(260, 137, 70, 17);
		contentPane.add(labelSexo);
		
		JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setBounds(327, 136, 98, 21);
		contentPane.add(rdbtnMasculino);
		
		JRadioButton rdbtnFemenino = new JRadioButton("Femenino");
		rdbtnFemenino.setBounds(427, 136, 82, 21);
		contentPane.add(rdbtnFemenino);
		
		sexo.add(rdbtnFemenino);
		sexo.add(rdbtnMasculino);
		
		
		JLabel labelD = new JLabel("Direcci\u00F3n de contacto");
		labelD.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelD.setBounds(31, 304, 136, 17);
		contentPane.add(labelD);
		
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
				int i = 1;
				
				nombreUsuario = texto_usuario.getText();
				contrasena = String.valueOf(texto_contrasena.getPassword());
				email = texto_email.getText();
				direccion = texto_direccion.getText();
				HashMap<String, Usuario> usuarios = new HashMap<String, Usuario>();
				File archivo;
				
				FileWriter escribir;
				PrintWriter linea;
				
				archivo = new File("usuarios.txt");
				if(!archivo.exists()) {
					try {
						archivo.createNewFile();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				}else {
					try { //Metemos en el fichero de texto el nombre de usuario y contraseña para posteriormente poder acceder mediante inicio sesion
						escribir = new FileWriter(archivo,true);
						linea = new PrintWriter(escribir);
						
						linea.println(nombreUsuario);
						linea.println(contrasena);
						linea.close();
						escribir.close();
					} catch (FileNotFoundException | UnsupportedEncodingException e3) {
						// TODO Auto-generated catch block
						e3.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
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
								usuarios.put(nombreUsuario, usuario);
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
		
		JLabel labelDisponerDeCuenta = new JLabel("\u00BFYa dispone de una cuenta?");
		labelDisponerDeCuenta.setBounds(270, 29, 161, 13);
		contentPane.add(labelDisponerDeCuenta);
		
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
