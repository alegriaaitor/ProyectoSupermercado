import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Color;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
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
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NOMBRE");
		lblNewLabel.setBounds(41, 10, 68, 13);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Iniciar Sesi\u00F3n ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(82, 87, 120, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Registrarse");
		btnNewButton_1.setBounds(82, 124, 120, 21);
		contentPane.add(btnNewButton_1);
		
		JTextPane txtpnIntroduceTusDatos = new JTextPane();
		txtpnIntroduceTusDatos.setForeground(Color.DARK_GRAY);
		txtpnIntroduceTusDatos.setBackground(Color.YELLOW);
		txtpnIntroduceTusDatos.setText("Introduce tus datos, compra en nuestro supermercado online y disfruta de los mejores productos.");
		txtpnIntroduceTusDatos.setBounds(227, 87, 152, 78);
		contentPane.add(txtpnIntroduceTusDatos);
		
		JButton btnNewButton_2 = new JButton("Ubicacion ");
		btnNewButton_2.setForeground(Color.BLUE);
		btnNewButton_2.setBounds(212, 10, 106, 21);
		contentPane.add(btnNewButton_2);
	}
}
