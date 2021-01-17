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
import SupermercadoProyecto.ventanasPrincipales.Supermercado;

public class VentanaUbicaciones extends JFrame {

	private JPanel contentPane;
	Supermercado supermercado;
	/**
	 * Launch the application.
	 */
	 public static HashMap<Supermercado, TreeSet<Producto>> hmSupermercados = new HashMap<>();

	public static void main(String[] args) {
		
		
		DBManager db = null;
		try {
			db = new DBManager();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//EEDD que permite almacenar un conjunto ordenado de productos por cada Supermercado
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
		Producto p2 = new Producto(" Papel Higienico dobele rollo", 3.83);
		Producto p3 = new Producto(" Atun Claro ", 3.90);
		Producto p4 = new Producto(" Leche Semidesnatada", 1.78);
		Producto p5 = new Producto(" Fuet Espetec", 2.00);
		Producto p6 = new Producto(" Tomate Frito", 1.00);
		Producto p7 = new Producto(" Bacon Taquitos", 1.95);
		Producto p8 = new Producto(" Pan Molde Tamaño Familiar", 0.95);
		Producto p9 = new Producto(" Nuez mondada natural", 2.61);
		Producto p10 = new Producto(" Chips Ahoy", 1.40);
		Producto p11 = new Producto(" Garbanzo Cocido", 2.50);
		Producto p12 = new Producto(" Espinacas", 1.30);
		Producto p13 = new Producto(" Lechuga", 1.00);
		Producto p14 = new Producto(" Calabacin", 1.50);
		Producto p15 = new Producto(" Sardinas", 2.59);
		Producto p16 = new Producto(" Lentejas", 0.50);
		Producto p17 = new Producto(" Avena", 0.40);
		Producto p18 = new Producto(" Chamorro", 4.50);
		Producto p19 = new Producto(" Pechuga de Pollo", 2.50);
		Producto p20 = new Producto(" Pechuga de Pavo", 1.75);
		Producto p21 = new Producto(" Salmon", 10.50);
		Producto p22 = new Producto(" Almendras", 2.50);
		Producto p23 = new Producto(" Salchichas", 1.50);
		Producto p24 = new Producto(" Tocino", 6.50);
		Producto p25 = new Producto(" Chorizo", 2.50);
		Producto p26 = new Producto(" Mantequilla", 2.50);
		Producto p27 = new Producto(" Margarina", 2.50);
		Producto p28 = new Producto(" Cepillo de Dientes", 0.40);
		Producto p29 = new Producto(" Cleenex", 1.50);
		Producto p30 = new Producto(" Espuma de afeitar", 2.50);

		hmSupermercados.get(sup1).add(p1);
		hmSupermercados.get(sup1).add(p2);
		hmSupermercados.get(sup1).add(p3);
		hmSupermercados.get(sup1).add(p4);
		hmSupermercados.get(sup1).add(p5);
		hmSupermercados.get(sup1).add(p6);
		hmSupermercados.get(sup1).add(p7);
		hmSupermercados.get(sup1).add(p8);
		hmSupermercados.get(sup1).add(p9);
		
		hmSupermercados.get(sup2).add(p10);
		hmSupermercados.get(sup2).add(p11);
		hmSupermercados.get(sup2).add(p12);
		hmSupermercados.get(sup2).add(p13);
		hmSupermercados.get(sup2).add(p14);
		hmSupermercados.get(sup2).add(p15);
		hmSupermercados.get(sup2).add(p16);
		hmSupermercados.get(sup2).add(p17);
		hmSupermercados.get(sup2).add(p18);
		hmSupermercados.get(sup2).add(p19);
		
		hmSupermercados.get(sup3).add(p20);
		hmSupermercados.get(sup3).add(p21);
		hmSupermercados.get(sup3).add(p22);
		hmSupermercados.get(sup3).add(p23);
		hmSupermercados.get(sup3).add(p24);
		hmSupermercados.get(sup3).add(p25);
		hmSupermercados.get(sup3).add(p26);
		hmSupermercados.get(sup3).add(p27);
		hmSupermercados.get(sup3).add(p28);
		hmSupermercados.get(sup3).add(p29);
		hmSupermercados.get(sup3).add(p30);




		
		
		
		
		//Recorro todas las entradas al HashMap
	/*	for (Supermercado sup: hmSupermercados.keySet()) {
			System.out.println(sup);
			System.out.println("Productos Almacenados: ");
			for(Producto p: hmSupermercados.get(sup)) {
				System.out.println(p);
			}
			
		}

	 */
		
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
		setBounds(100, 100, 744, 409);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Foto");
		lblNewLabel.setBounds(0, 99, 291, 194);
	
		ImageIcon ico1 = new ImageIcon("imagenes/euskadi-mapa.png");
        ImageIcon img1 = new ImageIcon(ico1.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH));
        lblNewLabel.setIcon(img1);
		contentPane.add(lblNewLabel);
		
		JList<Supermercado> list = new JList<Supermercado>();
		list.setBounds(311, 99, 394, 194);
		contentPane.add(list);
		
		JLabel lblNewLabel_1 = new JLabel("Inf\u00F3rmate sobre donde se situan nuestros supermercados");
		lblNewLabel_1.setBounds(152, 10, 350, 28);
		contentPane.add(lblNewLabel_1);
		
		JButton botonVizcaya = new JButton("Vizcaya");

		botonVizcaya.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultListModel<Supermercado> modelSupermercado1 = new DefaultListModel<Supermercado>();
				for(Supermercado sup: hmSupermercados.keySet()) {
					if(sup.getLocalidad().equals("Vizcaya")) {
						modelSupermercado1.addElement(sup);
						list.setModel(modelSupermercado1);
					}
					
				}
				
				

			}
		});
		botonVizcaya.setForeground(Color.BLACK);
		botonVizcaya.setBounds(10, 48, 85, 21);
		contentPane.add(botonVizcaya);
		
		JButton botonAlava = new JButton("\u00C1lava");
		botonAlava.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DefaultListModel<Supermercado> modelSupermercado1 = new DefaultListModel<Supermercado>();
				for(Supermercado sup: hmSupermercados.keySet()) {
					if(sup.getLocalidad().equals("Alava")) {
						modelSupermercado1.addElement(sup);
						list.setModel(modelSupermercado1);
					}
				}
			}	
		});
		botonAlava.setBounds(101, 48, 85, 21);
		contentPane.add(botonAlava);
		
		JButton botonGuipuzcoa = new JButton("Guip\u00FAzcoa");
		botonGuipuzcoa.setBounds(196, 48, 85, 21);
		contentPane.add(botonGuipuzcoa);
		botonGuipuzcoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DefaultListModel<Supermercado> modelSupermercado1 = new DefaultListModel<Supermercado>();
				for(Supermercado sup: hmSupermercados.keySet()) {
					if(sup.getLocalidad().equals("Guipuzcoa")) {
						modelSupermercado1.addElement(sup);
						list.setModel(modelSupermercado1);
					}
				}
			}	
		});
		
		JButton BotonVolver = new JButton("Volver");
		BotonVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaPrincipal principal = new VentanaPrincipal();
				principal.setVisible(true);
				dispose();
			}
		});
		BotonVolver.setBounds(24, 317, 85, 21);
		contentPane.add(BotonVolver);
		
	
		
	}
}
