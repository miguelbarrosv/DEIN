package Vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import ComponentesPersonalizados.MenuPersonalizado;
import ComponentesPersonalizados.TablaPersonalizada;
import UML.Controlador;
import UML.Equipo;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.help.HelpSetException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.TableModel;

public class frmVentanaAltaParticipacion extends JFrame {

	private JPanel contentPane;
	private ControladorVistas controladorVistas = new ControladorVistas();
	private Controlador controlador = new Controlador();
	private JTable tableDeportistas;
	private JTable tableEventos;
	private ArrayList<Equipo> equipos = new ArrayList();
	private JTextField txtEdad;
	private String medalla;
    private String edad;
    private int idEquipo;
    private int idDeportista;
    private int idEvento;
    private JTable tableEquipo;

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public frmVentanaAltaParticipacion() throws SQLException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 774, 669);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnAadirParticipacion = new JButton("Añadir\n");
		btnAadirParticipacion.setBounds(615, 596, 91, 23);
		btnAadirParticipacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					controlador.altaParticipacion(idEvento,idDeportista,idEquipo,Integer.parseInt(txtEdad.getText()),medalla);
					controladorVistas.cerrarVentanaAltaParticipacion();
					controladorVistas.cerrarVentanaParticipacion();
					controladorVistas.abrirVentanaParticipacion();
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (HelpSetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				

			}
		});
		contentPane.setLayout(null);
		
		contentPane.add(btnAadirParticipacion);
		
		JLabel lblAltaParticipacion = new JLabel("Alta Participacion");
		lblAltaParticipacion.setBounds(326, 27, 124, 14);
		contentPane.add(lblAltaParticipacion);
		
		JLabel lblEligeUnDeportista = new JLabel("Elige un deportista:");
		lblEligeUnDeportista.setBounds(25, 75, 162, 14);
		contentPane.add(lblEligeUnDeportista);
		
		TablaPersonalizada tableModel  = new TablaPersonalizada("deportistas");
		
		JScrollPane scrollPaneDeportistas = new JScrollPane();
		scrollPaneDeportistas.setBounds(25, 100, 312, 203);
		contentPane.add(scrollPaneDeportistas);
		tableDeportistas = new JTable(tableModel);
		scrollPaneDeportistas.setViewportView(tableDeportistas);
		
		JLabel lblEligeUnEvento = new JLabel("Elige un evento");
		lblEligeUnEvento.setBounds(394, 75, 131, 14);
		contentPane.add(lblEligeUnEvento);
		
		TablaPersonalizada tableModelEvento  = new TablaPersonalizada("eventos");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(394, 100, 312, 203);
		contentPane.add(scrollPane);
		tableEventos = new JTable(tableModelEvento);
		scrollPane.setViewportView(tableEventos);
		
		JLabel lblNewLabel = new JLabel("Elige un equipo");
		lblNewLabel.setBounds(25, 325, 118, 23);
		contentPane.add(lblNewLabel);
		
		txtEdad = new JTextField();
		txtEdad.setBounds(502, 390, 131, 20);
		contentPane.add(txtEdad);
		txtEdad.setColumns(10);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(394, 392, 46, 14);
		contentPane.add(lblEdad);
		
		JLabel lblMedalla = new JLabel("Medalla:");
		lblMedalla.setBounds(394, 442, 73, 14);
		contentPane.add(lblMedalla);
		
		final JComboBox cbMedalla = new JComboBox();
		cbMedalla.setBounds(502, 438, 131, 23);
		cbMedalla.setModel(new DefaultComboBoxModel(new String[] {"NA", "Bronze", "Silver", "Gold"}));
		contentPane.add(cbMedalla);
		
		TablaPersonalizada tableModelEquipo  = new TablaPersonalizada("equipos");
		
		tableEquipo = new JTable(tableModelEquipo);
		JScrollPane scrollPaneEquipo = new JScrollPane();
		scrollPaneEquipo.setBounds(25, 366, 318, 203);
		contentPane.add(scrollPaneEquipo);
		scrollPaneEquipo.setViewportView(tableEquipo);
		
		cbMedalla.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		        medalla = (String)cbMedalla.getSelectedItem();
			    System.out.println(cbMedalla.getSelectedIndex()+ " "+ medalla);
		    }
		});
		
		tableEquipo.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		    	idEquipo = (int)tableEquipo.getValueAt(tableEquipo.getSelectedRow(), 0);		    	
		    }
		});
		
		tableDeportistas.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		    	idDeportista = (int)tableDeportistas.getValueAt(tableDeportistas.getSelectedRow(), 0);		    	
		    }
		});
		
		tableEventos.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		    	idEvento = (int)tableEventos.getValueAt(tableEventos.getSelectedRow(), 0);		    	
		    }
		});
		
	}
}
