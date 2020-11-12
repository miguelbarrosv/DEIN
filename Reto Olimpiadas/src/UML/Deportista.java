package UML;

public class Deportista {
	
	private int id_deportista;
	private String nombre;
	private String sexo;
	private float peso;
	private float altura;
	
	public Deportista(int id_deportista, String nombre, String sexo, float peso, float altura) {
		
		this.id_deportista = id_deportista;
		this.nombre = nombre;
		this.sexo = sexo;
		this.peso = peso;
		this.altura = altura;
	}
	
	public Deportista() {}
	
	public void setId_deportista(int id_deportista) {
		this.id_deportista = id_deportista;
	}
	
	public int getId_deportista() {
		return id_deportista;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public String getSexo() {
		return sexo;
	}
	
	public void setPeso(float peso) {
		this.peso = peso;
	}
	
	public float getPeso() {
		return peso;
	}
	
	public void setAltura(float altura) {
		this.altura = altura;
	}
	
	public float getAltura() {
		return altura;
	}
}
