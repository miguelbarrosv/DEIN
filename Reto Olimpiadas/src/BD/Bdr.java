package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Bdr {
	
	private static Connection con ;
	public static final String URL="jdbc:mysql://localhost:3306/";
	public static final String SCHEMA = "olimpiadas";
	public static final String PARAMS="?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String USER = "root";
	public static final String PASS = "pass";
	
	/**
     * Funci�n para conectarse a la base de datos.
     *
     */
	public static void Conectar()
	 {
		try 
		 {
			//Se carga el driver de acceso a datos
		   Class.forName("com.mysql.cj.jdbc.Driver");
		   con = DriverManager.getConnection(URL+SCHEMA+PARAMS,USER,PASS);
		   System.out.println("Connected to the database");
		 }
		 catch (ClassNotFoundException e) 
		 {
		     System.out.println("Error al cargar el controlador ");
		 } catch (SQLException e) {
		     System.out.println("Error en la conexion ");
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
