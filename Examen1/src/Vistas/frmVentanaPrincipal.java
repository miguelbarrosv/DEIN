package Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import ComponentePersonalizado.TablaPersonalizada;
import ComponentePersonalizado.txtAñoPersonalizado;
import UML.Controlador;
import UML.Olimpiada;
import UML.OlimpiadaTabla;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import java.awt.Choice;
import java.awt.Button;

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.help.HelpSetException;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Scrollbar;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.JComboBox;

public class frmVentanaPrincipal extends JFrame {

	private JPanel contentPane;	
	private JTable tableOlimpiadas;
	private ControladorVistas controladorVistas = new ControladorVistas();
	private Controlador controlador = new Controlador();
	private ArrayList<Olimpiada> olimpiadas = new ArrayList();
	private ArrayList<OlimpiadaTabla> olimpiadasTabla = new ArrayList();
	private JPanel panel;
	private JLabel lblParticipacion;
	private JLabel lblEquipos;
	private JLabel lblDeportista;
	private JLabel lblDeporte;
	private JLabel lblEvento;
	private JLabel lblOlimpiadas_1;
	private JLabel lblInicio;
	private JTextField txtAnio;
	TablaPersonalizada tableModel;
	int idOlimpiada;
    String nombre;
    String anio;
    String ciudad;
    String temporada;

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws HelpSetException 
	 */
	public frmVentanaPrincipal() throws SQLException, HelpSetException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 844, 609);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblOlimpiadas = new JLabel("Lista de Olimpiadas");
		lblOlimpiadas.setBounds(305, 12, 170, 40);
		lblOlimpiadas.setFont(new Font("Dialog", Font.BOLD, 16));
		contentPane.add(lblOlimpiadas);
		
		tableModel  = new TablaPersonalizada("olimpiadas");
		
		JButton btnAadirOlimpiada = new JButton("Alta Olimpiada");
		btnAadirOlimpiada.setBounds(621, 547, 149, 25);
		btnAadirOlimpiada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					controladorVistas.abrirVentanaOlimpiadaAlta();
				} catch (HelpSetException e) {
					e.printStackTrace();
				}
			}
		});
		
		btnAadirOlimpiada.setFont(new Font("Dialog", Font.BOLD, 12));
		contentPane.add(btnAadirOlimpiada);
				
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 190, 733, 327);
		contentPane.add(scrollPane);
		tableOlimpiadas = new JTable(tableModel);
		scrollPane.setViewportView(tableOlimpiadas);
		
		JLabel lblAo = new JLabel("A\u00F1o:");
		lblAo.setBounds(37, 143, 58, 14);
		contentPane.add(lblAo);
		
		txtAnio = new txtAñoPersonalizado();
		txtAnio.setBounds(113, 138, 131, 19);
		txtAnio.setEditable(true);
		txtAnio.setEnabled(true);
		contentPane.add(txtAnio);
		txtAnio.setColumns(10);
		
		JLabel lblCiudad = new JLabel("Ciudad:");
		lblCiudad.setBounds(305, 140, 74, 15);
		contentPane.add(lblCiudad);
		
		JComboBox cbCiudad = new JComboBox();
		cbCiudad.setEditable(true);
		cbCiudad.setBounds(394, 132, 139, 25);
		contentPane.add(cbCiudad);
		
		olimpiadas = controlador.consultarCiudades();
		
		for (int x = 0; x < olimpiadas.size(); x++) {
			cbCiudad.addItem(olimpiadas.get(x).getCiudad());
		}
		
		JLabel lblFiltrarPor = new JLabel("Filtrar por:");
		lblFiltrarPor.setBounds(37, 86, 102, 15);
		contentPane.add(lblFiltrarPor);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					olimpiadasTabla = controlador.buscarOlimpiadasFiltros(Integer.parseInt(txtAnio.getText()),cbCiudad.getSelectedItem().toString());
					tableModel.refrescarTabla(olimpiadasTabla);
					tableModel.fireTableDataChanged();
				} catch (NumberFormatException e ) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Año introducido no valido");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		btnBuscar.setBounds(629, 132, 117, 25);
		contentPane.add(btnBuscar);
		
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
			
			hb.enableHelpKey(getRootPane(),"principal", helpset);
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
