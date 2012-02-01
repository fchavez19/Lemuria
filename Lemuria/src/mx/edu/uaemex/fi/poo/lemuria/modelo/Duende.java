package mx.edu.uaemex.fi.poo.lemuria.modelo;

// ESCA-JAVA0137:
/**
 * Enemigos a vencer, si les ganas NO obtendr&aacute;s poder; pero tu salud
 * mejorar&aacute;.
 * @author fchavez Francisco Ch&aacute;vez Casta&ntilde;eda.
 * @version 0.1
 */
public class Duende extends Personaje {
	/**
	 * Nivel de magia almacenada por el Duende.
	 */
	private long cantidadDeMagia;
	/**
	 * Cuando el duende es vencido suelta toda la magia que poseia.
	 * @return Cantidad de magia que solia poseer el duende.
	 */
	public long dropMagia(){
		long magia = this.cantidadDeMagia;
		this.cantidadDeMagia = 0;
		return magia;
	}
	/**
	 * Cada vez que vence a un enemigo aumenta su nivel de magia.
	 * @param m Nivel de magia absorbida del enemigo.
	 */
	public void aumentaMagia(long m){
		this.cantidadDeMagia += m;
	}

}
