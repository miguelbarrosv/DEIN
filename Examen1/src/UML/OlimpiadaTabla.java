package UML;

public class OlimpiadaTabla {
	private int id_olimpiada;
	private String nombre;
	private int anio;
	private String nombreDeporte;
	private String ciudad;
	private String nombreEvento;
	
	/**
	 * Creamos el objeto vacio sin parametros
	 */
	public OlimpiadaTabla() {}
	
	/**
	 * Creamos el objeto con los parametros que nos pasan
	 * 
	 * @param id_olimpiada
	 * @param nombre
	 * @param anio
	 * @param temporada
	 * @param ciudad
	 */
	public OlimpiadaTabla(int id_olimpiada,String nombre, int anio, String ciudad,String nombreDeporte, String nombreEvento) {
		this.id_olimpiada = id_olimpiada;
		this.nombre = nombre;
		this.anio = anio;
		this.ciudad = ciudad;
		this.nombreDeporte = nombreDeporte;
		this.nombreEvento = nombreEvento;
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
	 * Guardamos la el nombre del deporte que pasamos por parametro
	 * 
	 * @param temporada
	 */
	public void setNombreDeporte(String nombreDeporte) {
		this.nombreDeporte = nombreDeporte;
	}
	
	/**
	 * Devolvemos el nombre del deporte del objeto
	 * 
	 * @return
	 */
	public String getNombreDeporte() {
		return nombreDeporte;
	}
	
	/**
	 * Guardamos la el nombre del evento que pasamos por parametro
	 * 
	 * @param temporada
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
