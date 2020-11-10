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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import ComponentesPersonalizados.MenuPersonalizado;
import ComponentesPersonalizados.TablaPersonalizada;
import UML.Controlador;
import UML.Equipo;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JTextField;



public class frmVentanaEquipos extends JFrame {

	private JPanel contentPane;
	private ControladorVistas controladorVistas = new ControladorVistas();
	private Controlador controlador = new Controlador();
	private ArrayList<Equipo> equipos = new ArrayList();
	private JTextField txtNombre;
	private JTable tableEquipos;
	int idEquipo;
	String iniciales;
	String nombre;
	private JTextField txtIniciales;



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
		lblListaDeEquipos.setBounds(445, 22, 137, 15);
		contentPane.add(lblListaDeEquipos);
		
		TablaPersonalizada tableModel  = new TablaPersonalizada("equipos");
		
		tableEquipos = new JTable(tableModel);
		tableEquipos.setBounds(241, 59, 569, 346);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(213, 65, 643, 329);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(tableEquipos);
		
		MenuPersonalizado panel = new MenuPersonalizado("equipos");
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 187, 581);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		
		JButton btnAadirEquipo = new JButton("Añadir EQuipo");
		
		btnAadirEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorVistas.abrirVentanaAltaEquipos();
			}
		});
		btnAadirEquipo.setFont(new Font("Dialog", Font.BOLD, 10));
		btnAadirEquipo.setBounds(742, 546, 114, 25);
		contentPane.add(btnAadirEquipo);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(241, 444, 72, 14);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setEnabled(false);
		txtNombre.setBounds(338, 442, 187, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		final JButton btnModificar = new JButton("Modificar");
		btnModificar.setEnabled(false);
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					controlador.modificarEquipo(idEquipo, iniciales, nombre);
					controladorVistas.cerrarVentanaEquipos();
					controladorVistas.abrirVentanaPrincipal();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnModificar.setBounds(617, 546, 114, 23);
		contentPane.add(btnModificar);
		
		txtIniciales = new JTextField();
		txtIniciales.setEnabled(false);
		txtIniciales.setEditable(false);
		txtIniciales.setBounds(338, 491, 114, 19);
		contentPane.add(txtIniciales);
		txtIniciales.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Iniciales:");
		lblNewLabel.setBounds(243, 493, 70, 15);
		contentPane.add(lblNewLabel);
		
		final JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int respuesta = JOptionPane.showConfirmDialog(null, "Estas seguro de que quieres eliminar a este deportista?");
				
				if (respuesta == 0) {
					try {
						controlador.eliminarEquipo(idEquipo);
						controladorVistas.cerrarVentanaEquipos();
						ControladorVistas.abrirVentanaPrincipal();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnEliminar.setEnabled(false);
		btnEliminar.setBounds(504, 545, 102, 25);
		contentPane.add(btnEliminar);
		
		
		tableEquipos.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		    	idEquipo = (int)tableEquipos.getValueAt(tableEquipos.getSelectedRow(), 0);
		    	iniciales = tableEquipos.getValueAt(tableEquipos.getSelectedRow(), 1).toString();
		    	nombre = tableEquipos.getValueAt(tableEquipos.getSelectedRow(), 2).toString();
		    	
		    	txtIniciales.setEditable(true);
		    	txtIniciales.setEnabled(true);
		    	txtIniciales.setText(iniciales);
		    	
		    	txtNombre.setEditable(true);
		    	txtNombre.setEnabled(true);
		    	txtNombre.setText(nombre);
		    	
		    	btnModificar.setEnabled(true);
		    	btnEliminar.setEnabled(true);
		    	
		    }
		});
	}
}
