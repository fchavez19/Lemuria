package mx.edu.uaemex.fi.poo.lemuria.modelo;

/**
 * Los malvados del cuento, contra estos tendr&aacute;s que batallar, pero si los vences
 * obtendr&aacute;s poder.
 * @author fchavez Francisco Ch&aacute;vez Casta&ntilde;eda.
 * @version 0.1
 */
public class Troll extends PersonajeDeAccion {
	/**
	 * Libera el poder del Troll.
	 * @return Poder del Troll.
	 */
	
	public Troll(){
	}
	
	public long dropPower(){
		long poder = this.nivelDePoder;
		this.nivelDePoder = 0;
		return poder;
	}
}
