package SupermercadoProyecto.ventanasPrincipales;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import ConexionBD.DBException;
import ConexionBD.DBManager;



public class VentanaCarrito extends JFrame {
	private DefaultTreeModel modelo;
	private DefaultMutableTreeNode abuelo;
	private JTable tabla;
	private DefaultTableModel modeloTabla = new DefaultTableModel();
	private JPanel pDerecha;
	private JPanel pSur;
	public static JLabel labelTitulo;
	private JPanel pDerechaCentro, pDerechaSur;
	private JLabel resumenCompra, totalCarrito, totalCarritoPrecio, gastosEnvio, gastosEnvioPrecio, totalAPagar, totalAPagarPrecio, seguirComprando, procesoCompra, anadirProducto;
	
	public VentanaCarrito() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		setTitle("Ventana carrito");
		setSize( 600, 500 );
		JPanel pCentral = new JPanel();
		pDerecha = new JPanel(new BorderLayout());
		pSur = new JPanel(new GridLayout(1,3));
		pDerechaCentro = new JPanel(new GridLayout(3,2));
		pDerechaSur = new JPanel(new GridLayout());
		pCentral.setLayout(new BorderLayout());
		labelTitulo = new JLabel("COMPRUEBE LOS PRODUCTOS DEL CARRITO ",SwingConstants.CENTER);
		pCentral.add(labelTitulo, BorderLayout.NORTH);
		JButton botonAnadir = new JButton("Propuestas");
		JButton botonCaja = new JButton("Pasar por caja");
		JButton botonComprar = new JButton("Seguir comprando");
		
		Hilo h = new Hilo();
        h.start();
		
		tabla = new JTable(modeloTabla);
		String[] ids = {"Nombre", "Cantidad", "Precio"};
		modeloTabla.setColumnIdentifiers(ids);
		
		
		double precioTotal = 0;
		DBManager conexion = new DBManager();
		try {
			conexion.connect();
			precioTotal = conexion.obtenerTotalCarrito();
			conexion.disconnect();
		} catch (DBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String texto = String.format("%.2f ", precioTotal);
		String texto2 = String.format("%.2f", precioTotal + 2.50);
		
		//Inicializar variables
		anadirProducto = new JLabel("Añadir/Seguir comprando productos");
		resumenCompra = new JLabel("Resumen de la compra");
		totalCarrito = new JLabel("Total carrito: ");
		totalCarritoPrecio = new JLabel(texto);
		gastosEnvio = new JLabel("Gastos envio: ");
		gastosEnvioPrecio = new JLabel("2,50");
		totalAPagar = new JLabel("Total a pagar: ");
		totalAPagarPrecio = new JLabel(texto2);
		
		
		tabla.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
			
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
					int row, int column) {
				Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				int precio = (int) modeloTabla.getValueAt(row, 2);
				if(precio >= 50)
					c.setBackground(Color.RED);
				else if(precio < 50)
					c.setBackground(Color.GREEN);
				return c;
			
			}
		});
		
		//Añadir elementos a paneles
		pDerechaCentro.add(totalCarrito);
		pDerechaCentro.add(totalCarritoPrecio);
		pDerechaCentro.add(gastosEnvio);
		pDerechaCentro.add(gastosEnvioPrecio);
		pDerechaCentro.add(totalAPagar);
		pDerechaCentro.add(totalAPagarPrecio);
		
		pDerechaSur.add(botonCaja);
		
		pDerecha.add(resumenCompra, BorderLayout.NORTH);
		pDerecha.add(pDerechaCentro, BorderLayout.CENTER);
		pDerecha.add(pDerechaSur, BorderLayout.SOUTH);
		
		//Action y mouse listeners
		
		botonAnadir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				VentanaPropuestas p = new VentanaPropuestas();
				dispose();
				p.setVisible(true);
			}
		});
		
		botonComprar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaMenu menu = new VentanaMenu();
				menu.setVisible(true);
				dispose();
			}
		});
		
		botonCaja.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				double precioTotal = 0;
				try {
					PrintWriter pw = new PrintWriter("Recibo.txt");
					
					DBManager con = new DBManager();
					try {
						con.connect();
						ArrayList<Producto> al = con.obtenerCarrito();
						con.disconnect();
						for (Producto p : al) {
							String texto = String.format("%s   %.2f €", p.getNombre(), p.getPrecio());
							pw.println(texto);
							precioTotal += p.getPrecio();
						}
						pw.println();
						pw.println(String.format(" PRECIO TOTAL: %.2f €", precioTotal + 2.50));
						pw.flush();
						pw.close();
					} catch (DBException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
					
						
						try {
							DBManager con = new DBManager();
							con.connect();
							con.vaciarCarrito();
							con.disconnect();
						} catch (DBException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						JOptionPane.showMessageDialog(null, "Compra realizada con exito rotundo","Carrito",1);
						VentanaMenu m = new VentanaMenu();
						dispose();
						m.setVisible(true);
								
						
					}
				
		});	
					
		
		
		DBManager con = new DBManager();
		try {
			con.connect();
			ArrayList<Producto> pro = con.obtenerCarrito();
			con.disconnect();
			HashSet<Producto> hashSet = new HashSet<Producto>(pro);
			pro.clear();
			pro.addAll(hashSet);
			for(Producto p: pro) {
				con.connect();
				
				validarRegistroTabla(p);
				String fila[] = {p.getNombre(),String.valueOf(con.cantidadEnCarrito(p)),String.valueOf(p.getPrecio()*con.cantidadEnCarrito(p))};
				con.disconnect();
				validarRegistroTabla(p);
				modeloTabla.addRow(fila);
				
				
				
			}
		} catch (DBException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		
		pSur.add(botonAnadir);
		pSur.add(botonComprar);
		pCentral.add(pSur, BorderLayout.SOUTH);
		pCentral.add(new JScrollPane(tabla), BorderLayout.CENTER);
		pCentral.add(pDerecha, BorderLayout.EAST);
		add(pCentral);
		
		setVisible(true);
	}
	
	public void validarRegistroTabla(Producto p) {
		for (int i = 0; i < modeloTabla.getRowCount(); i++) {
			if(modeloTabla.getValueAt(i, 0).equals(p.getNombre())) {
				modeloTabla.removeRow(i);
				}
		}
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCarrito frame = new VentanaCarrito();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
}
