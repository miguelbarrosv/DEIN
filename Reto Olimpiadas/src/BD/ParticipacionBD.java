package BD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import UML.Olimpiada;
import UML.Participacion;

public class ParticipacionBD {
	private ResultSet resultado;
	private PreparedStatement ps;
    private String plantilla;
    private ArrayList<Participacion> listaParticipaciones;
    
    public Participacion crearObjeto() throws SQLException 
    {
    	Participacion p = new Participacion();
        p.setId_deportista(resultado.getInt("id_deportista"));
        p.setId_equipo(resultado.getInt("id_equipo"));
        p.setId_evento(resultado.getInt("id_evento"));
        p.setMedalla(resultado.getString("medalla"));
        p.setEdad(resultado.getInt("edad"));
        return p;
    }
    
    public ArrayList<Participacion> consultarTodasParticpaciones() throws SQLException {
    	listaParticipaciones = new ArrayList();
        Bdr.Conectar();
        plantilla = "SELECT * FROM Participacion";
        ps = Bdr.getCon().prepareStatement(plantilla);
        resultado = ps.executeQuery();
        
        while (resultado.next()) {
        	listaParticipaciones.add(crearObjeto());
        }
        
        Bdr.cerrarCon();
        return listaParticipaciones;
	}

	public void altaParticipacion() throws SQLException {
		Bdr.Conectar();
        plantilla = "INSERT INTO Participacion(anio,temporada,nombre,ciudad) VALUES(?,?,?,?)";
        ps = Bdr.getCon().prepareStatement(plantilla);
        ps.executeUpdate();
        Bdr.cerrarCon();
		
	}
}
