package BD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import UML.Olimpiada;
import UML.OlimpiadaTabla;

public class OlimpiadaBD {
	private ResultSet resultado;
	private PreparedStatement ps;
    private String plantilla;
    private ArrayList<OlimpiadaTabla> listaOlimpiadasTablas;
    private ArrayList<Olimpiada> listaOlimpiadas;
    private ArrayList<String> ciudades;
    
    /**
     * Metodo para recoger los datos y crear el objeto OlimpiadaTabla.
     * 
     * @return
     * @throws SQLException
     */
    public OlimpiadaTabla crearObjetoTabla() throws SQLException 
    {
        OlimpiadaTabla o = new OlimpiadaTabla();
        o.setId_olimpiada(resultado.getInt("id_olimpiada"));
        o.setNombre(resultado.getString("nombre"));
        o.setAnio(resultado.getInt("anio"));
        o.setCiudad(resultado.getString("ciudad"));
        o.setNombreDeporte(resultado.getString("nombreDeporte"));
        o.setNombreEvento(resultado.getString("nombreEvento"));
        return o;
    }
    
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
     * Metodo para recoger los datos y crear el objeto Olimpiada.
     * 
     * @return
     * @throws SQLException
     */
    public Olimpiada crearObjetoOlimpiadaCiudad() throws SQLException 
    {
        Olimpiada o = new Olimpiada();
        o.setCiudad(resultado.getString("ciudad"));
        return o;
    }
    
    /**
     * Metodo para hacer la consulta de los olimpiadas para añadirlos a un array de olimpiadas y devolverlo.
     * 
     * @return
     * @throws SQLException
     */
    public ArrayList<OlimpiadaTabla> consultarTodasOlimpiadas() throws SQLException {
    	listaOlimpiadasTablas = new ArrayList();
        Bdr.Conectar();
        plantilla = "SELECT Olimpiada.id_olimpiada,Olimpiada.nombre, Olimpiada.anio, Olimpiada.ciudad, Deporte.nombre as nombreDeporte,Evento.nombre as nombreEvento\n"
        		+ "FROM Evento, Olimpiada, Deporte\n"
        		+ "WHERE Evento.id_olimpiada = Olimpiada.id_olimpiada AND Evento.id_deporte = Deporte.id_deporte;";
        ps = Bdr.getCon().prepareStatement(plantilla);
        resultado = ps.executeQuery();
        
        while (resultado.next()) {
        	listaOlimpiadasTablas.add(crearObjetoTabla());
        }
        
        Bdr.cerrarCon();
        return listaOlimpiadasTablas;
	}

    /**
     * Metodo para insertar una nueva olimpiada
     * 
     * @param anio
     * @param temporada
     * @param nombre
     * @throws SQLException
     */
	public void altaOlimpiada(int anio, String nombre, String ciudad) throws SQLException {
		Bdr.Conectar();
        plantilla = "INSERT INTO Olimpiada(anio,nombre,ciudad) VALUES(?,?,?)";
        ps = Bdr.getCon().prepareStatement(plantilla);
        ps.setInt(1, anio);
        ps.setString(2, nombre);
        ps.setString(3, ciudad);
        
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
        listaOlimpiadas = new ArrayList();
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

	/**
	 * Sacamos todas las ciudades que hay en la base de datos
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Olimpiada> consultarCiudades() throws SQLException {
		Bdr.Conectar();
        listaOlimpiadas = new ArrayList();
        plantilla = "SELECT distinct(ciudad) from Olimpiada";
        ps = Bdr.getCon().prepareStatement(plantilla);
        resultado = ps.executeQuery();
        
        while (resultado.next()) {
            listaOlimpiadas.add(crearObjetoOlimpiadaCiudad());
        }
        
        Bdr.cerrarCon();
        return listaOlimpiadas;
	}

	/**
	 * Sacamos todas las olimpiadas con los filtros que nos han pasado
	 * @param año
	 * @param ciudad
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<OlimpiadaTabla> consultarOlimpiadasFiltros(int año, String ciudad) throws SQLException {
		Bdr.Conectar();
		listaOlimpiadasTablas = new ArrayList();
        Bdr.Conectar();
        plantilla = "SELECT Olimpiada.id_olimpiada,Olimpiada.nombre, Olimpiada.anio, Olimpiada.ciudad, Deporte.nombre as nombreDeporte,Evento.nombre as nombreEvento\n"
        		+ "FROM Evento, Olimpiada, Deporte\n"
        		+ "WHERE Evento.id_olimpiada = Olimpiada.id_olimpiada AND Evento.id_deporte = Deporte.id_deporte AND anio = ? AND ciudad = ?;";
        ps = Bdr.getCon().prepareStatement(plantilla);
        ps.setInt(1, año);
        ps.setString(2, ciudad);
        resultado = ps.executeQuery();
        
        while (resultado.next()) {
        	listaOlimpiadasTablas.add(crearObjetoTabla());
        }
        
        Bdr.cerrarCon();
        return listaOlimpiadasTablas;
	}
}
