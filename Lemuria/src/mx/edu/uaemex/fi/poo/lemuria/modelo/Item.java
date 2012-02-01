package mx.edu.uaemex.fi.poo.lemuria.modelo;

// ESCA-JAVA0137:
/**
 * Clase abstrcta que representa "cosas" en el juego.
 * @author fchavezFrancisco Ch&aacute;vez Casta&ntilde;eda.
 * @version 0.1
 */
public class Item {
	/**
	 * Nombre del item.
	 */
	protected String nombre;
	/**
	 * Valor que determina el Tipo de Item.
	 */
	protected int tipo;
	
	public Item(){
		
	}
	
	public Item(String n){
		this.nombre=n;
	}
	
	/**
	 * Consulta el nombre.
	 * @return Nombre.
	 */
	
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Establece el nombre.
	 * @param nombre Nombre del Item.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Consulta el tipo.
	 * @return Tipo del Item.
	 */
	public int getTipo() {
		return tipo;
	}
}
