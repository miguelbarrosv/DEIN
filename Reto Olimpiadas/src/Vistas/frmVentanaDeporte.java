package Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ComponentesPersonalizados.MenuPersonalizado;
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
		setBounds(100, 100, 866, 528);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		DefaultListModel<String> model = new DefaultListModel<>();
		JList<String> listaDeportes = new JList<>(model);
		listaDeportes.setModel(model);
		listaDeportes.setBounds(256, 73, 554, 324);
		contentPane.add(listaDeportes);
		
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
		btnNewButton.setBounds(702, 439, 108, 25);
		contentPane.add(btnNewButton);
		
		MenuPersonalizado panel = new MenuPersonalizado("deportes");
		panel.setLayout(null);
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 187, 494);
		contentPane.add(panel);
		
		deportes = controlador.consultarDeportes();
		
		for(int i=0; i < deportes.size(); i++) {
		    //A�adir cada elemento del ArrayList en el modelo de la lista
			model.addElement(deportes.get(i).getNombre());
		}
		
		
		
	}
}
