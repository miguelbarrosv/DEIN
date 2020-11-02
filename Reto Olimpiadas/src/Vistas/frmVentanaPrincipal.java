package Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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

public class frmVentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private Controlador controlador;
	private ControladorVistas controladorVistas = new ControladorVistas();

	/**
	 * Create the frame.
	 */
	public frmVentanaPrincipal() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 814, 501);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(51, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 187, 494);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblParticipacion = new JLabel("Participacion");
		lblParticipacion.setFont(new Font("Dialog", Font.BOLD, 16));
		lblParticipacion.setBounds(12, 74, 175, 52);
		lblParticipacion.setForeground(Color.WHITE);
		panel.add(lblParticipacion);
		
		JLabel lblEquipos = new JLabel("Equipos");
		lblEquipos.setForeground(Color.WHITE);
		lblEquipos.setFont(new Font("Dialog", Font.BOLD, 16));
		lblEquipos.setBounds(12, 138, 175, 52);
		panel.add(lblEquipos);
		
		JLabel lblDeportista = new JLabel("Deportista");
		lblDeportista.setForeground(Color.WHITE);
		lblDeportista.setFont(new Font("Dialog", Font.BOLD, 16));
		lblDeportista.setBounds(12, 202, 175, 52);
		panel.add(lblDeportista);
		
		JLabel lblDeporte = new JLabel("Deporte");
		lblDeporte.setForeground(Color.WHITE);
		lblDeporte.setFont(new Font("Dialog", Font.BOLD, 16));
		lblDeporte.setBounds(12, 266, 175, 52);
		panel.add(lblDeporte);
		
		JLabel lblEvento = new JLabel("Evento");
		lblEvento.setForeground(Color.WHITE);
		lblEvento.setFont(new Font("Dialog", Font.BOLD, 16));
		lblEvento.setBounds(12, 330, 175, 52);
		panel.add(lblEvento);
		
		JLabel lblOlimpiadas = new JLabel("Olimpiadas");
		lblOlimpiadas.setForeground(Color.WHITE);
		lblOlimpiadas.setFont(new Font("Dialog", Font.BOLD, 16));
		lblOlimpiadas.setBounds(12, 394, 175, 45);
		panel.add(lblOlimpiadas);
		
		JLabel lblInicio = new JLabel("Inicio");
		lblInicio.setForeground(Color.WHITE);
		lblInicio.setFont(new Font("Dialog", Font.BOLD, 16));
		lblInicio.setBounds(12, 10, 175, 52);
		panel.add(lblInicio);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(frmVentanaPrincipal.class.getResource("/IMG/olimpiadas.jpg")));
		label.setBounds(188, -60, 626, 536);
		contentPane.add(label);
		
		lblOlimpiadas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	try {
            		controladorVistas.cerrarVentanaPrincipal();
					controladorVistas.abrirVentanaOlimpiada();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
            }

        });
		
		lblEvento.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	try {
            		
					controladorVistas.abrirVentanaEvento();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
            }

        });
		
		lblDeportista.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	try {
					controladorVistas.abrirVentanaDeportista();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
            }

        });
		
		lblParticipacion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	try {
					controladorVistas.abrirVentanaParticipacion();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
            }

        });
		
		lblEquipos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	try {
					controladorVistas.abrirVentanaEquipos();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
            }

        });
		
		lblDeporte.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	try {
					controladorVistas.abrirVentanaDeporte();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
            }

        });
		
		
	}
}
