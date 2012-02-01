package mx.edu.uaemex.fi.poo.lemuria.modelo;

import java.util.Observable;

import javax.swing.JOptionPane;

import mx.edu.uaemex.fi.poo.lemuria.modelo.error.BolsaLlenaException;
import mx.edu.uaemex.fi.poo.lemuria.modelo.error.ItemNoEncontradoException;

/**
 * Clase que representa un bolsa para almacenar objetos.
 * @author fchavez Francisco Ch&aacute;vez Casta&ntilde;eda.
 * @version 0.1
 */

public class Bolsa extends Observable {
	/**
	 * Contenedor de objetos;
	 */
	private Object[] contenido;

	/**
	 * Constructora sin par&aacute;metros, su misi&oacute;n es crear el 
	 * contenedor.
	 */
	public Bolsa(){
		contenido = new Object[10];		
	}
	/**
	 * Agrega un Item a la bolsa.
	 * @param coso Item a agregar a la bolsa.
	 * @throws BolsaLlenaException en caso de intentar agregar un item a la bolsa,
	 * cuando ya est&aacute; llena.
	 */

	public void addItem(Item coso) throws BolsaLlenaException{
		for(int i = 0; i < contenido.length; i++){
			if(contenido[i] == null){
				contenido[i] = coso;
				if(coso instanceof Item){
					JOptionPane.showMessageDialog(null, "Te ganaste: " + coso.getNombre(), "Item añadido", JOptionPane.INFORMATION_MESSAGE);
				}
				if(coso instanceof Posion){
					System.out.println("Se agregó una :" + ((Posion)coso).getNombre());
					JOptionPane.showMessageDialog(null, "Recogiste una: " + ((Posion)coso).getNombre(), "Item añadido", JOptionPane.INFORMATION_MESSAGE);
				}
				else if(coso instanceof Arma){
					JOptionPane.showMessageDialog(null, "Recogiste: " + coso.getNombre() + " con nivel de poder: " + ((Arma) coso).getPoder(), "Item añadido", JOptionPane.INFORMATION_MESSAGE);
				}
				this.setChanged();
				this.notifyObservers(coso);
				return;
			}
		}
		throw new BolsaLlenaException();
	}

	/**
	 * Saca un item de la bolsa.
	 * @param it Item que se desa sacar.	
	 * @return	Item sacado.
	 * @throws ItemNoEncontradoException En caso de que se solicite sacar 
	 * un item que <i>no</i> se encuentra en la bolsa.
	 */
	public Item dropItem(Item it) throws ItemNoEncontradoException{
		if(it == null){
			throw new ItemNoEncontradoException();
		}
		int i = this.find(it.getNombre());
		return this.dropItem(i);
	}

	/**
	 * Saca un item de la bolsa.
	 * @param pos Posici&oacute;n en la colecci&oacute;n del item que se 
	 * desea sacar.
	 * @return Item sacado.
	 */
	public Item dropItem(int pos){
		Item res = (Item) this.contenido[pos];
		this.contenido[pos] = null;
		if(res instanceof Arma){
			JOptionPane.showMessageDialog(null, "Te robaron tu: " + res.getNombre(), "Item robado", JOptionPane.INFORMATION_MESSAGE);
		}
		if(res instanceof Item){
			if(res.getNombre().compareTo("esteroides")==0){
				JOptionPane.showMessageDialog(null, "Haz usado : " + res.getNombre() + " tu ataque se ha duplicado a cambio de perder la mitad de tu vida [sólo dura un turno]", "Item usado", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else{
			JOptionPane.showMessageDialog(null, "Te haz bebido tu: " + res.getNombre(), "Item usado", JOptionPane.INFORMATION_MESSAGE);
		}
		this.setChanged();
		this.notifyObservers(res);
		return res;
	}
	/**
	 * Localiza un item en la bolsa.
	 * @param nom Nombre del Item a localizar.
	 * @return	Item sacdo.
	 * @throws ItemNoEncontradoException En caso de que se solicite sacar 
	 * un item que <i>no</i> se encuentra en la bolsa.
	 */
	public int find(String nom) throws ItemNoEncontradoException{
		for(int i = 0; i < contenido.length; i++){
			if(contenido[i] != null){
				Item coso = (Item) contenido[i];
				if(coso.getNombre().compareToIgnoreCase(nom) == 0){
					return i;
				}
			}
		}
		throw new ItemNoEncontradoException();
	}

	public int showArmeria(){
		int i;
		int cuenta=0;
		for(i=0;i<contenido.length;i++){
			if(contenido[i]!=null){
				Arma arma= (Arma)(contenido[i]);
				System.out.println("Tienes un: " + arma.getNombre());
				cuenta++;
			}
		}
		if(cuenta ==0){
			System.out.println("No tienes items en la armería");
		}
		return cuenta;
	}

	public int showItems(){
		int i;
		int cuenta=0;
		for(i=0;i<contenido.length;i++){
			if(contenido[i]!=null){
				Item item= (Item)(contenido[i]);
				System.out.println("Tienes un: " + item.getNombre());
				cuenta++;
			}
		}
		if(cuenta ==0){
			System.out.println("No tienes items en la bolsa");
		}
		return cuenta;
	}

	public Object[] getContenido() {
		return contenido;
	}
	public void setContenido(Object[] contenido) {
		this.contenido = contenido;
	}



}
