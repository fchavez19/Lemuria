package mx.edu.uaemex.fi.poo.lemuria.modelo.error;

/**
 * Excepci&oacute;n que marca la muerte del presonaje.
 * @author fchavez Francisco Ch&aacute;vez Casta&ntilde;eda.
 * @version 0.1
 */
public class TuEstasMuertoException extends Exception {
	/**
	 * Default serial version.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructora sin par&aacute;metros.
	 */
	public TuEstasMuertoException() {
	}
	/**
	 * Constructora con mensaje.
	 * @param message Mensaje.
	 */
	public TuEstasMuertoException(String message) {
		super(message);
	}
	/**
	 * Constructora con causa.
	 * @param cause Causa.
	 */
	public TuEstasMuertoException(Throwable cause) {
		super(cause);
	}
	/**
	 * Constructora con causa y mensaje.
	 * @param message Mensaje.
	 * @param cause Causa.
	 */
	public TuEstasMuertoException(String message, Throwable cause) {
		super(message, cause);
	}
}
