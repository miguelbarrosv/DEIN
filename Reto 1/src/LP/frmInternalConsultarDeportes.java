package LP;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JInternalFrame;
import javax.swing.JList;

import BD.DeporteBD;
import LN.clsDeporte;

import javax.swing.JLabel;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;

public class frmInternalConsultarDeportes extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	
	private  ArrayList<clsDeporte> deportes;
				

	/**
	 * Create the frame.
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public frmInternalConsultarDeportes() throws SQLException, Exception  {
		JList listDeportes = new JList();
		listDeportes.setBounds(291, 189, -189, -113);
		getContentPane().add(listDeportes);
		
		deportes = DeporteBD.consultarTodosDeportes(); 
		DefaultListModel modelo = new DefaultListModel();
		
		if (deportes.isEmpty()) {
			System.out.print("Error no hay ningun deporte");
        } else {
        	for(int i = 0; i < deportes.size(); i++){
		        modelo.addElement(deportes.get(i).getNombre());
			}
			listDeportes.setModel(modelo);
        }
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		
		
		JLabel lblListaDeportes = new JLabel("Lista Deportes");
		lblListaDeportes.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblListaDeportes.setBounds(156, 25, 173, 21);
		getContentPane().add(lblListaDeportes);
		
		frmInternalConsultarDeportes frame = new frmInternalConsultarDeportes();
		frame.setVisible(true);
	}
}
