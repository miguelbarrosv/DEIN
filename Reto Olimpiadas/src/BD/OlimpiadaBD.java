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
}
