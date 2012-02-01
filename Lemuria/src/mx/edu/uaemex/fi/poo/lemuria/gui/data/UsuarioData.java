package mx.edu.uaemex.fi.poo.lemuria.gui.data;

// ESCA-JAVA0137:
/**
 * POJO para almacenar los valores de captura del registro de usuarios.
 * @author fchavez Francisco Ch&aacute;vez Casta&ntilde;eda.
 * @version 0.1
 */
public class UsuarioData extends UsuarioIdData {
	/**
	 * Nombre de pila del usuario.
	 */
	private String nombreDePila;
	/**
	 * Apellido paterno.
	 */
	private String apellidoPaterno;
	/**
	 * Apellido materno.
	 */
	private String apellidoMaterno;
	/**
	 * Edad del usuario.
	 */
	private String edad;
	
	/**
	 * Consulta el nombre de pila del usuario.
	 * @return Nombre de pila del usuario.
	 */
	public String getNombreDePila() {
		return nombreDePila;
	}
	/**
	 * Establece el nombre de pila del usuario.
	 * @param nombreDePila Nombre de pila del usuario.
	 */
	public void setNombreDePila(String nombreDePila) {
		this.nombreDePila = nombreDePila;
	}
	/**
	 * Consulta el apellido paterno. 
	 * @return Apellido paterno.
	 */
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	/**
	 * Establece el apellido paterno.
	 * @param apellidoPaterno Apellido paterno.
	 */
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	/**
	 * Consulta el apellido materno.
	 * @return Apellido materno.
	 */
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	/**
	 * Establece el apellido materno.
	 * @param apellidoMaterno Apellido materno.
	 */
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	/**
	 * Consulta la edad.
	 * @return Edad.
	 */
	public String getEdad() {
		return edad;
	}
	/**
	 * Establece la edad.
	 * @param edad Edad.
	 */ 
	public void setEdad(String edad) {
		this.edad = edad;
	}	
}
