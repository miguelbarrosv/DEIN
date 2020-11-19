package Excepciones;

public class RepetidoException extends Exception {
	private String mensaje;
	
	/**
	 * Recogemos el error de mensaje y lo guardamos
	 * @param _mensaje
	 */
	public RepetidoException(String _mensaje) {
		mensaje = _mensaje;
	}
	
	/**
	 * Devolvemos el mensaje de error
	 */
	public String getMessage() {
		return mensaje;
	}
}
