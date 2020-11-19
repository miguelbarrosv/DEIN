package UML;

public class Olimpiada {
	private int id_olimpiada;
	private String nombre;
	private int anio;
	private String temporada;
	private String ciudad;
	
	/**
	 * Creamos el objeto vacio sin parametros
	 */
	public Olimpiada() {}
	
	/**
	 * Creamos el objeto con los parametros que nos pasan
	 * 
	 * @param id_olimpiada
	 * @param nombre
	 * @param anio
	 * @param temporada
	 * @param ciudad
	 */
	public Olimpiada(int id_olimpiada,String nombre, int anio,String temporada, String ciudad) {
		this.id_olimpiada = id_olimpiada;
		this.nombre = nombre;
		this.anio = anio;
		this.temporada = temporada;
		this.ciudad = ciudad;
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
	 * Guardamos el anio que pasamos por parametro
	 * 
	 * @param anio
	 */
	public void setAnio(int anio) {
		this.anio = anio;
	}
	
	/**
	 * Devolvemos el anio del objeto
	 * 
	 * @return
	 */
	public int getAnio() {
		return anio;
	}

	/**
	 * Guardamos la temporada que pasamos por parametro
	 * 
	 * @param temporada
	 */
	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}
	
	/**
	 * Devolvemos la temporada del objeto
	 * 
	 * @return
	 */
	public String getTemporada() {
		return temporada;
	}
	
	/**
	 * Guardamos la ciudad que pasamos por parametro
	 * 
	 * @param ciudad
	 */
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	/**
	 * Devolvemos la ciudad del objeto
	 * 
	 * @return
	 */
	public String getCiudad() {
		return ciudad;
	}
}
