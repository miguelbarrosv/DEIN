package Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Excepciones.RepetidoException;
import UML.Controlador;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 259);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblAltaEquipo = new JLabel("Alta Equipo");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblAltaEquipo, 16, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblAltaEquipo, 188, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblAltaEquipo, 302, SpringLayout.WEST, contentPane);
		contentPane.add(lblAltaEquipo);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNombre, 72, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNombre, 95, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNombre, 82, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNombre, 165, SpringLayout.WEST, contentPane);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtNombre, 70, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtNombre, 188, SpringLayout.WEST, contentPane);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtIniciales = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtIniciales, 129, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtIniciales, 188, SpringLayout.WEST, contentPane);
		contentPane.add(txtIniciales);
		txtIniciales.setColumns(10);
		
		
		
		JButton btnAadirEquipo = new JButton("Añadir ");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnAadirEquipo, 186, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnAadirEquipo, 331, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnAadirEquipo, -10, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnAadirEquipo, -10, SpringLayout.EAST, contentPane);
		btnAadirEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nombre = txtNombre.getText();
				iniciales = txtIniciales.getText();
				try {
					controlador.altaEquipo(nombre, iniciales);
					controladorVistas.cerrarVentanaAltaEquipos();
					controladorVistas.cerrarVentanaEquipos();
					controladorVistas.abrirVentanaEquipos();
				} catch (RepetidoException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		btnAadirEquipo.setFont(new Font("Dialog", Font.BOLD, 12));
		contentPane.add(btnAadirEquipo);
		
		JLabel lblIniciales = new JLabel("Iniciales: ");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblIniciales, 131, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblIniciales, 95, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblIniciales, 165, SpringLayout.WEST, contentPane);
		contentPane.add(lblIniciales);
	}
}
