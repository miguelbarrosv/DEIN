package Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import ComponentesPersonalizados.MenuPersonalizado;
import ComponentesPersonalizados.TablaPersonalizada;
import UML.Controlador;
import UML.Equipo;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.help.HelpSetException;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SpringLayout;



public class frmVentanaEquipos extends JFrame {

	private JPanel contentPane;
	private ControladorVistas controladorVistas = new ControladorVistas();
	private Controlador controlador = new Controlador();
	private ArrayList<Equipo> equipos = new ArrayList();
	private JTextField txtNombre;
	private JTable tableEquipos;
	int idEquipo;
	String iniciales;
	String nombre;
	private JTextField txtIniciales;



	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws HelpSetException 
	 */
	public frmVentanaEquipos() throws SQLException, HelpSetException {
		ponerAyuda();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 893, 619);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblListaDeEquipos = new JLabel("Lista de equipos");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblListaDeEquipos, 22, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblListaDeEquipos, 469, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblListaDeEquipos, 37, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblListaDeEquipos, 563, SpringLayout.WEST, contentPane);
		contentPane.add(lblListaDeEquipos);
		
		TablaPersonalizada tableModel  = new TablaPersonalizada("equipos");
		
		tableEquipos = new JTable(tableModel);
		tableEquipos.setBounds(241, 59, 569, 346);
		JScrollPane scrollPane = new JScrollPane();
		sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane, 27, SpringLayout.SOUTH, lblListaDeEquipos);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane, 393, SpringLayout.NORTH, contentPane);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(tableEquipos);
		
		MenuPersonalizado panel = new MenuPersonalizado("equipos");
		sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane, 26, SpringLayout.EAST, panel);
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel, 581, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel, 187, SpringLayout.WEST, contentPane);
		panel.setBackground(Color.BLACK);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		
		JButton btnAadirEquipo = new JButton("Alta Equipo");
		sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane, 0, SpringLayout.EAST, btnAadirEquipo);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnAadirEquipo, 546, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnAadirEquipo, 742, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnAadirEquipo, 571, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnAadirEquipo, 856, SpringLayout.WEST, contentPane);
		
		btnAadirEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorVistas.abrirVentanaAltaEquipos();
			}
		});
		btnAadirEquipo.setFont(new Font("Dialog", Font.BOLD, 10));
		contentPane.add(btnAadirEquipo);
		
		JLabel lblNombre = new JLabel("Nombre:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNombre, 444, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNombre, 241, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNombre, 313, SpringLayout.WEST, contentPane);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtNombre, 442, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtNombre, 338, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtNombre, 486, SpringLayout.WEST, contentPane);
		txtNombre.setEditable(false);
		txtNombre.setEnabled(false);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		final JButton btnModificar = new JButton("Modificar");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnModificar, 546, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnModificar, 617, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnModificar, 731, SpringLayout.WEST, contentPane);
		btnModificar.setEnabled(false);
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					controlador.modificarEquipo(idEquipo, iniciales, nombre);
					controladorVistas.cerrarVentanaEquipos();
					controladorVistas.abrirVentanaPrincipal();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (HelpSetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		contentPane.add(btnModificar);
		
		txtIniciales = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtIniciales, 491, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtIniciales, 338, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtIniciales, 510, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtIniciales, 0, SpringLayout.EAST, txtNombre);
		txtIniciales.setEnabled(false);
		txtIniciales.setEditable(false);
		contentPane.add(txtIniciales);
		txtIniciales.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Iniciales:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 493, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 243, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel, 508, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel, 313, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel);
		
		final JButton btnEliminar = new JButton("Eliminar");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnEliminar, 545, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnEliminar, 504, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnEliminar, 570, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnEliminar, 606, SpringLayout.WEST, contentPane);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int respuesta = JOptionPane.showConfirmDialog(null, "Estas seguro de que quieres eliminar a este deportista?");
				
				if (respuesta == 0) {
					try {
						controlador.eliminarEquipo(idEquipo);
						controladorVistas.cerrarVentanaEquipos();
						ControladorVistas.abrirVentanaPrincipal();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (HelpSetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		btnEliminar.setEnabled(false);
		contentPane.add(btnEliminar);
		
		
		tableEquipos.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		    	idEquipo = (int)tableEquipos.getValueAt(tableEquipos.getSelectedRow(), 0);
		    	iniciales = tableEquipos.getValueAt(tableEquipos.getSelectedRow(), 1).toString();
		    	nombre = tableEquipos.getValueAt(tableEquipos.getSelectedRow(), 2).toString();
		    	
		    	txtIniciales.setEditable(true);
		    	txtIniciales.setEnabled(true);
		    	txtIniciales.setText(iniciales);
		    	
		    	txtNombre.setEditable(true);
		    	txtNombre.setEnabled(true);
		    	txtNombre.setText(nombre);
		    	
		    	btnModificar.setEnabled(true);
		    	btnEliminar.setEnabled(true);
		    	
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
			
			//hb.enableHelpOnButton(btnAiuda, "clsVentanaEquipo", helpset);
			hb.enableHelpKey(getRootPane(),"clsVentanaEquipo", helpset);
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
