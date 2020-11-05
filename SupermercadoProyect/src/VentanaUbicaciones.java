import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaUbicaciones extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaUbicaciones frame = new VentanaUbicaciones();
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
	public VentanaUbicaciones() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 69, 291, 194);
	
		ImageIcon ico1 = new ImageIcon(getClass().getResource("euskadi-mapa.png"));
        ImageIcon img1 = new ImageIcon(ico1.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH));
        lblNewLabel.setIcon(img1);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Inf\u00F3rmate sobre donde se situan nuestros supermercados");
		lblNewLabel_1.setBounds(152, 10, 274, 28);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Vizcaya");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(10, 48, 85, 21);
		contentPane.add(btnNewButton);
		
		JTextPane textPane = new JTextPane();
		textPane.setEnabled(false);
		textPane.setBounds(311, 88, 115, 131);
		contentPane.add(textPane);
		
		JButton btnNewButton_1 = new JButton("\u00C1lava");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1.setBounds(101, 48, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Guip\u00FAzcoa");
		btnNewButton_2.setBounds(196, 48, 85, 21);
		contentPane.add(btnNewButton_2);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setEnabled(false);
		textPane_1.setBounds(311, 88, 115, 125);
		contentPane.add(textPane_1);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setEnabled(false);
		textPane_2.setBounds(311, 88, 115, 125);
		contentPane.add(textPane_2);
		
		JButton btnNewButton_3 = new JButton("Volver");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaPrincipal principal = new VentanaPrincipal();
				principal.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(321, 232, 85, 21);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(10, 5, 53, 38);
		
		
		contentPane.add(lblNewLabel_2);
	}
}
