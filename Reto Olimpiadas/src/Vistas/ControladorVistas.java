package Vistas;

import java.sql.SQLException;

import javax.help.HelpSetException;

public class ControladorVistas {
	public static frmVentanaDeporte vDeporte;
	public static frmVentanaAltaDeporte vAltaDeporte;
	public static frmVentanaDeportistas vDeportista;
	public static frmVentanaAltaDeportista vAltaDeportista;
	public static frmVentanaEquipos vEquipos;
	public static frmVentanaOlimpiadas vOlimpiada;
	public static frmVentanaAltaOlimpiada vAltaOlimpiada;
	public static frmVentanaParticipacion vParticipacion;
	public static frmVentanaEvento vEvento;
	public static frmVentanaPrincipal vPrincipal;
	public static frmVentanaAltaEquipo vAltaEquipo;
	public static frmVentanaAltaParticipacion vAltaParticipacion;
	public static frmVentanaAltaEvento vAltaEvento;

	/**
	 * Creamos una ventana Deporte y la hacemos visible.
	 * 
	 * @throws SQLException
	 * @throws HelpSetException
	 */
	public void abrirVentanaDeporte() throws SQLException, HelpSetException
	{
		vDeporte = new frmVentanaDeporte();
		vDeporte.setVisible(true);
		vDeporte.setLocationRelativeTo(null);
	}

	/**
	 * Creamos una ventana AltaDeporte y la hacemos visible.
	 */
	public void abrirVentanaAltaDeporte() 
	{
		vAltaDeporte = new frmVentanaAltaDeporte();
		vAltaDeporte.setVisible(true);
		vAltaDeporte.setLocationRelativeTo(null);
	}

	/**
	 * Cerramos la ventana AltaDeporte.
	 */
	public void cerrarVentanaAltaDeporte() 
	{
		vAltaDeporte.dispose();
	} 
	
	/**
	 * Creamos una ventana Deportista y la hacemos visible.
	 * 
	 * @throws SQLException
	 * @throws HelpSetException
	 */
	public void abrirVentanaDeportista() throws SQLException, HelpSetException 
	{
		vDeportista = new frmVentanaDeportistas();
		vDeportista.setVisible(true);
		vDeportista.setLocationRelativeTo(null);
	}

	/**
	 * Creamos una ventana AltaDeportista y la hacemos visible.
	 */
	public void abrirVentanaAltaDeportista() 
	{
		vAltaDeportista = new frmVentanaAltaDeportista();
		vAltaDeportista.setVisible(true);
		vAltaDeportista.setLocationRelativeTo(null);
	}

	/**
	 * Creamos una ventana Equipos y la hacemos visible.
	 * 
	 * @throws SQLException
	 * @throws HelpSetException
	 */
	public void abrirVentanaEquipos() throws SQLException, HelpSetException 
	{
		vEquipos = new frmVentanaEquipos();
		vEquipos.setVisible(true);
		vEquipos.setLocationRelativeTo(null);
	}

	/**
	 * Creamos una ventana Olimpiada y la hacemos visible.
	 * 
	 * @throws SQLException
	 * @throws HelpSetException 
	 */
	public void abrirVentanaOlimpiada() throws SQLException, HelpSetException 
	{
		vOlimpiada = new frmVentanaOlimpiadas();
		vOlimpiada.setVisible(true);
		vOlimpiada.setLocationRelativeTo(null);
	}

	/**
	 * Creamos una ventana AltaOlimpiada y la hacemos visible.
	 * 
	 * @throws SQLException
	 */
	public void abrirVentanaOlimpiadaAlta() throws SQLException 
	{
		vAltaOlimpiada = new frmVentanaAltaOlimpiada();
		vAltaOlimpiada.setVisible(true);
		vAltaOlimpiada.setLocationRelativeTo(null);
	}
	
	/**
	 * Creamos una ventana Participacion y la hacemos visible.
	 * 
	 * @throws SQLException
	 * @throws HelpSetException
	 */
	public void abrirVentanaParticipacion() throws SQLException, HelpSetException 
	{
		vParticipacion = new frmVentanaParticipacion();
		vParticipacion.setVisible(true);
		vParticipacion.setLocationRelativeTo(null);
	}

