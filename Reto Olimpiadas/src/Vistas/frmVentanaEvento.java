package Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import ComponentesPersonalizados.MenuPersonalizado;
import ComponentesPersonalizados.TablaPersonalizada;
import UML.Controlador;
import UML.Evento;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmVentanaEvento extends JFrame {

	private JPanel contentPane;
	private JTable tableEventos;
	private Controlador controlador = new Controlador();
	private ArrayList<Evento> eventos = new ArrayList();
	private ControladorVistas controladorVistas = new ControladorVistas();

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public frmVentanaEvento() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 896, 621);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEvento = new JLabel("Evento");
		lblEvento.setBounds(504, 30, 64, 15);
		contentPane.add(lblEvento);
		
		MenuPersonalizado panel = new MenuPersonalizado("evento");
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 187, 596);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));;
		
		
		TablaPersonalizada tableModel  = new TablaPersonalizada("eventos");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(265, 68, 554, 329);
		contentPane.add(scrollPane);
		tableEventos = new JTable(tableModel);
		scrollPane.setViewportView(tableEventos);
		
		tableEventos.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		        int row = tableEventos.rowAtPoint(evt.getPoint());
		        int col = tableEventos.columnAtPoint(evt.getPoint());
		        
			    System.out.println(row + "  " + col);
		    }
		});
		
		JButton btnAadirEvento = new JButton("Añadir Evento");
		
		btnAadirEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					controladorVistas.abrirVentanaAltaEventos();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnAadirEvento.setFont(new Font("Dialog", Font.BOLD, 10));
		btnAadirEvento.setBounds(310, 238, 114, 25);
		contentPane.add(btnAadirEvento);
	}
}
