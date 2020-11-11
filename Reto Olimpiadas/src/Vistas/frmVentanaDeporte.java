package Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import ComponentesPersonalizados.MenuPersonalizado;
import ComponentesPersonalizados.TablaPersonalizada;
import UML.Controlador;
import UML.Deporte;

import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JTextField;

public class frmVentanaDeporte extends JFrame {

	private JPanel contentPane;
	private ArrayList<Deporte> deportes;
	private Controlador controlador = new Controlador();
	private ControladorVistas controladorVistas = new ControladorVistas();
	private JTextField txtNombre;
	private JTable tableDeporte;
	int idDeporte;
	String nombre;


	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public frmVentanaDeporte() throws SQLException {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 866, 557);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		TablaPersonalizada tableModel  = new TablaPersonalizada("deporte");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(241, 59, 569, 346);
		contentPane.add(scrollPane);
		tableDeporte = new JTable(tableModel);
		scrollPane.setViewportView(tableDeporte);
		
		JLabel lblNewLabel = new JLabel("Lista de Deportes");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel.setBounds(459, 23, 178, 25);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Añadir Deporte");
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 9));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				controladorVistas.abrirVentanaAltaDeporte();
			}
		});
		btnNewButton.setBounds(702, 490, 108, 25);
		contentPane.add(btnNewButton);
		
		MenuPersonalizado panel = new MenuPersonalizado("deportes");
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 187, 515);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(241, 445, 60, 14);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setEnabled(false);
		txtNombre.setEditable(false);
		txtNombre.setBounds(332, 443, 152, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		final JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controlador.modificarDeporte(idDeporte, nombre);
					controladorVistas.cerrarVentanaDeportes();
					controladorVistas.abrirVentanaPrincipal();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnModificar.setEnabled(false);
		btnModificar.setBounds(575, 490, 117, 25);
		contentPane.add(btnModificar);
		
		final JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setEnabled(false);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					controlador.eliminarDeporte(idDeporte);
					controladorVistas.cerrarVentanaDeportes();
					controladorVistas.abrirVentanaPrincipal();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				

			}
		});
		
		btnEliminar.setBounds(476, 490, 89, 23);
		contentPane.add(btnEliminar);
		
		tableDeporte.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		         idDeporte = (int) tableDeporte.getValueAt(tableDeporte.getSelectedRow(), 0);
		         nombre = tableDeporte.getValueAt(tableDeporte.getSelectedRow(), 1).toString();
		         
		         txtNombre.setEnabled(true);
		         btnModificar.setEnabled(true);
		         btnEliminar.setEnabled(true);
		    }
		});
	}
}
