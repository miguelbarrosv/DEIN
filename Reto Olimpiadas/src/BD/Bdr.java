package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.DatabaseMetaData;

public class Bdr {
	
	private static Connection con ;
	
	/**
     * Funcion para conectarse a la base de datos.
     *
     */
	public static void Conectar()
	 {
		try {
            Class.forName("org.sqlite.JDBC");
            String dbURL = "jdbc:sqlite:olimpiadas.db";
            con = DriverManager.getConnection(dbURL);
            if (con != null) {
                System.out.println("Connected to the database");
                DatabaseMetaData dm = (DatabaseMetaData) con.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Driver version: " + dm.getDriverVersion());
                System.out.println("Product name: " + dm.getDatabaseProductName());
                System.out.println("Product version: " + dm.getDatabaseProductVersion());
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
	 }
	
	/**
     * Es un Get que que devuelve la conexcion a la base de datos.
     *
     * @return devuelve la conexion
     */
	public static Connection getCon() {
        return con;
    }

    /**
     * Funcion para cerrar la conexion a la base de datos.
     * @throws SQLException 
     *
     * @throws Exception hereda excepciones
     */
	
    public static void cerrarCon() throws SQLException 
    {
        con.close();
    }
}
