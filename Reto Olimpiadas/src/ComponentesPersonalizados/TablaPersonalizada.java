package ComponentesPersonalizados;

import javax.swing.table.AbstractTableModel;

import java.sql.SQLException;
import java.util.ArrayList;
import UML.*;
import Vistas.frmVentanaParticipacion;


public class TablaPersonalizada extends AbstractTableModel{
	private java.util.ArrayList<Deportista> deportistas;
	private ArrayList<Evento> eventos;
	private ArrayList<Equipo> equipos;
	private ArrayList<Olimpiada> olimpiadas;
	private ArrayList<ParticipacionTabla> participaciones;
	private ArrayList<Deporte> deportes;


	private Controlador controlador = new Controlador();
	
	private String[] columnNames;
	private Object [][]datos;

	/**
	 * Metodo que comprueba la tabla que tiene que pintar a traves del parametro que pasamos
	 * 
	 * @param frame
	 * @throws SQLException
	 */
	public TablaPersonalizada(String frame) throws SQLException
    {
    	if(frame == "deportistas") {
    		deportistas = controlador.consultarDeportistas();
    		
    		int cont = 0;
    		columnNames = new String[] {
    				"Id Deportista", 
    	            "Nombre",	 
    	            "Sexo", 
    	            "Altura",
    	            "Peso"
    	            };
    		datos = new Object[deportistas.size()][];
    		
    		for (Deportista d : deportistas) {
    			datos [cont]= new Object[]{d.getId_deportista(),d.getNombre(),d.getSexo(),d.getAltura(),d.getPeso()};
        		
        		cont++;
    		}
    		fireTableDataChanged();
    		
    	} else if(frame == "participacion") {
    		participaciones = controlador.consultarTablaParticpaciones();
    		
    		int cont = 0;
    		columnNames = new String[] {
    			"Id_Deportista",
				"Deportista", 
    			"Id_Equipo",
	            "Equipo",
    			"Id_Evento",
	            "Evento", 
	            "Medalla",
	            "Edad"
	            };
    		
    		datos = new Object[participaciones.size()][];
    		
    		for (ParticipacionTabla p : participaciones) {
    			datos [cont]= new Object[]{p.getId_deportista(),p.getNombreDeportista(),p.getId_Equipo(),p.getNombreEquipo(),p.getId_evento(),p.getNombreEvento(),p.getMedalla(),p.getEdad()};
    			
    			cont++;
    		}
    		
    		fireTableDataChanged();
    		
    		
    	} else if(frame == "olimpiadas") {
    		olimpiadas = controlador.consultarOlimpiadas();
    		
    		int cont = 0;
    		columnNames = new String[] {
				"Id Olimpiada", 
	            "Nombre",	 
	            "Temporada", 
	            "Año",
	            "Ciudad"
	            };
	            
    		datos = new Object[olimpiadas.size()][];
    		
    		for (Olimpiada o : olimpiadas) {
    			datos [cont]= new Object[]{o.getId_olimpiada(),o.getNombre(),o.getTemporada(),o.getAnio(),o.getCiudad()};
        		
        		cont++;
    		}
    		
    		fireTableDataChanged();
    		
    	} else if(frame == "eventos") {
    		eventos = controlador.consultarEventos();
    		deportes = controlador.consultarDeportes();
    		olimpiadas = controlador.consultarOlimpiadas();
    		
    		int cont = 0;
    		
    		columnNames = new String[] {
				"Id_evento", 
	            "Nombre",
	            "Id_olimpiada",
	            "Olimpiada", 
	            "Id_deporte",
	            "Deporte"
	            };
    		
    		datos = new Object[eventos.size()][];
    		
    		for (Evento e : eventos) {
    			
    			for (Deporte d: deportes) {
    				
    				for (Olimpiada o : olimpiadas) {
    					
    					if (e.getId_olimpiada() == o.getId_olimpiada() && e.getId_deporte() == d.getId_deporte()) {
        	    			datos [cont]= new Object[]{e.getId_evento(),e.getNombre(),o.getId_olimpiada(),o.getNombre(),d.getId_deporte(),d.getNombre()};
        	    			cont++;
    					}
                		
    				}
    				
    			}
    			
    		}
    		
    		fireTableDataChanged();
    		
    	} else if(frame == "equipos") {
    		 equipos = controlador.consultarEquipos();
    		
    		int cont = 0;
    		columnNames = new String[] {
				"Id_Equipo", 
	            "Iniciales",	 
	            "Nombre"
	            };
	            
    		datos = new Object[equipos.size()][];
    		
    		for (Equipo e : equipos) {
    			datos [cont]= new Object[]{e.getId_equipo(),e.getIniciales(),e.getNombre()};
        		
        		cont++;
    		}
    		
    		fireTableDataChanged();
    		
    	} else if(frame == "deporte") {
    		deportes = controlador.consultarDeportes();
 		
   		int cont = 0;
   		columnNames = new String[] {
				"Id_Deporte", 
	            "Nombre"
	            };
	            
   		datos = new Object[deportes.size()][];
   		
   		for (Deporte d : deportes) {
   			datos [cont]= new Object[]{d.getId_deporte(),d.getNombre()};
       		
       		cont++;
   		}
   		
   		fireTableDataChanged();
   		
   	}
    	
    	fireTableDataChanged();
    }
	
	/**
	 * Metodo que devuelve el numero de columnas de una tabla
	 */
	public int getColumnCount() {
        return columnNames.length;
    }

	/**
	 * Metodo que devuelve el numero de filas que tiene la tabla
	 */
    public int getRowCount() {
        return datos.length;
    }

    /**
     * Metodo que devuelve el nombre de la columna
     */
    public String getColumnName(int col) {
        return columnNames[col];
    }

    /**
     * Metodo que devuelve el valor de la fila y columna seleccionada
     */
    public Object getValueAt(int row, int col) {
        return datos[row][col];
    }

}
