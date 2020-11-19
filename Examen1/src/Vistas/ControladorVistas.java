package Vistas;

import java.sql.SQLException;

import javax.help.HelpSetException;

public class ControladorVistas {

	private static frmVentanaPrincipal vPrincipal;
	private static frmVentanaAltaOlimpiada vAltaOlimpiada;
	
	/**
	 * Abrimos la ventana Principal
	 * @throws SQLException
	 * @throws HelpSetException
	 */
	public static void abrirVentanaPrincipal() throws SQLException, HelpSetException {
		vPrincipal = new frmVentanaPrincipal();
		vPrincipal.setVisible(true);
	}

	/**
	 * Abrimos la ventana alta olimpiada
	 * @throws HelpSetException
	 */
	public void abrirVentanaOlimpiadaAlta() throws HelpSetException {
		vAltaOlimpiada = new frmVentanaAltaOlimpiada();
		vAltaOlimpiada.setVisible(true);
	}

	/**
	 * Cerramos la ventana alta olimpiada
	 */
	public void cerrarVentanaAltaOlimpiada() {
		vAltaOlimpiada.dispose();
	}

	/**
	 * Cerramos la ventana Principal
	 */
	public void cerrarVentanaPrincipal() {
		vPrincipal.dispose();
	}
	

}
