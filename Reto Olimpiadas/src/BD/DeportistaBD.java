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
	
	public Deportista crearObjeto() throws SQLException 
    {
        Deportista d = new Deportista();
        d.setId_deportista(resultado.getInt("id_deportista"));
        d.setNombre(resultado.getString("nombre"));
        d.setSexo(resultado.getString("sexo"));
        d.setPeso(resultado.getInt("peso"));
        d.setAltura(resultado.getInt("altura"));
        
        return d;
    }

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

	public void añadirDeportista(String nombre, String sexo, int altura, int peso) throws SQLException {
		Bdr.Conectar();
        plantilla = "INSERT INTO Deportista(nombre,sexo,altura,peso) VALUES(?,?,?,?)";
        ps = Bdr.getCon().prepareStatement(plantilla);
        ps.setString(1, nombre);
        ps.setString(2, sexo);
        ps.setInt(3, altura);
        ps.setInt(4, peso);
        ps.executeUpdate();
        Bdr.cerrarCon();
	}

}