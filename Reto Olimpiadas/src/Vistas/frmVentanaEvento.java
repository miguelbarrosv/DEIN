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
	private JTable tableOlimpiadas;
	private JTable tableDeporte;

	private Controlador controlador = new Controlador();
	private ArrayList<Evento> eventos = new ArrayList();
	private ControladorVistas controladorVistas = new ControladorVistas();

	int idOlimpiada;
	int idEvento;
	int idDeporte;
	String nombreEvento;
	
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public frmVentanaEvento() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1066, 771);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEvento = new JLabel("Lista de Eventos");
		lblEvento.setBounds(550, 31, 98, 15);
		contentPane.add(lblEvento);
		
		MenuPersonalizado panel = new MenuPersonalizado("evento");
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 187, 718);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));;
		
		
		TablaPersonalizada tableModel  = new TablaPersonalizada("eventos");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(206, 57, 803, 329);
		contentPane.add(scrollPane);
		tableEventos = new JTable(tableModel);
		scrollPane.setViewportView(tableEventos);
		
		tableEventos.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		         idEvento = (int) tableEventos.getValueAt(tableEventos.getSelectedRow(), 0);
		         nombreEvento = tableEventos.getValueAt(tableEventos.getSelectedRow(), 1).toString();
		         idOlimpiada = (int) tableEventos.getValueAt(tableEventos.getSelectedRow(), 2);
		         idDeporte = (int) tableEventos.getValueAt(tableEventos.getSelectedRow(), 4);
		    }
		});
		
		tableDeporte.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		         idDeporte = (int) tableDeporte.getValueAt(tableDeporte.getSelectedRow(), 0);
		    }
		});
		
		tableOlimpiadas.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		         idOlimpiada = (int) tableOlimpiadas.getValueAt(tableOlimpiadas.getSelectedRow(), 0);
		    }
		});
		
		TablaPersonalizada tableModelOlimpiadas  = new TablaPersonalizada("olimpiadas");
		
		JScrollPane scrollPaneOlimpiadas = new JScrollPane();
		scrollPaneOlimpiadas.setEnabled(false);
		scrollPaneOlimpiadas.setBounds(205, 446, 382, 207);
		contentPane.add(scrollPaneOlimpiadas);
		tableOlimpiadas = new JTable(tableModelOlimpiadas);
		tableOlimpiadas.setRowSelectionAllowed(false);
		tableOlimpiadas.setEnabled(false);
		scrollPaneOlimpiadas.setViewportView(tableOlimpiadas);
		
		TablaPersonalizada tableModelDeporte  = new TablaPersonalizada("deporte");
		
		JScrollPane scrollPaneDeporte = new JScrollPane();
		scrollPaneDeporte.setBounds(610, 446, 416, 207);
		contentPane.add(scrollPaneDeporte);
		tableDeporte = new JTable(tableModelDeporte);
		scrollPaneDeporte.setViewportView(tableDeporte);
		
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
		btnAadirEvento.setBounds(806, 693, 114, 25);
		contentPane.add(btnAadirEvento);
		
		JLabel lblOlimpiadas = new JLabel("Selecciona una olimpiadas para modificarla: ");
		lblOlimpiadas.setBounds(206, 413, 209, 15);
		contentPane.add(lblOlimpiadas);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					controlador.eliminarEvento(idEvento);
					controladorVistas.cerrarVentanaEvento();
					controladorVistas.abrirVentanaPrincipal();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnEliminar.setEnabled(false);
		btnEliminar.setBounds(526, 692, 117, 25);
		contentPane.add(btnEliminar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					controlador.modificarEvento(idEvento,nombreEvento,idOlimpiada,idDeporte);
					controladorVistas.cerrarVentanaEvento();
					controladorVistas.abrirVentanaPrincipal();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnModificar.setEnabled(false);
		btnModificar.setBounds(669, 693, 117, 25);
		contentPane.add(btnModificar);
		
		JLabel lblDeportes = new JLabel("Selecciona un deporte para modificarlo:\r\n");
		lblDeportes.setBounds(610, 413, 189, 14);
		contentPane.add(lblDeportes);
	}
}
