package Vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ComponentesPersonalizados.MenuPersonalizado;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.GridLayout;

public class frmVentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JLabel lblParticipacion;
	private JLabel lblEquipos;
	private JLabel lblDeportista;
	private JLabel lblDeporte;
	private JLabel lblEvento;
	private JLabel lblOlimpiadas;
	private JLabel lblInicio;
	
	/**
	 * Create the frame.
	 */
	public frmVentanaPrincipal() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 826, 518);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(51, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(186, 0, 640, 452);
		label.setIcon(new ImageIcon(frmVentanaPrincipal.class.getResource("/IMG/olimpiadas.jpg")));
		contentPane.add(label);
		
		MenuPersonalizado panel = new MenuPersonalizado("principal");
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 187, 494);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		

	}
}
