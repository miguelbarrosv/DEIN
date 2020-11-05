package Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import ComponentesPersonalizados.TablaPersonalizada;

import com.jgoodies.forms.layout.FormSpecs;

public class frmVentanaAltaEvento extends JFrame {

	private JPanel contentPane;
	private JTable tableOlimpiadas;

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public frmVentanaAltaEvento() throws SQLException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 728, 541);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAltaEvento = new JLabel("Alta Evento");
		lblAltaEvento.setBounds(417, 38, 80, 15);
		contentPane.add(lblAltaEvento);
		
		JLabel lblEligeUnaOlimpiada = new JLabel("Elige una olimpiada:");
		lblEligeUnaOlimpiada.setBounds(71, 132, 161, 15);
		contentPane.add(lblEligeUnaOlimpiada);
		
		TablaPersonalizada tableModel  = new TablaPersonalizada("olimpiadas");
		
		tableOlimpiadas = new JTable(tableModel);
		tableOlimpiadas.setColumnSelectionAllowed(true);
		tableOlimpiadas.setEnabled(false);
		tableOlimpiadas.setBounds(219, 102, 568, 290);
		contentPane.add(tableOlimpiadas);
	}
}
