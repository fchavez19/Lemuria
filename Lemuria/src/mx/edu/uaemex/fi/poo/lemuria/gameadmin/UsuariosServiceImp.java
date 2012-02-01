package mx.edu.uaemex.fi.poo.lemuria.gameadmin;

import java.util.ArrayList;
import java.util.List;

import mx.edu.uaemex.fi.poo.lemuria.gameadmin.modelo.Jugador;
import mx.edu.uaemex.fi.poo.lemuria.gameadmin.modelo.error.UsuarioRepetidoException;
import mx.edu.uaemex.fi.poo.lemuria.gui.data.UsuarioData;
import mx.edu.uaemex.fi.poo.lemuria.gui.data.UsuarioIdData;

// ESCA-JAVA0137:
/**
 * Implementaci&oacute;n del servicio de usuarios.
 * @author fchavez Francisco Ch&aacute;vez Casta&ntilde;eda.
 * @version 0.1
 */

public class UsuariosServiceImp implements UsuariosService {
	/**
	 * Lista con los jugadores conocidos.
	 */
	private List<Jugador> jugadores;

	@Override
	public boolean datosCorrectos(UsuarioIdData data) {
		jugadores = new ArrayList<Jugador>();
		for(Jugador player : jugadores){
			if(player.getLogin().compareTo(data.getLogin()) == 0){
				System.out.println(data.getLogin());
				if(player.getPassword().compareTo(data.getPasswd()) == 0){
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public void realizaAlta(UsuarioData data) throws UsuarioRepetidoException {
		Jugador j = this.findUsuario(data.getLogin()); 
		if( j == null){
			j = new Jugador();
			int edad = Integer.parseInt(data.getEdad());
			j.setLogin(data.getLogin());
			j.setPassword(data.getPasswd());
			j.setEdad(edad);
		} else {
			throw new UsuarioRepetidoException("El usuario ya existe dentro del sistema");
		}
	}

	@Override
	public Jugador findUsuario(String login) {
		return null;
	}
}
