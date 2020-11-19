package UML;

import java.sql.SQLException;
import java.util.ArrayList;

import BD.OlimpiadaBD;
import Excepciones.RepetidoException;

public class Controlador {
	public OlimpiadaBD olimpiadaBD = new OlimpiadaBD();
	public ArrayList<OlimpiadaTabla> olimpiadasTabla;
	public ArrayList<Olimpiada> olimpiadas;
	public ArrayList<String> ciudades;
	
	/**
	 * Consultamos todas las olimpiadas para insertar los datos en la tabla
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<OlimpiadaTabla> consultarOlimpiadas() throws SQLException {
		olimpiadasTabla = olimpiadaBD.consultarTodasOlimpiadas();
		return olimpiadasTabla;
	}

	/**
	 * Metodo para insertar una nueva olimpiada
	 * @param anio
	 * @param nombre
	 * @param ciudad
	 * @throws SQLException
	 * @throws RepetidoException
	 */
	public void altaOlimpiada(int anio, String nombre, String ciudad) throws SQLException, RepetidoException {
		if(comprobarOlimpiada(nombre)) {
			olimpiadaBD.altaOlimpiada(anio,nombre,ciudad);
		} else {
			throw new RepetidoException("La olimpiada " + nombre + " ya existe");
		}
	}
	
	/**
	 * Metodo que llama a la base de datos para comprobar que la olimpiada que nos han pasado existe, si existe se le devolvera false, si no existe se le devolvera true
	 * 
	 * @param nombre
	 * @return
	 * @throws SQLException
	 */
	public boolean comprobarOlimpiada(String nombre) throws SQLException {
		Boolean comprobacion = false;
		olimpiadas = olimpiadaBD.comprobarNombreOlimpiada(nombre);
		
		if (olimpiadas == null || olimpiadas.size() == 0) {
			comprobacion = true;
		}
		
		return comprobacion;
	}

	/**
	 * Metodo para sacar todas las ciudades disponibles e insertarlas en el combo box
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Olimpiada> consultarCiudades() throws SQLException {
		olimpiadas = olimpiadaBD.consultarCiudades();
		return olimpiadas;
	}

	/**
	 * Metodo para buscar todas las olimpiadas con los filtros que nos han pasado para despues refrescar la tabla
	 * @param año
	 * @param ciudad
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<OlimpiadaTabla> buscarOlimpiadasFiltros(int año, String ciudad) throws SQLException {
		olimpiadasTabla = olimpiadaBD.consultarOlimpiadasFiltros(año,ciudad);
		return olimpiadasTabla;
	}
}
