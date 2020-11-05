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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 867, 606);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
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
		
		contentPane.add(btnAadirParticipacion, "8, 10, fill, bottom");
		
		JLabel lblAltaParticipacion = new JLabel("Alta Participacion");
		contentPane.add(lblAltaParticipacion, "4, 2, fill, top");
		
		JLabel lblEligeUnDeportista = new JLabel("Elige un deportista:");
		contentPane.add(lblEligeUnDeportista, "2, 4, fill, top");
		
		TablaPersonalizada tableModel  = new TablaPersonalizada("deportistas");
		
		JScrollPane scrollPaneDeportistas = new JScrollPane();
		contentPane.add(scrollPaneDeportistas, "2, 6, 3, 1, fill, fill");
		tableDeportistas = new JTable(tableModel);
		scrollPaneDeportistas.setViewportView(tableDeportistas);
		
		JLabel lblEligeUnEvento = new JLabel("Elige un evento");
		contentPane.add(lblEligeUnEvento, "2, 8, left, top");
		
		TablaPersonalizada tableModelEvento  = new TablaPersonalizada("eventos");
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "2, 10, 3, 1, fill, fill");
		tableEventos = new JTable(tableModelEvento);
		scrollPane.setViewportView(tableEventos);
		
		JLabel lblNewLabel = new JLabel("Elige un equipo");
		contentPane.add(lblNewLabel, "6, 4, fill, top");
		
		JComboBox cbEquipos = new JComboBox();
		contentPane.add(cbEquipos, "6, 6, 3, 1, fill, top");
		
		equipos = controlador.consultarEquipos();
		
		for (int x = 0; x < equipos.size(); x++) {
			String infEquipo = equipos.get(x).getIniciales() + " " + equipos.get(x).getNombre();
			cbEquipos.addItem(infEquipo);
		}
	}
}
