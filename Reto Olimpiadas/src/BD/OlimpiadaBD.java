package BD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import UML.Equipo;
import UML.Olimpiada;

public class OlimpiadaBD {
	private ResultSet resultado;
	private PreparedStatement ps;
    private String plantilla;
    private ArrayList<Olimpiada> listaOlimpiadas;
    
    /**
     * Metodo para recoger los datos y crear el objeto Olimpiada.
     * 
     * @return
     * @throws SQLException
     */
    public Olimpiada crearObjeto() throws SQLException 
    {
        Olimpiada o = new Olimpiada();
        o.setId_olimpiada(resultado.getInt("id_olimpiada"));
        o.setNombre(resultado.getString("nombre"));
        o.setAnio(resultado.getInt("anio"));
        o.setTemporada(resultado.getString("temporada"));
        o.setCiudad(resultado.getString("ciudad"));
        return o;
    }
    
    /**
     * Metodo para hacer la consulta de los olimpiadas para añadirlos a un array de olimpiadas y devolverlo.
     * 
     * @return
     * @throws SQLException
     */
    public ArrayList<Olimpiada> consultarTodasOlimpiadas() throws SQLException {
    	listaOlimpiadas = new ArrayList();
        Bdr.Conectar();
        plantilla = "SELECT * FROM Olimpiada";
        ps = Bdr.getCon().prepareStatement(plantilla);
        resultado = ps.executeQuery();
        
        while (resultado.next()) {
        	listaOlimpiadas.add(crearObjeto());
        }
        
        Bdr.cerrarCon();
        return listaOlimpiadas;
	}

    /**
     * Metodo para insertar una nueva olimpiada
     * 
     * @param anio
     * @param temporada
     * @param nombre
     * @param ciudad
     * @throws SQLException
     */
	public void altaOlimpiada(int anio, String temporada, String nombre, String ciudad) throws SQLException {
		Bdr.Conectar();
        plantilla = "INSERT INTO Olimpiada(anio,temporada,nombre,ciudad) VALUES(?,?,?,?)";
        ps = Bdr.getCon().prepareStatement(plantilla);
        ps.setInt(1, anio);
        ps.setString(2, temporada);
        ps.setString(3, nombre);
        ps.setString(4, ciudad);
        
        ps.executeUpdate();
        Bdr.cerrarCon();
		
	}

	/**
	 * Metodo para modificar una olimpiada ya existente
	 * 
	 * @param idOlimpiada
	 * @param nombre
	 * @param anio
	 * @param ciudad
	 * @param temporada
	 * @throws SQLException
	 */
	public void modificarOlimpiada(int idOlimpiada, String nombre, String anio, String ciudad, String temporada) throws SQLException {
		Bdr.Conectar();
        plantilla = "UPDATE Olimpiada SET nombre = ? ,año = ?,ciudad = ?,temporada = ? WHERE id_olimpiada = ?";
        ps = Bdr.getCon().prepareStatement(plantilla);
        ps.setString(1, nombre);
        ps.setString(2, anio);
        ps.setString(3, ciudad);
        ps.setString(4, temporada);
        ps.setInt(5, idOlimpiada);
        ps.executeUpdate();
        Bdr.cerrarCon();
	}
	
	/**
	 * Metodo para eliminar una olimpiada ya existente
	 * 
	 * @param idOlimpiada
	 * @throws SQLException
	 */
	public void eliminarOlimpiada(int idOlimpiada) throws SQLException {
		Bdr.Conectar();
        plantilla = "DELETE FROM  Olimpiada where id_olimpiada = ?";
        ps = Bdr.getCon().prepareStatement(plantilla);
        ps.setInt(1, idOlimpiada);
        ps.executeUpdate();
        Bdr.cerrarCon();
	}

	/**
	 * Metodo para comprobar si existe el nombre de la olimpiada que pasamos por parametros
	 * 
	 * @param nombre
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Olimpiada> comprobarNombreOlimpiada(String nombre) throws SQLException {
        Bdr.Conectar();
        plantilla = "SELECT * FROM Olimpiada WHERE nombre LIKE ?";
        ps = Bdr.getCon().prepareStatement(plantilla);
        ps.setString(1, nombre);
        resultado = ps.executeQuery();
        
        while (resultado.next()) {
            listaOlimpiadas.add(crearObjeto());
        }
        
        Bdr.cerrarCon();
        return listaOlimpiadas;
	}
}
