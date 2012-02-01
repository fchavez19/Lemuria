package mx.edu.uaemex.fi.poo.lemuria.modelo;

import java.util.Observable;

import mx.edu.uaemex.fi.poo.lemuria.modelo.error.BolsaLlenaException;
import mx.edu.uaemex.fi.poo.lemuria.modelo.error.ItemNoEncontradoException;
import mx.edu.uaemex.fi.poo.lemuria.modelo.error.ManoOcupadaException;
import mx.edu.uaemex.fi.poo.lemuria.modelo.error.TuEstasMuertoException;

// ESCA-JAVA0137:
/**
 * Clase que encapcula las caracter&iacute;sticas comunes a todos los personajes.
 * @author fchavez Francisco Ch&aacute;vez Casta&ntilde;eda.
 * @version 0.1
 */
public class Personaje extends Observable{
	/**
	 * Nombre del personaje.
	 */
	private String nombre;
	/**
	 * Bolsa donde almacenar&aacute;n distintos Items.
	 */
	private Bolsa bolsa;
	/**
	 * Nivel que marca la fuerza del ataque del personaje.
	 */
	protected long nivelDePoder;
	/**
	 * Nivel de salud, del personaje. B&aacute;sicamente cuanta vida te queda.
	 */
	protected long nivelDeSalud;
	/**
	 * Espacio para almacenar un Item.
	 */
	protected Item itemEnMano;
	
	/**
	 * Consulta el nombre.
	 * @return Nombre del personaje.
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Establece el nombre del personaje.
	 * @param nombre Nombre del personaje.
	 */
	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Aumenta el nivel del poder.
	 * @param poder Nivel de poder a aumentar.
	 */
	public void incrementaPoder(long poder){
		this.nivelDePoder += poder;
	}
	/**
	 * Decrementa el nivel de poder.
	 * @param despoder Nivel de poder a decrementar.
	 */
	public void decrementaPoder(long despoder){
		this.nivelDePoder -= despoder;
		if(this.nivelDePoder < 0){
			this.nivelDePoder = 0;
		}
	}
	/**
	 * Aumenta el nivel de salud.
	 * @param salud Nivel de salud a aumentar.
	 */
	public void incrementaSalud(long salud){
		this.nivelDeSalud += salud;
		this.setChanged();
		this.notifyObservers();
	}
	/**
	 * Decrementa el nivel de salud.
	 * @param enfermedad Nivel de salud a decrementar.
	 * @throws TuEstasMuertoException 
	 */
	public void decrementaSalud(long enfermedad) throws TuEstasMuertoException{
		this.nivelDeSalud -= enfermedad;
		this.setChanged();
		this.notifyObservers();
		if(this.nivelDeSalud <= 0){
			this.nivelDeSalud = 0;
			throw new TuEstasMuertoException();
		}
	}
	/**
	 * Pasa el Item que est&aacute; en la mano del personaje a la bolsa.
	 * @throws BolsaLlenaException Error cuando se intenta guardar un Item en la bolsa llena.
	 */
	public void guardaItem() throws BolsaLlenaException{
		this.bolsa.addItem(this.itemEnMano);
		this.itemEnMano = null;
	}
	/**
	 * Recoge un Item del escenario y lo guarda en la bolsa.
	 * @param it Item a recoger.
	 * @throws BolsaLlenaException Error cuando se intenta guardar un Item en la bolsa llena.
	 */
	public void pickUpItem(Item it) throws BolsaLlenaException{
		this.bolsa.addItem(it);
	}
	/**
	 * Consulta el nivel de salud del personaje.
	 * @return Nivel de salud del personaje.
	 */
	public long getNivelDeSalud() {
		return nivelDeSalud;
	}
	/**
	 * Toma un item de la bolsa.
	 * @param it Item a sacar de la bolsa y poner en la mano.
	 * @throws ItemNoEncontradoException En caso de no encontrar el Item en la bolsa.
	 * @throws ManoOcupadaException En caso de intentar tomar un item de la bolsa cuando el 
	 * personaje tiene la mano ocupada. 
	 */
	public void takeItem(Item it) throws ItemNoEncontradoException, ManoOcupadaException{		
		if(this.itemEnMano == null){
			int n = this.bolsa.find(it.getNombre());
			this.itemEnMano = this.bolsa.dropItem(n);
		} else {
			throw new ManoOcupadaException();
		}
	}
	
	public long getNivelDePoder() {
		return nivelDePoder;
	}
	
	public void setNivelDePoder(long nivelDePoder) {
		this.nivelDePoder = nivelDePoder;
		this.setChanged();
		this.notifyObservers();
	}
	public void setNivelDeSalud(long nivelDeSalud) {
		this.nivelDeSalud = nivelDeSalud;
		this.setChanged();
		this.notifyObservers();
	}
	public Bolsa getBolsa() {
		return bolsa;
	}
	public void setBolsa(Bolsa bolsa) {
		this.bolsa = bolsa;
	}
	public Item getItemEnMano() {
		return itemEnMano;
	}
	public void setItemEnMano(Item itemEnMano) {
		this.itemEnMano = itemEnMano;
	}
	
	public Personaje(){
		this.bolsa = new Bolsa();
	}
}
