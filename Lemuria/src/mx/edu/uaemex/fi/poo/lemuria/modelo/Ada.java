package mx.edu.uaemex.fi.poo.lemuria.modelo;

/**
 * Personaje que te ayudar&aacute; a continuar la misi&oacute;n.
 * @author fchavez Francisco Ch&aacute;vez Casta&ntilde;eda.
 * @version 0.1
 */
public class Ada extends Personaje {

	/**
	 * Cura a los enfermos, el nivel de curaci&oacute;n de un ada, depende
	 * de su nivel de poder.
	 * @return Cantidad de "sanaci&oacute;n" que proporciona.
	 */
	public long cura(){
		return this.nivelDePoder;
	}
}
