package mx.edu.uaemex.fi.poo.lemuria.gui.control;

import mx.edu.uaemex.fi.poo.lemuria.gameadmin.UsuariosService;
import mx.edu.uaemex.fi.poo.lemuria.gameadmin.modelo.Jugador;
import mx.edu.uaemex.fi.poo.lemuria.gui.data.UsuarioIdData;

/**
 * Control para la ventana principal.
 * @author fchavez Francisco Ch&aacute;vez Casta&ntilde;eda.
 * @version 0.1
 */
public class VentanaInicialCtrl {
	/**
	 * Servicio de administraci&oacute;n de usuarios.
	 */
	private UsuariosService service;
	/**
	 * Jugador, modelo compartido por el control y la vista.
	 */
	private Jugador jugador;
	/**
	 * Control general de la aplicaci&oacute;n.
	 */
	private ControlGeneral fatherCtrl;
	
	/**
	 * Constructora. 
	 * @param player Jugador.
	 */
	public VentanaInicialCtrl(Jugador player){
		this.jugador = player;
	}
	/**
	 * Establece el servicio de administraci&oacute;n de usuarios.
	 * @param service servicio de administraci&oacute;n de usuarios.
	 */
	public void setService(UsuariosService service) {
		this.service = service;
	}
	
	/**
	 * Trata de loguear al usuario.
	 * @param l Login.
	 * @param p Password.
	 */
	public void login(String l, String p) {
		UsuarioIdData response = new UsuarioIdData();
		response.setLogin(l);
		response.setPasswd(p);
		if(this.service.datosCorrectos(response)){
			this.jugador.setLogin(l);
			this.jugador.setPassword(p);
			this.jugador.setLogueado(true);
		} 
	}
	/**
	 * Establece una referencia al control general de la app.
	 * @param fatherCtrl Referencia al control general de la app.
	 */
	public void setFatherCtrl(ControlGeneral fatherCtrl) {
		this.fatherCtrl = fatherCtrl;
	}	
	/**
	 * Solicitud de la ventana de registro.
	 */
	public void registra(){
		this.fatherCtrl.muestraVentanaRegistro();
	}
}
