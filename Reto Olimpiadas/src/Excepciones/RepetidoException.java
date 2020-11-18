package Excepciones;

public class RepetidoException extends Exception {
	private String mensaje;
	
	public RepetidoException(String _mensaje) {
		mensaje = _mensaje;
	}
	
	public String getMessage() {
		return mensaje;
	}
}
