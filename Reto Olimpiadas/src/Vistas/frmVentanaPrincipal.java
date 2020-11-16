package Vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ComponentesPersonalizados.MenuPersonalizado;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.help.HelpSetException;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.SpringLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmVentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JLabel lblParticipacion;
	private JLabel lblEquipos;
	private JLabel lblDeportista;
	private JLabel lblDeporte;
	private JLabel lblEvento;
	private JLabel lblOlimpiadas;
	private JLabel lblInicio;
	private JButton btnAiuda;
	
	/**
	 * Create the frame.
	 * @throws HelpSetException 
	 */
	public frmVentanaPrincipal() throws HelpSetException {
		ponerAyuda();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 826, 533);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(51, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(192, 16, 640, 405);
		label.setIcon(new ImageIcon(frmVentanaPrincipal.class.getResource("/IMG/olimpiadas.jpg")));
		contentPane.add(label);
		
		MenuPersonalizado panel = new MenuPersonalizado("principal");
		panel.setBounds(5, 5, 187, 494);
		panel.setBackground(Color.BLACK);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnAiuda = new JButton("AIUDA");
		btnAiuda.setBounds(409, 460, 89, 23);
		contentPane.add(btnAiuda);

	}
	
	/**
	 * 	Ponemos la ayuda a esta pantalla pulsando en F1
	 * 
	 * @throws HelpSetException
	 */
	private void ponerAyuda() throws HelpSetException {
		try 
		{
			System.out.println("ey");
			File fichero = new File("Help"+File.separator+"help_set.hs");
			URL hsURL = fichero.toURI().toURL();
			
			HelpSet helpset = new HelpSet(getClass().getClassLoader(),hsURL);
			HelpBroker hb = helpset.createHelpBroker();
			
			//hb.enableHelpOnButton(btnAiuda, "clsVentanaPrincipal", helpset);
			hb.enableHelpKey(getRootPane(),"clsVentanaPrincipal", helpset);
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
