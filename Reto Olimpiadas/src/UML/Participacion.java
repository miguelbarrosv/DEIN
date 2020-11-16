package UML;

public class Participacion {
	private int id_deportista;
	private int id_equipo;
	private int id_evento;
	private String medalla;
	private int edad;
	
	/**
	 * Creamos el objeto vacio sin parametros
	 */
	public Participacion() {}
	
	/**
	 * Creamos el objeto con los parametros que nos pasan
	 * 
	 * @param id_deportista
	 * @param id_equipo
	 * @param id_evento
	 * @param medalla
	 * @param edad
	 */
	public Participacion(int id_deportista, int id_equipo, int id_evento, String medalla, int edad) {
		this.id_deportista = id_deportista;
		this.id_equipo = id_equipo;
		this.id_evento = id_evento;
		this.medalla = medalla;
		this.edad = edad;
	}
	
	/**
	 * Guardamos el id_deportista que pasamos por parametro
	 * 
	 * @param id_deportista
	 */
	public void setId_deportista(int id_deportista) {
		this.id_deportista = id_deportista;
	}
	
	
	/**
	 * Devolvemos el id_deportista del objeto
	 * 
	 * @return
	 */
	public int getId_deportista() {
		return id_deportista;
	}
	
	/**
	 * Guardamos el id_equipo que pasamos por parametro

	 * @param id_equipo
	 */
	public void setId_equipo(int id_equipo) {
		this.id_equipo = id_equipo;
	}
	
	/**
	 * Devolvemos el id_equipo del objeto
	 * 
	 * @return
	 */
	public int getId_Equipo() {
		return id_equipo;
	}
	
	/**
	 * Guardamos el id_evento que pasamos por parametro
	 * 
	 * @param id_evento
	 */
	public void setId_evento(int id_evento) {
		this.id_evento = id_evento;
	}
	
	/**
	 * Devolvemos el id_evento del objeto
	 * 
	 * @return
	 */
	public int getId_evento() {
		return id_evento;
	}
	
	/**
	 * Guardamos la medalla que pasamos por parametro
	 * 
	 * @param medalla
	 */
	public void setMedalla(String medalla) {
		this.medalla = medalla;
	}
	
	/**
	 * Devolvemos la medalla del objeto
	 * 
	 * @return
	 */
	public String getMedalla() {
		return medalla;
	}
	
	/**
	 * Guardamos la edad que pasamos por parametro
	 * 
	 * @param edad
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	/**
	 * Devolvemos la edad del objeto
	 * 
	 * @return
	 */
	public int getEdad() {
		return edad;
	}
}
