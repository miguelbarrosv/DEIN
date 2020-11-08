package Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import ComponentesPersonalizados.MenuPersonalizado;
import UML.Controlador;
import UML.Equipo;

import javax.swing.JLabel;
import javax.swing.JList;
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
	private JList<String> listaEquipos;


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
		
		DefaultListModel<String> model = new DefaultListModel<>();
		listaEquipos = new JList<String>(model);
		JScrollPane scrollPaneDeporte = new JScrollPane(listaEquipos);
		scrollPaneDeporte.setBounds(241, 59, 569, 346);
		contentPane.add(scrollPaneDeporte);
		
		MenuPersonalizado panel = new MenuPersonalizado("equipos");
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 187, 581);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		equipos = controlador.consultarEquipos();
		
		for (int x = 0; x < equipos.size(); x++) {
			String infEquipo = equipos.get(x).getIniciales() + " " + equipos.get(x).getNombre();
			model.addElement(infEquipo);
		}
		
		JButton btnAadirEquipo = new JButton("Añadir EQuipo");
		
		btnAadirEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorVistas.abrirVentanaAltaEquipos();
			}
		});
		btnAadirEquipo.setFont(new Font("Dialog", Font.BOLD, 10));
		btnAadirEquipo.setBounds(693, 510, 114, 25);
		contentPane.add(btnAadirEquipo);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(241, 444, 72, 14);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(323, 441, 187, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controlador.modificarEquipo();
			}
		});
		btnModificar.setBounds(550, 511, 114, 23);
		contentPane.add(btnModificar);
		
		listaEquipos.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                if (!arg0.getValueIsAdjusting()) {
                	
                	txtNombre.setText(listaEquipos.getSelectedValue().toString());
                	txtNombre.setEnabled(true);
                	System.out.print(listaEquipos.getSelectedValue().toString());
                }
            }
        });
	}
}
