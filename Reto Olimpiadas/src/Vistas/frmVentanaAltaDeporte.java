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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAadeUnDeporte = new JLabel("Añade un deporte");
		lblAadeUnDeporte.setBounds(152, 12, 143, 15);
		contentPane.add(lblAadeUnDeporte);
		
		JLabel lblNombre = new JLabel("Nombre :");
		lblNombre.setBounds(73, 73, 70, 15);
		contentPane.add(lblNombre);
		
		txtNombreDeporte = new JTextField();
		txtNombreDeporte.setBounds(171, 71, 143, 19);
		contentPane.add(txtNombreDeporte);
		txtNombreDeporte.setColumns(10);
		
		JButton btnAadirdeporte = new JButton("Añadir ");
		btnAadirdeporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{ 
				try {
					if (comprobarDatos()) {
						controlador.insertarDeporte(txtNombreDeporte.getText());
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		btnAadirdeporte.setBounds(224, 141, 108, 25);
		contentPane.add(btnAadirdeporte);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				controladorVistas.cerrarVentanaAltaDeporte();
			}
		});
		btnVolver.setBounds(91, 141, 108, 25);
		contentPane.add(btnVolver);
	}
	
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
