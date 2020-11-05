package Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import UML.Controlador;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class frmVentanaAltaOlimpiada extends JFrame {

	private JPanel contentPane;
	private JTextField txtAnio;
	private JTextField txtCiudad;
	private ControladorVistas controladorVistas = new ControladorVistas();
	private Controlador controlador = new Controlador();
	public String nombre;
	public String temporada;
	public int anio;
	public String ciudad;
	

	/**
	 * Create the frame.
	 */
	public frmVentanaAltaOlimpiada() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAadirOlimpiada = new JLabel("Añadir Olimpiada");
		lblAadirOlimpiada.setBounds(168, 12, 133, 15);
		contentPane.add(lblAadirOlimpiada);
		
		JLabel lblNombre = new JLabel("Año:");
		lblNombre.setBounds(35, 65, 70, 15);
		contentPane.add(lblNombre);
		
		txtAnio = new JTextField();
		txtAnio.setBounds(91, 63, 114, 19);
		contentPane.add(txtAnio);
		txtAnio.setColumns(10);
		
		JLabel lblTemporada = new JLabel("Temporada:");
		lblTemporada.setBounds(35, 123, 102, 15);
		contentPane.add(lblTemporada);
		
		final JComboBox cbTemporada = new JComboBox();
		cbTemporada.setModel(new DefaultComboBoxModel(new String[] {"Summer", "Winter"}));
		cbTemporada.setBounds(148, 118, 102, 24);
		contentPane.add(cbTemporada);
		
		JLabel lblCiudad = new JLabel("Ciudad:");
		lblCiudad.setBounds(35, 185, 70, 15);
		contentPane.add(lblCiudad);
		
		txtCiudad = new JTextField();
		txtCiudad.setBounds(109, 183, 114, 19);
		contentPane.add(txtCiudad);
		txtCiudad.setColumns(10);
		
		JButton btnAadir = new JButton("Añadir");
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				anio = Integer.parseInt(txtAnio.getText());
				temporada = (String) cbTemporada.getSelectedItem();
				nombre = txtAnio.getText()  + " " + temporada;
				ciudad = txtCiudad.getText();
				try {
					controlador.altaOlimpiada(anio,temporada,nombre,ciudad);
					controladorVistas.cerrarVentanaAltaOlimpiada();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		btnAadir.setBounds(316, 226, 93, 25);
		contentPane.add(btnAadir);
	}
}
