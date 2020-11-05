package Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ComponentesPersonalizados.MenuPersonalizado;
import Main.clsMain;
import UML.Controlador;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

public class frmVentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private Controlador controlador;
	private ControladorVistas controladorVistas = new ControladorVistas();

	/**
	 * Create the frame.
	 */
	public frmVentanaPrincipal() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 826, 501);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(51, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("187px"),
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("626px"),},
			new RowSpec[] {
				RowSpec.decode("554px"),}));
		
		MenuPersonalizado panel = new MenuPersonalizado("principal");
		panel.setLayout(null);
		panel.setBackground(Color.BLACK);
		contentPane.add(panel, "1, 1, fill, fill");
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(frmVentanaPrincipal.class.getResource("/IMG/olimpiadas.jpg")));
		contentPane.add(label, "3, 1, fill, fill");
		
		
	}
}
