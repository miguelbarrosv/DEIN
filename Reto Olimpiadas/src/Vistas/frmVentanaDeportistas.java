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
	 */
	public frmVentanaDeportistas() throws SQLException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 805, 660);
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
		lblListaDeDeportistas.setBounds(433, 26, 149, 15);
		contentPane.add(lblListaDeDeportistas);
		
		MenuPersonalizado panel = new MenuPersonalizado("deportista");
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 187, 620);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));;
		
		JButton btnAaidrDeportista = new JButton("A�adir Deportista");
		btnAaidrDeportista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorVistas.abrirVentanaAltaDeportista();
			}
		});
		
		btnAaidrDeportista.setFont(new Font("Dialog", Font.BOLD, 10));
		btnAaidrDeportista.setBounds(632, 584, 135, 25);
		contentPane.add(btnAaidrDeportista);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(213, 438, 74, 15);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setEnabled(false);
		txtNombre.setEditable(false);
		txtNombre.setBounds(304, 436, 147, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(213, 505, 46, 14);
		contentPane.add(lblSexo);
		
		
		rbHombre.setEnabled(false);
		rbHombre.setBounds(304, 482, 109, 23);
		contentPane.add(rbHombre);
		
		rbMujer.setEnabled(false);
		rbMujer.setBounds(304, 521, 109, 23);
		contentPane.add(rbMujer);
		
		ButtonGroup bgroup = new ButtonGroup();
        bgroup.add(rbMujer);
        bgroup.add(rbHombre);
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setBounds(522, 438, 46, 14);
		contentPane.add(lblPeso);
		
		txtPeso = new JTextField();
		txtPeso.setEditable(false);
		txtPeso.setEnabled(false);
		txtPeso.setBounds(620, 435, 147, 20);
		contentPane.add(txtPeso);
		txtPeso.setColumns(10);
		
		JLabel lblAltura = new JLabel("Altura:");
		lblAltura.setBounds(522, 505, 61, 14);
		contentPane.add(lblAltura);
		
		txtAltura = new JTextField();
		txtAltura.setEditable(false);
		txtAltura.setEnabled(false);
		txtAltura.setBounds(620, 502, 147, 20);
		contentPane.add(txtAltura);
		txtAltura.setColumns(10);
		
		final JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(comprobarDatos())
					controlador.modificarDeportista(idDeportista,nombre,sexo,Integer.parseInt(altura),Integer.parseInt(peso));
					controladorVistas.cerrarVentanaDeportista();
					ControladorVistas.abrirVentanaPrincipal();
				} catch (NumberFormatException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		btnModificar.setEnabled(false);
		btnModificar.setBounds(500, 584, 102, 23);
		contentPane.add(btnModificar);
		
		final JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int respuesta = JOptionPane.showConfirmDialog(null, "Estas seguro de que quieres eliminar a este deportista?");
				
				if (respuesta == 0) {
					try {
						controlador.eliminarDeportista(idDeportista);
						controladorVistas.cerrarVentanaDeportista();
						ControladorVistas.abrirVentanaPrincipal();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnEliminar.setEnabled(false);
		btnEliminar.setBounds(361, 583, 102, 25);
		contentPane.add(btnEliminar);
		
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
				
				if (sexo == "F") {
					rbMujer.setSelected(true);
				} else if(sexo == "M") {
					rbHombre.setSelected(true);
				}
				
				btnModificar.setEnabled(true);
		        
			    System.out.print(idDeportista + " " + nombre + " " + sexo + " " + peso + " " + altura);
		    }
		});
	}


	private boolean comprobarDatos() {
		if (txtNombre.getText().length() > 0 && txtPeso.getText().length() > 0 && txtAltura.getText().length() > 0 ) {
			if (rbMujer.isSelected() == true || rbHombre.isSelected() == true) {
				 try 
			        { 
			            // checking valid integer using parseInt() method 
			            Integer.parseInt(txtAltura.getText()); 
			            Integer.parseInt(txtPeso.getText()); 
			            
			            return true;
			        }  
			        catch (NumberFormatException e) 
			        { 
			            System.out.println("Los campos altura y peso solo admiten numeros"); 
			        
			        }
			} else {
				return false;
			}
		
		} else  {
			return false;
		}
		
		return true;
	}
}
