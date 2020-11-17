package Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.help.HelpSetException;
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
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

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
	 * 
	 * @throws SQLException 
	 * @throws HelpSetException 
	 */
	public frmVentanaDeporte() throws SQLException, HelpSetException {
		ponerAyuda();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 866, 556);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		TablaPersonalizada tableModel  = new TablaPersonalizada("deporte");
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane, 64, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane, 246, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane, 410, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane, 815, SpringLayout.WEST, contentPane);
		contentPane.add(scrollPane);
		tableDeporte = new JTable(tableModel);
		scrollPane.setViewportView(tableDeporte);
		
		JLabel lblNewLabel = new JLabel("Lista de Deportes");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 12, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 466, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel, 37, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel, 644, SpringLayout.WEST, contentPane);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Alta Deporte");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, 496, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 683, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, 815, SpringLayout.WEST, contentPane);
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				controladorVistas.abrirVentanaAltaDeporte();
			}
		});
		contentPane.add(btnNewButton);
		
		MenuPersonalizado panel = new MenuPersonalizado("deportes");
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel, 530, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel, 192, SpringLayout.WEST, contentPane);
		panel.setBackground(Color.BLACK);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNombre = new JLabel("Nombre:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNombre, 450, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNombre, 246, SpringLayout.WEST, contentPane);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtNombre, 448, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtNombre, 334, SpringLayout.WEST, contentPane);
		txtNombre.setEnabled(false);
		txtNombre.setEditable(false);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		final JButton btnModificar = new JButton("Modificar");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnModificar, 496, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnModificar, 554, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnModificar, 661, SpringLayout.WEST, contentPane);
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controlador.modificarDeporte(idDeporte, txtNombre.getText());
					controladorVistas.cerrarVentanaDeportes();
					controladorVistas.abrirVentanaPrincipal();
				} catch (SQLException | HelpSetException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnModificar.setEnabled(false);
		contentPane.add(btnModificar);
		
		final JButton btnEliminar = new JButton("Eliminar");
		sl_contentPane.putConstraint(SpringLayout.EAST, txtNombre, 22, SpringLayout.EAST, btnEliminar);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnEliminar, 496, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnEliminar, 430, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnEliminar, 529, SpringLayout.WEST, contentPane);
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
				} catch (HelpSetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				

			}
		});
		contentPane.add(btnEliminar);
		
		tableDeporte.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		         idDeporte = (int) tableDeporte.getValueAt(tableDeporte.getSelectedRow(), 0);
		         nombre = tableDeporte.getValueAt(tableDeporte.getSelectedRow(), 1).toString();
		         
		         txtNombre.setEnabled(true);
		         txtNombre.setEditable(true);
		         txtNombre.setText(nombre);
		         
		         btnModificar.setEnabled(true);
		         btnEliminar.setEnabled(true);
		    }
		});
	}
	
	/**
	 * 	Ponemos la ayuda a esta pantalla pulsando en F1
	 * 
	 * @throws HelpSetException
	 */
	private void ponerAyuda() throws HelpSetException {
		try 
		{
			File fichero = new File("Help"+File.separator+"help_set.hs");
			URL hsURL = fichero.toURI().toURL();
			
			HelpSet helpset = new HelpSet(getClass().getClassLoader(),hsURL);
			HelpBroker hb = helpset.createHelpBroker();
			
			//hb.enableHelpOnButton(btnAiuda, "clsVentanaDeportel", helpset);
			hb.enableHelpKey(getRootPane(),"deportes", helpset);
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
