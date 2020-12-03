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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.UIManager;
import javax.swing.border.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileWriter;
import ConexionBD.*;
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
		
		JLabel Texto_usuario = new JLabel("Usuario");
		Texto_usuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Texto_usuario.setBounds(45, 110, 88, 29);
		contentPane.add(Texto_usuario);
		
		JLabel texto_contrasena = new JLabel("Contrasena");
		texto_contrasena.setFont(new Font("Tahoma", Font.PLAIN, 15));
		texto_contrasena.setBounds(45, 205, 88, 29);
		contentPane.add(texto_contrasena);
		
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
		
		//BOTON INICIAR SESION
				botonIniciarSesion.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {

						String nombreUsuario = Texto_usuario.getText();
						String contrasena = texto_contrasena.getText();

						DBManager conexion = new DBManager();

						try {
							conexion.connect();

							if (conexion.loginUsuario(nombreUsuario, contrasena) == true) {
								id_usuario = conexion.obtenerId(nombreUsuario);
								VentanaMenu vm = new VentanaMenu();
								setVisible(false);
								vm.setVisible(true);

							} else {
								JOptionPane.showMessageDialog(null, "No se ha podido iniciar sesion", "Error", 0);
								Texto_usuario.setText("");
								texto_contrasena.setText("");
							}

							conexion.disconnect();

						} catch (DBException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

						if (checkGuardarDatos.isSelected()) {
							try {
								if (!archivo.exists()) {
									archivo.createNewFile();
									FileWriter escribir = new FileWriter(archivo);
									escribir.write(nombreUsuario + "," + contrasena);
									escribir.close();
								}

							}catch (Exception e1) {

							}
						}else {
							try {
								if (archivo.exists()) {
									archivo.delete();
								}
							}catch (Exception e2) {
								
							}
						}
					}
				});
				
				
				JLabel label = new JLabel("");
				label.setIcon(new ImageIcon("multimedia/Logo.png"));
				label.setBounds(249,16, 154, 155);
				contentPane.add(label);
						
				boton.setCursor(new Cursor(HAND_CURSOR));

				botonRegistro.addMouseListener(new MouseListener() {
					@Override
					public void mouseReleased(MouseEvent e) {
					}
					@Override
					public void mousePressed(MouseEvent e) {
					}
					@Override
					public void mouseExited(MouseEvent e) {
					}
					@Override
					public void mouseEntered(MouseEvent e) {
					}
					@Override
					public void mouseClicked(MouseEvent e) {
						VentanaRegistro vr = new VentanaRegistro();
						setVisible(false);
						vr.setVisible(true);
					}
				});

			}

		
		btnRegistrarse.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				registro1.setVisible(true);
				dispose();
				
				
			}
			
		});
	}
}
