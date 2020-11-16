package UML;

public class ParticipacionTabla {
	private int id_deportista;
	private int id_equipo;
	private int id_evento;
	private String nombreDeportista;
	private String nombreEvento;
	private String nombreEquipo;
	private String medalla;
	private int edad;
	
	/**
	 * Creamos el objeto vacio sin parametros
	 */
	public ParticipacionTabla() {}
	
	/**
	 * Creamos el objeto con los parametros que nos pasan
	 * 
	 * @param id_deportista
	 * @param id_equipo
	 * @param id_evento
	 * @param nombreDeportista
	 * @param nombreEvento
	 * @param nombreEquipo
	 * @param medalla
	 * @param edad
	 */
	public ParticipacionTabla(int id_deportista, int id_equipo, int id_evento,String nombreDeportista,String nombreEvento,String nombreEquipo, String medalla, int edad) {
		this.id_deportista = id_deportista;
		this.id_equipo = id_equipo;
		this.id_evento = id_evento;
		this.medalla = medalla;
		this.edad = edad;
		this.nombreDeportista = nombreDeportista;
		this.nombreEquipo = nombreEquipo;
		this.nombreEvento = nombreEvento;
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
	 * Guardamos el id_deportista que pasamos por parametro
	 * 
	 * @param id_deportista
	 */
	public void setId_Deportista(int id_deportista) {
		this.id_deportista = id_deportista;
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
	
	/**
	 * Guardamos el nombre del equipo que pasamos por parametro
	 * 
	 * @param nombreEquipo
	 */
	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}
	
	/**
	 * Devolvemos el nombre del equipo del objeto
	 * 
	 * @return
	 */
	public String getNombreEquipo() {
		return nombreEquipo;
	}
	
	/**
	 * Guardamos el nombre del deportista que pasamos por parametro
	 * 
	 * @param nombreDeportista
	 */
	public void setNombreDeportista(String nombreDeportista) {
		this.nombreDeportista = nombreDeportista;
	}
	
	/**
	 * Devolvemos el nombre del deportista del objeto
	 * 
	 * @return
	 */
	public String getNombreDeportista() {
		return nombreDeportista;
	}
	
	/**
	 * Guardamos el nombre del evento que pasamos por parametro
	 * 
	 * @param nombreEvento
	 */
	public void setNombreEvento(String nombreEvento) {
		this.nombreEvento = nombreEvento;
	}
	
	/**
	 * Devolvemos el nombre del evento del objeto
	 * 
	 * @return
	 */
	public String getNombreEvento() {
		return nombreEvento;
	}
	
}
