
import java.awt.*;


import javax.swing.border.EmptyBorder;
import javax.swing.*;



public class VentanaCarniceria extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCarniceria frame = new VentanaCarniceria();
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
	public VentanaCarniceria() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtrFoto = new JTextArea();
		txtrFoto.setText("FOTO 1");
		txtrFoto.setBounds(44, 10, 57, 57);
		contentPane.add(txtrFoto);
		
		JTextArea txtrFoto_4 = new JTextArea();
		txtrFoto_4.setText("FOTO 2");
		txtrFoto_4.setBounds(139, 10, 57, 57);
		contentPane.add(txtrFoto_4);
		
		JTextArea txtrFoto_1 = new JTextArea();
		txtrFoto_1.setText("FOTO 3");
		txtrFoto_1.setBounds(235, 10, 57, 57);
		contentPane.add(txtrFoto_1);
		
		JTextArea txtrFoto_2 = new JTextArea();
		txtrFoto_2.setText("FOTO 4");
		txtrFoto_2.setBounds(329, 10, 57, 57);
		contentPane.add(txtrFoto_2);
		
		JLabel lblNewLabel = new JLabel("Producto 1");
		lblNewLabel.setBounds(44, 77, 57, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblProducto = new JLabel("Producto 2");
		lblProducto.setBounds(139, 77, 57, 13);
		contentPane.add(lblProducto);
		
		JLabel lblProducto_1 = new JLabel("Producto 3");
		lblProducto_1.setBounds(235, 77, 57, 13);
		contentPane.add(lblProducto_1);
		
		JLabel lblProducto_2 = new JLabel("Producto 4");
		lblProducto_2.setBounds(329, 77, 57, 13);
		contentPane.add(lblProducto_2);
		
		JLabel lblNewLabel_1 = new JLabel("Descripcion");
		lblNewLabel_1.setBounds(44, 100, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Descripcion");
		lblNewLabel_1_1.setBounds(139, 100, 45, 13);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Descripcion");
		lblNewLabel_1_2.setBounds(235, 100, 45, 13);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Descripcion");
		lblNewLabel_1_3.setBounds(329, 100, 45, 13);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_2 = new JLabel("Precio");
		lblNewLabel_2.setBounds(44, 177, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Precio");
		lblNewLabel_2_1.setBounds(139, 177, 45, 13);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Precio");
		lblNewLabel_2_2.setBounds(235, 177, 45, 13);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Precio");
		lblNewLabel_2_3.setBounds(329, 177, 45, 13);
		contentPane.add(lblNewLabel_2_3);
		
		JButton btnNewButton = new JButton("A\u00F1adir");
		btnNewButton.setBounds(22, 200, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("A\u00F1adir");
		btnNewButton_1.setBounds(121, 200, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("A\u00F1adir");
		btnNewButton_2.setBounds(216, 200, 85, 21);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("A\u00F1adir");
		btnNewButton_3.setBounds(324, 200, 85, 21);
		contentPane.add(btnNewButton_3);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setMinimum(10);
		scrollBar.setMaximum(419);
		scrollBar.setBounds(419, 10, 17, 423);
		contentPane.add(scrollBar);
		
		JTextArea txtrFoto_5 = new JTextArea();
		txtrFoto_5.setText("FOTO 5");
		txtrFoto_5.setBounds(44, 233, 57, 48);
		contentPane.add(txtrFoto_5);
		
		JTextArea txtrFoto_3_1 = new JTextArea();
		txtrFoto_3_1.setText("FOTO 6");
		txtrFoto_3_1.setBounds(139, 233, 57, 48);
		contentPane.add(txtrFoto_3_1);
		
		JTextArea txtrFoto_3_2 = new JTextArea();
		txtrFoto_3_2.setText("FOTO 7");
		txtrFoto_3_2.setBounds(235, 233, 57, 48);
		contentPane.add(txtrFoto_3_2);
		
		JTextArea txtrFoto_3_3 = new JTextArea();
		txtrFoto_3_3.setText("FOTO 8");
		txtrFoto_3_3.setBounds(329, 233, 57, 48);
		contentPane.add(txtrFoto_3_3);
		
		JLabel lblProducto_3 = new JLabel("Producto 5");
		lblProducto_3.setBounds(44, 291, 57, 13);
		contentPane.add(lblProducto_3);
		
		JLabel lblProducto_4 = new JLabel("Producto 6");
		lblProducto_4.setBounds(139, 291, 57, 13);
		contentPane.add(lblProducto_4);
		
		JLabel lblProducto_5 = new JLabel("Producto 7");
		lblProducto_5.setBounds(235, 291, 57, 13);
		contentPane.add(lblProducto_5);
		
		JLabel lblProducto_6 = new JLabel("Producto 8");
		lblProducto_6.setBounds(329, 291, 57, 13);
		contentPane.add(lblProducto_6);
		
		JLabel lblNewLabel_1_4 = new JLabel("Descripcion");
		lblNewLabel_1_4.setBounds(44, 314, 45, 13);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Descripcion");
		lblNewLabel_1_5.setBounds(139, 314, 45, 13);
		contentPane.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Descripcion");
		lblNewLabel_1_6.setBounds(235, 314, 45, 13);
		contentPane.add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_7 = new JLabel("Descripcion");
		lblNewLabel_1_7.setBounds(329, 314, 45, 13);
		contentPane.add(lblNewLabel_1_7);
		
		JLabel lblNewLabel_2_4 = new JLabel("Precio");
		lblNewLabel_2_4.setBounds(44, 384, 45, 13);
		contentPane.add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_5 = new JLabel("Precio");
		lblNewLabel_2_5.setBounds(139, 384, 45, 13);
		contentPane.add(lblNewLabel_2_5);
		
		JLabel lblNewLabel_2_6 = new JLabel("Precio");
		lblNewLabel_2_6.setBounds(235, 384, 45, 13);
		contentPane.add(lblNewLabel_2_6);
		
		JLabel lblNewLabel_2_7 = new JLabel("Precio");
		lblNewLabel_2_7.setBounds(324, 384, 45, 13);
		contentPane.add(lblNewLabel_2_7);
		
		JButton btnNewButton_4 = new JButton("A\u00F1adir");
		btnNewButton_4.setBounds(22, 407, 85, 21);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("A\u00F1adir");
		btnNewButton_5.setBounds(121, 407, 85, 21);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("A\u00F1adir");
		btnNewButton_6.setBounds(216, 407, 85, 21);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("A\u00F1adir");
		btnNewButton_7.setBounds(324, 407, 85, 21);
		contentPane.add(btnNewButton_7);
	}
}
