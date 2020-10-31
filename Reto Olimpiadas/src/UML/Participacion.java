package UML;

public class Participacion {
	private int id_deportista;
	private int id_equipo;
	private int id_evento;
	private String medalla;
	private int edad;
	
	public Participacion() {}
	
	public Participacion(int id_deportista, int id_equipo, int id_evento, String medalla, int edad) {
		this.id_deportista = id_deportista;
		this.id_equipo = id_equipo;
		this.id_evento = id_evento;
		this.medalla = medalla;
		this.edad = edad;
	}
	
	public void setId_deportista(int id_deportista) {
		this.id_deportista = id_deportista;
	}
	
	public int getId_deportista() {
		return id_deportista;
	}
	
	public void setId_equipo(int id_equipo) {
		this.id_equipo = id_equipo;
	}
	
	public int getId_Equipo() {
		return id_equipo;
	}
	
	public void setId_evento(int id_evento) {
		this.id_evento = id_evento;
	}
	
	public int getId_evento() {
		return id_evento;
	}
	
	public void setMedalla(String medalla) {
		this.medalla = medalla;
	}
	
	public String getMedalla() {
		return medalla;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public int getEdad() {
		return edad;
	}
}
