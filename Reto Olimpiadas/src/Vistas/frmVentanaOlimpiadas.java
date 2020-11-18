package Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ComponentesPersonalizados.MenuPersonalizado;
import ComponentesPersonalizados.TablaPersonalizada;
import UML.Controlador;
import UML.Olimpiada;

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

public class frmVentanaOlimpiadas extends JFrame {

	private JPanel contentPane;	
	private JTable tableOlimpiadas;
	private ControladorVistas controladorVistas = new ControladorVistas();
	private Controlador controlador = new Controlador();
	private ArrayList<Olimpiada> olimpiadas = new ArrayList();
	private JPanel panel;
	private JLabel lblParticipacion;
	private JLabel lblEquipos;
	private JLabel lblDeportista;
	private JLabel lblDeporte;
	private JLabel lblEvento;
	private JLabel lblOlimpiadas_1;
	private JLabel lblInicio;
	private JTextField txtNombre;
	private JTextField txtAnio;
	private JTextField txtTemporada;
	private JTextField txtCiudad;
	
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
	public frmVentanaOlimpiadas() throws SQLException, HelpSetException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 844, 609);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblOlimpiadas = new JLabel("Lista de Olimpiadas");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblOlimpiadas, 15, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblOlimpiadas, 405, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblOlimpiadas, 55, SpringLayout.NORTH, contentPane);
		lblOlimpiadas.setFont(new Font("Dialog", Font.BOLD, 16));
		contentPane.add(lblOlimpiadas);
		
		TablaPersonalizada tableModel  = new TablaPersonalizada("olimpiadas");
		
		JButton btnAadirOlimpiada = new JButton("Alta Olimpiada");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnAadirOlimpiada, 538, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnAadirOlimpiada, 674, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnAadirOlimpiada, 823, SpringLayout.WEST, contentPane);
		btnAadirOlimpiada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					controladorVistas.abrirVentanaOlimpiadaAlta();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		
		btnAadirOlimpiada.setFont(new Font("Dialog", Font.BOLD, 12));
		contentPane.add(btnAadirOlimpiada);
				
		JScrollPane scrollPane = new JScrollPane();
		sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane, 61, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane, 202, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane, 388, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane, 823, SpringLayout.WEST, contentPane);
		contentPane.add(scrollPane);
		tableOlimpiadas = new JTable(tableModel);
		scrollPane.setViewportView(tableOlimpiadas);
		
		
		MenuPersonalizado panel = new MenuPersonalizado("olimpiada");
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel, 5, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel, 5, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel, 589, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel, 192, SpringLayout.WEST, contentPane);
		panel.setBackground(new Color(255,153,0));
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNombre = new JLabel("Nombre:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNombre, 417, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNombre, 243, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNombre, 431, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNombre, 313, SpringLayout.WEST, contentPane);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtNombre, 415, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtNombre, 337, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtNombre, 468, SpringLayout.WEST, contentPane);
		txtNombre.setEnabled(false);
		txtNombre.setEditable(false);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblAo = new JLabel("A\u00F1o:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblAo, 479, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblAo, 243, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblAo, 493, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblAo, 301, SpringLayout.WEST, contentPane);
		contentPane.add(lblAo);
		
		txtAnio = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtAnio, 477, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtAnio, 337, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtAnio, 497, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtAnio, 468, SpringLayout.WEST, contentPane);
		txtAnio.setEditable(false);
		txtAnio.setEnabled(false);
		contentPane.add(txtAnio);
		txtAnio.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Temporada:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 417, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 519, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel, 431, SpringLayout.NORTH, contentPane);
		contentPane.add(lblNewLabel);
		
		txtTemporada = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtTemporada, 415, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtTemporada, 652, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtTemporada, 788, SpringLayout.WEST, contentPane);
		txtTemporada.setEditable(false);
		txtTemporada.setEnabled(false);
		contentPane.add(txtTemporada);
		txtTemporada.setColumns(10);
		
		JLabel lblCiudad = new JLabel("Ciudad:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblCiudad, 479, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblCiudad, 519, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblCiudad, 593, SpringLayout.WEST, contentPane);
		contentPane.add(lblCiudad);
		
		txtCiudad = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtCiudad, 477, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtCiudad, 652, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtCiudad, 783, SpringLayout.WEST, contentPane);
		txtCiudad.setEditable(false);
		txtCiudad.setEnabled(false);
		contentPane.add(txtCiudad);
		txtCiudad.setColumns(10);
		
		final JButton btnModificar = new JButton("Modificar");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnModificar, 539, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnModificar, 553, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnModificar, 660, SpringLayout.WEST, contentPane);
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controlador.modificarOlimpiada(idOlimpiada,txtNombre.getText(), txtAnio.getText(), txtCiudad.getText(),txtTemporada.getText());
					controladorVistas.cerrarVentanaOlimpiada();
					ControladorVistas.abrirVentanaPrincipal();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (HelpSetException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		btnModificar.setEnabled(false);
		contentPane.add(btnModificar);
		
		final JButton btnEliminar = new JButton("Eliminar");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnEliminar, 539, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnEliminar, 434, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnEliminar, 562, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnEliminar, 534, SpringLayout.WEST, contentPane);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int respuesta = JOptionPane.showConfirmDialog(null, "Estas seguro de que quieres eliminar esta olimpiada?");
				
				if (respuesta == 0) {
					try {
						controlador.eliminarOlimpiada(idOlimpiada);
						controladorVistas.cerrarVentanaOlimpiada();
						ControladorVistas.abrirVentanaPrincipal();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (HelpSetException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
		btnEliminar.setEnabled(false);
		contentPane.add(btnEliminar);
		
		tableOlimpiadas.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		    	idOlimpiada = (int) tableOlimpiadas.getValueAt(tableOlimpiadas.getSelectedRow(), 0);
		        nombre = tableOlimpiadas.getValueAt(tableOlimpiadas.getSelectedRow(), 1).toString();
		        anio = tableOlimpiadas.getValueAt(tableOlimpiadas.getSelectedRow(), 3).toString();
		        ciudad =  tableOlimpiadas.getValueAt(tableOlimpiadas.getSelectedRow(), 4).toString();
		        temporada = tableOlimpiadas.getValueAt(tableOlimpiadas.getSelectedRow(), 2).toString();

		        txtCiudad.setEditable(true);
		        txtCiudad.setEnabled(true);
				txtCiudad.setText(ciudad);

				
				txtTemporada.setEditable(true);
				txtTemporada.setEnabled(true);
				txtTemporada.setText(temporada);

				
				txtNombre.setEditable(true);
				txtNombre.setEnabled(true);
				txtNombre.setText(nombre);
				
				txtAnio.setEnabled(true);
				txtAnio.setEditable(true);
				txtAnio.setText(anio);

				
				btnModificar.setEnabled(true);
				btnEliminar.setEnabled(true);
		        
			    System.out.print(idOlimpiada + " " + nombre + " " + temporada + " " + anio + " " + ciudad);
		    }
		});
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
			
			//hb.enableHelpOnButton(btnAiuda, "clsVentanaOlimpiada", helpset);
			hb.enableHelpKey(getRootPane(),"olimpiada", helpset);
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
