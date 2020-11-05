package Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import ComponentesPersonalizados.TablaPersonalizada;
import UML.Controlador;
import UML.Deporte;
import javax.swing.JTextField;


public class frmVentanaAltaEvento extends JFrame {

	private JPanel contentPane;
	private JTable tableOlimpiadas;
	private Controlador controlador = new Controlador();
	private ArrayList<Deporte> deportes;
	private JList<String> listaDeportes;
	private JTextField textField;

	
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public frmVentanaAltaEvento() throws SQLException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 850, 585);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAltaEvento = new JLabel("Alta Evento");
		lblAltaEvento.setBounds(406, 25, 80, 15);
		contentPane.add(lblAltaEvento);
		
		JLabel lblEligeUnaOlimpiada = new JLabel("Elige una olimpiada:");
		lblEligeUnaOlimpiada.setBounds(47, 71, 161, 15);
		contentPane.add(lblEligeUnaOlimpiada);
		
		TablaPersonalizada tableModel  = new TablaPersonalizada("olimpiadas");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(47, 97, 319, 175);
		contentPane.add(scrollPane);
		tableOlimpiadas = new JTable(tableModel);
		scrollPane.setViewportView(tableOlimpiadas);
		
		JLabel lblEligeUnDeporte = new JLabel("Elige un deporte");
		lblEligeUnDeporte.setBounds(442, 71, 85, 14);
		contentPane.add(lblEligeUnDeporte);
		
		DefaultListModel<String> model = new DefaultListModel<>();
		listaDeportes = new JList<String>(model);
		JScrollPane scrollPaneDeporte = new JScrollPane(listaDeportes);
		scrollPaneDeporte.setBounds(442, 97, 338, 175);
		contentPane.add(scrollPaneDeporte);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(47, 331, 46, 14);
		contentPane.add(lblNombre);
		
		textField = new JTextField();
		textField.setBounds(122, 328, 244, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnAadir = new JButton("A\u00F1adir");
		btnAadir.setBounds(665, 468, 89, 23);
		contentPane.add(btnAadir);
		
		deportes = controlador.consultarDeportes();
		
		for(int i=0; i < deportes.size(); i++) {
		    //A�adir cada elemento del ArrayList en el modelo de la lista
			model.addElement(deportes.get(i).getNombre());
		}
		
	}
}
