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
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.help.HelpSetException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.SpringLayout;

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
	 * @throws HelpSetException 
	 */
	public frmVentanaEvento() throws SQLException, HelpSetException {
		ponerAyuda();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1060, 757);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblEvento = new JLabel("Lista de Eventos");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblEvento, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblEvento, -380, SpringLayout.EAST, contentPane);
		lblEvento.setFont(new Font("Dialog", Font.BOLD, 16));
		contentPane.add(lblEvento);
		
		MenuPersonalizado panel = new MenuPersonalizado("evento");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblEvento, 287, SpringLayout.EAST, panel);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel, -5, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel, 731, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel, 187, SpringLayout.WEST, contentPane);
		panel.setBackground(new Color(255,153,0));
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));;
		
		
		TablaPersonalizada tableModel  = new TablaPersonalizada("eventos");
		
		JScrollPane scrollPane = new JScrollPane();
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblEvento, -32, SpringLayout.NORTH, scrollPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane, 57, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane, 206, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane, 386, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane, 1026, SpringLayout.WEST, contentPane);
		contentPane.add(scrollPane);
		tableEventos = new JTable(tableModel);
		scrollPane.setViewportView(tableEventos);
		
		TablaPersonalizada tableModelOlimpiadas  = new TablaPersonalizada("olimpiadas");
		
		final JScrollPane scrollPaneOlimpiadas = new JScrollPane();
		sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPaneOlimpiadas, 446, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, scrollPaneOlimpiadas, 205, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPaneOlimpiadas, 653, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, scrollPaneOlimpiadas, 587, SpringLayout.WEST, contentPane);
		scrollPaneOlimpiadas.setEnabled(false);
		contentPane.add(scrollPaneOlimpiadas);
		tableOlimpiadas = new JTable(tableModelOlimpiadas);
		tableOlimpiadas.setEnabled(false);
		scrollPaneOlimpiadas.setViewportView(tableOlimpiadas);
		
		TablaPersonalizada tableModelDeporte  = new TablaPersonalizada("deporte");
		
		final JScrollPane scrollPaneDeporte = new JScrollPane();
		scrollPaneDeporte.setEnabled(false);
		sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPaneDeporte, 446, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, scrollPaneDeporte, 610, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPaneDeporte, 653, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, scrollPaneDeporte, 1026, SpringLayout.WEST, contentPane);
		contentPane.add(scrollPaneDeporte);
		tableDeporte = new JTable(tableModelDeporte);
		tableDeporte.setEnabled(false);
		scrollPaneDeporte.setViewportView(tableDeporte);
		
		JButton btnAadirEvento = new JButton("Alta Evento");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnAadirEvento, 692, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnAadirEvento, 912, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnAadirEvento, 717, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnAadirEvento, 1026, SpringLayout.WEST, contentPane);
		
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
		btnAadirEvento.setFont(new Font("Dialog", Font.BOLD, 12));
		contentPane.add(btnAadirEvento);
		
		JLabel lblOlimpiadas = new JLabel("Selecciona una olimpiadas para modificarla: ");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblOlimpiadas, 413, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblOlimpiadas, 206, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblOlimpiadas, 428, SpringLayout.NORTH, contentPane);
		contentPane.add(lblOlimpiadas);
		
		final JButton btnEliminar = new JButton("Eliminar");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnEliminar, 692, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnEliminar, 658, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnEliminar, 717, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnEliminar, 775, SpringLayout.WEST, contentPane);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					controlador.eliminarEvento(idEvento);
					controladorVistas.cerrarVentanaEvento();
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
		btnEliminar.setEnabled(false);
		contentPane.add(btnEliminar);
		
		
		
		
		
		final JButton btnModificar = new JButton("Modificar");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnModificar, 692, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnModificar, 785, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnModificar, 717, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnModificar, 902, SpringLayout.WEST, contentPane);
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					controlador.modificarEvento(idEvento,nombreEvento,idOlimpiada,idDeporte);
					controladorVistas.cerrarVentanaEvento();
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
		btnModificar.setEnabled(false);
		contentPane.add(btnModificar);
		
		tableEventos.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		         idEvento = (int) tableEventos.getValueAt(tableEventos.getSelectedRow(), 0);
		         nombreEvento = tableEventos.getValueAt(tableEventos.getSelectedRow(), 1).toString();
		         idOlimpiada = (int) tableEventos.getValueAt(tableEventos.getSelectedRow(), 2);
		         idDeporte = (int) tableEventos.getValueAt(tableEventos.getSelectedRow(), 4);
		         
		         btnEliminar.setEnabled(true);
		         btnModificar.setEnabled(true);
		         
		         tableOlimpiadas.setEnabled(true);
		         tableDeporte.setEnabled(true);
		         
		         scrollPaneDeporte.setEnabled(true);
		         scrollPaneOlimpiadas.setEnabled(true);

		    }
		});
		
		tableOlimpiadas.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		         idOlimpiada = (int)tableOlimpiadas.getValueAt(tableOlimpiadas.getSelectedRow(), 0);
		    }
		});
		
		tableDeporte.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		         idDeporte = (int)tableDeporte.getValueAt(tableDeporte.getSelectedRow(), 0);
		    }
		});
		
		JLabel lblDeportes = new JLabel("Selecciona un deporte para modificarlo:\r\n");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblDeportes, 413, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblDeportes, 610, SpringLayout.WEST, contentPane);
		contentPane.add(lblDeportes);
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
			
			//hb.enableHelpOnButton(btnAiuda, "clsVentanaEvento", helpset);
			hb.enableHelpKey(getRootPane(),"evento", helpset);
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
