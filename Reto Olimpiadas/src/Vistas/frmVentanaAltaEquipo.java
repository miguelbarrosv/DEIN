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
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class frmVentanaAltaEquipo extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtIniciales;

	private Controlador controlador = new Controlador();
	private ControladorVistas controladorVistas = new ControladorVistas();
	private String nombre;
	private String iniciales;

	/**
	 * Create the frame.
	 */
	public frmVentanaAltaEquipo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAltaEquipo = new JLabel("Alta Equipo");
		lblAltaEquipo.setBounds(175, 12, 100, 15);
		contentPane.add(lblAltaEquipo);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(73, 90, 70, 15);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(175, 88, 114, 19);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblIniciales = new JLabel("Iniciales");
		lblIniciales.setBounds(73, 151, 70, 15);
		contentPane.add(lblIniciales);
		
		txtIniciales = new JTextField();
		txtIniciales.setBounds(175, 149, 114, 19);
		contentPane.add(txtIniciales);
		txtIniciales.setColumns(10);
		
		
		
		JButton btnAadirEquipo = new JButton("Añadir Equipo");
		btnAadirEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nombre = txtNombre.getText();
				iniciales = txtIniciales.getText();
				try {
					controlador.altaEquipo(nombre, iniciales);
					controladorVistas.cerrarVentanaAltaEquipos();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnAadirEquipo.setFont(new Font("Dialog", Font.BOLD, 10));
		btnAadirEquipo.setBounds(310, 238, 114, 25);
		contentPane.add(btnAadirEquipo);
	}
}
