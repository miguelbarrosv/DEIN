package Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import UML.Controlador;
import UML.Deporte;

import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class frmVentanaDeporte extends JFrame {

	private JPanel contentPane;
	private ArrayList<Deporte> deportes;
	private Controlador controlador = new Controlador();
	private ControladorVistas controladorVistas = new ControladorVistas();

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public frmVentanaDeporte() throws SQLException {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 705, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		DefaultListModel<String> model = new DefaultListModel<>();
		JList<String> listaDeportes = new JList<>(model);
		listaDeportes.setModel(model);
		listaDeportes.setBounds(256, 73, 389, 257);
		contentPane.add(listaDeportes);
		
		JLabel lblNewLabel = new JLabel("Lista de Deportes");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel.setBounds(370, 12, 178, 15);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Añadir Deporte");
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 9));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				controladorVistas.abrirVentanaAltaDeporte();
			}
		});
		btnNewButton.setBounds(585, 408, 108, 25);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 187, 494);
		contentPane.add(panel);
		
		JLabel lblParticipacion = new JLabel("Participacion");
		lblParticipacion.setForeground(Color.WHITE);
		lblParticipacion.setFont(new Font("Dialog", Font.BOLD, 16));
		lblParticipacion.setBounds(12, 74, 175, 52);
		panel.add(lblParticipacion);
		
		JLabel lblEquipos = new JLabel("Equipos");
		lblEquipos.setForeground(Color.WHITE);
		lblEquipos.setFont(new Font("Dialog", Font.BOLD, 16));
		lblEquipos.setBounds(12, 138, 175, 52);
		panel.add(lblEquipos);
		
		JLabel lblDeportista = new JLabel("Deportista");
		lblDeportista.setForeground(Color.WHITE);
		lblDeportista.setFont(new Font("Dialog", Font.BOLD, 16));
		lblDeportista.setBounds(12, 202, 175, 52);
		panel.add(lblDeportista);
		
		JLabel lblDeporte = new JLabel("Deporte");
		lblDeporte.setForeground(Color.WHITE);
		lblDeporte.setFont(new Font("Dialog", Font.BOLD, 16));
		lblDeporte.setBounds(12, 266, 175, 52);
		panel.add(lblDeporte);
		
		JLabel lblEvento = new JLabel("Evento");
		lblEvento.setForeground(Color.WHITE);
		lblEvento.setFont(new Font("Dialog", Font.BOLD, 16));
		lblEvento.setBounds(12, 330, 175, 52);
		panel.add(lblEvento);
		
		JLabel lblOlimpiadas = new JLabel("Olimpiadas");
		lblOlimpiadas.setForeground(Color.WHITE);
		lblOlimpiadas.setFont(new Font("Dialog", Font.BOLD, 16));
		lblOlimpiadas.setBounds(12, 394, 175, 45);
		panel.add(lblOlimpiadas);
		
		JLabel lblInicio = new JLabel("Inicio");
		lblInicio.setForeground(Color.WHITE);
		lblInicio.setFont(new Font("Dialog", Font.BOLD, 16));
		lblInicio.setBounds(12, 10, 175, 52);
		panel.add(lblInicio);
		
		deportes = controlador.consultarDeportes();
		
		for(int i=0; i < deportes.size(); i++) {
		    //Añadir cada elemento del ArrayList en el modelo de la lista
			model.addElement(deportes.get(i).getNombre());
		}
	}
}
