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
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 805, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		TablaPersonalizada tableModel  = new TablaPersonalizada("deportistas");
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(218, 70, 554, 329);
		contentPane.add(scrollPane);
		tableDeportistas = new JTable(tableModel);
		scrollPane.setViewportView(tableDeportistas);
		
		JLabel lblListaDeDeportistas = new JLabel("Lista de deportistas");
		lblListaDeDeportistas.setBounds(428, 31, 218, 15);
		lblListaDeDeportistas.setFont(new Font("Dialog", Font.BOLD, 16));
		contentPane.add(lblListaDeDeportistas);
		
		MenuPersonalizado panel = new MenuPersonalizado("deportista");
		panel.setBounds(5, 0, 187, 625);
		panel.setBackground(Color.BLACK);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));;
		
		JButton btnAaidrDeportista = new JButton("Alta Deportista");
		btnAaidrDeportista.setBounds(625, 588, 147, 26);
		btnAaidrDeportista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorVistas.abrirVentanaAltaDeportista();
			}
		});
		
		btnAaidrDeportista.setFont(new Font("Dialog", Font.BOLD, 12));
		contentPane.add(btnAaidrDeportista);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(218, 443, 74, 15);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(309, 441, 147, 19);
		txtNombre.setEnabled(false);
		txtNombre.setEditable(false);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(218, 510, 46, 15);
		contentPane.add(lblSexo);
		rbHombre.setBounds(309, 487, 109, 23);
		
		
		rbHombre.setEnabled(false);
		contentPane.add(rbHombre);
		rbMujer.setBounds(309, 526, 109, 23);
		
		rbMujer.setEnabled(false);
		contentPane.add(rbMujer);
		
		ButtonGroup bgroup = new ButtonGroup();
        bgroup.add(rbMujer);
        bgroup.add(rbHombre);
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setBounds(527, 443, 46, 15);
		contentPane.add(lblPeso);
		
		txtPeso = new JTextField();
		txtPeso.setBounds(625, 440, 147, 19);
		txtPeso.setEditable(false);
		txtPeso.setEnabled(false);
		contentPane.add(txtPeso);
		txtPeso.setColumns(10);
		
		JLabel lblAltura = new JLabel("Altura:");
		lblAltura.setBounds(527, 510, 61, 15);
		contentPane.add(lblAltura);
		
		txtAltura = new JTextField();
		txtAltura.setBounds(625, 507, 147, 19);
		txtAltura.setEditable(false);
		txtAltura.setEnabled(false);
		contentPane.add(txtAltura);
		txtAltura.setColumns(10);
		
		final JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(495, 589, 111, 25);
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
		btnEliminar.setBounds(366, 588, 108, 26);
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
