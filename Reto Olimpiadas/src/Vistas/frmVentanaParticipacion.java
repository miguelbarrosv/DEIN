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
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
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
import javax.swing.DefaultComboBoxModel;

public class frmVentanaParticipacion extends JFrame {

	private JPanel contentPane;
	private ControladorVistas controladorVistas = new ControladorVistas();
	private Controlador controlador = new Controlador();
	private ArrayList<Participacion> participaciones = new ArrayList();
	private ArrayList<Deportista> deportistas = new ArrayList();
	private ArrayList<Equipo> equipos = new ArrayList();

	String nombreEvento;
    String nombreDeportista;
    String nombreEquipo ;
    String medalla;
    String edad;
	private JTable tableParticipaciones;
	private JTextField txtDeportista;
	private JTextField txtEvento;
	private JTextField txtEquipo;
	private JTextField txtEdad;
	
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public frmVentanaParticipacion() throws SQLException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 840, 707);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblParticipaciones = new JLabel("Participaciones");
		lblParticipaciones.setBounds(449, 27, 109, 15);
		contentPane.add(lblParticipaciones);
		
		
		
		JButton btnNewButton = new JButton("Añadir Participacion");
		
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
		
		btnNewButton.setBounds(631, 615, 182, 25);
		contentPane.add(btnNewButton);
		
		TablaPersonalizada tableModel  = new TablaPersonalizada("participacion");
		
		tableParticipaciones = new JTable(tableModel);
		tableParticipaciones.setBounds(230, 81, 553, 306);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(213, 65, 600, 329);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(tableParticipaciones);
		
		MenuPersonalizado panel = new MenuPersonalizado("participacion");
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 187, 670);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNombre = new JLabel("Deportista: ");
		lblNombre.setBounds(213, 445, 96, 15);
		contentPane.add(lblNombre);
		
		txtDeportista = new JTextField();
		txtDeportista.setEnabled(false);
		txtDeportista.setEditable(false);
		txtDeportista.setBounds(339, 443, 196, 19);
		contentPane.add(txtDeportista);
		txtDeportista.setColumns(10);
		
		JLabel lblEvento = new JLabel("Evento: ");
		lblEvento.setBounds(213, 497, 70, 15);
		contentPane.add(lblEvento);
		
		txtEvento = new JTextField();
		txtEvento.setEditable(false);
		txtEvento.setEnabled(false);
		txtEvento.setBounds(339, 495, 196, 19);
		contentPane.add(txtEvento);
		txtEvento.setColumns(10);
		
		JLabel lblEquipo = new JLabel("Equipo: ");
		lblEquipo.setBounds(213, 550, 70, 15);
		contentPane.add(lblEquipo);
		
		txtEquipo = new JTextField();
		txtEquipo.setEnabled(false);
		txtEquipo.setEditable(false);
		txtEquipo.setBounds(339, 548, 196, 19);
		contentPane.add(txtEquipo);
		txtEquipo.setColumns(10);
		
		JLabel lblEdad = new JLabel("Edad: ");
		lblEdad.setBounds(589, 445, 52, 15);
		contentPane.add(lblEdad);
		
		txtEdad = new JTextField();
		txtEdad.setEditable(false);
		txtEdad.setEnabled(false);
		txtEdad.setBounds(677, 443, 136, 19);
		contentPane.add(txtEdad);
		txtEdad.setColumns(10);
		
		JLabel lblMedalla = new JLabel("Medalla:");
		lblMedalla.setBounds(589, 497, 70, 15);
		contentPane.add(lblMedalla);
		
		final JComboBox cbMedalla = new JComboBox();
		cbMedalla.setEnabled(false);
		cbMedalla.setModel(new DefaultComboBoxModel(new String[] {"NA", "Bronze", "Silver", "Gold"}));
		cbMedalla.setBounds(677, 494, 136, 20);
		contentPane.add(cbMedalla);
		
		final JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controlador.modificarParticipacion( nombreEvento, nombreDeportista, nombreEquipo, medalla, edad);
				controladorVistas.cerrarVentanaParticipacion();
				ControladorVistas.abrirVentanaPrincipal();
			}
		});
		btnModificar.setEnabled(false);
		btnModificar.setBounds(489, 615, 117, 25);
		contentPane.add(btnModificar);
		
		final JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int respuesta = JOptionPane.showConfirmDialog(null, "Estas seguro de que quieres eliminar esta participacion?");

				if (respuesta == 0) {
					controlador.eliminarParticipacion( nombreEvento, nombreDeportista);
					controladorVistas.cerrarVentanaParticipacion();
					ControladorVistas.abrirVentanaPrincipal();
				}
			}
		});
		btnEliminar.setEnabled(false);
		btnEliminar.setBounds(339, 615, 117, 25);
		contentPane.add(btnEliminar);
		
		TablaPersonalizada tableModelDeportista  = new TablaPersonalizada("deportistas2");
		
		tableParticipaciones.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		         nombreDeportista = tableParticipaciones.getValueAt(tableParticipaciones.getSelectedRow(), 0).toString();
		         nombreEquipo =  tableParticipaciones.getValueAt(tableParticipaciones.getSelectedRow(), 1).toString();
		         nombreEvento = tableParticipaciones.getValueAt(tableParticipaciones.getSelectedRow(), 2).toString();
		         medalla = tableParticipaciones.getValueAt(tableParticipaciones.getSelectedRow(), 3).toString();
		         edad =  tableParticipaciones.getValueAt(tableParticipaciones.getSelectedRow(), 4).toString();


		        txtDeportista.setEditable(true);
		        txtDeportista.setEnabled(true);
		        txtDeportista.setText(nombreDeportista);

				
		        txtEquipo.setEditable(true);
		        txtEquipo.setEnabled(true);
		        txtEquipo.setText(nombreEquipo);

				
				txtEvento.setEditable(true);
				txtEvento.setEnabled(true);
				txtEvento.setText(nombreEvento);
				
				txtEdad.setEditable(true);
				txtEdad.setEnabled(true);
				txtEdad.setText(edad.toString());
				
				cbMedalla.setEnabled(true);
				cbMedalla.setEditable(true);
				
				if (medalla == "NA") {
					cbMedalla.setSelectedIndex(0);
				} else if(medalla == "Bronze") {
					cbMedalla.setSelectedIndex(1);
				} else if(medalla == "Silver") {
					cbMedalla.setSelectedIndex(2);
				} else if(medalla == "Gold") {
					cbMedalla.setSelectedIndex(3);
				}
				
				btnModificar.setEnabled(true);
		        btnEliminar.setEnabled(true);
		        
			    System.out.print(nombreDeportista + " " + nombreEquipo + " " + nombreEvento + " " + medalla + " " + edad);
		        
		    }
		});
		
		cbMedalla.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		        medalla = (String) cbMedalla.getSelectedItem();
			    System.out.println(medalla);
		    }
		});
		
	}	
}
