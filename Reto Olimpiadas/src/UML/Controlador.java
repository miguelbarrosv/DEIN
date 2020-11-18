package UML;

import java.sql.SQLException;
import java.util.ArrayList;

import BD.DeporteBD;
import BD.DeportistaBD;
import BD.EquipoBD;
import BD.EventoBD;
import BD.OlimpiadaBD;
import BD.ParticipacionBD;
import Excepciones.RepetidoException;
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
	
	/**
	 * Metodo que llama a la base de datos para consultar los deportes para delvolverlos a la vista
	 * 
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Deporte> consultarDeportes() throws SQLException
	{
		deportes = deporteBD.consultarTodosDeportes();
		return deportes;
	}

	/**
	 * Metodo que llama a la base de datos para comprobar que el deporte que nos han pasado existe, si existe se le devolvera false, si no existe se le devolvera true
	 * 
	 * @param nombre
	 * @return
	 * @throws SQLException
	 */
	public boolean comprobarDeporte(String nombre) throws SQLException {
		Boolean comprobacion = false;
		deportes = deporteBD.consultarNombreDeporte(nombre);
		
		if (deportes == null || deportes.size() == 0) {
			comprobacion = true;
		}
		
		return comprobacion;
	}


	/**
	 * Metodo que llama a la base de datos para insertar un nuevo deporte con los parametros que pasamos
	 * 
	 * @param nombre
	 * @throws SQLException
	 * @throws RepetidoException 
	 */
	public void insertarDeporte(String nombre) throws SQLException, RepetidoException {
		if(comprobarDeporte(nombre)) {
			deporteBD.altaDeporte(nombre);
		}else {
			throw new RepetidoException("Deporte repetido: "+nombre);
		}
	}

	/**
	 * Metodo que llama a la base de datos para consultar los deportistas para delvolver un array de ese objeto a la vista
	 * 
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Deportista> consultarDeportistas() throws SQLException {
		deportistas = deportistaBD.consultarTodosDeportistas();
		return deportistas;
	}

	/**
	 * Metodo que llama a la base de datos para insertar un nuevo deportistas con los parametros que pasamos
	 * 
	 * @param nombre
	 * @param sexo
	 * @param altura
	 * @param peso
	 * @throws SQLException
	 * @throws RepetidoException 
	 */
	public void altaDeportista(String nombre, String sexo, float altura, float peso) throws SQLException, RepetidoException {
		
		if(comprobarDeportista(nombre)) {
			deportistaBD.altaDeportista(nombre,sexo,altura,peso);
		} else {
			throw new RepetidoException("El deportista " + nombre + " ya existe");
		}
	}

	/**
	 * Metodo que llama a la base de datos para consultar los equipos para delvolver un array de ese objeto a la vista
	 * 
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Equipo> consultarEquipos() throws SQLException {
		equipos = equipoBD.consultarTodosEquipos();
		return equipos;
	}

	/**
	 * Metodo que llama a la base de datos para consultar las olimpiadas para delvolver un array de ese objeto a la vista
	 * 
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Olimpiada> consultarOlimpiadas() throws SQLException {
		olimpiadas = olimpiadaBD.consultarTodasOlimpiadas();
		return olimpiadas;
	}

	/**
	 * Metodo que llama a la base de datos para insertar una nueva olimpiada con los parametros que pasamos
	 * 
	 * @param anio
	 * @param temporada
	 * @param nombre
	 * @param ciudad
	 * @throws SQLException
	 * @throws RepetidoException 
	 */
	public void altaOlimpiada(int anio, String temporada, String nombre, String ciudad) throws SQLException, RepetidoException {
		if(comprobarOlimpiada(nombre)) {
			olimpiadaBD.altaOlimpiada(anio,temporada,nombre,ciudad);
		} else {
			throw new RepetidoException("LA olimpiada " + nombre + " ya existe");
		}
	}

	/**
	 * Metodo que llama a la base de datos para consultar las participaciones para delvolver un array de ese objeto a la vista
	 * 
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<ParticipacionTabla> consultarTablaParticpaciones() throws SQLException {
		participaciones = participacionBD.consultarTablaParticpaciones();
		return participaciones;
	}

	/**
	 * Metodo que llama a la base de datos para consultar los eventos para delvolver un array de ese objeto a la vista
	 * 
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Evento> consultarEventos() throws SQLException {
		eventos = eventoBD.consultarTodosEventos();
		return eventos;
	}

	/**
	 * Metodo que llama a la base de datos para insertar un nuevo equipo con los parametros que pasamos
	 * 
	 * @param nombre
	 * @param iniciales
	 * @throws SQLException
	 * @throws RepetidoException 
	 */
	public void altaEquipo(String nombre, String iniciales) throws SQLException, RepetidoException {
		if (comprobarEquipo(nombre)) {
			equipoBD.altaEquipo(nombre, iniciales);
		} else {
			throw new RepetidoException("El equipo " + nombre + " ya existe");
		}
	}

	/**
	 * Metodo que llama a la base de datos para insertar una nueva participacion con los parametros que pasamos
	 * 
	 * @param idEvento
	 * @param idDeportista
	 * @param idEquipo
	 * @param edad
	 * @param medalla
	 * @throws SQLException
	 */
	public void altaParticipacion(int idEvento, int idDeportista, int idEquipo, int edad, String medalla) throws SQLException {
		participacionBD.altaParticipacion(idEvento, idDeportista, idEquipo, edad, medalla);
	}

	/**
	 * Metodo que llama a la base de datos para modificar un deportista con los parametros que pasamos
	 * 
	 * @param idDeportista
	 * @param nombre
	 * @param sexo
	 * @param altura
	 * @param peso
	 * @throws SQLException
	 */
	public void modificarDeportista(int idDeportista, String nombre, String sexo, String altura, String peso) throws SQLException {
		deportistaBD.modificarDeportista(idDeportista,nombre,sexo,Float.parseFloat(altura),Float.parseFloat(peso));
	}
	
	/**
	 * Metodo que llama a la base de datos para eliminar un deportistas con los parametros que pasamos
	 * 
	 * @param idDeportista
	 * @throws SQLException
	 */
	public void eliminarDeportista(int idDeportista) throws SQLException {
		deportistaBD.eliminarDeportista(idDeportista);
	}

	/**
	 * Metodo que llama a la base de datos para modificar una olimpiada con los parametros que pasamos
	 * 
	 * @param idOlimpiada
	 * @param nombre
	 * @param anio
	 * @param ciudad
	 * @param temporada
	 * @throws SQLException
	 */
	public void modificarOlimpiada(int idOlimpiada, String nombre, String anio, String ciudad, String temporada) throws SQLException {
		olimpiadaBD.modificarOlimpiada(idOlimpiada, nombre, anio, ciudad, temporada);
	}

	/**
	 * Metodo que llama a la base de datos para eliminar una olimpiada con los parametros que pasamos
	 * 
	 * @param idOlimpiada
	 * @throws SQLException
	 */
	public void eliminarOlimpiada(int idOlimpiada) throws SQLException {
		olimpiadaBD.eliminarOlimpiada(idOlimpiada);
	}

	/**
	 * Metodo que llama a la base de datos para modificar una participacion con los parametros que pasamos
	 * 
	 * @param idEvento
	 * @param idDeportista
	 * @param idEquipo
	 * @param medalla
	 * @param edad
	 * @throws NumberFormatException
	 * @throws SQLException
	 */
	public void modificarParticipacion(int idEvento, int idDeportista, int idEquipo, String medalla, int edad) throws NumberFormatException, SQLException {
		participacionBD.modificarParticipacion(idEvento, idDeportista,idEquipo, medalla, edad);
	}

	/**
	 * Metodo que llama a la base de datos para eliminar una participacion con los parametros que pasamos
	 * 
	 * @param idEvento
	 * @param idDeportista
	 * @throws SQLException
	 */
	public void eliminarParticipacion(int idEvento, int idDeportista) throws SQLException {
		participacionBD.eliminarParticipacion(idEvento,idDeportista);
	}

	/**
	 * Metodo que llama a la base de datos para modificar un equipo con los parametros que pasamos
	 * 
	 * @param idEquipo
	 * @param iniciales
	 * @param nombre
	 * @throws SQLException
	 */
	public void modificarEquipo(int idEquipo, String iniciales, String nombre) throws SQLException {
		equipoBD.modificarEquipo(idEquipo,iniciales,nombre);
	}

	/**
	 * Metodo que llama a la base de datos para eliminar un equipo con los parametros que pasamos
	 * 
	 * @param idEquipo
	 * @throws SQLException
	 */
	public void eliminarEquipo(int idEquipo) throws SQLException {
		equipoBD.eliminarEquipo(idEquipo);
	}

	/**
	 * Metodo que llama a la base de datos para modificar un evento con los parametros que pasamos
	 * 
	 * @param idEvento
	 * @param nombreEvento
	 * @param idOlimpiada
	 * @param idDeporte
	 * @throws SQLException
	 */
	public void modificarEvento(int idEvento, String nombreEvento, int idOlimpiada, int idDeporte) throws SQLException {
		eventoBD.modificarEvento( idEvento,  nombreEvento,  idOlimpiada,  idDeporte);
	}

	/**
	 * Metodo que llama a la base de datos para eliminar un evento con los parametros que pasamos
	 * 
	 * @param idEvento
	 * @throws SQLException
	 */
	public void eliminarEvento(int idEvento) throws SQLException {
		eventoBD.eliminarEvento(idEvento);
	}

	/**
	 * Metodo que llama a la base de datos para modificar un deporte con los parametros que pasamos
	 * 
	 * @param idDeporte
	 * @param nombre
	 * @throws SQLException
	 */
	public void modificarDeporte(int idDeporte, String nombre) throws SQLException {
		deporteBD.modificarDeporte(idDeporte,nombre);
	}

	/**
	 * Metodo que llama a la base de datos para eliminar un deporte con los parametros que pasamos
	 * 
	 * @param idDeporte
	 * @throws SQLException
	 */
	public void eliminarDeporte(int idDeporte) throws SQLException {
		deporteBD.eliminarDeporte(idDeporte);
	}

	/**
	 * Metodo que llama a la base de datos para insertar un nuevo evento con los parametros que pasamos
	 * 
	 * @param nombre
	 * @param idOlimpiada
	 * @param idDeporte
	 * @throws SQLException
	 */
	public void altaEvento(String nombre, int idOlimpiada, int idDeporte) throws SQLException {
		eventoBD.altaEvento(nombre, idOlimpiada, idDeporte);
	}

	/**
	 * Metodo que llama a la base de datos para comprobar que la olimpiada que nos han pasado existe, si existe se le devolvera false, si no existe se le devolvera true
	 * 
	 * @param nombre
	 * @return
	 * @throws SQLException
	 */
	public boolean comprobarOlimpiada(String nombre) throws SQLException {
		Boolean comprobacion = false;
		olimpiadas = olimpiadaBD.comprobarNombreOlimpiada(nombre);
		
		if (olimpiadas == null || olimpiadas.size() == 0) {
			comprobacion = true;
		}
		
		return comprobacion;
	}

	/**
	 * Metodo que llama a la base de datos para comprobar que el equipo que nos han pasado existe, si existe se le devolvera false, si no existe se le devolvera true
	 * 
	 * @param nombre
	 * @return
	 * @throws SQLException
	 */
	public boolean comprobarEquipo(String nombre) throws SQLException {
		Boolean comprobacion = false;
		equipos = equipoBD.comprobarNombreEquipo(nombre);
		
		if(equipos == null || equipos.size() == 0) {
			comprobacion = true;
		}
		
		return comprobacion;
	}
	
	public boolean comprobarDeportista(String nombre) throws SQLException {
		Boolean comprobacion = false;
		deportistas = deportistaBD.comprobarNombreDeportista(nombre);
		
		if(deportistas == null || deportistas.size() == 0) {
			comprobacion = true;
		}
		
		return comprobacion;
	}

}
