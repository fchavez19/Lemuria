package mx.edu.uaemex.fi.poo.lemuria.modelo.error;

// ESCA-JAVA0234:
/**
 * Excepci&oacute;n que marca el error de intentar pasar como par&aacute;metro una 
 * cantidad que no es acaptable con respecto a cierta l&oacute;gica. Por ejemplo:<br>
 * <br>
 * El m&eacute;tdo getMagia de las posiones recibe como par&aacute;metro la el porcentaje 
 * de la posi&oacute;n que debe ser sacado, por lo que esta cantidad debe de ser un n&uacute;mero
 * positivo entre 0 y 1. Cualquier variaci&oacute;n respecto a este rango ser&aacute; marcada 
 * con la presente excepci&oacute;n.
 * @author fchavez fchavez Francisco Ch&aacute;vez Casta&ntilde;eda.
 * @version 0.1
 */
public class CantidadNoValidaException extends Exception {
	/**
	 * Default serial version.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Constructora sin par&aacute;metros.
	 */
	public CantidadNoValidaException() {
	}
	/**
	 * Constructora con mensaje.
	 * @param message Mensaje.
	 */
	public CantidadNoValidaException(String message) {
		super(message);
	}
	/**
	 * Constructora con causa.
	 * @param cause Causa.
	 */
	public CantidadNoValidaException(Throwable cause) {
		super(cause);
	}
	/**
	 * Constructora con causa y mensaje.
	 * @param message Mensaje.
	 * @param cause Causa.
	 */
	public CantidadNoValidaException(String message, Throwable cause) {
		super(message, cause);
	}
}
