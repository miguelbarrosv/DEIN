package UML;

public class Deporte {
	
	private int id_deporte;
    private String nombre;
    
    /**
	 * Creamos el objeto vacio sin parametros
     */
    public Deporte() {}
    
    /**
	 * Creamos el objeto con los parametros que nos pasan
     * 
     * @param id_deporte
     * @param nombre
     */
	public Deporte(int id_deporte, String nombre) {
		this.id_deporte = id_deporte;
		this.nombre = nombre;
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
	
}
