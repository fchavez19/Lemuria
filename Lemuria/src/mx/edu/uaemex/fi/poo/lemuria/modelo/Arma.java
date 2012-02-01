package mx.edu.uaemex.fi.poo.lemuria.modelo;

/**
 * Armas para los personajes de acci&oacute;n.
 * @author fchavez Francisco Ch&aacute;vez Casta&ntilde;eda.
 * @version 0.1
 */

public class Arma extends Item {
	/**
	 * Nivel de poder del arma.
	 */
	private long poder;

	/**
	 * Cosntructora que inicializa el arma, como lemuria solia ser un pueblo
	 * pac&iacute;fico se pensaba que las armas nunca llegar&iacute;an a ser muchas
	 * por lo que hasta nombre ten&iacute;an.<br>
	 * La constructora debe de marcar al Item con el tipo adecuado (arma).
	 * @param n Nombre del arma.
	 * @param pod Nivel del poder.
	 */
	
	public Arma(){
		//sólo para crear el objeto
	}
	
	public Arma(String n, long pod){
		this.tipo = TipoItem.ARMA;
		this.setNombre(n);
		this.poder = pod;
	}
	/**	
	 * Consulta el nivel de poder del arma.
	 * @return Nivel de poder del arma.
	 */
	public long getPoder() {
		return poder;
	}
	
}
