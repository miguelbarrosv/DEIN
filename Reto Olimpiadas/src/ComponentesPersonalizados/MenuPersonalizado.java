package ComponentesPersonalizados;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.help.HelpSetException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

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
	private JButton btnAyuda;
	public MenuPersonalizado() 
	{
		controladorVistas = new ControladorVistas ();
		controlador = new Controlador();
	}
	
	/**
	 * Metodo que crea el menu personalizado y añade los eventos a los menus
	 * 
	 * @param frame
	 * @throws HelpSetException 
	 */
	public MenuPersonalizado(String frame) throws HelpSetException 
	{
		
		
		this();
		
		lblInicio = new JLabel("Inicio");
		lblInicio.setForeground(Color.WHITE);
		lblInicio.setFont(new Font("Dialog", Font.BOLD, 16));
		lblInicio.setBackground(new Color(255,153,0));
    	lblInicio.setOpaque(true);
		this.add(lblInicio);
		
		lblParticipacion = new JLabel("Participacion");
		lblParticipacion.setForeground(Color.WHITE);
		lblParticipacion.setFont(new Font("Dialog", Font.BOLD, 16));
    	lblParticipacion.setBackground(new Color(255,153,0));
    	lblParticipacion.setOpaque(true);
		this.add(lblParticipacion);
		
		lblDeportista = new JLabel("Deportista");
		lblDeportista.setForeground(Color.WHITE);
		lblDeportista.setFont(new Font("Dialog", Font.BOLD, 16));
    	lblDeportista.setBackground(new Color(255,153,0));
    	lblDeportista.setOpaque(true);

		this.add(lblDeportista);
		
		lblEvento = new JLabel("Evento");
		lblEvento.setForeground(Color.WHITE);
		lblEvento.setFont(new Font("Dialog", Font.BOLD, 16));
    	lblEvento.setBackground(new Color(255,153,0));
    	lblEvento.setOpaque(true);
		this.add(lblEvento);
		
		lblDeporte = new JLabel("Deporte");
		lblDeporte.setForeground(Color.WHITE);
		lblDeporte.setFont(new Font("Dialog", Font.BOLD, 16));
    	lblDeporte.setBackground(new Color(255,153,0));
    	lblDeporte.setOpaque(true);
		this.add(lblDeporte);
		
		
		lblOlimpiadas = new JLabel("Olimpiadas");
		lblOlimpiadas.setForeground(Color.WHITE);
		lblOlimpiadas.setFont(new Font("Dialog", Font.BOLD, 16));
    	lblOlimpiadas.setBackground(new Color(255,153,0));
    	lblOlimpiadas.setOpaque(true);
		this.add(lblOlimpiadas);
		
		lblEquipos = new JLabel("Equipos");
		lblEquipos.setForeground(Color.WHITE);
		lblEquipos.setFont(new Font("Dialog", Font.BOLD, 16));
    	lblEquipos.setBackground(new Color(255,153,0));
    	lblEquipos.setOpaque(true);
		this.add(lblEquipos);
		
		btnAyuda = new JButton("Ayuda");
		btnAyuda.setForeground(Color.WHITE);
    	btnAyuda.setBackground(new Color(255,153,0));
		btnAyuda.setFont(new Font("Dialog", Font.BOLD, 16));
		this.add(btnAyuda);
		btnAyuda.setFocusable(false);
		btnAyuda.setHorizontalAlignment(SwingConstants.LEFT);
		
		
		lblDeporte.setBorder(new EmptyBorder(0,10,0,0));
		lblEquipos.setBorder(new EmptyBorder(0,10,0,0));
		lblOlimpiadas.setBorder(new EmptyBorder(0,10,0,0));
		lblEvento.setBorder(new EmptyBorder(0,10,0,0));
		lblParticipacion.setBorder(new EmptyBorder(0,10,0,0));
		lblInicio.setBorder(new EmptyBorder(0,10,0,0));
		lblDeportista.setBorder(new EmptyBorder(0,10,0,0));
		btnAyuda.setBorder(new EmptyBorder(0,10,0,0));

		lblDeporte.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
            	lblDeporte.setBackground(new Color(255,105,0));
            }
        });

		lblDeporte.addMouseListener(new MouseAdapter() {
            public void mouseExited(MouseEvent evt) {
            	lblDeporte.setBackground(new Color(255,153,0));
            }
        });
		
		lblEquipos.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
            	lblEquipos.setBackground(new Color(255,105,0));
            }
        });

		lblEquipos.addMouseListener(new MouseAdapter() {
            public void mouseExited(MouseEvent evt) {
            	lblEquipos.setBackground(new Color(255,153,0));
            }
        });
		
		lblOlimpiadas.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
            	lblOlimpiadas.setBackground(new Color(255,105,0));
            }
        });

		lblOlimpiadas.addMouseListener(new MouseAdapter() {
            public void mouseExited(MouseEvent evt) {
            	lblOlimpiadas.setBackground(new Color(255,153,0));
            }
        });
		
		lblEvento.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
            	lblEvento.setBackground(new Color(255,105,0));
            }
        });

		lblEvento.addMouseListener(new MouseAdapter() {
            public void mouseExited(MouseEvent evt) {
            	lblEvento.setBackground(new Color(255,153,0));
            }
        });
		
		lblParticipacion.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
            	lblParticipacion.setBackground(new Color(255,105,0));
            }
        });

		lblParticipacion.addMouseListener(new MouseAdapter() {
            public void mouseExited(MouseEvent evt) {
            	lblParticipacion.setBackground(new Color(255,153,0));
            }
        });
		
		lblInicio.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
            	lblInicio.setBackground(new Color(255,105,0));
            }
        });

		lblInicio.addMouseListener(new MouseAdapter() {
            public void mouseExited(MouseEvent evt) {
            	lblInicio.setBackground(new Color(255,153,0));
            }
        });
		
		lblDeportista.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
            	lblDeportista.setBackground(new Color(255,105,0));
            }
        });

		lblDeportista.addMouseListener(new MouseAdapter() {
            public void mouseExited(MouseEvent evt) {
            	lblDeportista.setBackground(new Color(255,153,0));
            }
        });
		
		btnAyuda.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
            	btnAyuda.setBackground(new Color(255,105,0));
            }
        });

		btnAyuda.addMouseListener(new MouseAdapter() {
            public void mouseExited(MouseEvent evt) {
            	btnAyuda.setBackground(new Color(255,153,0));
            }
        });
		
		if (frame == "principal") {
			lblOlimpiadas.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	            	try {
	            		controladorVistas.cerrarVentanaPrincipal();
						controladorVistas.abrirVentanaOlimpiada();
					} catch (SQLException e1) {
						e1.printStackTrace();
					} catch (HelpSetException e1) {
						// TODO Auto-generated catch block
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
					} catch (HelpSetException e1) {
						// TODO Auto-generated catch block
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
					} catch (HelpSetException e1) {
						// TODO Auto-generated catch block
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
					} catch (HelpSetException e1) {
						// TODO Auto-generated catch block
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
					} catch (HelpSetException e1) {
						// TODO Auto-generated catch block
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
					} catch (HelpSetException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	            }

	        });
			
		} else if (frame == "olimpiada") {
			lblInicio.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	            	controladorVistas.cerrarVentanaOlimpiada();
					try {
						controladorVistas.abrirVentanaPrincipal();
					} catch (HelpSetException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	            }
	        });
			
			lblOlimpiadas.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	            	try {
	            		controladorVistas.cerrarVentanaOlimpiada();
						controladorVistas.abrirVentanaOlimpiada();
					} catch (SQLException e1) {
						e1.printStackTrace();
					} catch (HelpSetException e1) {
						// TODO Auto-generated catch block
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
					} catch (HelpSetException e1) {
						// TODO Auto-generated catch block
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
					} catch (HelpSetException e1) {
						// TODO Auto-generated catch block
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
					} catch (HelpSetException e1) {
						// TODO Auto-generated catch block
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
					} catch (HelpSetException e1) {
						// TODO Auto-generated catch block
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
					} catch (HelpSetException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	            }

	        });
			
		} else if (frame == "equipos") {
			lblInicio.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
            		controladorVistas.cerrarVentanaEquipos();
					try {
						controladorVistas.abrirVentanaPrincipal();
					} catch (HelpSetException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	            }
	        });
			
			lblOlimpiadas.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	            	try {
	            		controladorVistas.cerrarVentanaEquipos();
						controladorVistas.abrirVentanaOlimpiada();
					} catch (SQLException e1) {
						e1.printStackTrace();
					} catch (HelpSetException e1) {
						// TODO Auto-generated catch block
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
					} catch (HelpSetException e1) {
						// TODO Auto-generated catch block
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
					} catch (HelpSetException e1) {
						// TODO Auto-generated catch block
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
					} catch (HelpSetException e1) {
						// TODO Auto-generated catch block
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
					} catch (HelpSetException e1) {
						// TODO Auto-generated catch block
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
					} catch (HelpSetException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	            }

	        });
			
		} else if (frame == "deportes") {
			lblInicio.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
            		controladorVistas.cerrarVentanaDeportes();
					try {
						controladorVistas.abrirVentanaPrincipal();
					} catch (HelpSetException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	            }
	        });
			
			lblOlimpiadas.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	            	try {
	            		controladorVistas.cerrarVentanaDeportes();
						controladorVistas.abrirVentanaOlimpiada();
					} catch (SQLException e1) {
						e1.printStackTrace();
					} catch (HelpSetException e1) {
						// TODO Auto-generated catch block
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
					} catch (HelpSetException e1) {
						// TODO Auto-generated catch block
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
					} catch (HelpSetException e1) {
						// TODO Auto-generated catch block
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
					} catch (HelpSetException e1) {
						// TODO Auto-generated catch block
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
					} catch (HelpSetException e1) {
						// TODO Auto-generated catch block
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
					} catch (HelpSetException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	            }

	        });
			
		} else if(frame == "participacion") {
			lblInicio.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
            		controladorVistas.cerrarVentanaParticipacion();
					try {
						controladorVistas.abrirVentanaPrincipal();
					} catch (HelpSetException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	            }
	        });
			
			lblOlimpiadas.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	            	try {
	            		controladorVistas.cerrarVentanaParticipacion();
						controladorVistas.abrirVentanaOlimpiada();
					} catch (SQLException e1) {
						e1.printStackTrace();
					} catch (HelpSetException e1) {
						// TODO Auto-generated catch block
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
					} catch (HelpSetException e1) {
						// TODO Auto-generated catch block
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
					} catch (HelpSetException e1) {
						// TODO Auto-generated catch block
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
					} catch (HelpSetException e1) {
						// TODO Auto-generated catch block
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
					} catch (HelpSetException e1) {
						// TODO Auto-generated catch block
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
					} catch (HelpSetException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	            }

	        });
			
		} else if(frame == "deportista") {
			lblInicio.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
            		controladorVistas.cerrarVentanaDeportista();
					try {
						controladorVistas.abrirVentanaPrincipal();
					} catch (HelpSetException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	            }
	        });
			
			lblOlimpiadas.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	            	try {
	            		controladorVistas.cerrarVentanaDeportista();
						controladorVistas.abrirVentanaOlimpiada();
					} catch (SQLException e1) {
						e1.printStackTrace();
					} catch (HelpSetException e1) {
						// TODO Auto-generated catch block
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
					} catch (HelpSetException e1) {
						// TODO Auto-generated catch block
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
					} catch (HelpSetException e1) {
						// TODO Auto-generated catch block
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
					} catch (HelpSetException e1) {
						// TODO Auto-generated catch block
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
					} catch (HelpSetException e1) {
						// TODO Auto-generated catch block
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
					} catch (HelpSetException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	            }

	        });
			
		} else if (frame == "evento") {
			lblInicio.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
            		controladorVistas.cerrarVentanaEvento();
					try {
						controladorVistas.abrirVentanaPrincipal();
					} catch (HelpSetException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	            }
	        });
			
			lblOlimpiadas.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	            	try {
	            		controladorVistas.cerrarVentanaEvento();
						controladorVistas.abrirVentanaOlimpiada();
					} catch (SQLException | HelpSetException e1) {
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
					} catch (HelpSetException e1) {
						// TODO Auto-generated catch block
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
					} catch (HelpSetException e1) {
						// TODO Auto-generated catch block
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
					} catch (HelpSetException e1) {
						// TODO Auto-generated catch block
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
					} catch (HelpSetException e1) {
						// TODO Auto-generated catch block
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
					} catch (HelpSetException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	            }

	        });
		}
		ponerAyuda(frame);
	}
	
	/**
	 * 	Ponemos la ayuda a esta pantalla pulsando en F1
	 * @param frame 
	 * 
	 * @throws HelpSetException
	 */
	private void ponerAyuda(String frame) throws HelpSetException {
		try 
		{
			File fichero = new File("Help"+File.separator+"help_set.hs");
			URL hsURL = fichero.toURI().toURL();
			
			HelpSet helpset = new HelpSet(getClass().getClassLoader(),hsURL);
			HelpBroker hb = helpset.createHelpBroker();
			
			hb.enableHelpOnButton(btnAyuda,frame, helpset);
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
