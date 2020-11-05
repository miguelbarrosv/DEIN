package Vistas;

import java.sql.SQLException;

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


	public void abrirVentanaDeporte() throws SQLException
	{
		vDeporte = new frmVentanaDeporte();
		vDeporte.setVisible(true);
	}

	public void abrirVentanaAltaDeporte() 
	{
		vAltaDeporte = new frmVentanaAltaDeporte();
		vAltaDeporte.setVisible(true);
	}

	public void cerrarVentanaAltaDeporte() 
	{
		vAltaDeporte.dispose();
	} 
	

	public void abrirVentanaDeportista() throws SQLException 
	{
		vDeportista = new frmVentanaDeportistas();
		vDeportista.setVisible(true);
	}

	public void abrirVentanaAltaDeportista() 
	{
		vAltaDeportista = new frmVentanaAltaDeportista();
		vAltaDeportista.setVisible(true);
	}

	public void abrirVentanaEquipos() throws SQLException 
	{
		vEquipos = new frmVentanaEquipos();
		vEquipos.setVisible(true);
	}

	public void abrirVentanaOlimpiada() throws SQLException 
	{
		vOlimpiada = new frmVentanaOlimpiadas();
		vOlimpiada.setVisible(true);
	}

	public void abrirVentanaOlimpiadaAlta() throws SQLException 
	{
		vAltaOlimpiada = new frmVentanaAltaOlimpiada();
		vAltaOlimpiada.setVisible(true);
	}
	
	public void abrirVentanaParticipacion() throws SQLException 
	{
		vParticipacion = new frmVentanaParticipacion();
		vParticipacion.setVisible(true);
	}

	public void abrirVentanaAltaParticipacion() throws SQLException 
	{
		vAltaParticipacion = new frmVentanaAltaParticipacion();
		vAltaParticipacion.setVisible(true);
	}

	public void abrirVentanaEvento() throws SQLException 
	{
		vEvento = new frmVentanaEvento();
		vEvento.setVisible(true);
	}

	public void cerrarVentanaOlimpiada() 
	{
		vOlimpiada.dispose();
	}

	public static void abrirVentanaPrincipal() 
	{
		vPrincipal = new frmVentanaPrincipal();
		vPrincipal.setVisible(true);
	}
	
	public static void cerrarVentanaPrincipal() 
	{
		vPrincipal.dispose();
	}

	public void cerrarVentanaEquipos() 
	{
		// TODO Auto-generated method stub
		vEquipos.dispose();
	}

	public void cerrarVentanaDeportes() 
	{
		// TODO Auto-generated method stub
		vDeporte.dispose();
	}

	public void cerrarVentanaParticipacion() 
	{
		// TODO Auto-generated method stub
		vParticipacion.dispose();
	}

	public void cerrarVentanaDeportista() 
	{
		// TODO Auto-generated method stub
		vDeportista.dispose();
	}

	public void cerrarVentanaEvento() 
	{
		// TODO Auto-generated method stub
		vEvento.dispose();
	}

	public void cerrarVentanaAltaDeportista() 
	{
		// TODO Auto-generated method stub
		vAltaDeportista.dispose();
	}

	public void cerrarVentanaAltaOlimpiada() 
	{
		// TODO Auto-generated method stub
		vAltaOlimpiada.dispose();
	}

	public void cerrarVentanaAltaEquipos() 
	{
		// TODO Auto-generated method stub
		vAltaEquipo.dispose();
	}
	
	public void abrirVentanaAltaEquipos() 
	{
		// TODO Auto-generated method stub
		vAltaEquipo= new frmVentanaAltaEquipo();
		vAltaEquipo.setVisible(true);
	}

	public void cerrarVentanaAltaParticipacion() {
		// TODO Auto-generated method stub
		vAltaParticipacion.dispose();
	}

	public void abrirVentanaAltaEventos() throws SQLException {
		// TODO Auto-generated method stub
		vAltaEvento = new frmVentanaAltaEvento();
		vAltaEvento.setVisible(true);
	}
	
}
