package UML;

public class Equipo {
	private int id_equipo;
	private String nombre;
	private String iniciales;
	
	public Equipo(int id_equipo, String nombre, String iniciales) {
			
			this.id_equipo = id_equipo;
			this.nombre = nombre;
			this.iniciales = iniciales;
	}
	
	public Equipo() {}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setId_equipo(int id_equipo) {
		this.id_equipo = id_equipo;
	}
	
	public int getId_equipo() {
		return id_equipo;
	}
	
	public void setIniciales(String iniciales) {
		this.iniciales = iniciales;
	}
	
	public String getIniciales() {
		return iniciales;
	}
}
