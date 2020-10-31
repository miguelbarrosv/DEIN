package Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import UML.Controlador;
import UML.Equipo;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;



public class frmVentanaEquipos extends JFrame {

	private JPanel contentPane;
	private ControladorVistas controladorVistas = new ControladorVistas();
	private Controlador controlador = new Controlador();
	private ArrayList<Equipo> equipos = new ArrayList();

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public frmVentanaEquipos() throws SQLException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 673, 495);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblListaDeEquipos = new JLabel("Lista de equipos");
		lblListaDeEquipos.setBounds(372, 39, 123, 15);
		contentPane.add(lblListaDeEquipos);
		
		JComboBox cbEquipos = new JComboBox();
		cbEquipos.setBounds(471, 173, 151, 24);
		contentPane.add(cbEquipos);
		
		JLabel lblSelecionaUnEquipo = new JLabel("Seleciona un equipo:");
		lblSelecionaUnEquipo.setBounds(254, 178, 156, 15);
		contentPane.add(lblSelecionaUnEquipo);
		
		JButton btnAadirEquipo = new JButton("Añadir Equipo");
		btnAadirEquipo.setFont(new Font("Dialog", Font.BOLD, 10));
		btnAadirEquipo.setBounds(531, 337, 112, 25);
		contentPane.add(btnAadirEquipo);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 187, 494);
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
		
		equipos = controlador.consultarEquipos();
		
		for (int x = 0; x < equipos.size(); x++) {
			String infEquipo = equipos.get(x).getIniciales() + " " + equipos.get(x).getNombre();
			cbEquipos.addItem(infEquipo);
		}
	}
}
