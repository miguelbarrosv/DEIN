package UML;

public class Olimpiada {
	private int id_olimpiada;
	private String nombre;
	private int anio;
	private String temporada;
	private String ciudad;
	
	public Olimpiada() {}
	
	public Olimpiada(int id_olimpiada,String nombre, int anio,String temporada, String ciudad) {
		this.id_olimpiada = id_olimpiada;
		this.nombre = nombre;
		this.anio = anio;
		this.temporada = temporada;
		this.ciudad = ciudad;
	}
	
	public void setId_olimpiada(int id_olimpiada) {
		this.id_olimpiada = id_olimpiada;
	}
	
	public int getId_olimpiada() {
		return id_olimpiada;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setAnio(int anio) {
		this.anio = anio;
	}
	
	public int getAnio() {
		return anio;
	}
	
	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}
	
	public String getTemporada() {
		return temporada;
	}
	
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	public String getCiudad() {
		return ciudad;
	}
	
	
}
