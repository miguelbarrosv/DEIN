package UML;

public class Deporte {
	
	private int id_deporte;
    private String nombre;
    
    public Deporte() {}
    
	public Deporte(int id_deporte, String nombre) {
		this.id_deporte = id_deporte;
		this.nombre = nombre;
	}
	
	public void setId_deporte(int id_deporte) {
		this.id_deporte = id_deporte;
	}
	
	public int getId_deporte() {
		return id_deporte;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
}
