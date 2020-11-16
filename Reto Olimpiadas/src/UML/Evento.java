package UML;

public class Evento {
	private int id_evento;
	private String nombre;
	private int id_olimpiada;
	private int id_deporte;
	
	/**
	 * Creamos el objeto vacio sin parametros
	 */
	public Evento() {}
	
	/**
	 * Creamos el objeto con los parametros que nos pasan
	 * 
	 * @param id_evento
	 * @param nombre
	 * @param id_olimpiada
	 * @param id_deporte
	 */
	public Evento(int id_evento, String nombre, int id_olimpiada, int id_deporte) {
		this.id_evento = id_evento;
		this.nombre = nombre;
		this.id_olimpiada = id_olimpiada;
		this.id_deporte = id_deporte;
	}
	
	/**
	 * Guardamos el nombre que pasamos por parametro
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Devolvemos el nombre del objeto
	 * 
	 * @return
	 */
	public String getNombre() {
		return nombre;
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
	 * Guardamos el id_olimpiada que pasamos por parametro
	 * 
	 * @param id_olimpiada
	 */
	public void setId_olimpiada(int id_olimpiada) {
		this.id_olimpiada = id_olimpiada;
	}
	
	/**
	 * Devolvemos el id_olimpiada del objeto
	 * 
	 * @return
	 */
	public int getId_olimpiada() {
		return id_olimpiada;
	}
	
	/**
	 * Guardamos el id_deporte que pasamos por parametro
	 * 
	 * @param id_deporte
	 */
	public void setId_deporte(int id_deporte) {
		this.id_deporte = id_deporte;
	}
	
	/**
	 * Devolvemos el id_deporte del objeto
	 * 
	 * @return
	 */
	public int getId_deporte() {
		return id_deporte;
	}

}
