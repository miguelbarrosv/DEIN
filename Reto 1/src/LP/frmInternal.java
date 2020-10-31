package LP;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class frmInternal extends JInternalFrame {

	private JPanel contentPane;
	private JTextField txtDeporte;

	/**
	 * Create the frame.
	 */
	public frmInternal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Dar de alta un deporte");
		lblNewLabel.setBounds(119, 12, 203, 52);
		contentPane.add(lblNewLabel);
		
		txtDeporte = new JTextField();
		txtDeporte.setBounds(119, 89, 180, 19);
		contentPane.add(txtDeporte);
		txtDeporte.setColumns(10);
		
		JButton btnInsertar = new JButton("Insertar");
		btnInsertar.setBounds(153, 139, 117, 25);
		contentPane.add(btnInsertar);
	}
}
