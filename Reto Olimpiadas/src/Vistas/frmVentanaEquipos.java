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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JTextField;



public class frmVentanaEquipos extends JFrame {

	private JPanel contentPane;
	private ControladorVistas controladorVistas = new ControladorVistas();
	private Controlador controlador = new Controlador();
	private ArrayList<Equipo> equipos = new ArrayList();
	private JTextField textField;

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public frmVentanaEquipos() throws SQLException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 885, 606);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblListaDeEquipos = new JLabel("Lista de equipos");
		lblListaDeEquipos.setBounds(488, 73, 85, 15);
		contentPane.add(lblListaDeEquipos);
		
		final JComboBox cbEquipos = new JComboBox();
		cbEquipos.setBounds(459, 196, 151, 24);
		contentPane.add(cbEquipos);
		
		MenuPersonalizado panel = new MenuPersonalizado("equipos");
		panel.setLayout(null);
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 187, 567);
		contentPane.add(panel);
		
		equipos = controlador.consultarEquipos();
		
		for (int x = 0; x < equipos.size(); x++) {
			String infEquipo = equipos.get(x).getIniciales() + " " + equipos.get(x).getNombre();
			cbEquipos.addItem(infEquipo);
		}
		
		cbEquipos.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	String x = cbEquipos.getSelectedItem().toString();
		    	int posicion = cbEquipos.getSelectedIndex();
		    	System.out.print(x + " "+ posicion);
		    	
		    }
		});
		
		JButton btnAadirEquipo = new JButton("Añadir EQuipo");
		
		btnAadirEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorVistas.abrirVentanaAltaEquipos();
			}
		});
		btnAadirEquipo.setFont(new Font("Dialog", Font.BOLD, 10));
		btnAadirEquipo.setBounds(693, 510, 114, 25);
		contentPane.add(btnAadirEquipo);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(279, 400, 46, 14);
		contentPane.add(lblNombre);
		
		textField = new JTextField();
		textField.setBounds(381, 397, 187, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(550, 511, 89, 23);
		contentPane.add(btnModificar);
	}
}
