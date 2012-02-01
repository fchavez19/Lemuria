package mx.edu.uaemex.fi.poo.lemuria.gameadmin.modelo;

import java.io.Serializable;
import java.util.Observable;

/**
 * Clase que modela a una persona.
 * @author fchavez Francisco Ch&aacute;vez Casta&ntilde;eda.
 * @version 0.1.
 */
public class Persona extends Observable implements Serializable {
	/**
	 * Default serial version UID.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Nombre legal de la persona.
	 */
	private Nombre nombre;
	/**
	 * Edad.
	 */
	private int edad;

	/**
	 * Constructora sin par&aacute;metros.
	 */
	public Persona(){
	}
	/**
	 * Constructora.
	 * @param nom Nombre de la persona.
	 * @param edad Edad de la persona.
	 */
	public Persona(Nombre nom, int edad){
		this.nombre = nom;
		this.edad = edad;
	}
	/**
	 * Consulta el nombre.
	 * @return Nombre legal de la persona.
	 */
	public Nombre getNombre() {
		return nombre;
	}
	/**
	 * Establece el nombre.
	 * @param nombre Nombre legal de la persona.
	 */
	public void setNombre(Nombre nombre) {
		this.nombre = nombre;
	}
	/**
	 * Consulta la edad de la persona.
	 * @return edad.
	 */
	public int getEdad() {
		return edad;
	}
	/**
	 * Establece la edad.
	 * @param edad Edad de la persona.
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}
}
