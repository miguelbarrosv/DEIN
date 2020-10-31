package LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import LN.clsPersona;

import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.JList;
import javax.swing.JButton;

public class frmAltaDeportes extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtAltaDeporte;		
	private JButton btnInsertarPersona;
	private ModeloAlta modelo;
	private JComboBox <clsDeporte> comboBox;
	
	/**
	 * Create the frame.
	 */
	public frmAltaDeportes() {
		modelo = new ModeloAlta(new ArrayList<clsDeporte>());
		comboBox = new JComboBox <clsDeporte> (modelo);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		txtAltaDeporte = new JTextField();
		contentPane.add(txtAltaDeporte, BorderLayout.NORTH);
		txtAltaDeporte.setColumns(10);
		
		JList listDeportes = new JList(modelo);
		
		contentPane.add(listDeportes, BorderLayout.CENTER);
				
		btnInsertarPersona = new JButton("Insertar Persona");
		btnInsertarPersona.addActionListener(this);
		contentPane.add(btnInsertarPersona, BorderLayout.SOUTH);
				
	}
	
	
	public void setItem(clsDeporte deporte)
	{
//		this.comboBox.addItem(deporte);
		modelo.addElement(deporte);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		//Cogemos el objeto seleccionado en el JComboBox, lo casteamos a la clase correspondiente y obtenemos el DNI
				clsDeporte seleccion = ((clsDeporte) comboBox.getSelectedItem());
				if(seleccion != null)
				{
					String nombre = seleccion.getNombre();
					System.out.println("El nombre de este deporte es " + nombre);
				}
	}
}