	/**
	 * Creamos una ventana AltaParticipacion y la hacemos visible.
	 * 
	 * @throws SQLException
	 */
	public void abrirVentanaAltaParticipacion() throws SQLException 
	{
		vAltaParticipacion = new frmVentanaAltaParticipacion();
		vAltaParticipacion.setVisible(true);
		vAltaParticipacion.setLocationRelativeTo(null);
	}

	/**
	 * Creamos una ventana Evento y la hacemos visible.
	 * 
	 * @throws SQLException
	 * @throws HelpSetException
	 */
	public void abrirVentanaEvento() throws SQLException, HelpSetException 
	{
		vEvento = new frmVentanaEvento();
		vEvento.setVisible(true);
		vEvento.setLocationRelativeTo(null);
	}

	/**
	 * Cerramos la ventana Olimpiada.
	 */
	public void cerrarVentanaOlimpiada() 
	{
		vOlimpiada.dispose();
	}

	/**
	 * Creamos una ventana Principal y la hacemos visible.
	 * 
	 * @throws HelpSetException
	 */
	public static void abrirVentanaPrincipal() throws HelpSetException 
	{
		vPrincipal = new frmVentanaPrincipal();
		vPrincipal.setVisible(true);
		vPrincipal.setLocationRelativeTo(null);
	}
	
	/**
	 * Cerramos la ventana Principal.
	 */
	public static void cerrarVentanaPrincipal() 
	{
		vPrincipal.dispose();
	}

	/**
	 * Cerramos la ventana Equipos.
	 */
	public void cerrarVentanaEquipos() 
	{
		vEquipos.dispose();
	}

	/**
	 * Cerramos la ventana Deportes.
	 */
	public void cerrarVentanaDeportes() 
	{
		vDeporte.dispose();
	}

	/**
	 * Cerramos la ventana Participacion.
	 */
	public void cerrarVentanaParticipacion() 
	{
		vParticipacion.dispose();
	}

	/**
	 * Cerramos la ventana Deportista.
	 */
	public void cerrarVentanaDeportista() 
	{
		vDeportista.dispose();
	}

	/**
	 * Cerramos la ventana Evento.
	 */
	public void cerrarVentanaEvento() 
	{
		vEvento.dispose();
	}

	/**
	 * Cerramos la ventana AltaDeportista.
	 */
	public void cerrarVentanaAltaDeportista() 
	{
		vAltaDeportista.dispose();
	}
	
	/**
	 * Cerramos la ventana AltaOlimpiada.
	 */
	public void cerrarVentanaAltaOlimpiada() 
	{
		vAltaOlimpiada.dispose();
	}

	/**
	 * Cerramos la ventana AltaEquipos.
	 */
	public void cerrarVentanaAltaEquipos() 
	{
		vAltaEquipo.dispose();
	}
	
	/**
	 * Creamos una ventana AltaEquipos y la hacemos visible.
	 * 
	 */
	public void abrirVentanaAltaEquipos() 
	{
		vAltaEquipo= new frmVentanaAltaEquipo();
		vAltaEquipo.setVisible(true);
		vAltaEquipo.setLocationRelativeTo(null);
	}

	/**
	 * Cerramos la ventana AltaParticipacion.
	 */
	public void cerrarVentanaAltaParticipacion() {
		vAltaParticipacion.dispose();
	}

	/**
	 * Creamos una ventana AltaEventos y la hacemos visible.
	 * 
	 * @throws SQLException
	 */
	public void abrirVentanaAltaEventos() throws SQLException {
		vAltaEvento = new frmVentanaAltaEvento();
		vAltaEvento.setVisible(true);
		vAltaEvento.setLocationRelativeTo(null);
	}
	
	/**
	 * Cerramos la ventana AltaEventos.
	 * 
	 * @throws SQLException
	 */
	public void cerrarVentanaAltaEvento() throws SQLException {
		vAltaEvento.dispose();
	}
	
	
	
}
