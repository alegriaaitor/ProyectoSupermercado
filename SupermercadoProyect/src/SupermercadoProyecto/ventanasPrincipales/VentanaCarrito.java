package SupermercadoProyecto.ventanasPrincipales;
import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.JList;

public class VentanaCarrito extends JFrame {

	private JPanel contentPane;
	final VentanaMenu menu = new VentanaMenu();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCarrito frame = new VentanaCarrito();
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
	public VentanaCarrito() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 830, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Carrito");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel.setBounds(37, 24, 111, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Resumen de la compra");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(550, 40, 193, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Total a pagar");
		lblNewLabel_2.setBounds(550, 148, 86, 13);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Pasar por caja");
		btnNewButton.setBounds(560, 175, 122, 32);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("0,00");
		lblNewLabel_3.setBounds(664, 148, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Total carrito");
		lblNewLabel_4.setBounds(550, 73, 86, 13);
		contentPane.add(lblNewLabel_4);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(509, 50, 0, 157);
		contentPane.add(separator);
		
		JLabel lblNewLabel_3_1 = new JLabel("0,00");
		lblNewLabel_3_1.setBounds(664, 73, 45, 13);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("0,00");
		lblNewLabel_3_2.setBounds(664, 108, 45, 13);
		contentPane.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_4_1 = new JLabel("Gastos de envio");
		lblNewLabel_4_1.setBounds(550, 108, 104, 13);
		contentPane.add(lblNewLabel_4_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(546, 134, 148, 4);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel_5 = new JLabel("¿Te has olvidado de algo?");
		lblNewLabel_5.setBounds(550, 262, 159, 13);
		contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton_1 = new JButton("Continua comprando");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaMenu menu = new VentanaMenu();
				menu.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(572, 285, 157, 21);
		contentPane.add(btnNewButton_1);
		
		JList list = new JList();
		list.setBounds(59, 73, 415, 317);
		contentPane.add(list);
		
	}
}
