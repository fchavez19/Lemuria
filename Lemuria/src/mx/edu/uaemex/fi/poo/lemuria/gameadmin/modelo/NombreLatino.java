package mx.edu.uaemex.fi.poo.lemuria.gameadmin.modelo;

// ESCA-JAVA0137:
// ESCA-JAVA0234:
/**
 * Clase que representa a los nombres compuestos por 2 apellidos y un conjunto de nombres de
 * de pila.
 * @author fchavez Francisco Ch&aacute;vez Casta&ntilde;eda.
 * @version 0.1
 */
public class NombreLatino extends Nombre {
	/**
	 * Default serial version.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Apellido materno.
	 */
	private String apellidoMaterno;
	
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
	
	@Override
	public String toString(){
		return super.toString() + " " + this.apellidoMaterno;
	}
}
