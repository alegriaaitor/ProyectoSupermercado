package SupermercadoProyecto.ventanasPrincipales;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.AbstractButton;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ConexionBD.DBManager;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.*;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.TreeSet;

import javax.swing.JTable;
import javax.swing.AbstractListModel;

public class VentanaUbicaciones extends JFrame {

	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		DBManager db = null;
		try {
			db = new DBManager();
			db.open();
			db.crearTablas();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//EEDD que permite almacenar un conjunto ordenado de productos por cada Supermercado
		HashMap<Supermercado, TreeSet<Producto>> hmSupermercados = new HashMap<>();
		/*Hemos declarado e instanciado un HP cuya clave es la Supermercado y por cada supermercado guarda
		 *un conjunto(Set) ordenado (Tree) de productos*/
		
		Supermercado sup1 = new Supermercado("Vizcaya", "Calle D.Areilza, Bilbao", 111, "08:00/21:00");
		Supermercado sup2 = new Supermercado("Vizcaya", "Calle Ercilla, Bilbao", 112, "08:30/22:00");
		Supermercado sup3 = new Supermercado("Vizcaya", "Calle D.Areilza, Bilbao", 113, "09:00/21:00");

		Supermercado sup4 = new Supermercado("Alava", "Avenida general Alegria, Vitoria", 441, "07:30/20:00");
		Supermercado sup5 = new Supermercado("Alava", "Calle Rotonda, Vitoria", 442, "08:30/21:00");
		Supermercado sup6 = new Supermercado("Alava", "Calle La Avanzada, Vitoria", 443, "09:30/22:00");

		Supermercado sup7 = new Supermercado("Guipuzcoa", "Calle de Anoeta, Donosti", 771, "09:00/22:00");
		Supermercado sup8 = new Supermercado("Guipuzcoa", "Calle Descenso, Donosti", 772, "08:30/20:00");
		Supermercado sup9 = new Supermercado("Guipuzcoa", "Calle Segunda Division, Donosti", 773, "10:00/22:00");

	
		//Añado entradas al HashMap
		hmSupermercados.put(sup1, new TreeSet<>());
		hmSupermercados.put(sup2, new TreeSet<>());
		hmSupermercados.put(sup3, new TreeSet<>());
		hmSupermercados.put(sup4, new TreeSet<>());
		hmSupermercados.put(sup5, new TreeSet<>());
		hmSupermercados.put(sup6, new TreeSet<>());
		hmSupermercados.put(sup7, new TreeSet<>());
		hmSupermercados.put(sup8, new TreeSet<>());
		hmSupermercados.put(sup9, new TreeSet<>());
		
		//Añado Productos al TreeSet asociado a cada entrada del HashMap
		Producto p1 = new Producto(" Filipinos", 2.50);
		Producto p2 = new Producto(" Filipinos", 2.50);
		Producto p3 = new Producto(" Filipinos", 2.50);
		Producto p4 = new Producto(" Filipinos", 2.50);
		Producto p5 = new Producto(" Filipinos", 2.50);
		Producto p6 = new Producto(" Filipinos", 2.50);
		Producto p7 = new Producto(" Filipinos", 2.50);
		Producto p8 = new Producto(" Filipinos", 2.50);
		Producto p9 = new Producto(" Filipinos", 2.50);

		
		Producto p10 = new Producto(" Chips Ahoy", 1.40);
		Producto p20 = new Producto(" Oreo", 2.75);
		hmSupermercados.get(sup1).add(p1);
		hmSupermercados.get(sup2).add(p10);
		hmSupermercados.get(sup3).add(p20);
		
		//Recorro todas las entradas al HashMap
		for (Supermercado sup: hmSupermercados.keySet()) {
			System.out.println(sup);
			System.out.println("Productos Almacenados: ");
			for(Producto p: hmSupermercados.get(sup)) {
				System.out.println(p);
			}
			
		}


		
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
		setBounds(100, 100, 550, 362);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Foto");
		lblNewLabel.setBounds(10, 69, 291, 194);
	
		ImageIcon ico1 = new ImageIcon("imagenes/euskadi-mapa.png");
        ImageIcon img1 = new ImageIcon(ico1.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH));
        lblNewLabel.setIcon(img1);
		contentPane.add(lblNewLabel);
		
		
		JLabel lblNewLabel_1 = new JLabel("Inf\u00F3rmate sobre donde se situan nuestros supermercados");
		lblNewLabel_1.setBounds(152, 10, 274, 28);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Vizcaya");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(10, 48, 85, 21);
		contentPane.add(btnNewButton);
		
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
		
		JButton BotonVolver = new JButton("Volver");
		BotonVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaPrincipal principal = new VentanaPrincipal();
				principal.setVisible(true);
				dispose();
			}
		});
		BotonVolver.setBounds(196, 252, 85, 21);
		contentPane.add(BotonVolver);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(10, 5, 53, 38);
		
		
		contentPane.add(lblNewLabel_2);
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"PRODUCTOSssss"};
			public int getSize() {
	
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(345, 302, 136, -238);
		contentPane.add(list);
	}
}
