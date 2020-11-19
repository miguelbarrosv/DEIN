package ComponentePersonalizado;

import javax.swing.table.AbstractTableModel;

import java.sql.SQLException;
import java.util.ArrayList;
import UML.*;


public class TablaPersonalizada extends AbstractTableModel{
	private ArrayList<OlimpiadaTabla> olimpiadasTabla;


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
    	if(frame == "olimpiadas") {
    		olimpiadasTabla = controlador.consultarOlimpiadas();
    		
    		int cont = 0;
    		columnNames = new String[] {
	            "Nombre",	 
	            "Año",
	            "Ciudad",
	            "Nombre Deporte",
	            "Nombre Evento"
	            };
	            
    		datos = new Object[olimpiadasTabla.size()][];
    		
    		for (OlimpiadaTabla o : olimpiadasTabla) {
    			datos [cont]= new Object[]{o.getNombre(),o.getAnio(),o.getCiudad(),o.getNombreDeporte(),o.getNombreEvento()};
        		
        		cont++;
    		}
    		
    		fireTableDataChanged();
    		
    	} 
    	
    	fireTableDataChanged();
    }
	
	public TablaPersonalizada() {
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

	public  void refrescarTabla(ArrayList<OlimpiadaTabla> olimpiadasTabla) {		
		int cont = 0;
		columnNames = new String[] {
            "Nombre",	 
            "Año",
            "Ciudad",
            "Nombre Deporte",
            "Nombre Evento"
            };
            
		datos = new Object[olimpiadasTabla.size()][];
		
		for (OlimpiadaTabla o : olimpiadasTabla) {
			datos [cont]= new Object[]{o.getNombre(),o.getAnio(),o.getCiudad(),o.getNombreDeporte(),o.getNombreEvento()};
    		
    		cont++;
		}
		
		fireTableDataChanged();
	}

}
