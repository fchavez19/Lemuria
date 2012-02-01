package mx.edu.uaemex.fi.poo.lemuria.gameadmin.modelo.error;

// ESCA-JAVA0234:
/**
 * Clase que marca el error de intentar registrar un usuario con un login que ya existe.
 * @author fchavez Francisco Ch&aacute;vez Casta&ntilde;eda.
 * @version 0.1
 */
public class UsuarioRepetidoException extends Exception {
	/**
	 * Default serial version.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Constructora sin par&aacute;metros.
	 */
	public UsuarioRepetidoException(){
		
	}
	/**
	 * Constructora con mensaje de error.
	 * @param m Mensaje de error.
	 */
	public UsuarioRepetidoException(String m){
		super(m);
	}
}
