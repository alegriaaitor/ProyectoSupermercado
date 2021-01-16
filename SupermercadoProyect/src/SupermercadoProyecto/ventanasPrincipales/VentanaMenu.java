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
import javax.swing.JSlider;
import javax.swing.JMenuBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;

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
		setBounds(100, 100, 603, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(10, 0, 101, 22);
		contentPane.add(menuBar);
		
		JMenu menuNombreMenu = new JMenu("Secciones");
		menuBar.add(menuNombreMenu);
		
		JMenuItem menuItemPanaderia = new JMenuItem("Panaderia");
		menuItemPanaderia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaPanaderia panaderia = new VentanaPanaderia();
        		panaderia.setVisible(true);
        		dispose();
			}
		});
		menuNombreMenu.add(menuItemPanaderia);

		
		JMenuItem menuItemCarniceria = new JMenuItem("Carniceria");
		menuItemCarniceria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				VentanaCarniceria carniceria = new VentanaCarniceria();
        		carniceria.setVisible(true);
        		dispose();	
			}
		});
		menuNombreMenu.add(menuItemCarniceria);
		
		JMenuItem menuItemFruteria = new JMenuItem("Fruteria");
		menuItemFruteria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				VentanaFruteria fruteria = new VentanaFruteria();
    			fruteria.setVisible(true);
    			dispose();
			}
		});
		menuNombreMenu.add(menuItemFruteria);
		
		JMenuItem menuItemPescaderia = new JMenuItem("Pescaderia");
		menuItemPescaderia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				VentanaPescaderia pescaderia= new VentanaPescaderia();
				pescaderia.setVisible(true);
				dispose();
			}
		});
		menuNombreMenu.add(menuItemPescaderia);
		
		JLabel labelFondo = new JLabel("New label");
		
		labelFondo.setHorizontalAlignment(SwingConstants.TRAILING);
		labelFondo.setBounds(0, 0, 589, 432);
		ImageIcon ico4 = new ImageIcon("imagenes/menuFondo.jpg");
        ImageIcon img4 = new ImageIcon(ico4.getImage().getScaledInstance(labelFondo.getWidth(), labelFondo.getHeight(), Image.SCALE_SMOOTH));
        labelFondo.setIcon(img4);
		contentPane.add(labelFondo);
		
		JLabel lblNewLabel = new JLabel("Cambiar de cuenta");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(39, 336, 130, 34);
		contentPane.add(lblNewLabel);
		
		JButton btnIniciar = new JButton("Iniciar Sesion");
		btnIniciar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaInicioSesion vi = new VentanaInicioSesion();
				vi.setVisible(true);
				dispose();
			}
		});
		
        
		btnIniciar.setBounds(49, 380, 120, 32);
		contentPane.add(btnIniciar);
		
		JButton btnUbicacion = new JButton("botonUbicacion");
		btnUbicacion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaUbicaciones vu = new VentanaUbicaciones();
				vu.setVisible(true);
				dispose();
			}
		});
		btnUbicacion.setBounds(187, 380, 130, 32);
		contentPane.add(btnUbicacion);
        
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
