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
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.table.TableModel;

import ComponentesPersonalizados.TablaPersonalizada;

import java.awt.Color;
import java.awt.Font;

public class frmVentanaParticipacion extends JFrame {

	private JPanel contentPane;
	private ControladorVistas controladorVistas = new ControladorVistas();
	private Controlador controlador = new Controlador();
	private ArrayList<Participacion> participaciones = new ArrayList();
	private ArrayList<Deportista> deportistas = new ArrayList();
	private ArrayList<Equipo> equipos = new ArrayList();

	private JTable tableParticipaciones;
	
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public frmVentanaParticipacion() throws SQLException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 689, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblParticipaciones = new JLabel("Participaciones");
		lblParticipaciones.setBounds(393, 40, 128, 15);
		contentPane.add(lblParticipaciones);
		
		
		
		JButton btnNewButton = new JButton("Añadir Participacion");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorVistas.abrirVentanaAltaParticipacion();
			}
		});
		
		btnNewButton.setBounds(476, 342, 182, 25);
		contentPane.add(btnNewButton);
		
		TablaPersonalizada tableModel  = new TablaPersonalizada("participacion");
		
		tableParticipaciones = new JTable(tableModel);
		tableParticipaciones.setBounds(265, 108, 393, 168);
		contentPane.add(tableParticipaciones);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.BLACK);
		panel.setBounds(12, 0, 187, 494);
		contentPane.add(panel);
		
		JLabel lblParticipacion = new JLabel("Participacion");
		lblParticipacion.setForeground(Color.WHITE);
		lblParticipacion.setFont(new Font("Dialog", Font.BOLD, 16));
		lblParticipacion.setBounds(12, 74, 175, 52);
		panel.add(lblParticipacion);
		
		JLabel lblEquipos = new JLabel("Equipos");
		lblEquipos.setForeground(Color.WHITE);
		lblEquipos.setFont(new Font("Dialog", Font.BOLD, 16));
		lblEquipos.setBounds(12, 138, 175, 52);
		panel.add(lblEquipos);
		
		JLabel lblDeportista = new JLabel("Deportista");
		lblDeportista.setForeground(Color.WHITE);
		lblDeportista.setFont(new Font("Dialog", Font.BOLD, 16));
		lblDeportista.setBounds(12, 202, 175, 52);
		panel.add(lblDeportista);
		
		JLabel lblDeporte = new JLabel("Deporte");
		lblDeporte.setForeground(Color.WHITE);
		lblDeporte.setFont(new Font("Dialog", Font.BOLD, 16));
		lblDeporte.setBounds(12, 266, 175, 52);
		panel.add(lblDeporte);
		
		JLabel lblEvento = new JLabel("Evento");
		lblEvento.setForeground(Color.WHITE);
		lblEvento.setFont(new Font("Dialog", Font.BOLD, 16));
		lblEvento.setBounds(12, 330, 175, 52);
		panel.add(lblEvento);
		
		JLabel lblOlimpiadas = new JLabel("Olimpiadas");
		lblOlimpiadas.setForeground(Color.WHITE);
		lblOlimpiadas.setFont(new Font("Dialog", Font.BOLD, 16));
		lblOlimpiadas.setBounds(12, 394, 175, 45);
		panel.add(lblOlimpiadas);
		
		JLabel lblInicio = new JLabel("Inicio");
		lblInicio.setForeground(Color.WHITE);
		lblInicio.setFont(new Font("Dialog", Font.BOLD, 16));
		lblInicio.setBounds(12, 10, 175, 52);
		panel.add(lblInicio);
		
		participaciones = controlador.consultarParticipaciones();
		deportistas = controlador.consultarDeportistas();
		equipos = controlador.consultarEquipos();
		
		
}
