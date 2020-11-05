import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMenu frame = new VentanaMenu();
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
	public VentanaMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 388, 393);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(20, 10, 50, 40);
		ImageIcon ico1 = new ImageIcon(getClass().getResource("superman.jpg"));
        ImageIcon img1 = new ImageIcon(ico1.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH));
        lblNewLabel.setIcon(img1);
        contentPane.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Selecciona la seccion a la que quieres acceder");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(20, 86, 331, 27);
        contentPane.add(lblNewLabel_1);
        
        JButton btnNewButton = new JButton("");
        ImageIcon ico2 = new ImageIcon(getClass().getResource("pescaderia.jpeg"));
        ImageIcon img2 = new ImageIcon(ico2.getImage().getScaledInstance(137, 89, Image.SCALE_SMOOTH));
        btnNewButton.setBounds(20, 134, 137, 89);
        btnNewButton.setIcon(img2);
        contentPane.add(btnNewButton);
        
        JButton btnPescaderia= new JButton("");
        btnNewButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		VentanaPescaderia pescaderia = new VentanaPescaderia();
        		pescaderia.setVisible(true);
        		dispose();
        	}
        });
        
        JButton btnCarniceria = new JButton("");
        btnCarniceria.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		VentanaCarniceria carniceria = new VentanaCarniceria();
        		carniceria.setVisible(true);
        		dispose();
        	}
        });
        ImageIcon ico3 = new ImageIcon(getClass().getResource("carniceria.jpg"));
        ImageIcon img3 = new ImageIcon(ico3.getImage().getScaledInstance(137, 89, Image.SCALE_SMOOTH));
        btnCarniceria.setBounds(175, 134, 137, 89);
        btnCarniceria.setIcon(img3);
        contentPane.add(btnCarniceria);
        
        JButton btnNewButton_2 = new JButton("Pescaderia");
        btnNewButton_2.setBounds(20, 245, 137, 89);
        contentPane.add(btnNewButton_2);
        
        JButton btnNewButton_3 = new JButton("Pescaderia");
        btnNewButton_3.setBounds(175, 245, 137, 89);
        contentPane.add(btnNewButton_3);
	
	}
}
