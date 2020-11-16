package Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import UML.Controlador;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SpringLayout;

public class frmVentanaAltaDeporte extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombreDeporte;
	private ControladorVistas controladorVistas = new ControladorVistas();
	private Controlador controlador = new Controlador();
	private Boolean comprobacion;


	/**
	 * Create the frame.
	 */
	public frmVentanaAltaDeporte() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 218);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblAadeUnDeporte = new JLabel("Alta Deporte");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblAadeUnDeporte, 11, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblAadeUnDeporte, 188, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblAadeUnDeporte, 26, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblAadeUnDeporte, 258, SpringLayout.WEST, contentPane);
		contentPane.add(lblAadeUnDeporte);
		
		JLabel lblNombre = new JLabel("Nombre :");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNombre, 73, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNombre, 41, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNombre, 88, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNombre, 111, SpringLayout.WEST, contentPane);
		contentPane.add(lblNombre);
		
		txtNombreDeporte = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtNombreDeporte, 70, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtNombreDeporte, 136, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtNombreDeporte, 89, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtNombreDeporte, 279, SpringLayout.WEST, contentPane);
		contentPane.add(txtNombreDeporte);
		txtNombreDeporte.setColumns(10);
		
		JButton btnAadirdeporte = new JButton("Añadir ");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnAadirdeporte, 124, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnAadirdeporte, 306, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnAadirdeporte, -15, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnAadirdeporte, -10, SpringLayout.EAST, contentPane);
		btnAadirdeporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{ 
				try {
					if (comprobarDatos()) {
						controlador.insertarDeporte(txtNombreDeporte.getText());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		contentPane.add(btnAadirdeporte);
	}
	
	/**
	 * Comprobamos que los datos que nos introducen son correctos, si son correctos devolveremos true, si no son correctos se devolvera false.
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean comprobarDatos() throws Exception {
		try {
			String nombre = txtNombreDeporte.getText();
			
			if (nombre.isEmpty()) {
				throw new Exception("El nombre del deporte es obligatorio");
			} 
			
			if (controlador.comprobarDeporte(nombre)) {
				throw new Exception("El nombre del deporte introducido ya existe");
			} 
			
			return true;
		} catch (Exception e) {
			
			return false;
		}
		
		
		
		
	}
}
