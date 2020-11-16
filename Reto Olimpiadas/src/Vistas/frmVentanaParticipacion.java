package Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import UML.Controlador;
import UML.Deportista;
import UML.Equipo;
import UML.Participacion;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.table.TableModel;

import ComponentesPersonalizados.MenuPersonalizado;
import ComponentesPersonalizados.TablaPersonalizada;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.help.HelpSetException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.SpringLayout;

public class frmVentanaParticipacion extends JFrame {

	private JPanel contentPane;
	private ControladorVistas controladorVistas = new ControladorVistas();
	private Controlador controlador = new Controlador();
	private ArrayList<Participacion> participaciones = new ArrayList();
	private ArrayList<Deportista> deportistas = new ArrayList();
	private ArrayList<Equipo> equipos = new ArrayList();

	int idEvento;
    int idDeportista;
    int idEquipo ;
	String nombreEvento;
    String nombreDeportista;
    String nombreEquipo ;
    String medalla;
    String edad;
	private JTable tableParticipaciones;
	private JTable tableEquipos;
	private JTextField txtEdad;
	private JTextField txtIdDeportista;
	private JTextField txtIdEvento;
	private JTextField txtIdEquipo;

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws HelpSetException 
	 */
	public frmVentanaParticipacion() throws SQLException, HelpSetException {
		ponerAyuda();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1031, 778);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblParticipaciones = new JLabel("Participaciones");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblParticipaciones, 26, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblParticipaciones, 563, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblParticipaciones, 41, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblParticipaciones, 672, SpringLayout.WEST, contentPane);
		contentPane.add(lblParticipaciones);
		
		
		
		JButton btnNewButton = new JButton("Alta Participacion");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, 699, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 819, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton, 724, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, 1001, SpringLayout.WEST, contentPane);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					controladorVistas.abrirVentanaAltaParticipacion();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		contentPane.add(btnNewButton);
		
		TablaPersonalizada tableModel  = new TablaPersonalizada("participacion");
		
		tableParticipaciones = new JTable(tableModel);
		tableParticipaciones.setBounds(230, 81, 553, 306);
		JScrollPane scrollPane = new JScrollPane();
		sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane, 24, SpringLayout.SOUTH, lblParticipaciones);
		sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane, 207, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane, 368, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane, -10, SpringLayout.EAST, contentPane);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(tableParticipaciones);
		
		MenuPersonalizado panel = new MenuPersonalizado("participacion");
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel, 733, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel, 187, SpringLayout.WEST, contentPane);
		panel.setBackground(Color.BLACK);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		TablaPersonalizada tableModelEquipo  = new TablaPersonalizada("equipos");
		
		tableEquipos = new JTable(tableModelEquipo);
		tableEquipos.setSurrendersFocusOnKeystroke(true);
		tableEquipos.setEnabled(false);
		tableEquipos.setBounds(241, 59, 569, 346);
		JScrollPane scrollPaneEquipo = new JScrollPane();
		sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPaneEquipo, 414, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, scrollPaneEquipo, 0, SpringLayout.WEST, scrollPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, scrollPaneEquipo, 674, SpringLayout.WEST, contentPane);
		scrollPaneEquipo.setEnabled(false);
		contentPane.add(scrollPaneEquipo);
		scrollPaneEquipo.setViewportView(tableEquipos);
		
		JLabel lblEquipo = new JLabel("Selecciona una fila para cambiar de equipo: ");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblEquipo, 392, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblEquipo, 0, SpringLayout.WEST, scrollPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblEquipo, -7, SpringLayout.NORTH, scrollPaneEquipo);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblEquipo, 521, SpringLayout.WEST, contentPane);
		contentPane.add(lblEquipo);
		
		JLabel lblEdad = new JLabel("Edad: ");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblEdad, 421, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblEdad, 726, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblEdad, 436, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblEdad, 778, SpringLayout.WEST, contentPane);
		contentPane.add(lblEdad);
		
		txtEdad = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtEdad, 420, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtEdad, 819, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtEdad, 439, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtEdad, 955, SpringLayout.WEST, contentPane);
		txtEdad.setEditable(false);
		txtEdad.setEnabled(false);
		contentPane.add(txtEdad);
		txtEdad.setColumns(10);
		
		JLabel lblMedalla = new JLabel("Medalla:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblMedalla, 473, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblMedalla, 726, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblMedalla, 488, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblMedalla, 796, SpringLayout.WEST, contentPane);
		contentPane.add(lblMedalla);
		
		final JComboBox cbMedalla = new JComboBox();
		sl_contentPane.putConstraint(SpringLayout.NORTH, cbMedalla, 470, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, cbMedalla, 819, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, cbMedalla, 955, SpringLayout.WEST, contentPane);
		cbMedalla.setModel(new DefaultComboBoxModel(new String[] {"NA", "Bronze", "Silver", "Gold"}));
		cbMedalla.setEnabled(false);
		contentPane.add(cbMedalla);
		cbMedalla.addItem("NA");
		cbMedalla.addItem("Bronze");
		cbMedalla.addItem("Silver");
		cbMedalla.addItem("Gold");
		
		
		final JButton btnModificar = new JButton("Modificar");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnModificar, 699, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnModificar, 692, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnModificar, 724, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnModificar, 809, SpringLayout.WEST, contentPane);
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					controlador.modificarParticipacion( idEvento, idDeportista, idEquipo, medalla, Integer.parseInt(edad));
					controladorVistas.cerrarVentanaParticipacion();
					ControladorVistas.abrirVentanaPrincipal();
				} catch (NumberFormatException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (HelpSetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		btnModificar.setEnabled(false);
		contentPane.add(btnModificar);
		
		final JButton btnEliminar = new JButton("Eliminar");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPaneEquipo, -57, SpringLayout.NORTH, btnEliminar);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnEliminar, 699, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnEliminar, 563, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnEliminar, 724, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnEliminar, 680, SpringLayout.WEST, contentPane);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int respuesta = JOptionPane.showConfirmDialog(null, "Estas seguro de que quieres eliminar esta participacion?");

				if (respuesta == 0) {
					try {
						controlador.eliminarParticipacion(idEvento,idDeportista);
						controladorVistas.cerrarVentanaParticipacion();
						ControladorVistas.abrirVentanaPrincipal();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (HelpSetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
		});
		btnEliminar.setEnabled(false);
		contentPane.add(btnEliminar);
		
		txtIdDeportista = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtIdDeportista, 887, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtIdDeportista, 213, SpringLayout.WEST, contentPane);
		contentPane.add(txtIdDeportista);
		txtIdDeportista.setColumns(10);
		txtIdDeportista.setVisible(false);

		
		txtIdEvento = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtIdEvento, 884, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtIdEvento, 309, SpringLayout.WEST, contentPane);
		contentPane.add(txtIdEvento);
		txtIdEvento.setColumns(10);
		txtIdEvento.setVisible(false);

		
		txtIdEquipo = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtIdEquipo, 884, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtIdEquipo, 409, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtIdEquipo, 461, SpringLayout.WEST, contentPane);
		contentPane.add(txtIdEquipo);
		txtIdEquipo.setColumns(10);
		txtIdEquipo.setVisible(false);
		
		
		
		tableParticipaciones.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		    	
				idDeportista = (int)tableParticipaciones.getValueAt(tableParticipaciones.getSelectedRow(), 0);
		        nombreDeportista = tableParticipaciones.getValueAt(tableParticipaciones.getSelectedRow(), 1).toString();
				idEquipo = (int)tableParticipaciones.getValueAt(tableParticipaciones.getSelectedRow(), 2);
		        nombreEquipo =  tableParticipaciones.getValueAt(tableParticipaciones.getSelectedRow(), 3).toString();
				idEvento = (int)tableParticipaciones.getValueAt(tableParticipaciones.getSelectedRow(), 4);
		        nombreEvento = tableParticipaciones.getValueAt(tableParticipaciones.getSelectedRow(), 5).toString();
		        medalla = tableParticipaciones.getValueAt(tableParticipaciones.getSelectedRow(), 6).toString();
		        edad =  tableParticipaciones.getValueAt(tableParticipaciones.getSelectedRow(), 7).toString();		         
		         
				txtEdad.setEditable(true);
				txtEdad.setEnabled(true);
				txtEdad.setText(edad.toString());
				
				cbMedalla.setEnabled(true);
				cbMedalla.setEditable(true);
				
				if (medalla.equals("NA")) {
					cbMedalla.setSelectedIndex(0);
				} else if(medalla.equals("Bronze")) {
					cbMedalla.setSelectedIndex(1);
				} else if(medalla.equals("Silver")) {
					cbMedalla.setSelectedIndex(2);
				} else if(medalla.equals("Gold")) {
					cbMedalla.setSelectedIndex(3);
				}
				
				btnModificar.setEnabled(true);
		        btnEliminar.setEnabled(true);
		        
			    System.out.print(nombreDeportista + " " + nombreEquipo + " " + nombreEvento + " " + medalla + " " + edad);
		        
			    tableEquipos.setEnabled(true);
			    tableEquipos.setRowSelectionAllowed(true);
		    }
		});
		
		tableEquipos.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		    	idEquipo = (int)tableEquipos.getValueAt(tableEquipos.getSelectedRow(), 0);		    	
		    }
		});
		
		cbMedalla.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		        medalla = (String)cbMedalla.getSelectedItem();
			    System.out.println(cbMedalla.getSelectedIndex()+ " "+ medalla);
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
			
			//hb.enableHelpOnButton(btnAiuda, "clsVentanaParticipacion", helpset);
			hb.enableHelpKey(getRootPane(),"clsVentanaParticipacion", helpset);
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

}
