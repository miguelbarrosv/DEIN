package Main;

import java.sql.SQLException;

import javax.help.HelpSetException;

import Vistas.ControladorVistas;

/**
 * Metodo para iniciar la aplicacion y abrir la ventana principal
 * 
 * @author migue
 */
public class clsMain { 
	public static void main(String[] args) throws HelpSetException, SQLException {
		ControladorVistas.abrirVentanaPrincipal();
	}
}
