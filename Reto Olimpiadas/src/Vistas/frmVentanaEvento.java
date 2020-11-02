package Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ComponentesPersonalizados.MenuPersonalizado;
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
		
		MenuPersonalizado panel = new MenuPersonalizado("evento");
		panel.setLayout(null);
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 187, 494);
		contentPane.add(panel);
		
		eventos = controlador.consultarEventos();
		
		
		for (int x = 0; x < eventos.size(); x++) {
			cbEvento.addItem(eventos.get(x).getId_evento());
		}
	}
}
