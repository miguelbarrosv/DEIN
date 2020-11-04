package ComponentesPersonalizados;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JPanel;

import UML.Controlador;
import Vistas.ControladorVistas;

public class MenuPersonalizado extends JPanel{
	
	private Controlador controlador;
	private ControladorVistas controladorVistas;
	private JLabel lblParticipacion;
	private JLabel lblEquipos;
	private JLabel lblDeportista;
	private JLabel lblDeporte;
	private JLabel lblEvento;
	private JLabel lblOlimpiadas;
	private JLabel lblInicio;
	
	public MenuPersonalizado() 
	{
		controladorVistas = new ControladorVistas ();
		controlador = new Controlador();
	}
	
	public MenuPersonalizado(String frame) 
	{
		
		this();
		
		lblParticipacion = new JLabel("Participacion");
		lblParticipacion.setForeground(Color.WHITE);
		lblParticipacion.setFont(new Font("Dialog", Font.BOLD, 16));
		lblParticipacion.setBounds(12, 74, 175, 52);
		this.add(lblParticipacion);
		
		lblEquipos = new JLabel("Equipos");
		lblEquipos.setForeground(Color.WHITE);
		lblEquipos.setFont(new Font("Dialog", Font.BOLD, 16));
		lblEquipos.setBounds(12, 138, 175, 52);
		this.add(lblEquipos);
		
		lblDeportista = new JLabel("Deportista");
		lblDeportista.setForeground(Color.WHITE);
		lblDeportista.setFont(new Font("Dialog", Font.BOLD, 16));
		lblDeportista.setBounds(12, 202, 175, 52);
		this.add(lblDeportista);
		
		lblDeporte = new JLabel("Deporte");
		lblDeporte.setForeground(Color.WHITE);
		lblDeporte.setFont(new Font("Dialog", Font.BOLD, 16));
		lblDeporte.setBounds(12, 266, 175, 52);
		this.add(lblDeporte);
		
		lblEvento = new JLabel("Evento");
		lblEvento.setForeground(Color.WHITE);
		lblEvento.setFont(new Font("Dialog", Font.BOLD, 16));
		lblEvento.setBounds(12, 330, 175, 52);
		this.add(lblEvento);
		
		lblOlimpiadas = new JLabel("Olimpiadas");
		lblOlimpiadas.setForeground(Color.WHITE);
		lblOlimpiadas.setFont(new Font("Dialog", Font.BOLD, 16));
		lblOlimpiadas.setBounds(12, 394, 175, 45);
		this.add(lblOlimpiadas);
		
		lblInicio = new JLabel("Inicio");
		lblInicio.setForeground(Color.WHITE);
		lblInicio.setFont(new Font("Dialog", Font.BOLD, 16));
		lblInicio.setBounds(12, 10, 175, 52);
		this.add(lblInicio);
		
		
		
		if (frame == "principal") {
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
	            		controladorVistas.cerrarVentanaPrincipal();
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
	            		controladorVistas.cerrarVentanaPrincipal();
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
	            		controladorVistas.cerrarVentanaPrincipal();
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
	            		controladorVistas.cerrarVentanaPrincipal();
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
	            		controladorVistas.cerrarVentanaPrincipal();
						controladorVistas.abrirVentanaDeporte();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
	            }

	        });
			
		} else if (frame == "olimpiada") {
			lblOlimpiadas.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	            	try {
	            		controladorVistas.cerrarVentanaOlimpiada();
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
	            		controladorVistas.cerrarVentanaOlimpiada();
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
	            		controladorVistas.cerrarVentanaOlimpiada();
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
	            		controladorVistas.cerrarVentanaOlimpiada();
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
	            		controladorVistas.cerrarVentanaOlimpiada();
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
	            		controladorVistas.cerrarVentanaOlimpiada();
						controladorVistas.abrirVentanaDeporte();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
	            }

	        });
			
		} else if (frame == "equipos") {
			lblOlimpiadas.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	            	try {
	            		controladorVistas.cerrarVentanaEquipos();
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
	            		controladorVistas.cerrarVentanaEquipos();
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
	            		controladorVistas.cerrarVentanaEquipos();
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
	            		controladorVistas.cerrarVentanaEquipos();
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
	            		controladorVistas.cerrarVentanaEquipos();
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
	            		controladorVistas.cerrarVentanaEquipos();
						controladorVistas.abrirVentanaDeporte();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
	            }

	        });
			
		} else if (frame == "deportes") {
			lblOlimpiadas.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	            	try {
	            		controladorVistas.cerrarVentanaDeportes();
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
	            		controladorVistas.cerrarVentanaDeportes();
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
	            		controladorVistas.cerrarVentanaDeportes();
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
	            		controladorVistas.cerrarVentanaDeportes();
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
	            		controladorVistas.cerrarVentanaDeportes();
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
	            		controladorVistas.cerrarVentanaDeportes();
						controladorVistas.abrirVentanaDeporte();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
	            }

	        });
			
		} else if(frame == "participacion") {
			lblOlimpiadas.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	            	try {
	            		controladorVistas.cerrarVentanaParticipacion();
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
	            		controladorVistas.cerrarVentanaParticipacion();
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
	            		controladorVistas.cerrarVentanaParticipacion();
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
	            		controladorVistas.cerrarVentanaParticipacion();
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
	            		controladorVistas.cerrarVentanaParticipacion();
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
	            		controladorVistas.cerrarVentanaParticipacion();
						controladorVistas.abrirVentanaDeporte();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
	            }

	        });
			
		} else if(frame == "deportista") {
			lblOlimpiadas.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	            	try {
	            		controladorVistas.cerrarVentanaDeportista();
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
	            		controladorVistas.cerrarVentanaDeportista();
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
	            		controladorVistas.cerrarVentanaDeportista();
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
	            		controladorVistas.cerrarVentanaDeportista();
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
	            		controladorVistas.cerrarVentanaDeportista();
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
	            		controladorVistas.cerrarVentanaDeportista();
						controladorVistas.abrirVentanaDeporte();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
	            }

	        });
			
		} else if (frame == "evento") {
			lblOlimpiadas.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	            	try {
	            		controladorVistas.cerrarVentanaEvento();
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
	            		controladorVistas.cerrarVentanaEvento();
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
	            		controladorVistas.cerrarVentanaEvento();
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
	            		controladorVistas.cerrarVentanaEvento();
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
	            		controladorVistas.cerrarVentanaEvento();
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
	            		controladorVistas.cerrarVentanaEvento();
						controladorVistas.abrirVentanaDeporte();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
	            }

	        });
			
		}
	}
}
