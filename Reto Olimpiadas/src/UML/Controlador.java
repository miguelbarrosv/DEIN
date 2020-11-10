package UML;

import java.sql.SQLException;
import java.util.ArrayList;

import BD.DeporteBD;
import BD.DeportistaBD;
import BD.EquipoBD;
import BD.EventoBD;
import BD.OlimpiadaBD;
import BD.ParticipacionBD;
import Vistas.ControladorVistas;
import Vistas.frmVentanaPrincipal;

public class Controlador {
	public ControladorVistas controladorVistas = new ControladorVistas();
	public ArrayList<Deporte> deportes;
	public DeporteBD deporteBD = new DeporteBD();
	public ArrayList<Deportista> deportistas;
	public DeportistaBD deportistaBD = new DeportistaBD();
	public EquipoBD equipoBD = new EquipoBD();
	public ArrayList<Equipo> equipos;
	public OlimpiadaBD olimpiadaBD = new OlimpiadaBD();
	public ArrayList<Olimpiada> olimpiadas;
	public ParticipacionBD participacionBD = new ParticipacionBD();
	public ArrayList<ParticipacionTabla> participaciones = new ArrayList();
	public EventoBD eventoBD = new EventoBD();
	public ArrayList<Evento> eventos = new ArrayList();
	public static frmVentanaPrincipal vPrincipal = new frmVentanaPrincipal();
	
	
	
	public ArrayList<Deporte> consultarDeportes() throws SQLException
	{
		deportes = deporteBD.consultarTodosDeportes();
		return deportes;
	}


	public boolean comprobarDeporte(String nombre) throws SQLException {
		Boolean comprobacion = false;
		deportes = deporteBD.consultarNombreDeporte(nombre);
		
		if (deportes == null || deportes.size() == 0) {
			comprobacion = true;
		}
		
		return comprobacion;
	}


	public void insertarDeporte(String nombre) throws SQLException {
		deporteBD.altaDeporte(nombre);
	}


	public ArrayList<Deportista> consultarDeportistas() throws SQLException {
		deportistas = deportistaBD.consultarTodosDeportistas();
		return deportistas;
	}


	public void altaDeportista(String nombre, String sexo, int altura, int peso) throws SQLException {
		deportistaBD.altaDeportista(nombre,sexo,altura,peso);
	}


	public ArrayList<Equipo> consultarEquipos() throws SQLException {
		equipos = equipoBD.consultarTodosEquipos();
		return equipos;
	}


	public ArrayList<Olimpiada> consultarOlimpiadas() throws SQLException {
		olimpiadas = olimpiadaBD.consultarTodasOlimpiadas();
		return olimpiadas;
	}


	public void altaOlimpiada(int anio, String temporada, String nombre, String ciudad) throws SQLException {
		olimpiadaBD.altaOlimpiada(anio,temporada,nombre,ciudad);
	}


	public ArrayList<ParticipacionTabla> consultarTablaParticpaciones() throws SQLException {
		participaciones = participacionBD.consultarTablaParticpaciones();
		return participaciones;
	}


	public ArrayList<Evento> consultarEventos() throws SQLException {
		eventos = eventoBD.consultarTodosEventos();
		return eventos;
	}


	public void altaEquipo(String nombre, String iniciales) throws SQLException {
		equipoBD.altaEquipo(nombre, iniciales);
	}


	public void altaParticipacion() throws SQLException {
		// TODO Auto-generated method stub
		participacionBD.altaParticipacion();
	}

	public void modificarDeportista(int idDeportista, String nombre, String sexo, int altura, int peso) throws SQLException {
		// TODO Auto-generated method stub
		deportistaBD.modificarDeportista(idDeportista,nombre,sexo,altura,peso);
	}
	
	public void eliminarDeportista(int idDeportista) throws SQLException {
		// TODO Auto-generated method stub
		deportistaBD.eliminarDeportista(idDeportista);
	}


	public void modificarOlimpiada(int idOlimpiada, String nombre, String anio, String ciudad, String temporada) throws SQLException {
		// TODO Auto-generated method stub
		olimpiadaBD.modificarOlimpiada(idOlimpiada, nombre, anio, ciudad, temporada);
	}


	public void eliminarOlimpiada(int idOlimpiada) throws SQLException {
		olimpiadaBD.eliminarOlimpiada(idOlimpiada);
	}

	public void modificarParticipacion(int idEvento, int idDeportista, int idEquipo, String medalla, int edad) throws NumberFormatException, SQLException {
		// TODO Auto-generated method stub
		participacionBD.modificarParticipacion(idEvento, idDeportista,idEquipo, medalla, edad);
	}


	public void eliminarParticipacion(int idEvento, int idDeportista) throws SQLException {
		participacionBD.eliminarParticipacion(idEvento,idDeportista);
	}

	public void modificarEquipo(int idEquipo, String iniciales, String nombre) throws SQLException {
		equipoBD.modificarEquipo(idEquipo,iniciales,nombre);
	}

	public void eliminarEquipo(int idEquipo) throws SQLException {
		equipoBD.eliminarEquipo(idEquipo);
	}


	public void modificarEvento(int idEvento, String nombreEvento, int idOlimpiada, int idDeporte) throws SQLException {
		// TODO Auto-generated method stub
		eventoBD.modificarEvento( idEvento,  nombreEvento,  idOlimpiada,  idDeporte);
	}

	public void eliminarEvento(int idEvento) throws SQLException {
		eventoBD.eliminarEvento(idEvento);
	}

}
