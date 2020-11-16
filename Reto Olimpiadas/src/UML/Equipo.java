package UML;

public class Equipo {
	private int id_equipo;
	private String nombre;
	private String iniciales;
	
	/**
	 * Creamos el objeto con los parametros que nos pasan
	 * 
	 * @param id_equipo
	 * @param nombre
	 * @param iniciales
	 */
	public Equipo(int id_equipo, String nombre, String iniciales) {
			
			this.id_equipo = id_equipo;
			this.nombre = nombre;
			this.iniciales = iniciales;
	}
	
	/**
	 * Creamos el objeto vacio sin parametros
	 */
	public Equipo() {}
	
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
	 * Guardamos el id_equipo que pasamos por parametro
	 * 
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
	public int getId_equipo() {
		return id_equipo;
	}
	
	/**
	 * Guardamos las iniciales que pasamos por parametro
	 * 
	 * @param iniciales
	 */
	public void setIniciales(String iniciales) {
		this.iniciales = iniciales;
	}
	
	/**
	 * Devolvemos elas iniciales del objeto
	 * 
	 * @return
	 */
	public String getIniciales() {
		return iniciales;
	}
}
