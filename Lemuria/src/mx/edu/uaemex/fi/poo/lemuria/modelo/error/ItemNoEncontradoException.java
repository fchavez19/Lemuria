package mx.edu.uaemex.fi.poo.lemuria.modelo.error;

/**
 * Excepci&oacute;n que marca el error de intentar sacar un Item de una bolsa
 * en la que no est&aacute; contenido.
 * @author fchavez fchavez Francisco Ch&aacute;vez Casta&ntilde;eda.
 * @version 0.1
 */
public class ItemNoEncontradoException extends Exception {
	/**
	 * Default serial version.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructora sin par&aacute;metros.
	 */
	public ItemNoEncontradoException() {
	}
	/**
	 * Constructora con mensaje.
	 * @param message Mensaje.
	 */
	public ItemNoEncontradoException(String message) {
		super(message);
	}
	/**
	 * Constructora con causa.
	 * @param cause Causa.
	 */
	public ItemNoEncontradoException(Throwable cause) {
		super(cause);
	}
	/**
	 * Constructora con causa y mensaje.
	 * @param message Mensaje.
	 * @param cause Causa.
	 */
	public ItemNoEncontradoException(String message, Throwable cause) {
		super(message, cause);
	}

}
