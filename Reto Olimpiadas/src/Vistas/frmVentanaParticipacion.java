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

import ComponentesPersonalizados.MenuPersonalizado;
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
		setBounds(100, 100, 840, 526);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblParticipaciones = new JLabel("Participaciones");
		lblParticipaciones.setBounds(457, 37, 79, 15);
		contentPane.add(lblParticipaciones);
		
		
		
		JButton btnNewButton = new JButton("Añadir Participacion");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					controladorVistas.abrirVentanaAltaParticipacion();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		btnNewButton.setBounds(590, 422, 182, 25);
		contentPane.add(btnNewButton);
		
		TablaPersonalizada tableModel  = new TablaPersonalizada("participacion");
		
		tableParticipaciones = new JTable(tableModel);
		tableParticipaciones.setBounds(230, 81, 553, 306);
		contentPane.add(tableParticipaciones);
		
		MenuPersonalizado panel = new MenuPersonalizado("participacion");
		panel.setLayout(null);
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 187, 494);
		contentPane.add(panel);
		
	}	
}
