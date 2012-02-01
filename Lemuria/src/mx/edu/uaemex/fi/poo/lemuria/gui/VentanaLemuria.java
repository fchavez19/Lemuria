package mx.edu.uaemex.fi.poo.lemuria.gui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import mx.edu.uaemex.fi.poo.lemuria.gameadmin.modelo.Jugador;

// ESCA-JAVA0011:
/**
 * Clase abstracta que encapsula el comporatmiento com&uacute;n de las ventanas
 * del juego Lemuria.
 * @author fchavez fchavez Francisco Ch&aacute;vez Casta&ntilde;eda.
 * @version 0.1
 */

public abstract class VentanaLemuria extends JFrame implements Observer {
	/**
	 * Deafult serial version UID.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Objeto jugador que servir&aacute; como modelo en el GUI.
	 */
	private Jugador playerModel;
	
	public VentanaLemuria(){
		super("Lemuria");
		BufferedImage icon;
		try {
			icon = ImageIO.read(new File("lemurIcon.jpg"));
			this.setIconImage(icon);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Juego atrofiado por favor, restaurar version");
		}
	}

	/**
	 * Establece el modelo.
	 * @param j Jugador que actua como modelo.
	 */
	
	public void setPlayerModel(Jugador j) {
		this.playerModel = j;
		this.playerModel.addObserver(this);
	}
	/**
	 * Consulta el jugador actual del juego.
	 * @return Jugador actual.
	 */
	protected Jugador getPlayerModel(){
		return this.playerModel;
	}
}
