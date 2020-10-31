package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Bdr {
	
	private Connection con;
	
	/**
     * Función para conectarse a la base de datos.
     *
     */
	public void Conectar()
	 {
		try 
		 {
			//Se carga el driver de acceso a datos
		   Class.forName("com.mysql.cj.jdbc.Driver");
		   DriverManager.getConnection("jdbc:mysql://localhost:3306/olimpiadas","root","root");
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
	public Connection getCon() {
        return con;
    }

    /**
     * Funcion para cerrar la conexion a la base de datos.
     *
     * @throws Exception hereda excepciones
     */
	
    public void cerrarCon() throws Exception {
        con.close();
    }
}
