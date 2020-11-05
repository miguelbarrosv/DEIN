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
import javax.swing.JTextField;

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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public frmVentanaOlimpiadas() throws SQLException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 844, 609);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblOlimpiadas = new JLabel("Olimpiadas");
		lblOlimpiadas.setBounds(461, 41, 51, 15);
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
		btnAadirOlimpiada.setBounds(632, 533, 131, 25);
		contentPane.add(btnAadirOlimpiada);
				
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(238, 81, 548, 302);
		contentPane.add(scrollPane);
		tableOlimpiadas = new JTable(tableModel);
		scrollPane.setViewportView(tableOlimpiadas);
		
		
		MenuPersonalizado panel = new MenuPersonalizado("olimpiada");
		panel.setLayout(null);
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 187, 610);
		contentPane.add(panel);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(262, 412, 46, 14);
		contentPane.add(lblNombre);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setEditable(false);
		textField.setBounds(337, 409, 131, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblAo = new JLabel("A\u00F1o:");
		lblAo.setBounds(262, 474, 46, 14);
		contentPane.add(lblAo);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setEnabled(false);
		textField_1.setBounds(337, 471, 131, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Tempoarda:");
		lblNewLabel.setBounds(550, 412, 58, 14);
		contentPane.add(lblNewLabel);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setBounds(632, 409, 131, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblCiudad = new JLabel("Ciudad:");
		lblCiudad.setBounds(547, 474, 46, 14);
		contentPane.add(lblCiudad);
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setBounds(632, 471, 131, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(514, 534, 89, 23);
		contentPane.add(btnModificar);
		
		
	}
}
