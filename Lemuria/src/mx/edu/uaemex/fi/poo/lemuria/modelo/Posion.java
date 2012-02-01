package mx.edu.uaemex.fi.poo.lemuria.modelo;

import java.awt.Color;

import mx.edu.uaemex.fi.poo.lemuria.modelo.error.CantidadNoValidaException;

/**
 * Elemento m&aacute;gico que sirve para recobrar salud.
 * @author fchavez Francisco Ch&aacute;vez Casta&ntilde;eda.
 * @version 0.1
 */
public class Posion extends Item {
	/**
	 * Nivel por omisi&oacute;n de la posi&oacute;n.
	 */
	public static final int NIVEL_DEFAULT = 100;
	/**
	 * Nivel de la posici&oacute;n, representa un porcentaje (0-100).
	 */
	private long nivel;
	/**
	 * Color de la posi&oacute;n.
	 */
	private Color color;

	/**
	 * Constructora, asegura que el contenido de la posima est&eacute; al 100%
	 * y le asigna su color.
	 * @param col Color.
	 */
	public Posion(final Color col, long nivel){
		this.nivel=nivel;
		this.color = col;
		if(color == Color.green){
			this.nombre = "posion salud";
		}
	}

	public Posion(String nombre, long nivel){
		this.nivel=nivel;
		this.nombre = "posion " + nombre;
		if(this.nombre.compareTo("posion salud")==0){
			this.color=Color.GREEN;
		}
	}
	/**
	 * Gasta cierto porcentaje de la posici&oacute;n. 
	 * @param porcentaje Cantidad de posi&acute;n a gastar establecida en t&eacute;rminos
	 * de porcentaje.
	 * @return Cantidad de posi&ocute;n gastada.
	 * @throws CantidadNoValidaException 
	 */
	public long getMagia(final double porcentaje) throws CantidadNoValidaException{
		if(porcentaje < 0 || porcentaje > 1){
			throw new CantidadNoValidaException("No es un porcentaje permitido");
		}
		long resta = (long) porcentaje * nivel;
		if(resta > nivel){
			throw new CantidadNoValidaException("No puedes sacar más de lo que tienes");
		}
		nivel -= resta;
		return resta;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}


}
