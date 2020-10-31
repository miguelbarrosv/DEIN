package UML;

public class Evento {
	private int id_evento;
	private String nombre;
	private int id_olimpiada;
	private int id_deporte;
	
	public Evento() {}
	
	public Evento(int id_evento, String nombre, int id_olimpiada, int id_deporte) {
		this.id_evento = id_evento;
		this.nombre = nombre;
		this.id_olimpiada = id_olimpiada;
		this.id_deporte = id_deporte;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setId_evento(int id_evento) {
		this.id_evento = id_evento;
	}
	
	public int getId_evento() {
		return id_evento;
	}
	
	public void setId_olimpiada(int id_olimpiada) {
		this.id_olimpiada = id_olimpiada;
	}
	
	public int getId_olimpiada() {
		return id_olimpiada;
	}
	
	public void setId_deporte(int id_deporte) {
		this.id_deporte = id_deporte;
	}
	
	public int getId_deporte() {
		return id_deporte;
	}

}
