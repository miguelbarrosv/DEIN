package Vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ComponentesPersonalizados.MenuPersonalizado;
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
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class frmVentanaDeportistas extends JFrame {

	private JPanel contentPane;
	private JTable tableDeportistas;
	private ArrayList<Deportista> deportistas;
	private Controlador controlador = new Controlador();
	private ControladorVistas controladorVistas = new ControladorVistas();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public frmVentanaDeportistas() throws SQLException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 805, 645);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		TablaPersonalizada tableModel  = new TablaPersonalizada("deportistas");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(213, 65, 554, 329);
		contentPane.add(scrollPane);
		tableDeportistas = new JTable(tableModel);
		scrollPane.setViewportView(tableDeportistas);
		
		JLabel lblListaDeDeportistas = new JLabel("Lista de deportistas");
		lblListaDeDeportistas.setBounds(454, 25, 102, 15);
		contentPane.add(lblListaDeDeportistas);
		
		MenuPersonalizado panel = new MenuPersonalizado("deportista");
		panel.setLayout(null);
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 187, 606);
		contentPane.add(panel);
		
		JButton btnAaidrDeportista = new JButton("A�adir Deportista");
		btnAaidrDeportista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorVistas.abrirVentanaAltaDeportista();
			}
		});
		
		btnAaidrDeportista.setFont(new Font("Dialog", Font.BOLD, 10));
		btnAaidrDeportista.setBounds(632, 570, 135, 25);
		contentPane.add(btnAaidrDeportista);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(213, 438, 46, 14);
		contentPane.add(lblNombre);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setEditable(false);
		textField.setBounds(287, 435, 147, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(213, 505, 46, 14);
		contentPane.add(lblSexo);
		
		JRadioButton rdbtnHombre = new JRadioButton("Hombre");
		rdbtnHombre.setEnabled(false);
		rdbtnHombre.setBounds(287, 483, 109, 23);
		contentPane.add(rdbtnHombre);
		
		JRadioButton rdbtnMujer = new JRadioButton("Mujer");
		rdbtnMujer.setEnabled(false);
		rdbtnMujer.setBounds(287, 521, 109, 23);
		contentPane.add(rdbtnMujer);
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setBounds(537, 438, 46, 14);
		contentPane.add(lblPeso);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setBounds(620, 435, 147, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblAltura = new JLabel("Altura:");
		lblAltura.setBounds(537, 505, 46, 14);
		contentPane.add(lblAltura);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setBounds(620, 502, 147, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(522, 571, 89, 23);
		contentPane.add(btnModificar);
		
		tableDeportistas.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		        int row = tableDeportistas.rowAtPoint(evt.getPoint());
		        int col = tableDeportistas.columnAtPoint(evt.getPoint());
		        
			    System.out.println(row + "  " + col);
		    }
		});

	}
}
