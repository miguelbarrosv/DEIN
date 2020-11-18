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
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SpringLayout;

public class frmVentanaAltaOlimpiada extends JFrame {

	private JPanel contentPane;
	private JTextField txtCiudad;
	private ControladorVistas controladorVistas = new ControladorVistas();
	private Controlador controlador = new Controlador();
	public String nombre;
	public String temporada;
	public int anio;
	public String ciudad;
	private JTextField txtAnio;
	

	/**
	 * Create the frame.
	 */
	public frmVentanaAltaOlimpiada() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAadirOlimpiada = new JLabel("Alta Olimpiada");
		lblAadirOlimpiada.setBounds(174, 15, 114, 15);
		contentPane.add(lblAadirOlimpiada);
		
		JLabel lblNombre = new JLabel("Año:");
		lblNombre.setBounds(40, 70, 70, 15);
		contentPane.add(lblNombre);
		
		JLabel lblTemporada = new JLabel("Temporada:");
		lblTemporada.setBounds(40, 128, 102, 15);
		contentPane.add(lblTemporada);
		
		final JComboBox cbTemporada = new JComboBox();
		cbTemporada.setBounds(171, 123, 132, 24);
		cbTemporada.setModel(new DefaultComboBoxModel(new String[] {"Summer", "Winter"}));
		contentPane.add(cbTemporada);
		
		JLabel lblCiudad = new JLabel("Ciudad:");
		lblCiudad.setBounds(40, 190, 70, 15);
		contentPane.add(lblCiudad);
		
		txtCiudad = new JTextField();
		txtCiudad.setBounds(174, 188, 135, 19);
		contentPane.add(txtCiudad);
		txtCiudad.setColumns(10);
		
		JButton btnAadir = new JButton("Añadir");
		btnAadir.setBounds(321, 231, 93, 25);
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (txtAnio.getText().isEmpty()) {
						throw new RepetidoException("El nombre del deporte es obligatorio");
					}
					
					anio = Integer.parseInt(txtAnio.getText());
					temporada = (String) cbTemporada.getSelectedItem();
					nombre = txtAnio.getText()  + " " + temporada;
					ciudad = txtCiudad.getText();
					
					controlador.altaOlimpiada(anio,temporada,nombre,ciudad);
					controladorVistas.cerrarVentanaAltaOlimpiada();
					controladorVistas.cerrarVentanaOlimpiada();
					controladorVistas.abrirVentanaOlimpiada();
						
				} catch (RepetidoException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		contentPane.add(btnAadir);
		
		txtAnio = new JTextField();
		txtAnio.setBounds(171, 68, 132, 19);
		contentPane.add(txtAnio);
		txtAnio.setColumns(10);
	}
}
