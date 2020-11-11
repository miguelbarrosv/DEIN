package BD;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import UML.Deporte;

public class DeporteBD {
	//private static Bdr bdr;
    private ResultSet resultado;
    private PreparedStatement ps;
    private String plantilla;
    private ArrayList<Deporte> listaDeportes;
    
    public Deporte crearObjeto() throws SQLException 
    {
        Deporte d = new Deporte();
        d.setId_deporte(resultado.getInt("id_deporte"));
        d.setNombre(resultado.getString("nombre"));
        return d;
    }
    
    public ArrayList<Deporte> consultarTodosDeportes() throws SQLException 
    {
    	listaDeportes = new ArrayList();
        Bdr.Conectar();
        plantilla = "SELECT * FROM Deporte";
        ps = Bdr.getCon().prepareStatement(plantilla);
        resultado = ps.executeQuery();
        while (resultado.next()) {
            listaDeportes.add(crearObjeto());
        }
        Bdr.cerrarCon();
        return listaDeportes;
    }

	public ArrayList<Deporte> consultarNombreDeporte(String nombre) throws SQLException 
	{
		listaDeportes = new ArrayList();
        Bdr.Conectar();
        plantilla = "SELECT * FROM Deporte WHERE nombre = ?";
        ps = Bdr.getCon().prepareStatement(plantilla);
        ps.setString(1, nombre);
        resultado = ps.executeQuery();
        
        while (resultado.next()) {
            listaDeportes.add(crearObjeto());
        }
        
        Bdr.cerrarCon();
        return listaDeportes;
	}

	public void altaDeporte(String nombre) throws SQLException 
	{
		Bdr.Conectar();
        plantilla = "INSERT INTO Deporte(nombre) VALUES(?)";
        ps = Bdr.getCon().prepareStatement(plantilla);
        ps.setString(1, nombre);
        ps.executeUpdate();
        Bdr.cerrarCon();
	}

	public void modificarDeporte(int idDeporte, String nombre) throws SQLException {
		// TODO Auto-generated method stub
		Bdr.Conectar();
        plantilla = "UPDATE Olimpiada SET nombre = ? WHERE id_deporte = ?";
        ps = Bdr.getCon().prepareStatement(plantilla);
        ps.setString(1, nombre);
        ps.setInt(2, idDeporte);
        ps.executeUpdate();
        Bdr.cerrarCon();
	}

	public void eliminarDeporte(int idDeporte) throws SQLException {
		Bdr.Conectar();
        plantilla = "DELETE FROM  Deporte where id_deporte = ?";
        ps = Bdr.getCon().prepareStatement(plantilla);
        ps.setInt(1, idDeporte);
        ps.executeUpdate();
        Bdr.cerrarCon();		
	}
	
	
	
	
}
