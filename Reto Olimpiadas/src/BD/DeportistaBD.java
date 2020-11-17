package BD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import UML.Deporte;
import UML.Deportista;

public class DeportistaBD {
	
	private ResultSet resultado;
    private PreparedStatement ps;
    private String plantilla;
    private ArrayList<Deportista> listaDeportistas;
	
    /**
     * Metodo para recoger los datos y crear el objeto deportista
     * 
     * @return
     * @throws SQLException
     */
	public Deportista crearObjeto() throws SQLException 
    {
        Deportista d = new Deportista();
        d.setId_deportista(resultado.getInt("id_deportista"));
        d.setNombre(resultado.getString("nombre"));
        d.setSexo(resultado.getString("sexo"));
        d.setPeso(resultado.getFloat("peso"));
        d.setAltura(resultado.getFloat("altura"));
        
        return d;
    }

	/**
     * Metodo para hacer la consulta de los deportistas para añadirlos a un array de deportistas y devolverlo
	 * 
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Deportista> consultarTodosDeportistas() throws SQLException {
		listaDeportistas = new ArrayList();
        Bdr.Conectar();
        plantilla = "SELECT * FROM Deportista";
        ps = Bdr.getCon().prepareStatement(plantilla);
        resultado = ps.executeQuery();
        
        while (resultado.next()) {
        	listaDeportistas.add(crearObjeto());
        }
        
        Bdr.cerrarCon();
        
        return listaDeportistas;
	}

	/**
     * Metodo para insertar un nuevo deportista
	 * 
	 * @param nombre
	 * @param sexo
	 * @param altura
	 * @param peso
	 * @throws SQLException
	 */
	public void altaDeportista(String nombre, String sexo, float altura, float peso) throws SQLException {
		Bdr.Conectar();
        plantilla = "INSERT INTO Deportista(nombre,sexo,altura,peso) VALUES(?,?,?,?)";
        ps = Bdr.getCon().prepareStatement(plantilla);
        ps.setString(1, nombre);
        ps.setString(2, sexo);
        ps.setFloat(3, altura);
        ps.setFloat(4, peso);
        ps.executeUpdate();
        Bdr.cerrarCon();
	}

	/**
     * Metodo para modificar un deportista que ya existe
	 * 
	 * @param idDeportista
	 * @param nombre
	 * @param sexo
	 * @param f
	 * @param g
	 * @throws SQLException
	 */
	public void modificarDeportista(int idDeportista, String nombre, String sexo, float altura, float peso) throws SQLException {
		Bdr.Conectar();
        plantilla = "UPDATE Deportista SET nombre = ? ,sexo = ?,altura = ?,peso = ? WHERE id_deportista = ?";
        ps = Bdr.getCon().prepareStatement(plantilla);
        ps.setString(1, nombre);
        ps.setString(2, sexo);
        ps.setFloat(3, altura);
        ps.setFloat(4, peso);
        ps.setInt(5, idDeportista);
        ps.executeUpdate();
        Bdr.cerrarCon();
	}

	/**
	 * Metodo para eliminar un deportista que ya existe

	 * 
	 * @param idDeportista
	 * @throws SQLException
	 */
	public void eliminarDeportista(int idDeportista) throws SQLException {
		Bdr.Conectar();
		plantilla = "DELETE FROM  Deportista where id_deportista = ?";
		ps = Bdr.getCon().prepareStatement(plantilla);
		ps.setInt(1, idDeportista);
		ps.executeUpdate();
		Bdr.cerrarCon();
	}

}
