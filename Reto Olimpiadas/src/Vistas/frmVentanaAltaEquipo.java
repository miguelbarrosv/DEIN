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
import javax.swing.SpringLayout;

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
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblAltaEquipo = new JLabel("Alta Equipo");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblAltaEquipo, 11, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblAltaEquipo, 183, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblAltaEquipo, 26, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblAltaEquipo, 246, SpringLayout.WEST, contentPane);
		contentPane.add(lblAltaEquipo);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNombre, 90, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNombre, 73, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNombre, 105, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNombre, 143, SpringLayout.WEST, contentPane);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtNombre, 87, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtNombre, 156, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtNombre, 106, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtNombre, 270, SpringLayout.WEST, contentPane);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblIniciales = new JLabel("Iniciales:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblIniciales, 151, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblIniciales, 73, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblIniciales, 166, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblIniciales, 143, SpringLayout.WEST, contentPane);
		contentPane.add(lblIniciales);
		
		txtIniciales = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtIniciales, 148, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtIniciales, 156, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtIniciales, 167, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtIniciales, 270, SpringLayout.WEST, contentPane);
		contentPane.add(txtIniciales);
		txtIniciales.setColumns(10);
		
		
		
		JButton btnAadirEquipo = new JButton("Añadir Equipo");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnAadirEquipo, 225, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnAadirEquipo, 299, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnAadirEquipo, 250, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnAadirEquipo, 413, SpringLayout.WEST, contentPane);
		btnAadirEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nombre = txtNombre.getText();
				iniciales = txtIniciales.getText();
				try {
					if(controlador.comprobarEquipo(nombre)) {
						controlador.altaEquipo(nombre, iniciales);
						controladorVistas.cerrarVentanaAltaEquipos();
					} else
						throw new Exception("Ya existe un equipo con este nombre");
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		btnAadirEquipo.setFont(new Font("Dialog", Font.BOLD, 10));
		contentPane.add(btnAadirEquipo);
	}
}
