package Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ComponentesPersonalizados.MenuPersonalizado;
import ComponentesPersonalizados.TablaPersonalizada;
import UML.Controlador;
import UML.Olimpiada;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import java.awt.Choice;
import java.awt.Button;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Scrollbar;
import javax.swing.JScrollPane;
import java.awt.Color;

public class frmVentanaOlimpiadas extends JFrame {

	private JPanel contentPane;	
	private JTable tableOlimpiadas;
	private ControladorVistas controladorVistas = new ControladorVistas();
	private Controlador controlador = new Controlador();
	private ArrayList<Olimpiada> olimpiadas = new ArrayList();
	private JPanel panel;
	private JLabel lblParticipacion;
	private JLabel lblEquipos;
	private JLabel lblDeportista;
	private JLabel lblDeporte;
	private JLabel lblEvento;
	private JLabel lblOlimpiadas_1;
	private JLabel lblInicio;

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public frmVentanaOlimpiadas() throws SQLException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 699, 508);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblOlimpiadas = new JLabel("Olimpiadas");
		lblOlimpiadas.setBounds(411, 29, 93, 15);
		contentPane.add(lblOlimpiadas);
		
		TablaPersonalizada tableModel  = new TablaPersonalizada("olimpiadas");
		
		JButton btnAadirOlimpiada = new JButton("Añadir Olimpiada");
		btnAadirOlimpiada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					controladorVistas.abrirVentanaOlimpiadaAlta();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		btnAadirOlimpiada.setFont(new Font("Dialog", Font.BOLD, 10));
		btnAadirOlimpiada.setBounds(535, 343, 131, 25);
		contentPane.add(btnAadirOlimpiada);
		
		tableOlimpiadas = new JTable(tableModel);
		tableOlimpiadas.setColumnSelectionAllowed(true);
		tableOlimpiadas.setEnabled(false);
		tableOlimpiadas.setBounds(250, 101, 416, 168);
		contentPane.add(tableOlimpiadas);
		
		MenuPersonalizado panel = new MenuPersonalizado("olimpiadas");
		panel.setLayout(null);
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 187, 494);
		contentPane.add(panel);
		
		
	}
}
