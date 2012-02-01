package mx.edu.uaemex.fi.poo.lemuria.gameadmin.modelo;

/**
 * Clase que representa a los jugadores.
 * @author fchavez Francisco Ch&aacute;vez Castan&tilde;eda.
 * @version 0.1.
 */
public class Jugador extends Persona {
	/**
	 * Default serial version UID.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Identificador de usuario.
	 */
	private String login;
	/**
	 * Contrase&ntilde;a.
	 */
	private String password;
	/**
	 * Bandera que indica si el usuario se encuentra logueado.
	 */
	private boolean logueado;
	
	/**
	 * Constrctora sin par&aacute;metros.
	 */
	public Jugador(){		
	}
	/**
	 * Constructora.
	 * @param login Identificador de usuario.
	 * @param passwd Contrase&ntilde;a.
	 */
	public Jugador(String login, String passwd){
		this.login = login;
		this.password = passwd;
	}
	/**
	 * Consulta el identificador de usuario.
	 * @return Identificador de usuario.
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * Establece el idetificador de usuario.
	 * @param login Identificador de usuario.
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	/**
	 * Consulta la contrase&ntilde;a.
	 * @return Contrase&ntilde;a.
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * Establece la contrase&ntilde;a.
	 * @param password Contrase&ntilde;a.
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * Consulta el estado de logueado de un jugador.
	 * @return Bandera que indica el estado de logueado de un jugador.
	 */
	public boolean isLogueado() {
		return logueado;
	}
	/**
	 * Establece el estado de logueado de un jugador.
	 * @param logueado Estado de logueado de un jugador.
	 */
	public void setLogueado(boolean logueado) {		
		this.logueado = logueado;
		this.cambio();
		this.notifyObservers();
	}
	/**
	 * Funci&oacute;n que marca que ha habido un cambio en el modelo.
	 */
	public void cambio(){
		this.setChanged();
	}
}
