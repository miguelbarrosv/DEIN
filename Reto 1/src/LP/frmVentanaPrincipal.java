package LP;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.Font;

public class frmVentanaPrincipal extends JFrame {

//	private JPanel contentPane;
	private JDesktopPane desktopPane;
	private frmInternalConsultarDeportes internalDeportes;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public frmVentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMenu = new JMenu("MENU");
		menuBar.add(mnMenu);
		
		JMenuItem mntmInternal = new JMenuItem("Mostrar Deportes");
		mnMenu.add(mntmInternal);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBounds(211, 121, 1, 1);
		this.setContentPane(desktopPane);
//		contentPane.add(desktopPane);
		
		JLabel lblVentanaPrincipal = new JLabel("Ventana Principal");
		lblVentanaPrincipal.setBounds(147, 37, 153, 72);
//		contentPane.add(lblVentanaPrincipal);
		
		JButton btnAltaDeporte = new JButton("Dar de alta deportes");
		btnAltaDeporte.setBounds(142, 161, 136, 25);
		desktopPane.add(btnAltaDeporte);
		
		JLabel lblVentanaPrincipal_1 = new JLabel("Ventana Principal");
		lblVentanaPrincipal_1.setFont(new Font("Dialog", Font.BOLD, 26));
		lblVentanaPrincipal_1.setBounds(80, 33, 288, 95);
		desktopPane.add(lblVentanaPrincipal_1);
		
		mntmInternal.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					internalDeportes = new frmInternalConsultarDeportes();
					internalDeportes.setVisible(true);
					desktopPane.add(internalDeportes);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		btnAltaDeporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmInternal internal = new frmInternal();
				internal.setVisible(true);
				desktopPane.add(internal);
			}
		});
		
		
	}
}
