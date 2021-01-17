package SupermercadoProyecto.ventanasPrincipales;
import java.awt.BorderLayout;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ConexionBD.DBException;
import ConexionBD.DBManager;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.JList;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;


public class VentanaCarrito extends JFrame {

	private JPanel contentPane;
	private ArrayList <Producto> p;
	private DefaultListModel<Producto> modeloLista = new DefaultListModel<>();
	final VentanaMenu menu = new VentanaMenu();
	
	/**
	 * Launch the application.
	 */
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
	

	/**
	 * Create the frame.
	 *  
	 */
	public VentanaCarrito() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 830, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblNewLabel = new JLabel("Carrito");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel.setBounds(188, 26, 111, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Resumen de la compra");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(550, 40, 193, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Total a pagar");
		lblNewLabel_2.setBounds(550, 148, 86, 13);
		contentPane.add(lblNewLabel_2);
		
		JButton botonPasaPorCaja = new JButton("Pasar por caja");
		botonPasaPorCaja.setBounds(560, 175, 122, 32);
		contentPane.add(botonPasaPorCaja);
		
		JLabel lblNewLabel_4 = new JLabel("Total carrito");
		lblNewLabel_4.setBounds(550, 73, 86, 13);
		contentPane.add(lblNewLabel_4);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(509, 50, 0, 157);
		contentPane.add(separator);
	
		
		JLabel lblNewLabel_4_1 = new JLabel("Gastos de envio");
		lblNewLabel_4_1.setBounds(550, 108, 104, 13);
		contentPane.add(lblNewLabel_4_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(546, 134, 148, 4);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel_5 = new JLabel("¿Te has olvidado de algo?");
		lblNewLabel_5.setBounds(550, 262, 159, 13);
		contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton_1 = new JButton("Continua comprando");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaMenu menu = new VentanaMenu();
				menu.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(572, 285, 157, 21);
		contentPane.add(btnNewButton_1);
		
		p = new ArrayList<>();
		
		JList list;
		
		DefaultListModel<Producto> modelo1= new DefaultListModel<>();
		DBManager con = new DBManager();
		try {
			con.connect();
			ArrayList<Producto> pro = con.obtenerCarrito();
			con.disconnect();
			for(Producto p: pro) {
				modelo1.addElement(p);
			}
		} catch (DBException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		list = new JList<>(modelo1);
		list.setBounds(58, 72, 415, 317);
		contentPane.add(list);
		
		
		
		
		
		JLabel labelProcesandoCompra = new JLabel("Procesando Compra...");
		labelProcesandoCompra.setVisible(false);
		labelProcesandoCompra.setBounds(509, 332, 193, 32);
		contentPane.add(labelProcesandoCompra);
		
		
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setVisible(false);
		progressBar.setBounds(563, 376, 146, 26);
		contentPane.add(progressBar);
		
		
		
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
		
		JLabel intGastosEnvio = new JLabel("2.50");
		intGastosEnvio.setBounds(698, 108, 45, 13);
		contentPane.add(intGastosEnvio);
		
		JLabel intTotalCarrito = new JLabel(texto);
		intTotalCarrito.setBounds(698, 73, 45, 13);
		contentPane.add(intTotalCarrito);

		JLabel intTotlPagar = new JLabel(texto2);
		intTotlPagar.setBounds(698, 148, 91, 13);
		contentPane.add(intTotlPagar);
		
		JLabel labelCarritoFondo = new JLabel("");
		labelCarritoFondo.setHorizontalAlignment(SwingConstants.TRAILING);
		labelCarritoFondo.setBounds(0, 0, 816, 441);
		ImageIcon ico4 = new ImageIcon("imagenes/supermercado.jpg");
        ImageIcon img4 = new ImageIcon(ico4.getImage().getScaledInstance(labelCarritoFondo.getWidth(), labelCarritoFondo.getHeight(), Image.SCALE_SMOOTH));
        labelCarritoFondo.setIcon(img4);
		contentPane.add(labelCarritoFondo);
		
		botonPasaPorCaja.addActionListener(new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				double precioTotal = 0;
				try {
					PrintWriter pw = new PrintWriter("Recibo.txt");
					for(int i=0;i<modelo1.size();i++) {
						Producto p = modelo1.get(i);
						String texto = String.format("%s   %.2f €", p.getNombre(), p.getPrecio());
						pw.println(texto);
						precioTotal += p.getPrecio();
					}
					pw.println();
					pw.println(String.format(" PRECIO TOTAL: %.2f €", precioTotal + 2.50));
					pw.flush();
					pw.close();
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
					Thread hilo = new Thread(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						labelProcesandoCompra.setVisible(true);
						progressBar.setVisible(true);
						
						for (int i = 0; i <= 100 ; i++) {
							progressBar.setValue(i);
							try {
								Thread.sleep(50);
								
							}catch(InterruptedException e1) {
								e1.printStackTrace();
							}
						}
						
						try {
							con.connect();
							con.vaciarCarrito();
							con.disconnect();
						} catch (DBException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						labelProcesandoCompra.setVisible(false);
						progressBar.setVisible(false);
								
								
						
					}
				});
					hilo.start();
				
			}
		});
		
		
	}
}
