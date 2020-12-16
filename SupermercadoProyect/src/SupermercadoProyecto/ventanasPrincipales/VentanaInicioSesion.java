package SupermercadoProyecto.ventanasPrincipales;
import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import ConexionBD.*;
import javax.swing.JPasswordField;

public class VentanaInicioSesion extends JFrame {
	private static Scanner sc;
	private static int intentos;
	private static String usuario, contrasena;
	private JPanel contentPane;
	private JTextField textFieldUsuario;
	final VentanaRegistro registro1 = new VentanaRegistro();
	private JPasswordField passwordFieldContrasena;
	public static int idUsuario;

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
		botonIniciarSesion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FileReader fr = null;
			try {
			
				int nlineas = 0;
				int i = 0;
				String[] usuarios = null;
				String linea;
				sc = new Scanner(new File("usuarios.txt"));
				File f = new File("usuarios.txt");
				fr = new FileReader(f);
				BufferedReader br = new BufferedReader(fr);
				
				try {
					while((linea = br.readLine()) != null) { 
						nlineas++;
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				usuarios = new String[nlineas];
				
				while(sc.hasNextLine()) {
					usuarios[i++] = sc.nextLine();
				}
				
				intentos++;
				
				usuario = textFieldUsuario.getText();
				contrasena = passwordFieldContrasena.getText();
				
				Seguridad s = new Seguridad();
				if(s.validarUsuario(usuarios, usuario, contrasena, intentos) == true) {
					VentanaMenu menu = new VentanaMenu();
					menu.setVisible(true);
					dispose();
				}
				
				
			}catch(FileNotFoundException ex) {
				Logger.getLogger(VentanaInicioSesion.class.getName()).log(Level.SEVERE, null, ex);
			} finally {
				try {
					fr.close();
				}catch(IOException ex1) {
					Logger.getLogger(VentanaInicioSesion.class.getName()).log(Level.SEVERE, null, ex1);
				}
			}
				
				
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
