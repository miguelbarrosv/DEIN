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
	private JTable tableDeportistas;
	private JTable tableEventos;


	int idEvento;
    int idDeportista;
    int idEquipo ;
	String nombreEvento;
    String nombreDeportista;
    String nombreEquipo ;
    String medalla;
    String edad;
	private JTable tableParticipaciones;
	private JTextField txtEdad;
	private JTextField txtIdDeportista;
	private JTextField txtIdEvento;
	private JTextField txtIdEquipo;
	
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public frmVentanaParticipacion() throws SQLException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1031, 957);
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
		
		btnNewButton.setBounds(823, 882, 182, 25);
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
		lblNombre.setBounds(213, 417, 96, 15);
		contentPane.add(lblNombre);
		
		JLabel lblEvento = new JLabel("Evento: ");
		lblEvento.setBounds(213, 642, 70, 15);
		contentPane.add(lblEvento);
		
		JLabel lblEquipo = new JLabel("Equipo: ");
		lblEquipo.setBounds(624, 642, 70, 15);
		contentPane.add(lblEquipo);
		
		JLabel lblEdad = new JLabel("Edad: ");
		lblEdad.setBounds(771, 445, 52, 15);
		contentPane.add(lblEdad);
		
		txtEdad = new JTextField();
		txtEdad.setEditable(false);
		txtEdad.setEnabled(false);
		txtEdad.setBounds(853, 442, 136, 19);
		contentPane.add(txtEdad);
		txtEdad.setColumns(10);
		
		JLabel lblMedalla = new JLabel("Medalla:");
		lblMedalla.setBounds(743, 497, 70, 15);
		contentPane.add(lblMedalla);
		
		final JComboBox cbMedalla = new JComboBox();
		cbMedalla.setEnabled(false);
		cbMedalla.setModel(new DefaultComboBoxModel(new String[] {"NA", "Bronze", "Silver", "Gold"}));
		cbMedalla.setBounds(853, 497, 136, 20);
		contentPane.add(cbMedalla);
		
		final JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controlador.modificarParticipacion( txtIdEvento.getText(), txtIdDeportista.getText(), txtIdEquipo.getText(), medalla, edad);
				controladorVistas.cerrarVentanaParticipacion();
				ControladorVistas.abrirVentanaPrincipal();
			}
		});
		
		btnModificar.setEnabled(false);
		btnModificar.setBounds(690, 882, 117, 25);
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
		btnEliminar.setBounds(563, 882, 117, 25);
		contentPane.add(btnEliminar);
		
		txtIdDeportista = new JTextField();
		txtIdDeportista.setBounds(213, 887, 86, 20);
		contentPane.add(txtIdDeportista);
		txtIdDeportista.setColumns(10);
		txtIdDeportista.setVisible(false);

		
		txtIdEvento = new JTextField();
		txtIdEvento.setBounds(309, 884, 86, 20);
		contentPane.add(txtIdEvento);
		txtIdEvento.setColumns(10);
		txtIdEvento.setVisible(false);

		
		txtIdEquipo = new JTextField();
		txtIdEquipo.setBounds(409, 884, 52, 20);
		contentPane.add(txtIdEquipo);
		txtIdEquipo.setColumns(10);
		txtIdEquipo.setVisible(false);
		
		tableParticipaciones.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
				try {
					
					TablaPersonalizada tableModelDeportista = new TablaPersonalizada("deportistasParticipacion");
					JScrollPane scrollPaneDeportista = new JScrollPane();
					scrollPaneDeportista.setBounds(213, 444, 319, 175);
					contentPane.add(scrollPaneDeportista);
					tableDeportistas = new JTable(tableModelDeportista);
					scrollPaneDeportista.setViewportView(tableDeportistas);
					
					TablaPersonalizada tableModelEventos  = new TablaPersonalizada("eventosParticipacion");
					
					JScrollPane scrollPaneEventos = new JScrollPane();
					scrollPaneEventos.setBounds(213, 666, 361, 205);
					contentPane.add(scrollPaneEventos);
					tableEventos = new JTable(tableModelEventos);
					scrollPaneEventos.setViewportView(tableEventos);
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
		    	
				 idDeportista = (int)tableParticipaciones.getValueAt(tableParticipaciones.getSelectedRow(), 0);
		         nombreDeportista = tableParticipaciones.getValueAt(tableParticipaciones.getSelectedRow(), 1).toString();
				 idEquipo = (int)tableParticipaciones.getValueAt(tableParticipaciones.getSelectedRow(), 2);
		         nombreEquipo =  tableParticipaciones.getValueAt(tableParticipaciones.getSelectedRow(), 3).toString();
				 idEvento = (int)tableParticipaciones.getValueAt(tableParticipaciones.getSelectedRow(), 4);
		         nombreEvento = tableParticipaciones.getValueAt(tableParticipaciones.getSelectedRow(), 5).toString();
		         medalla = tableParticipaciones.getValueAt(tableParticipaciones.getSelectedRow(), 6).toString();
		         edad =  tableParticipaciones.getValueAt(tableParticipaciones.getSelectedRow(), 7).toString();
				
		         for (int i = 0; i < tableDeportistas.getRowCount(); i++) {
					 if (idDeportista == (int)tableDeportistas.getValueAt(tableParticipaciones.getSelectedRow(), 0)) {
						 tableDeportistas.setRowSelectionInterval(i,i);
						 txtIdDeportista.setText(tableDeportistas.getValueAt(i, 0).toString());
				 	}
				}
		         
		         for (int i = 0; i < tableDeportistas.getRowCount(); i++) {
					 if (idDeportista == (int)tableEventos.getValueAt(tableParticipaciones.getSelectedRow(), 2)) {
						 tableEventos.setRowSelectionInterval(i,i);
						 txtIdEvento.setText(tableEventos.getValueAt(i, 0).toString());
				 	}
				}		         
		         
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
				
		tableDeportistas.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				txtIdDeportista.setText(tableDeportistas.getValueAt(tableDeportistas.getSelectedRow(), 0).toString());
			}
		});
		
		tableEventos.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				txtIdEvento.setText(tableEventos.getValueAt(tableEventos.getSelectedRow(), 0).toString());
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
