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

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.help.HelpSetException;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import UML.Controlador;
import UML.Deportista;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.SpringLayout;

public class frmVentanaDeportistas extends JFrame {

	private JPanel contentPane;
	private JTable tableDeportistas;
	private ArrayList<Deportista> deportistas;
	private Controlador controlador = new Controlador();
	private ControladorVistas controladorVistas = new ControladorVistas();
	private JTextField txtNombre;
	private JTextField txtPeso;
	private JTextField txtAltura;
	String nombre;
    String altura;
    String peso ;
    String sexo;
    int idDeportista;
	final JRadioButton rbHombre = new JRadioButton("Hombre");
	final JRadioButton rbMujer = new JRadioButton("Mujer");


	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws HelpSetException 
	 */
	public frmVentanaDeportistas() throws SQLException, HelpSetException {
		ponerAyuda();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 805, 670);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		TablaPersonalizada tableModel  = new TablaPersonalizada("deportistas");
		SpringLayout sl_contentPane = new SpringLayout();
		sl_contentPane.putConstraint(SpringLayout.NORTH, rbMujer, 526, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, rbMujer, 309, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, rbMujer, 418, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, rbHombre, 487, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, rbHombre, 309, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, rbHombre, 418, SpringLayout.WEST, contentPane);
		contentPane.setLayout(sl_contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane, 70, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane, 218, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane, 399, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane, 772, SpringLayout.WEST, contentPane);
		contentPane.add(scrollPane);
		tableDeportistas = new JTable(tableModel);
		scrollPane.setViewportView(tableDeportistas);
		
