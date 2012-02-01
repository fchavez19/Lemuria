package mx.edu.uaemex.fi.poo.lemuria.gui.control;

import mx.edu.uaemex.fi.poo.lemuria.gameadmin.UsuariosService;
import mx.edu.uaemex.fi.poo.lemuria.gameadmin.modelo.Jugador;
import mx.edu.uaemex.fi.poo.lemuria.gameadmin.modelo.error.UsuarioRepetidoException;
import mx.edu.uaemex.fi.poo.lemuria.gui.data.UsuarioData;

// ESCA-JAVA0137:
/**
 * Control para la ventana de registro de usuarios.
 * @author fchavez Francisco Ch&aacute;vez Casta&ntilde;eda.
 * @version 0.1
 */
public class VentanaRegistroCtrl {
	/**
	 * Servicio de administraci&oacute;n de usuarios.
	 */
	private UsuariosService service;
	/**
	 * Modelo que utilizado por la ventana.
	 */
	private Jugador modelo;
	
	/**
	 * Establece el servicio que utilizar&aacute; el control.
	 * @param service Servicio que utilizar&aacute; el control.
	 */
	public void setService(UsuariosService service) {
		this.service = service;
	}
	/**
	 * Establece el modelo.
	 * @param modelo Juagdor que sirve como modelo del control.
	 */
	public void setModelo(Jugador modelo) {
		this.modelo = modelo;
	}	
	/**
	 * Intenta realizar el alta del registro del usuario.
	 * @param d Datos del usuario a dar de alta.
	 * @throws UsuarioRepetidoException En caso de que el nombre de usuario ya exista.
	 */
	public void daDeAlta(UsuarioData d) throws UsuarioRepetidoException {					
		this.service.realizaAlta(d);
		this.modelo.cambio();
		this.modelo.notifyObservers();
	}		
}
