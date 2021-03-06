package SupermercadoProyecto.ventanasPrincipales;

import java.awt.*;


import javax.swing.border.EmptyBorder;

import ConexionBD.DBException;
import ConexionBD.DBManager;


import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class VentanaCarniceria extends JFrame {

	private JPanel contentPane;
	private DefaultListModel<Producto> modelo;
	private JPanel pNorte;
	private JPanel pCentro;
	private JScrollPane scrollPanel;
	private   ArrayList<VentanaPanelProductosCarnicos> alp = new ArrayList();
	ArrayList<VentanaPanelProductosCarnicos> alpp = new ArrayList<VentanaPanelProductosCarnicos>();

	public static JLabel labelTitulo;
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public VentanaCarniceria() {
		
		pNorte = new JPanel();
		pNorte.setBackground(Color.BLACK);
		pCentro = new JPanel(new GridLayout(0, 3 ));
		pCentro.setBackground(Color.BLACK);
		getContentPane().add(pNorte,BorderLayout.NORTH);
//		getContentPane().add(pCentro,BorderLayout.CENTER);
  	    
		setTitle("Ventana Productos Carnicos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(200, 150, 600, 600);
		//setSize(400, 400);
		JButton botonSiguienteSeccion = new JButton("Cambiar Seccion");
		JButton botonIniciarSesion = new JButton("Cambia de cuenta");
        JButton botonCarrito = new JButton("Ver Carrito");
		
        pNorte.add(botonSiguienteSeccion);
        pNorte.add(botonCarrito);
        pNorte.add(botonIniciarSesion);
        
        JScrollPane scrollbar = new JScrollPane(pCentro);
        
        scrollbar.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollbar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
  
        getContentPane().add(scrollbar, BorderLayout.CENTER);
        
        DBManager dbmanager = new DBManager();
        try {
			dbmanager.connect();
			alpp = dbmanager.eligeProductos();
			
			dbmanager.disconnect();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
        
        for(VentanaPanelProductosCarnicos vpp : alpp) {
        	pCentro.add(vpp);
        }
        
        botonSiguienteSeccion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				VentanaPescaderia vp = new VentanaPescaderia();
				vp.setVisible(true);
				dispose();
			}
		});
        
        botonIniciarSesion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				VentanaInicioSesion vi = new VentanaInicioSesion();
				vi.setVisible(true);
				dispose();
			}
		});
        
   		botonCarrito.addMouseListener(new MouseAdapter() {
   			@Override
   			public void mouseClicked(MouseEvent e) {
   				
   				VentanaCarrito carrito = new VentanaCarrito();
   				carrito.setVisible(true);
   				dispose();
   			}
   		});
   		
   		

        
	/*	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 554, 495);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel nombreProducto1 = new JLabel("Chuleton de vaca (500g)");
		nombreProducto1.setForeground(Color.WHITE);
		nombreProducto1.setBounds(111, 62, 244, 13);
		contentPane.add(nombreProducto1);
		
		
		JLabel lblProducto = new JLabel("Solomillo de ternera (250g)");
		lblProducto.setForeground(Color.WHITE);
		lblProducto.setBounds(111, 139, 244, 13);
		contentPane.add(lblProducto);
		
		JLabel lblProducto_1 = new JLabel("Entrecot de ternera (300g)");
		lblProducto_1.setForeground(Color.WHITE);
		lblProducto_1.setBounds(111, 237, 244, 13);
		contentPane.add(lblProducto_1);
		
		JLabel lblProducto_2 = new JLabel("Chorizo criollo (250g)");
		lblProducto_2.setForeground(Color.WHITE);
		lblProducto_2.setBounds(111, 329, 236, 13);
		contentPane.add(lblProducto_2);
		
		DBManager con = new DBManager();
		JLabel labelPrecioChuleton;
		try {
			con.connect();
			labelPrecioChuleton = new JLabel("Precio: " + con.obtenerPrecioProducto("Chuleton de vaca")); //Pasamos por parametro "Chuleton de vaca 
			labelPrecioChuleton.setForeground(Color.WHITE);
			labelPrecioChuleton.setBounds(111, 98, 149, 13);    										  //y nos devuelve el precio del poducto pasado
			contentPane.add(labelPrecioChuleton);
			con.disconnect();
		} catch (DBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			con.connect();
			JLabel labelPrecioSolomillo = new JLabel("Precio: " + con.obtenerPrecioProducto("Solomillo de ternera"));
			labelPrecioSolomillo.setForeground(Color.WHITE);
			labelPrecioSolomillo.setBounds(111, 178, 149, 13);
			contentPane.add(labelPrecioSolomillo);
			con.disconnect();
		}catch(DBException e2) {
			e2.printStackTrace();
		}
		
		try {
			con.connect();	
			JLabel labelPrecioEntrecot = new JLabel("Precio: " + con.obtenerPrecioProducto("Entrecot de ternera"));
			labelPrecioEntrecot.setForeground(Color.WHITE);
			labelPrecioEntrecot.setBounds(111, 273, 149, 13);
			contentPane.add(labelPrecioEntrecot);
			con.disconnect();
		}catch(DBException e2) {
			e2.printStackTrace();
		}
		
		try {
			con.connect();
			JLabel labelPrecioCriollo = new JLabel("Precio: " + con.obtenerPrecioProducto("Chorizo criollo"));
			labelPrecioCriollo.setForeground(Color.WHITE);
			labelPrecioCriollo.setBounds(111, 371, 149, 13);
			contentPane.add(labelPrecioCriollo);
			con.disconnect();
		}catch(DBException e3) {
			e3.printStackTrace();
		}
		
		
		JButton botonAnadirChuleton = new JButton("A\u00F1adir");
		botonAnadirChuleton.setBounds(373, 75, 85, 21);
		contentPane.add(botonAnadirChuleton);
		botonAnadirChuleton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				try {
				con.connect();
				Producto carne1 = new Producto();
				carne1.setNombre("Chuleton de vaca");
				carne1.setPrecio(con.obtenerPrecioProducto("Chuleton de vaca"));
				con.anadirProductoACarrito(carne1);
				con.disconnect();
				}catch(DBException e) {
					e.printStackTrace();
				}
				
			}
		});
		
		JButton botonCriollo = new JButton("A\u00F1adir");
		botonCriollo.setBounds(373, 356, 85, 21);
		contentPane.add(botonCriollo);
		botonCriollo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					con.connect();
					Producto carne2 = new Producto();
					carne2.setNombre("Chorizo criollo");
					carne2.setPrecio(con.obtenerPrecioProducto(carne2.getNombre()));
					con.anadirProductoACarrito(carne2);
					con.disconnect();
					}catch(DBException e) {
						e.printStackTrace();
					}
			}
		});
		
		JButton botonSolomillo = new JButton("A\u00F1adir");
		botonSolomillo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		botonSolomillo.setBounds(373, 174, 85, 21);
		contentPane.add(botonSolomillo);
		botonSolomillo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					con.connect();
					Producto carne3 = new Producto();
					carne3.setNombre("Solomillo de ternera");
					carne3.setPrecio(con.obtenerPrecioProducto(carne3.getNombre()));
					con.anadirProductoACarrito(carne3);
					con.disconnect();
					}catch(DBException e) {
						e.printStackTrace();
					}
			}
		});
		
		JButton botonEntrecot = new JButton("A\u00F1adir");
		botonEntrecot.setBounds(373, 269, 85, 21);
		contentPane.add(botonEntrecot);
		botonEntrecot.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					con.connect();
					Producto carne4 = new Producto();
					carne4.setNombre("Entrecot de ternera");
					carne4.setPrecio(con.obtenerPrecioProducto(carne4.getNombre()));
					con.anadirProductoACarrito(carne4);
					con.disconnect();
					}catch(DBException e) {
						e.printStackTrace();
					}
			}
		});
		
		JButton btnNewButton_8 = new JButton("Volver");
		btnNewButton_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaMenu menu = new VentanaMenu();
				menu.setVisible(true);
				dispose();
			}
		});
		btnNewButton_8.setBounds(111, 425, 85, 21);
		contentPane.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("Ver carrito");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaCarrito carrito = new VentanaCarrito();
				carrito.setVisible(true);
				dispose();
			}
		});
		btnNewButton_9.setBounds(237, 425, 94, 21);
		contentPane.add(btnNewButton_9);
		
		JLabel labelSolomillo = new JLabel("Foto");
		labelSolomillo.setBounds(26, 139, 75, 75);
		contentPane.add(labelSolomillo);
		ImageIcon ico4 = new ImageIcon("imagenes/solomillo.png");
        ImageIcon img4 = new ImageIcon(ico4.getImage().getScaledInstance(labelSolomillo.getWidth(), labelSolomillo.getHeight(), Image.SCALE_SMOOTH));
        labelSolomillo.setIcon(img4);
		contentPane.add(labelSolomillo);
		
		JLabel labelEntrecot = new JLabel("Foto");
		labelEntrecot.setBounds(26, 237, 75, 75);
		contentPane.add(labelEntrecot);
		ImageIcon ico3 = new ImageIcon("imagenes/entrecot.png");
        ImageIcon img3 = new ImageIcon(ico3.getImage().getScaledInstance(labelEntrecot.getWidth(), labelEntrecot.getHeight(), Image.SCALE_SMOOTH));
        labelEntrecot.setIcon(img3);
		contentPane.add(labelEntrecot);
		
		JLabel labelChorizoCriollo = new JLabel("Foto");
		labelChorizoCriollo.setBounds(26, 329, 75, 75);
		contentPane.add(labelChorizoCriollo);
		ImageIcon ico2 = new ImageIcon("imagenes/criollo.png");
        ImageIcon img2 = new ImageIcon(ico2.getImage().getScaledInstance(labelChorizoCriollo.getWidth(), labelChorizoCriollo.getHeight(), Image.SCALE_SMOOTH));
        labelChorizoCriollo.setIcon(img2);
		contentPane.add(labelChorizoCriollo);
		
		JLabel labelChuleton = new JLabel("Foto");
		labelChuleton.setBounds(26, 48, 75, 75);
		contentPane.add(labelChuleton);
		ImageIcon ico1 = new ImageIcon("imagenes/chuleton.png");
        ImageIcon img1 = new ImageIcon(ico1.getImage().getScaledInstance(labelChuleton.getWidth(), labelChuleton.getHeight(), Image.SCALE_SMOOTH));
        labelChuleton.setIcon(img1);
		contentPane.add(labelChuleton);
		ImageIcon ico = new ImageIcon("imagenes/fondos.jpg");
		
		JButton btnNewButton = new JButton("Cambiar Seccion");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaFruteria fruteria = new VentanaFruteria();
				fruteria.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(372, 425, 136, 21);
		contentPane.add(btnNewButton);
		
		labelTitulo = new JLabel("CARNICERIA");
		labelTitulo.setForeground(Color.WHITE);
		labelTitulo.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		labelTitulo.setBounds(157, 25, 149, 27);
		contentPane.add(labelTitulo);
		
		JLabel labelFondo = new JLabel("");
		labelFondo.setHorizontalAlignment(SwingConstants.TRAILING);
		labelFondo.setBounds(0, 0, 540, 458);
		ImageIcon ico7 = new ImageIcon("imagenes/fondos.jpg");
        ImageIcon img = new ImageIcon(ico7.getImage().getScaledInstance(labelFondo.getWidth(), labelFondo.getHeight(), Image.SCALE_SMOOTH));
        labelFondo.setIcon(img);
		contentPane.add(labelFondo);
		
		*/
		
		
	}
}
