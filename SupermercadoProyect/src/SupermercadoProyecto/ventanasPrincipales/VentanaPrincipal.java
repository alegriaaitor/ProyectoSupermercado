package SupermercadoProyecto.ventanasPrincipales;
import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

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
		setBounds(100, 100, 599, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Iniciar Sesion ");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaInicioSesion inicio = new VentanaInicioSesion();
				inicio.setVisible(true);
				dispose();
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnNewButton.setBounds(78, 87, 139, 39);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Registrarse");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaRegistro registro = new VentanaRegistro();
				registro.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(78, 166, 139, 39);
		contentPane.add(btnNewButton_1);
		
		JTextPane txtpnIntroduceTusDatos = new JTextPane();
		txtpnIntroduceTusDatos.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtpnIntroduceTusDatos.setForeground(Color.DARK_GRAY);
		txtpnIntroduceTusDatos.setBackground(Color.YELLOW);
		txtpnIntroduceTusDatos.setText("Introduce tus datos, compra en nuestro supermercado online y disfruta de los mejores productos.");
		txtpnIntroduceTusDatos.setBounds(34, 323, 489, 48);
		contentPane.add(txtpnIntroduceTusDatos);
		
		JButton btnNewButton_2 = new JButton("Ubicacion ");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				VentanaUbicaciones ubicacion = new VentanaUbicaciones();
				ubicacion.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setForeground(Color.BLUE);
		btnNewButton_2.setBounds(429, 249, 131, 43);
		contentPane.add(btnNewButton_2);
		
		JLabel labelSupermercado = new JLabel("");
		labelSupermercado.setHorizontalAlignment(SwingConstants.TRAILING);
		labelSupermercado.setBounds(10, 10, 550, 315);
		//ImageIcon ico1 = new ImageIcon(getClass().getResource("superman.jpg"));
	    //ImageIcon img1 = new ImageIcon(ico1.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH));
	    //lblNewLabel.setIcon(img1);
		ImageIcon ico4 = new ImageIcon("imagenes/supermercado.jpg");
        ImageIcon img4 = new ImageIcon(ico4.getImage().getScaledInstance(labelSupermercado.getWidth(), labelSupermercado.getHeight(), Image.SCALE_SMOOTH));
        labelSupermercado.setIcon(img4);
	    contentPane.add(labelSupermercado);
	    
	    JLabel lblNewLabel_1 = new JLabel("New label");
	    lblNewLabel_1.setBounds(10, 10, 45, 13);
	    contentPane.add(lblNewLabel_1);
		
	}
}
