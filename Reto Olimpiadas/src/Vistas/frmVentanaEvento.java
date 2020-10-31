package Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import UML.Controlador;
import UML.Evento;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Font;

public class frmVentanaEvento extends JFrame {

	private JPanel contentPane;
	private Controlador controlador = new Controlador();
	private ArrayList<Evento> eventos = new ArrayList();

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public frmVentanaEvento() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 705, 507);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEvento = new JLabel("Evento");
		lblEvento.setBounds(410, 42, 70, 15);
		contentPane.add(lblEvento);
		
		JComboBox cbEvento = new JComboBox();
		cbEvento.setBounds(375, 158, 131, 24);
		contentPane.add(cbEvento);
		
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
		
		JLabel lblEvento_1 = new JLabel("Evento");
		lblEvento_1.setForeground(Color.WHITE);
		lblEvento_1.setFont(new Font("Dialog", Font.BOLD, 16));
		lblEvento_1.setBounds(12, 330, 175, 52);
		panel.add(lblEvento_1);
		
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
		
		eventos = controlador.consultarEventos();
		
		
		for (int x = 0; x < eventos.size(); x++) {
			cbEvento.addItem(eventos.get(x).getId_evento());
		}
	}
}
