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
		setBounds(100, 100, 673, 526);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblListaDeEquipos = new JLabel("Lista de equipos");
		lblListaDeEquipos.setBounds(356, 90, 85, 15);
		contentPane.add(lblListaDeEquipos);
		
		JComboBox cbEquipos = new JComboBox();
		cbEquipos.setBounds(328, 228, 151, 24);
		contentPane.add(cbEquipos);
		
		MenuPersonalizado panel = new MenuPersonalizado("equipos");
		panel.setLayout(null);
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 187, 494);
		contentPane.add(panel);
		
		equipos = controlador.consultarEquipos();
		
		for (int x = 0; x < equipos.size(); x++) {
			String infEquipo = equipos.get(x).getIniciales() + " " + equipos.get(x).getNombre();
			cbEquipos.addItem(infEquipo);
		}
	}
}
