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
    
    /**
     * Metodo para recoger los datos y crear el objeto equipo
     * 
     * @return
     * @throws SQLException
     */
    public Equipo crearObjeto() throws SQLException 
    {
        Equipo e = new Equipo();
        e.setId_equipo(resultado.getInt("id_equipo"));
        e.setNombre(resultado.getString("nombre"));
        e.setIniciales(resultado.getString("iniciales"));
        
        return e;
    }
    
    /**
     * Metodo para hacer la consulta de los equipos para añadirlos a un array de equipos y devolverlo
     * 
     * @return
     * @throws SQLException
     */
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

    /**
     * Metodo para insertar in nuevo equipo
     * 
     * @param nombre
     * @param iniciales
     * @throws SQLException
     */
	public void altaEquipo(String nombre, String iniciales) throws SQLException {
		Bdr.Conectar();
        plantilla = "INSERT INTO Equipo(nombre,iniciales) VALUES(?,?)";
        ps = Bdr.getCon().prepareStatement(plantilla);
        ps.setString(1, nombre);
        ps.setString(2, iniciales);
        
        ps.executeUpdate();
        Bdr.cerrarCon();
	}

	/**
	 * Metodo para eliminar un equipo ya existente
	 * 
	 * @param idEquipo
	 * @throws SQLException
	 */
	public void eliminarEquipo(int idEquipo) throws SQLException {
		Bdr.Conectar();
		plantilla = "DELETE FROM  Equipo where id_equipo = ?";
		ps = Bdr.getCon().prepareStatement(plantilla);
		ps.setInt(1, idEquipo);
		ps.executeUpdate();
		Bdr.cerrarCon();
	}

	/**
	 * Metodo para modificar un equipo ya existente
	 * 
	 * @param idEquipo
	 * @param iniciales
	 * @param nombre
	 * @throws SQLException
	 */
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

	/**
	 * Metodo para comprobar si existe el equipo que pasamos por parametro
	 * 
	 * @param nombre
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Equipo> comprobarNombreEquipo(String nombre) throws SQLException {
		Bdr.Conectar();
        plantilla = "SELECT * FROM Equipo WHERE nombre LIKE ?";
        ps = Bdr.getCon().prepareStatement(plantilla);
        ps.setString(1, nombre);
        resultado = ps.executeQuery();
        
        while (resultado.next()) {
        	listaEquipos.add(crearObjeto());
        }
        
        Bdr.cerrarCon();
        return listaEquipos;
	}
}
