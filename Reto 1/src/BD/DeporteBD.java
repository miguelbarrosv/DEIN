package BD;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import LN.clsDeporte;

public class DeporteBD {
	private static  Bdr bdr;
    private static ResultSet resultado;
    private static String stringlistaDeportes;
    
    
    
    public static clsDeporte crearObjeto() throws Exception, SQLException {
        clsDeporte d = new clsDeporte();
        d.setNombre(resultado.getString("nombre"));
        return d;
    }
    
    public static ArrayList<clsDeporte> consultarTodosDeportes() throws Exception, SQLException {
    	ArrayList<clsDeporte> listaDeportes = new ArrayList();
        bdr.Conectar();
        Statement sentencia = bdr.getCon().createStatement();
        resultado = sentencia.executeQuery("SELECT * FROM DEPORTE");
        while (resultado.next()) {
            listaDeportes.add(crearObjeto());
        }
        bdr.cerrarCon();
        return listaDeportes;
    }
}
