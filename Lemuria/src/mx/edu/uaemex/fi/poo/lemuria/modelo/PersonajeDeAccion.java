package mx.edu.uaemex.fi.poo.lemuria.modelo;

import mx.edu.uaemex.fi.poo.lemuria.modelo.error.BolsaLlenaException;

// ESCA-JAVA0137:
// ESCA-JAVA0114:
/**
 * Personaje que si establece peleas.
 * @author fchavez Francisco Ch&aacute;vez Casta&ntilde;eda.
 */
public class PersonajeDeAccion extends Personaje {
	/**
	 * Bolsa especial para armas.
	 */
	protected Bolsa armeria;
	/**
	 * Defiendete.
	 * @return cantidad de salud que servir&aacute; como defensa.
	 */
	public long defiende(){
		return this.getNivelDeSalud();
	}
	/**
	 * Muestra tu poder para el ataque.
	 * @return Nivel de poder de ataque.
	 */
	
	public PersonajeDeAccion(){
		super();
		this.armeria= new Bolsa();
	}
	public long ataca(){
		if(this.itemEnMano != null && this.itemEnMano instanceof Arma){
			Arma arma = (Arma) this.itemEnMano;
			return this.nivelDePoder + arma.getPoder();
		}
		return this.nivelDePoder;
	}
	/**
	 * Pasa el Item que est&aacute; en la mano del personaje a la bolsa. Si el Item
	 * es de tipo Arma se almacena en la armeria, de lo contrario se almacena en la bolsa
	 * de items comunes.
	 * @throws BolsaLlenaException Error cuando se intenta guardar un Item en la bolsa llena.
	 */
	public void guardaItem() throws BolsaLlenaException{
		if(this.itemEnMano != null){
			if(this.itemEnMano instanceof Arma){
				this.armeria.addItem(this.itemEnMano);
				this.itemEnMano = null;
			} else {
				super.guardaItem();
			}
		}
	}
	/**
	 * Recoge un Item del escenario. Si el Item
	 * es de tipo Arma se almacena en la armeria, de lo contrario se almacena en la bolsa
	 * de items comunes.
	 * @param it Item a recoger.
	 * @throws BolsaLlenaException Error cuando se intenta guardar un Item en la bolsa llena.
	 */
	public void pickUpItem(Item it) throws BolsaLlenaException{		
		if(it instanceof Arma){
			this.armeria.addItem(it);
		} else {
			super.pickUpItem(it);
		}
	}
	
	public Bolsa getArmeria() {
		return armeria;
	}
	public void setArmeria(Bolsa armeria) {
		this.armeria = armeria;
	}	
	
	
	
}
