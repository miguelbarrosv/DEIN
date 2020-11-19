package Vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import ComponentePersonalizado.txtAñoPersonalizado;
import Excepciones.RepetidoException;
import UML.Controlador;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.help.HelpSetException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
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
	private JTextField txtNombre;
	

	/**
	 * Create the frame.
	 * @throws HelpSetException 
	 */
	public frmVentanaAltaOlimpiada() throws HelpSetException {
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
					nombre = txtNombre.getText();
					ciudad = txtCiudad.getText();
					
					controlador.altaOlimpiada(anio,nombre,ciudad);
					controladorVistas.cerrarVentanaAltaOlimpiada();
					controladorVistas.cerrarVentanaPrincipal();
					controladorVistas.abrirVentanaPrincipal();
						
				} catch (RepetidoException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		contentPane.add(btnAadir);
		
		txtAnio = new txtAñoPersonalizado();
		txtAnio.setBounds(171, 68, 132, 19);
		contentPane.add(txtAnio);
		txtAnio.setColumns(10);
		
		JLabel lblNombre_1 = new JLabel("Nombre:");
		lblNombre_1.setBounds(40, 134, 70, 15);
		contentPane.add(lblNombre_1);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(174, 134, 135, 19);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtAnio.getDocument().addDocumentListener((DocumentListener) new DocumentListener() {
		     public void changedUpdate(DocumentEvent e) {
		       warn();
		     }
		     public void removeUpdate(DocumentEvent e) {
		       warn();
		     }
		     public void insertUpdate(DocumentEvent e) {
		       warn();
		     }

		     public void warn() {
		    	try {
		    		int anio = Integer.parseInt(txtAnio.getText());
			        
		    		if (anio < 1930 || anio > 2020) {
		    			txtAnio.setBackground(Color.orange);
		    		} else {
		    			txtAnio.setBackground(Color.white);
		    		}
			        
		    	} catch (NumberFormatException e) {
		    		txtAnio.setBackground(Color.red);
		    	}
		        
		     }
		});
		ponerAyuda();
	}
	
	/**
	 * 	Ponemos la ayuda a esta pantalla pulsando en F1
	 * 
	 * @throws HelpSetException
	 */
	private void ponerAyuda() throws HelpSetException {
		try 
		{
			File fichero = new File("Help"+File.separator+"help_set.hs");
			URL hsURL = fichero.toURI().toURL();
			
			HelpSet helpset = new HelpSet(getClass().getClassLoader(),hsURL);
			HelpBroker hb = helpset.createHelpBroker();
			
			hb.enableHelpKey(getRootPane(),"olimpiada", helpset);
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
