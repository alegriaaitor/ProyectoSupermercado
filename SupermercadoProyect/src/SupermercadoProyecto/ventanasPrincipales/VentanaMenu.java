package SupermercadoProyecto.ventanasPrincipales;
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
import java.awt.event.MouseListener;

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
        
        JLabel lblNewLabel_1 = new JLabel("Selecciona la seccion a la que quieres acceder");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(20, 86, 331, 27);
        contentPane.add(lblNewLabel_1);
        
        JButton btnPanaderia= new JButton("Panaderia");
        btnPanaderia.setBounds(20, 134, 137, 89);
        contentPane.add(btnPanaderia);
       
	        btnPanaderia.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseClicked(MouseEvent e) {
	        		VentanaPanaderia panaderia = new VentanaPanaderia();
	        		panaderia.setVisible(true);
	        		dispose();
	        	}
	        });
	        
        JButton btnCarniceria = new JButton("Carniceria");
        btnCarniceria.setBounds(175, 134, 137, 89);
        contentPane.add(btnCarniceria);
	       
	        btnCarniceria.addMouseListener(new MouseAdapter() {
		        	@Override
		        	public void mouseClicked(MouseEvent e) {
		        		VentanaCarniceria carniceria = new VentanaCarniceria();
		        		carniceria.setVisible(true);
		        		dispose();
		        	}
		        });
       
        
        JButton btnFruteria = new JButton("Fruteria");
        btnFruteria.setBounds(20, 245, 137, 89);
        contentPane.add(btnFruteria);
	       
	        btnFruteria.addMouseListener(new MouseAdapter() {
	        		public void mouseClicked(MouseEvent e) {
	        			VentanaFruteria fruteria = new VentanaFruteria();
	        			fruteria.setVisible(true);
	        			dispose();
	        		}
				});
        
   
        
        JButton btnPescaderia = new JButton("Pescaderia");
        btnPescaderia.setBounds(175, 245, 137, 89);
        contentPane.add(btnPescaderia);
        
	        btnPescaderia.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseClicked(MouseEvent e) {
	        		VentanaPescaderia pescaderia = new VentanaPescaderia();
	        		pescaderia.setVisible(true);
	        		dispose();
	        	}
	        });
        
	}
}
