import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
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

public class VentanaInicioSesion extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	final VentanaRegistro registro1 = new VentanaRegistro();

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
		
		textField = new JTextField();
		textField.setBounds(45, 149, 281, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(45, 244, 281, 29);
		contentPane.add(textField_1);
		
		JButton btnNewButton = new JButton("Iniciar Sesion");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaMenu menu = new VentanaMenu();
				menu.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(118, 319, 133, 35);
		contentPane.add(btnNewButton);
		
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
