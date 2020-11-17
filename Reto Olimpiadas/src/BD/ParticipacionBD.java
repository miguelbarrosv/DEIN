package BD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import UML.Olimpiada;
import UML.Participacion;
import UML.ParticipacionTabla;

public class ParticipacionBD {
	private ResultSet resultado;
	private PreparedStatement ps;
    private String plantilla;
    private ArrayList<ParticipacionTabla> listaParticipaciones;
    
    /**
     * Metodo para recoger los datos y crear el objeto Participacion.
     * 
     * @return
     * @throws SQLException
     */
    public ParticipacionTabla crearObjeto() throws SQLException 
    {
    	ParticipacionTabla p = new ParticipacionTabla();
        p.setId_Deportista(resultado.getInt("ID_DEPORTISTA"));
        p.setId_equipo(resultado.getInt("ID_EQUIPO"));
        p.setId_evento(resultado.getInt("ID_EVENTO"));
        p.setMedalla(resultado.getString("MEDALLA"));
        p.setEdad(resultado.getInt("EDAD"));
        p.setNombreDeportista(resultado.getString("DEPORTISTA"));
        p.setNombreEquipo(resultado.getString("EQUIPO"));
        p.setNombreEvento(resultado.getString("EVENTO"));
        return p;
    }
    
    /**
     * Metodo para hacer la consulta de las participaciones para añadirlos a un array de participaciones y devolverlo.
     * 
     * @return
     * @throws SQLException
     */
    public ArrayList<ParticipacionTabla> consultarTablaParticpaciones() throws SQLException {
    	listaParticipaciones = new ArrayList();
        Bdr.Conectar();
        plantilla = "SELECT p.edad as EDAD, p.medalla as MEDALLA, Deportista.id_deportista AS ID_DEPORTISTA, Deportista.nombre as DEPORTISTA, Evento.id_evento as ID_EVENTO,Evento.nombre as EVENTO, Equipo.id_equipo as ID_EQUIPO, Equipo.nombre as EQUIPO\n"
        		+ "from Participacion p, Equipo, Evento, Deportista\n"
        		+ "where p.id_equipo = Equipo.id_equipo and p.id_deportista = Deportista.id_deportista and p.id_evento = Evento.id_evento";
        
        ps = Bdr.getCon().prepareStatement(plantilla);
        resultado = ps.executeQuery();
        
        while (resultado.next()) {
        	listaParticipaciones.add(crearObjeto());
        }
        
        Bdr.cerrarCon();
        return listaParticipaciones;
	}
    
    /**
     * Metodo para insertar una nueva Participacion
     * 
     * @param idEvento
     * @param idDeportista
     * @param idEquipo
     * @param edad
     * @param medalla
     * @throws SQLException
     */
	public void altaParticipacion(int idEvento, int idDeportista, int idEquipo, int edad, String medalla) throws SQLException {
		Bdr.Conectar();
        plantilla = "INSERT INTO Participacion(id_evento ,id_deportista ,id_equipo ,medalla ,edad) VALUES(?,?,?,?,?)";
        ps = Bdr.getCon().prepareStatement(plantilla);
        ps.setInt(1,idEvento);
        ps.setInt(2, idDeportista);
        ps.setInt(3, idEquipo);
        ps.setString(4, medalla);
        ps.setInt(5, edad);
        ps.executeUpdate();
        Bdr.cerrarCon();
		
	}

	/**
	 * Metodo para modificar una participacion ya existente
	 * 
	 * @param id_evento
	 * @param id_deportista
	 * @param id_equipo
	 * @param medalla
	 * @param edad
	 * @throws SQLException
	 */
	public void modificarParticipacion(int id_evento, int id_deportista, int id_equipo, String medalla,int edad) throws SQLException {
		Bdr.Conectar();
        plantilla = "UPDATE Participacion SET id_evento = ? ,id_deportista = ?,id_equipo = ?,medalla = ?,edad = ? WHERE id_evento = ? AND id_deportista = ?";
        ps = Bdr.getCon().prepareStatement(plantilla);
        ps.setInt(1, id_evento);
        ps.setInt(2, id_deportista);
        ps.setInt(3, id_equipo);
        ps.setString(4, medalla);
        ps.setInt(5, edad);
        ps.setInt(6, id_evento);
        ps.setInt(7, id_deportista);
        
        ps.executeUpdate();
        Bdr.cerrarCon();
	}

	/**
	 * Metodo para eliminar una participacion ya existente
	 * 
	 * @param idEvento
	 * @param idDeportista
	 * @throws SQLException
	 */
	public void eliminarParticipacion(int idEvento, int idDeportista) throws SQLException {
		// TODO Auto-generated method stub
		Bdr.Conectar();
		plantilla = "DELETE FROM Participacion where id_deportista = ? AND id_evento = ?";
		ps = Bdr.getCon().prepareStatement(plantilla);
		ps.setInt(1, idDeportista);
		ps.setInt(2, idEvento);
		ps.executeUpdate();
		Bdr.cerrarCon();
	}
}
