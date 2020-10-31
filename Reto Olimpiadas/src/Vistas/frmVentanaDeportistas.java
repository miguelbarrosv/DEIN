package Vistas;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ComponentesPersonalizados.TablaPersonalizada;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JLabel;

import UML.Controlador;
import UML.Deportista;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class frmVentanaDeportistas extends JFrame {

	private JPanel contentPane;
	private JTable tableDeportistas;
	private ArrayList<Deportista> deportistas;
	private Controlador controlador = new Controlador();
	private ControladorVistas controladorVistas = new ControladorVistas();

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public frmVentanaDeportistas() throws SQLException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		TablaPersonalizada tableModel  = new TablaPersonalizada("deportistas");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(100, 49, 256, 179);
		contentPane.add(scrollPane);
		tableDeportistas = new JTable(tableModel);
		scrollPane.setViewportView(tableDeportistas);
		
		JLabel lblListaDeDeportistas = new JLabel("Lista de deportistas");
		lblListaDeDeportistas.setBounds(152, 12, 153, 15);
		contentPane.add(lblListaDeDeportistas);
		
		JButton btnAaidrDeportista = new JButton("Añaidr Deportista");
		btnAaidrDeportista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorVistas.abrirVentanaAltaDeportista();
			}
		});
		
		btnAaidrDeportista.setFont(new Font("Dialog", Font.BOLD, 10));
		btnAaidrDeportista.setBounds(276, 240, 135, 25);
		contentPane.add(btnAaidrDeportista);
		
	
	}
}
