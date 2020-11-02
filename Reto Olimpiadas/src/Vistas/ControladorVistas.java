package Vistas;

import java.sql.SQLException;

public class ControladorVistas {
	public frmVentanaDeporte vDeporte;
	public frmVentanaAñadirDeporte vAltaDeporte;
	public frmVentanaDeportistas vDeportista;
	public frmVentanaAltaDeportista vAltaDeportista;
	public frmVentanaEquipos vEquipos;
	public frmVentanaOlimpiadas vOlimpiada;
	public frmVentanaAltaOlimpiada vAltaOlimpiada;
	public frmVentanaParticipacion vParticipacion;
	public frmVentanaEvento vEvento;
	public static frmVentanaPrincipal vPrincipal;

	public void abrirVentanaDeporte() throws SQLException
	{
		vDeporte = new frmVentanaDeporte();
		vDeporte.setVisible(true);
	}

	public void abrirVentanaAltaDeporte() 
	{
		vAltaDeporte = new frmVentanaAñadirDeporte();
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

	public void abrirVentanaAltaDeportista() {
		vAltaDeportista = new frmVentanaAltaDeportista();
		vAltaDeportista.setVisible(true);
	}

	public void abrirVentanaEquipos() throws SQLException {
		vEquipos = new frmVentanaEquipos();
		vEquipos.setVisible(true);
	}

	public void abrirVentanaOlimpiada() throws SQLException {
		vOlimpiada = new frmVentanaOlimpiadas();
		vOlimpiada.setVisible(true);
	}

	public void abrirVentanaOlimpiadaAlta() throws SQLException {
		vAltaOlimpiada = new frmVentanaAltaOlimpiada();
		vAltaOlimpiada.setVisible(true);
	}
	
	public void abrirVentanaParticipacion() throws SQLException {
		vParticipacion = new frmVentanaParticipacion();
		vParticipacion.setVisible(true);
	}

	public void abrirVentanaAltaParticipacion() {

	}

	public void abrirVentanaEvento() throws SQLException {
		vEvento = new frmVentanaEvento();
		vEvento.setVisible(true);
	}

	public void cerrarVentanaOlimpiada() {
		vOlimpiada.dispose();
	}

	public static void abrirVentanaPrincipal() {
		vPrincipal = new frmVentanaPrincipal();
		vPrincipal.setVisible(true);
	}
	
	public static void cerrarVentanaPrincipal() {
		vPrincipal.dispose();
	}

	public void cerrarVentanaEquipos() {
		// TODO Auto-generated method stub
		vEquipos.dispose();
	}

	public void cerrarVentanaDeportes() {
		// TODO Auto-generated method stub
		vDeporte.dispose();
	}

	public void cerrarVentanaParticipacion() {
		// TODO Auto-generated method stub
		vParticipacion.dispose();
	}

	public void cerrarVentanaDeportista() {
		// TODO Auto-generated method stub
		vDeportista.dispose();
	}

	public void cerrarVentanaEvento() {
		// TODO Auto-generated method stub
		vEvento.dispose();
	}
	
}
