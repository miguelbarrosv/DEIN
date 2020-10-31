package Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Label;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JFormattedTextField;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.Panel;
import javax.swing.border.TitledBorder;

import UML.Controlador;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class frmVentanaAltaDeportista extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rbHombre;
	private String sexo;
	private ControladorVistas controladorVistas = new ControladorVistas();
	private Controlador controlador = new Controlador();


	/**
	 * Create the frame.
	 */
	public frmVentanaAltaDeportista() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label label = new Label("Añadir Deportista");
		label.setBounds(157, 10, 128, 21);
		contentPane.add(label);
		
		Label label_1 = new Label("Nombre: ");
		label_1.setBounds(30, 66, 68, 21);
		contentPane.add(label_1);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(124, 68, 103, 19);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		Label label_3 = new Label("Altura:");
		label_3.setBounds(30, 231, 68, 21);
		contentPane.add(label_3);
		
		Label label_4 = new Label("Peso");
		label_4.setBounds(30, 285, 68, 21);
		contentPane.add(label_4);
		
		JFormattedTextField frmtdtxtPeso = new JFormattedTextField(java.text.NumberFormat.getCurrencyInstance());
		frmtdtxtPeso.setBounds(124, 285, 103, 19);
		contentPane.add(frmtdtxtPeso);
		
		JFormattedTextField frmtdtxtAltura = new JFormattedTextField(java.text.NumberFormat.getCurrencyInstance());
		frmtdtxtAltura.setBounds(124, 233, 103, 19);
		contentPane.add(frmtdtxtAltura);
		
		JButton btnAadir = new JButton("Añadir");
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombre = txtNombre.getText();
				
				if (rbHombre.isSelected()) {
					sexo = "H";
				} else {
					sexo = "M";
				}
				
				int altura = Integer.parseInt(frmtdtxtAltura.getText());
				int peso = Integer.parseInt(frmtdtxtPeso.getText());

				try {
					controlador.añadirDeportista(nombre,sexo,altura,peso);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		btnAadir.setBounds(308, 299, 80, 25);
		contentPane.add(btnAadir);
		
		JPanel panel_1 = new JPanel();
		panel_1.setToolTipText("");
		panel_1.setBorder(new TitledBorder(null, "Sexo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(32, 109, 195, 98);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		rbHombre = new JRadioButton("Hombre");
		rbHombre.setBounds(51, 27, 80, 23);
		panel_1.add(rbHombre);
		buttonGroup.add(rbHombre);
		
		JRadioButton rbMujer = new JRadioButton("Mujer");
		rbMujer.setBounds(51, 67, 65, 23);
		panel_1.add(rbMujer);
		buttonGroup.add(rbMujer);
	}
}
