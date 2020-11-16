package UML;

public class Deportista {
	
	private int id_deportista;
	private String nombre;
	private String sexo;
	private float peso;
	private float altura;
	
	/**
	 * Creamos el objeto con los parametros que nos pasan
	 * 
	 * @param id_deportista
	 * @param nombre
	 * @param sexo
	 * @param peso
	 * @param altura
	 */
	public Deportista(int id_deportista, String nombre, String sexo, float peso, float altura) {
		
		this.id_deportista = id_deportista;
		this.nombre = nombre;
		this.sexo = sexo;
		this.peso = peso;
		this.altura = altura;
	}
	
	/**
	 * Creamos el objeto vacio sin parametros
	 */
	public Deportista() {}
	
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
	 * Guardamos el sexo que pasamos por parametro
	 * 
	 * @param sexo
	 */
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	/**
	 * Devolvemos el sexo del objeto
	 * 
	 * @return
	 */
	public String getSexo() {
		return sexo;
	}
	
	/**
	 * Guardamos el peso que pasamos por parametro
	 * 
	 * @param peso
	 */
	public void setPeso(float peso) {
		this.peso = peso;
	}
	
	/**
	 * Devolvemos el peso del objeto
	 * 
	 * @return
	 */
	public float getPeso() {
		return peso;
	}
	
	/**
	 * Guardamos la altura que pasamos por parametro
	 * 
	 * @param altura
	 */
	public void setAltura(float altura) {
		this.altura = altura;
	}
	
	/**
	 * Devolvemos la altura del objeto
	 * 
	 * @return
	 */
	public float getAltura() {
		return altura;
	}
}