		JLabel lblListaDeDeportistas = new JLabel("Lista de deportistas");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblListaDeDeportistas, 31, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblListaDeDeportistas, 428, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblListaDeDeportistas, 46, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblListaDeDeportistas, 646, SpringLayout.WEST, contentPane);
		lblListaDeDeportistas.setFont(new Font("Dialog", Font.BOLD, 16));
		contentPane.add(lblListaDeDeportistas);
		
		MenuPersonalizado panel = new MenuPersonalizado("deportista");
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel, 5, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel, 625, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel, 192, SpringLayout.WEST, contentPane);
		panel.setBackground(new Color(255,153,0));
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));;
		
		JButton btnAaidrDeportista = new JButton("Alta Deportista");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnAaidrDeportista, 588, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnAaidrDeportista, 625, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnAaidrDeportista, 614, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnAaidrDeportista, 772, SpringLayout.WEST, contentPane);
		btnAaidrDeportista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorVistas.abrirVentanaAltaDeportista();
			}
		});
		
		btnAaidrDeportista.setFont(new Font("Dialog", Font.BOLD, 12));
		contentPane.add(btnAaidrDeportista);
		
		JLabel lblNombre = new JLabel("Nombre:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNombre, 443, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNombre, 218, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNombre, 458, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNombre, 292, SpringLayout.WEST, contentPane);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtNombre, 441, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtNombre, 309, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtNombre, 460, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtNombre, 456, SpringLayout.WEST, contentPane);
		txtNombre.setEnabled(false);
		txtNombre.setEditable(false);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblSexo = new JLabel("Sexo:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblSexo, 510, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblSexo, 218, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblSexo, 525, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblSexo, 264, SpringLayout.WEST, contentPane);
		contentPane.add(lblSexo);
		
		
		rbHombre.setEnabled(false);
		contentPane.add(rbHombre);
		
		rbMujer.setEnabled(false);
		contentPane.add(rbMujer);
		
		ButtonGroup bgroup = new ButtonGroup();
        bgroup.add(rbMujer);
        bgroup.add(rbHombre);
		
		JLabel lblPeso = new JLabel("Peso:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblPeso, 443, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblPeso, 527, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblPeso, 458, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblPeso, 573, SpringLayout.WEST, contentPane);
		contentPane.add(lblPeso);
		
		txtPeso = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtPeso, 440, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtPeso, 625, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtPeso, 459, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtPeso, 772, SpringLayout.WEST, contentPane);
		txtPeso.setEditable(false);
		txtPeso.setEnabled(false);
		contentPane.add(txtPeso);
		txtPeso.setColumns(10);
		
		JLabel lblAltura = new JLabel("Altura:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblAltura, 510, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblAltura, 527, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblAltura, 525, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblAltura, 588, SpringLayout.WEST, contentPane);
		contentPane.add(lblAltura);
		
		txtAltura = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtAltura, 507, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtAltura, 625, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtAltura, 526, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtAltura, 772, SpringLayout.WEST, contentPane);
		txtAltura.setEditable(false);
		txtAltura.setEnabled(false);
		contentPane.add(txtAltura);
		txtAltura.setColumns(10);
		
		final JButton btnModificar = new JButton("Modificar");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnModificar, 589, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnModificar, 495, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnModificar, 614, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnModificar, 606, SpringLayout.WEST, contentPane);
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(comprobarDatos())
					controlador.modificarDeportista(idDeportista,txtNombre.getText(),sexo,txtAltura.getText(),txtPeso.getText());
					controladorVistas.cerrarVentanaDeportista();
					ControladorVistas.abrirVentanaPrincipal();
				} catch (NumberFormatException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (HelpSetException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		btnModificar.setEnabled(false);
		contentPane.add(btnModificar);
		
		final JButton btnEliminar = new JButton("Eliminar");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnEliminar, 588, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnEliminar, 366, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnEliminar, 614, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnEliminar, 474, SpringLayout.WEST, contentPane);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int respuesta = JOptionPane.showConfirmDialog(null, "Estas seguro de que quieres eliminar a este deportista?");
				if (respuesta == 0) {
					try {
						controlador.eliminarDeportista(idDeportista);
						controladorVistas.cerrarVentanaDeportista();
						ControladorVistas.abrirVentanaPrincipal();
					} catch (SQLException e1) {
						e1.printStackTrace();
					} catch (HelpSetException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnEliminar.setEnabled(false);
		contentPane.add(btnEliminar);
		
		rbMujer.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            sexo = "F";

	        }
	    });
		
		rbHombre.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	sexo = "M";

	        }
	    });
		
		tableDeportistas.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		         idDeportista = (int) tableDeportistas.getValueAt(tableDeportistas.getSelectedRow(), 0);
		         nombre = tableDeportistas.getValueAt(tableDeportistas.getSelectedRow(), 1).toString();
		         altura = tableDeportistas.getValueAt(tableDeportistas.getSelectedRow(), 3).toString();
		         peso =  tableDeportistas.getValueAt(tableDeportistas.getSelectedRow(), 4).toString();
		         sexo = tableDeportistas.getValueAt(tableDeportistas.getSelectedRow(), 2).toString();

		        txtAltura.setEditable(true);
				txtAltura.setEnabled(true);
				txtAltura.setText(altura);

				
				txtPeso.setEditable(true);
				txtPeso.setEnabled(true);
				txtPeso.setText(peso);

				
				txtNombre.setEditable(true);
				txtNombre.setEnabled(true);
				txtNombre.setText(nombre);
				
				rbMujer.setEnabled(true);
				rbHombre.setEnabled(true);
				
				if (sexo.equals("F")) {
					rbMujer.setSelected(true);
				} else if(sexo.equals("M")) {
					rbHombre.setSelected(true);
				}
				
				btnModificar.setEnabled(true);
		        btnEliminar.setEnabled(true);
		        
			    System.out.print(idDeportista + " " + nombre + " " + sexo + " " + peso + " " + altura);
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
			
			//hb.enableHelpOnButton(btnAiuda, "clsVentanaDeportista", helpset);
			hb.enableHelpKey(getRootPane(),"deportista", helpset);
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	/**
	 *	Comprobamos los datos que vamos a modificar, si son correctos devolveremos true, si no son correctos se devolvera false. 
	 * 
	 * @return
	 */
	
	private boolean comprobarDatos() {
		if (txtNombre.getText().length() > 0 && txtPeso.getText().length() > 0 && txtAltura.getText().length() > 0 ) {
			if (rbMujer.isSelected() == true || rbHombre.isSelected() == true) { 
				return true;    
			} else {
				return false;
			}
		
		} else  {
			return false;
		}
	}
}
