package mx.edu.uaemex.fi.poo.lemuria.gameadmin.modelo;

import java.io.Serializable;

/**
 * Clase que representa los nombres con el cual socialmente se identifica el usuario.
 * @author fchavez Francisco Ch&aacute;vez Castan&tilde;eda.
 * @version 0.1.
 */
public class Nombre implements Serializable {
	/**
	 * Serial version UID.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Apellido paterno.
	 */
	private String apellidoPaterno;
	/**
	 * Nombre de pila.
	 */
	private String nombreDePila;

	/**
	 * Constructora sin par&aacute;metros.
	 */
	public Nombre(){
	}
	/**
	 * Constructora.
	 * @param nP Nombre de pila.
	 * @param aP Apellido paterno.
	 */
	public Nombre(String nP, String aP){
		this.nombreDePila = nP;
		this.apellidoPaterno = aP;
	}
	/**
	 * Consulta el apellido paterno.
	 * @return Apellido paterno.
	 */
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	/**
	 * Establece el Apellido paterno.
	 * @param apellidoPaterno Apellido paterno.
	 */
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	/**
	 * Consulta el nombreDePila.
	 * @return NombreDePila.
	 */
	public String getNombreDePila() {
		return nombreDePila;
	}
	/**
	 * Establece el nombreDePila.
	 * @param nombreDePila NombreDePila.
	 */
	public void setNombreDePila(String nombreDePila) {
		this.nombreDePila = nombreDePila;
	}	
	
	@Override
	public String toString(){
		return this.nombreDePila + " " + this.apellidoPaterno;
	}
}

