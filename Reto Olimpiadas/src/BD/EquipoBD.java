package BD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import UML.Deportista;
import UML.Equipo;

public class EquipoBD {
	private ResultSet resultado;
    private PreparedStatement ps;
    private String plantilla;
    private ArrayList<Equipo> listaEquipos;
    
    public Equipo crearObjeto() throws SQLException 
    {
        Equipo e = new Equipo();
        e.setId_equipo(resultado.getInt("id_equipo"));
        e.setNombre(resultado.getString("nombre"));
        e.setIniciales(resultado.getString("iniciales"));
        
        return e;
    }
    
    public ArrayList<Equipo> consultarTodosEquipos() throws SQLException {
		listaEquipos = new ArrayList();
        Bdr.Conectar();
        plantilla = "SELECT * FROM Equipo";
        ps = Bdr.getCon().prepareStatement(plantilla);
        resultado = ps.executeQuery();
        
        while (resultado.next()) {
        	listaEquipos.add(crearObjeto());
        }
        
        Bdr.cerrarCon();
        
        return listaEquipos;
	}

	public void altaEquipo(String nombre, String iniciales) throws SQLException {
		Bdr.Conectar();
        plantilla = "INSERT INTO Equipo(nombre,iniciales) VALUES(?,?)";
        ps = Bdr.getCon().prepareStatement(plantilla);
        ps.setString(1, nombre);
        ps.setString(2, iniciales);
        
        ps.executeUpdate();
        Bdr.cerrarCon();
	}

	public void eliminarEquipo(int idEquipo) throws SQLException {
		Bdr.Conectar();
		plantilla = "DELETE FROM  Equipo where id_equipo = ?";
		ps = Bdr.getCon().prepareStatement(plantilla);
		ps.setInt(1, idEquipo);
		ps.executeUpdate();
		Bdr.cerrarCon();
	}

	public void modificarEquipo(int idEquipo, String iniciales, String nombre) throws SQLException {
		Bdr.Conectar();
        plantilla = "UPDATE Equipo SET nombre = ? ,iniciales = ? WHERE id-equipo = ?";
        ps = Bdr.getCon().prepareStatement(plantilla);
        ps.setString(1, nombre);
        ps.setString(2, iniciales);
        ps.setInt(3, idEquipo);
        ps.executeUpdate();
        Bdr.cerrarCon();
	}
}
