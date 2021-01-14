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
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;

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
		setBounds(100, 100, 541, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
        
        JLabel lblNewLabel_1 = new JLabel("Selecciona la seccion a la que quieres acceder");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(20, 86, 331, 27);
        contentPane.add(lblNewLabel_1);
        
        JButton btnPanaderia= new JButton("Panaderia");
        btnPanaderia.setBounds(375, 117, 137, 89);
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
        btnCarniceria.setBounds(375, 209, 137, 89);
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
        btnFruteria.setBounds(375, 10, 137, 89);
        contentPane.add(btnFruteria);
	       
	        btnFruteria.addMouseListener(new MouseAdapter() {
	        		public void mouseClicked(MouseEvent e) {
	        			VentanaFruteria fruteria = new VentanaFruteria();
	        			fruteria.setVisible(true);
	        			dispose();
	        		}
				});
        
   
        
        JButton btnPescaderia = new JButton("Pescaderia");
        btnPescaderia.setBounds(375, 308, 137, 89);
        contentPane.add(btnPescaderia);
        
        JLabel labelFondo = new JLabel("");
        labelFondo.setBounds(0, 0, 533, 418);
        ImageIcon ico4 = new ImageIcon("imagenes/supermercado.jpg");
        ImageIcon img4 = new ImageIcon(ico4.getImage().getScaledInstance(labelFondo.getWidth(), labelFondo.getHeight(), Image.SCALE_SMOOTH));
        labelFondo.setIcon(img4);
        contentPane.add(labelFondo);
        
	        btnPescaderia.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseClicked(MouseEvent e) {
	        		VentanaPescaderia pescaderia = new VentanaPescaderia();
	        		pescaderia.setVisible(true);
	        		dispose();
	        	}
	        });
        
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
