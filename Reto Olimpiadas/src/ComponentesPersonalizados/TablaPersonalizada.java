package ComponentesPersonalizados;

import javax.swing.table.AbstractTableModel;

import LN.clsEventoDescriptivo;
import LP.ArrayList;
import LP.Object;
import LP.String;
import UML.*;


public class TablaPersonalizada extends AbstractTableModel{
	private java.util.ArrayList<Deportista> deportistas;
	private ArrayList<Evento> eventos;
	private ArrayList<Equipo> equipos;
	private ArrayList<Olimpiada> olimpiadas;
	private ArrayList<Participacion> participaciones;

	private Controlador controlador = new Controlador();
	
	private String[] columnNames;
	private Object [][]datos;

	public TablaPersonalizada(String frame)
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
    		
    	} else if(frame == "eventos") {
    		eventos = controlador.consultarEventos();

    		int cont = 0;
    		columnNames = new String[] {
				"Id Evento", 
	            "Nombre"
	            };
	            
    		datos = new Object[deportistas.size()][];
    		
    		for (Evento e : eventos) {
    			datos [cont]= new Object[]{e.getId_evento(),e.getNombre()};
        		
        		cont++;
    		}
    		fireTableDataChanged();
    		
    	} else if(frame == "participacion") {
    		participaciones = controlador.consultarParticipaciones();
    		deportistas = controlador.consultarDeportistas();
    		equipos = controlador.consultarEquipos();
    		
    		int cont = 0;
    		
    		columnNames = new String[] {
				"Deportista", 
	            "Equipo",	 
	            "Evento", 
	            "Medalla",
	            "Edad"
	            };
    		
    		datos = new Object[participaciones.size()][];
    		
    		for (Participacion p : participaciones) {
    			
    			for (Deportista d: deportistas) {
    				
    				for (Equipo e : equipos) {
    					
    					datos [cont]= new Object[]{};
                		
                		cont++;
    				}
    				
    			}
    			
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
	            
    		datos = new Object[deportistas.size()][];
    		
    		for (Olimpiada o : olimpiadas) {
    			datos [cont]= new Object[]{o.getId_olimpiada(),o.getNombre(),o.getTemporada(),o.getAnio(),o.getCiudad()};
        		
        		cont++;
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
