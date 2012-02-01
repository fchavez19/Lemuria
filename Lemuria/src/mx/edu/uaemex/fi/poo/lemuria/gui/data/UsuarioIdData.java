package mx.edu.uaemex.fi.poo.lemuria.gui.data;

import java.util.Observable;

/**
 * POJO para almacenar la informaci&oacute;n de la ventana de identificaci&oacute;n.
 * @author fchavez Francisco Ch&aacute;vez Casta&ntilde;eda.
 * @version 0.1
 */
public class UsuarioIdData extends Observable {
	/**
	 * Valor del login.
	 */
	private String login;
	/**
	 * Valor del passwd.
	 */
	private String passwd;
	
	/**
	 * COnstructora sin par&aacute;metros.
	 */
	public UsuarioIdData(){ }
	/**
	 * Constructora.
	 * @param l Identificador del usuario en el sistema.
	 * @param p Contrase&ntilde;na.
	 */
	public UsuarioIdData(String l, String p){
		this.login = l;
		this.passwd = p;
	}
	/**
	 * Consulta el identificador del usuario en el sistema.
	 * @return Identificador del usuario en el sistema.
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * Establece el identificador del usuario en el sistema.
	 * @param login Identificador del usuario en el sistema.
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	/**
	 * Consulta la contrase&ntilde;na.
	 * @return Contrase&ntilde;na.
	 */
	public String getPasswd() {
		return passwd;
	}
	/**
	 * Establece la contrase&ntilde;na.
	 * @param passwd Contrase&ntilde;na.
	 */
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}	
	/**
	 * Para tener el setChanged.
	 */
	public void cambio(){
		this.setChanged();
	}
}
