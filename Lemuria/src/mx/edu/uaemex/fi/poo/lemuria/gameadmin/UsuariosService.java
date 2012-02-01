package mx.edu.uaemex.fi.poo.lemuria.gameadmin;

import mx.edu.uaemex.fi.poo.lemuria.gameadmin.modelo.Jugador;
import mx.edu.uaemex.fi.poo.lemuria.gameadmin.modelo.error.UsuarioRepetidoException;
import mx.edu.uaemex.fi.poo.lemuria.gui.data.UsuarioData;
import mx.edu.uaemex.fi.poo.lemuria.gui.data.UsuarioIdData;


/**
 * Interfaz para los servicios de administrac&oacute;n de usuarios.
 * @author fchavez Francisco Ch&aacute;vez Casta&ntilde;eda.
 * @version 0.1
 */
public interface UsuariosService {
	/**
	 * Determina si el conjunto de datos de identificaci&oacute;n de usuarios 
	 * se encuentra en los registros.
	 * @param data Datos del usuario a dar de alta.
	 * @return Bandera que indica si el conjunto de datos de identificaci&oacute;n de usuarios 
	 * se encuentra en los registros.
	 */
	boolean datosCorrectos(UsuarioIdData data);
	/**
	 * Da de alta al usuario.
	 * @param data Datos del usuario.
	 * @throws UsuarioRepetidoException en caso de que el login proporcionado ya est&eacute; en uso.
	 */
	void realizaAlta(UsuarioData data) throws UsuarioRepetidoException;
	/**
	 * Busca si existe un usuario con el nombre de usuario dado.
	 * @param login Nombre del usuario para el sistema.
	 * @return Bandera que indica si el usuario existe o no.
	 */
	Jugador findUsuario(String login);
}
