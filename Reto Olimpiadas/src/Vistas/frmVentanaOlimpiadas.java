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
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import java.awt.Choice;
import java.awt.Button;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridLayout;
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
	private JTextField txtNombre;
	private JTextField txtAnio;
	private JTextField txtTemporada;
	private JTextField txtCiudad;
	
	int idOlimpiada;
    String nombre;
    String anio;
    String ciudad;
    String temporada;

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
		lblOlimpiadas.setBounds(461, 41, 79, 15);
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
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 187, 584);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(238, 412, 70, 14);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setEnabled(false);
		txtNombre.setEditable(false);
		txtNombre.setBounds(337, 409, 131, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblAo = new JLabel("A\u00F1o:");
		lblAo.setBounds(250, 474, 58, 14);
		contentPane.add(lblAo);
		
		txtAnio = new JTextField();
		txtAnio.setEditable(false);
		txtAnio.setEnabled(false);
		txtAnio.setBounds(337, 471, 131, 20);
		contentPane.add(txtAnio);
		txtAnio.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Temporada:");
		lblNewLabel.setBounds(512, 412, 96, 14);
		contentPane.add(lblNewLabel);
		
		txtTemporada = new JTextField();
		txtTemporada.setEditable(false);
		txtTemporada.setEnabled(false);
		txtTemporada.setBounds(632, 409, 131, 20);
		contentPane.add(txtTemporada);
		txtTemporada.setColumns(10);
		
		JLabel lblCiudad = new JLabel("Ciudad:");
		lblCiudad.setBounds(512, 474, 64, 14);
		contentPane.add(lblCiudad);
		
		txtCiudad = new JTextField();
		txtCiudad.setEditable(false);
		txtCiudad.setEnabled(false);
		txtCiudad.setBounds(632, 471, 131, 20);
		contentPane.add(txtCiudad);
		txtCiudad.setColumns(10);
		
		final JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controlador.modificarOlimpiada(idOlimpiada,nombre, anio, ciudad,temporada);
					controladorVistas.cerrarVentanaOlimpiada();
					ControladorVistas.abrirVentanaPrincipal();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btnModificar.setEnabled(false);
		btnModificar.setBounds(496, 534, 107, 23);
		contentPane.add(btnModificar);
		
		final JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int respuesta = JOptionPane.showConfirmDialog(null, "Estas seguro de que quieres eliminar esta olimpiada?");
				
				if (respuesta == 0) {
					try {
						controlador.eliminarOlimpiada(idOlimpiada);
						controladorVistas.cerrarVentanaOlimpiada();
						ControladorVistas.abrirVentanaPrincipal();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
		btnEliminar.setEnabled(false);
		btnEliminar.setBounds(379, 534, 89, 23);
		contentPane.add(btnEliminar);
		
		tableOlimpiadas.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		    	idOlimpiada = (int) tableOlimpiadas.getValueAt(tableOlimpiadas.getSelectedRow(), 0);
		        nombre = tableOlimpiadas.getValueAt(tableOlimpiadas.getSelectedRow(), 1).toString();
		        anio = tableOlimpiadas.getValueAt(tableOlimpiadas.getSelectedRow(), 3).toString();
		        ciudad =  tableOlimpiadas.getValueAt(tableOlimpiadas.getSelectedRow(), 4).toString();
		        temporada = tableOlimpiadas.getValueAt(tableOlimpiadas.getSelectedRow(), 2).toString();

		        txtCiudad.setEditable(true);
		        txtCiudad.setEnabled(true);
				txtCiudad.setText(ciudad);

				
				txtTemporada.setEditable(true);
				txtTemporada.setEnabled(true);
				txtTemporada.setText(temporada);

				
				txtNombre.setEditable(true);
				txtNombre.setEnabled(true);
				txtNombre.setText(nombre);
				
				txtAnio.setEnabled(true);
				txtAnio.setEnabled(true);
				txtAnio.setText(anio);

				btnModificar.setEnabled(true);
				btnEliminar.setEnabled(true);
		        
			    System.out.print(idOlimpiada + " " + nombre + " " + temporada + " " + anio + " " + ciudad);
		    }
		});
	}
}
