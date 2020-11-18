package Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Label;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JFormattedTextField;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import javax.help.HelpSetException;
import javax.swing.ButtonGroup;
import java.awt.Panel;
import javax.swing.border.TitledBorder;

import Excepciones.RepetidoException;
import UML.Controlador;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.SpringLayout;

public class frmVentanaAltaDeportista extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rbHombre;
	private String sexo;
	private float altura;

	
	JFormattedTextField frmtdtxtPeso; 
	JFormattedTextField frmtdtxtAltura;
	
	private ControladorVistas controladorVistas = new ControladorVistas();
	private Controlador controlador = new Controlador();

	/**
	 * Create the frame.
	 */
	public frmVentanaAltaDeportista() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		Label label = new Label("Alta Deportista");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, label, 183, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, label, 31, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, label, -113, SpringLayout.EAST, contentPane);
		contentPane.add(label);
		
		Label label_1 = new Label("Nombre: ");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label_1, 66, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, label_1, 54, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, label_1, 87, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, label_1, 122, SpringLayout.WEST, contentPane);
		contentPane.add(label_1);
		
		txtNombre = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtNombre, 68, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtNombre, 128, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtNombre, 87, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtNombre, 240, SpringLayout.WEST, contentPane);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		Label label_3 = new Label("Altura:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label_3, 231, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, label_3, 54, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, label_3, 252, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, label_3, 122, SpringLayout.WEST, contentPane);
		contentPane.add(label_3);
		
		Label label_4 = new Label("Peso:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label_4, 285, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, label_4, 54, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, label_4, 306, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, label_4, 122, SpringLayout.WEST, contentPane);
		contentPane.add(label_4);
		
		frmtdtxtPeso = new JFormattedTextField(java.text.NumberFormat.getNumberInstance());
		sl_contentPane.putConstraint(SpringLayout.NORTH, frmtdtxtPeso, 285, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, frmtdtxtPeso, 128, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, frmtdtxtPeso, 304, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, frmtdtxtPeso, 240, SpringLayout.WEST, contentPane);
		contentPane.add(frmtdtxtPeso);
		
		frmtdtxtAltura = new JFormattedTextField(java.text.NumberFormat.getNumberInstance());
		sl_contentPane.putConstraint(SpringLayout.NORTH, frmtdtxtAltura, 231, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, frmtdtxtAltura, 128, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, frmtdtxtAltura, 250, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, frmtdtxtAltura, 240, SpringLayout.WEST, contentPane);
		contentPane.add(frmtdtxtAltura);
		
		JButton btnAadir = new JButton("Añadir");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnAadir, 306, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnAadir, 319, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnAadir, 331, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnAadir, 399, SpringLayout.WEST, contentPane);
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombre = txtNombre.getText();
				
				if (rbHombre.isSelected()) {
					sexo = "H";
				} else {
					sexo = "M";
				}
								 
				try {
					Double d =(Double) NumberFormat.getNumberInstance().parse(frmtdtxtAltura.getText());
					altura = d.floatValue();
					System.out.println(altura);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				
				float peso = Float.parseFloat(frmtdtxtPeso.getText());

				try {
					controlador.altaDeportista(nombre,sexo,altura,peso);
					controladorVistas.cerrarVentanaAltaDeportista();
					controladorVistas.cerrarVentanaDeportista();
					controladorVistas.abrirVentanaPrincipal();

				} catch (SQLException e) {
					e.printStackTrace();
				} catch (HelpSetException e) {
					e.printStackTrace();
				} catch (RepetidoException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		contentPane.add(btnAadir);
		
		JPanel panel_1 = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel_1, 116, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel_1, 54, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel_1, 201, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel_1, 244, SpringLayout.WEST, contentPane);
		panel_1.setToolTipText("");
		panel_1.setBorder(new TitledBorder(null, "Sexo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		rbHombre = new JRadioButton("Hombre");
		rbHombre.setBounds(76, 7, 98, 23);
		panel_1.add(rbHombre);
		buttonGroup.add(rbHombre);
		
		JRadioButton rbMujer = new JRadioButton("Mujer");
		rbMujer.setBounds(76, 52, 83, 23);
		panel_1.add(rbMujer);
		buttonGroup.add(rbMujer);
	}
}
