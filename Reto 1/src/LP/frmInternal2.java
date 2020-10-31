package LP;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import BD.DeporteBD;
import LN.clsDeporte;

import javax.swing.JButton;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JComboBox;

public class frmInternal2 extends JInternalFrame {
	
	private JTextField txtNuevoDeporte;
	
	private ModeloAltaDeporte modelo;

	/**
	 * Create the frame.
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public frmInternal2() throws SQLException, Exception {
		modelo = new ModeloAltaDeporte(new ArrayList<clsDeporte>());
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblDeportes = new JLabel("Deportes");
		lblDeportes.setFont(new Font("Dialog", Font.BOLD, 21));
		lblDeportes.setBounds(147, 12, 117, 31);
		getContentPane().add(lblDeportes);
		
		txtNuevoDeporte = new JTextField();
		txtNuevoDeporte.setBounds(118, 172, 172, 19);
		getContentPane().add(txtNuevoDeporte);
		txtNuevoDeporte.setColumns(10);
		
		JButton btnInsertar = new JButton("Insertar");
		btnInsertar.setBounds(147, 203, 117, 25);
		getContentPane().add(btnInsertar);
		
		JLabel lblInsertarNuevoDeporte = new JLabel("Insertar nuevo deporte");
		lblInsertarNuevoDeporte.setBounds(118, 145, 192, 15);
		getContentPane().add(lblInsertarNuevoDeporte);
		
		JComboBox cbDeportes = new JComboBox();
		cbDeportes.setBounds(118, 67, 158, 24);
		getContentPane().add(cbDeportes);

	}
}
