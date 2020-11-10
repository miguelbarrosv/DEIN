package BD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import UML.Deportista;
import UML.Evento;

public class EventoBD {

	private ResultSet resultado;
    private PreparedStatement ps;
    private String plantilla;
    private ArrayList<Evento> listaEventos;
	
	public Evento crearObjeto() throws SQLException 
    {
		Evento e = new Evento();
        e.setId_evento(resultado.getInt("id_evento"));
        e.setNombre(resultado.getString("nombre"));
        e.setId_olimpiada(resultado.getInt("id_olimpiada"));
        e.setId_deporte(resultado.getInt("id_deporte"));
        
        return e;
    }

	public ArrayList<Evento> consultarTodosEventos() throws SQLException {
		listaEventos = new ArrayList();
        Bdr.Conectar();
        plantilla = "SELECT * FROM Evento";
        ps = Bdr.getCon().prepareStatement(plantilla);
        resultado = ps.executeQuery();
        
        while (resultado.next()) {
        	listaEventos.add(crearObjeto());
        }
        
        Bdr.cerrarCon();
       
        return listaEventos;
	}

	public void altaEvento(int id_evento, String nombre, int id_olimpiada, int id_deporte) throws SQLException {
		Bdr.Conectar();
        plantilla = "INSERT INTO Evento(id_evento,nombre,id_olimpiada,id_deporte) VALUES(?,?,?,?)";
        ps = Bdr.getCon().prepareStatement(plantilla);
        ps.setInt(1, id_evento);
        ps.setString(2, nombre);
        ps.setInt(3, id_olimpiada);
        ps.setInt(4, id_deporte);
        ps.executeUpdate();
        Bdr.cerrarCon();
	}

	public void modificarEvento(int idEvento, String nombreEvento, int idOlimpiada, int idDeporte) throws SQLException {
		Bdr.Conectar();
        plantilla = "UPDATE Evento SET nombre = ? ,id_olimpiada = ?,id_deporte = ? WHERE id_evento = ?";
        ps = Bdr.getCon().prepareStatement(plantilla);
        ps.setString(1, nombreEvento);
        ps.setInt(2, idOlimpiada);
        ps.setInt(3, idDeporte);
        ps.setInt(4, idEvento);
        ps.executeUpdate();
        Bdr.cerrarCon();
	}

	public void eliminarEvento(int idEvento) throws SQLException {
		Bdr.Conectar();
		plantilla = "DELETE FROM  Evento where id_evento = ?";
		ps = Bdr.getCon().prepareStatement(plantilla);
		ps.setInt(1, idEvento);
		ps.executeUpdate();
		Bdr.cerrarCon();
	}

}
