package ComponentesPersonalizados;

import javax.swing.table.AbstractTableModel;

import java.sql.SQLException;
import java.util.ArrayList;
import UML.*;


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
				"Deportista", 
	            "Equipo",	 
	            "Evento", 
	            "Medalla",
	            "Edad"
	            };
    		
    		datos = new Object[participaciones.size()][];
    		
    		for (ParticipacionTabla p : participaciones) {
    			datos [cont]= new Object[]{p.getNombreDeportista(),p.getNombreEquipo(),p.getNombreEvento(),p.getMedalla(),p.getEdad()};
    			
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
	            "Olimpiada", 
	            "Deporte"
	            };
    		
    		datos = new Object[eventos.size()][];
    		
    		for (Evento e : eventos) {
    			
    			for (Deporte d: deportes) {
    				
    				for (Olimpiada o : olimpiadas) {
    					
    					if (e.getId_olimpiada() == o.getId_olimpiada() && e.getId_deporte() == d.getId_deporte()) {
        	    			datos [cont]= new Object[]{e.getId_evento(),e.getNombre(),o.getNombre(),d.getNombre()};
        	    			cont++;
    					}
                		
    				}
    				
    			}
    			
    		}
    		fireTableDataChanged();
    	}
    	
    	fireTableDataChanged();
    }
	
	public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return datos.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        return datos[row][col];
    }

}
