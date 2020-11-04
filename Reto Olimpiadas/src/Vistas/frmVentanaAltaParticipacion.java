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

public class frmVentanaAltaParticipacion extends JFrame {

	private JPanel contentPane;
	private ControladorVistas controladorVistas = new ControladorVistas();
	private Controlador controlador = new Controlador();
	private JTable tableDeportistas;
	private JTable tableEventos;
	private ArrayList<Equipo> equipos = new ArrayList();


	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public frmVentanaAltaParticipacion() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 867, 606);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAadirParticipacion = new JButton("Añadir\n");
		btnAadirParticipacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					controlador.altaParticipacion();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				controladorVistas.cerrarVentanaAltaParticipacion();
			}
		});
		btnAadirParticipacion.setBounds(743, 544, 96, 25);
		contentPane.add(btnAadirParticipacion);
		
		JLabel lblAltaParticipacion = new JLabel("Alta Participacion");
		lblAltaParticipacion.setBounds(378, 12, 135, 15);
		contentPane.add(lblAltaParticipacion);
		
		JLabel lblEligeUnDeportista = new JLabel("Elige un deportista:");
		lblEligeUnDeportista.setBounds(80, 74, 159, 15);
		contentPane.add(lblEligeUnDeportista);
		
		TablaPersonalizada tableModel  = new TablaPersonalizada("deportistas");
		tableDeportistas = new JTable(tableModel);
		JScrollPane scrollPaneDeportistas = new JScrollPane();
		contentPane.add(scrollPaneDeportistas);
		scrollPaneDeportistas.setViewportView(tableDeportistas);
		tableDeportistas = new JTable();
		tableDeportistas.setBounds(80, 115, 370, 162);
		contentPane.add(tableDeportistas);
		
		JLabel lblEligeUnEvento = new JLabel("Elige un evento");
		lblEligeUnEvento.setBounds(80, 324, 127, 15);
		contentPane.add(lblEligeUnEvento);
		
		TablaPersonalizada tableModelEventos  = new TablaPersonalizada("eventos");
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane);
		tableEventos = new JTable(tableModelEventos);
		scrollPane.setViewportView(tableEventos);
		tableEventos.setBounds(80, 366, 370, 167);
		
		JLabel lblNewLabel = new JLabel("Elige un equipo");
		lblNewLabel.setBounds(548, 74, 120, 15);
		contentPane.add(lblNewLabel);
		
		JComboBox cbEquipos = new JComboBox();
		cbEquipos.setBounds(548, 110, 211, 25);
		contentPane.add(cbEquipos);
		
		equipos = controlador.consultarEquipos();
		
		for (int x = 0; x < equipos.size(); x++) {
			String infEquipo = equipos.get(x).getIniciales() + " " + equipos.get(x).getNombre();
			cbEquipos.addItem(infEquipo);
		}
	}
}
