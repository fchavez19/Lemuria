package mx.edu.uaemex.fi.poo.lemuria.modelo.error;

// ESCA-JAVA0234:
/**
 * Excepci&oacute;n que marca el error de intentar meter un Item en una bolsa
 * llena.
 * @author fchavez fchavez Francisco Ch&aacute;vez Casta&ntilde;eda.
 * @version 0.1
 */
public class BolsaLlenaException extends Exception {
	/**
	 * Default serial version.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Constructora sin par&aacute;metros.
	 */
	public BolsaLlenaException() {
	}
	/**
	 * Constructora con mensaje.
	 * @param message Mensaje.
	 */
	public BolsaLlenaException(String message) {
		super(message);
	}
	/**
	 * Constructora con causa.
	 * @param cause Causa.
	 */
	public BolsaLlenaException(Throwable cause) {
		super(cause);
	}
	/**
	 * Constructora con causa y mensaje.
	 * @param message Mensaje.
	 * @param cause Causa.
	 */
	public BolsaLlenaException(String message, Throwable cause) {
		super(message, cause);
	}

}
