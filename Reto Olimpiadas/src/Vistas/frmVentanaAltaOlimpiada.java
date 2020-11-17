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
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SpringLayout;

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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblAadirOlimpiada = new JLabel("Alta Olimpiada");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblAadirOlimpiada, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblAadirOlimpiada, 169, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblAadirOlimpiada, 25, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblAadirOlimpiada, -157, SpringLayout.EAST, contentPane);
		contentPane.add(lblAadirOlimpiada);
		
		JLabel lblNombre = new JLabel("Año:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNombre, 65, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNombre, 35, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNombre, 80, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNombre, 105, SpringLayout.WEST, contentPane);
		contentPane.add(lblNombre);
		
		txtAnio = new JFormattedTextField(java.text.NumberFormat.getNumberInstance());
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtAnio, -1, SpringLayout.NORTH, lblNombre);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtAnio, 148, SpringLayout.WEST, contentPane);
		contentPane.add(txtAnio);
		
		JLabel lblTemporada = new JLabel("Temporada:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblTemporada, 123, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblTemporada, 35, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblTemporada, 138, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblTemporada, 137, SpringLayout.WEST, contentPane);
		contentPane.add(lblTemporada);
		
		final JComboBox cbTemporada = new JComboBox();
		sl_contentPane.putConstraint(SpringLayout.NORTH, cbTemporada, -5, SpringLayout.NORTH, lblTemporada);
		sl_contentPane.putConstraint(SpringLayout.WEST, cbTemporada, 148, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, cbTemporada, 0, SpringLayout.EAST, lblAadirOlimpiada);
		cbTemporada.setModel(new DefaultComboBoxModel(new String[] {"Summer", "Winter"}));
		contentPane.add(cbTemporada);
		
		JLabel lblCiudad = new JLabel("Ciudad:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblCiudad, 185, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblCiudad, 35, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblCiudad, 200, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblCiudad, 105, SpringLayout.WEST, contentPane);
		contentPane.add(lblCiudad);
		
		txtCiudad = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.WEST, txtCiudad, 43, SpringLayout.EAST, lblCiudad);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtCiudad, -136, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtAnio, 0, SpringLayout.EAST, txtCiudad);
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtCiudad, -2, SpringLayout.NORTH, lblCiudad);
		contentPane.add(txtCiudad);
		txtCiudad.setColumns(10);
		
		JButton btnAadir = new JButton("Añadir");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnAadir, 226, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnAadir, 316, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnAadir, 251, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnAadir, 409, SpringLayout.WEST, contentPane);
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				anio = Integer.parseInt(txtAnio.getText());
				temporada = (String) cbTemporada.getSelectedItem();
				nombre = txtAnio.getText()  + " " + temporada;
				ciudad = txtCiudad.getText();
				try {
					if (nombre.isEmpty()) {
						throw new Exception("El nombre del deporte es obligatorio");
					}
					
					if (comprobarNombreOlimpiada()) {
						try {
							controlador.altaOlimpiada(anio,temporada,nombre,ciudad);
							controladorVistas.cerrarVentanaAltaOlimpiada();
							controladorVistas.cerrarVentanaOlimpiada();
							controladorVistas.abrirVentanaPrincipal();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					} else
						throw new Exception("El nombre del deporte introducido ya existe");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		contentPane.add(btnAadir);
	}
	
	/**
	 * Comprobamos que el nombre de olimpiada que nos introducen no se repite, si se repite devolveremos False, si no se repite devolveremos true.
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean comprobarNombreOlimpiada() throws SQLException {
		Boolean comprobacion = false;
		if(controlador.comprobarOlimpiada(nombre)) {
			comprobacion = true;
		} else 
			comprobacion = false;		
		
		return comprobacion;
		}
}
