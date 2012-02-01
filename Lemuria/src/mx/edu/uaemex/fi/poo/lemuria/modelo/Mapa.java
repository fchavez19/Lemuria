package mx.edu.uaemex.fi.poo.lemuria.modelo;

import java.awt.Color;
import java.io.File;
import java.io.Serializable;
import java.util.Observable;

import javax.imageio.ImageIO;

public class Mapa extends Observable implements Serializable{
	private String[][] propiedades;
	
	private final int limiteX=3;
	private final int limiteY=2;
	
	private final int limiteMatriz=12;
	
	private int coordenadaX=0;
	private int coordenadaY=0;

	public Mapa(){

		propiedades = new String[12][6];
		propiedades[0][0]="0";
		propiedades[0][1]="0";
		propiedades[0][2] ="selva.jpg";
		propiedades[0][3] =null;
		propiedades[0][4] =null;
		propiedades[0][5] =null;
		
		propiedades[1][0]="0";
		propiedades[1][1]="1";
		propiedades[1][2] ="EntradaCueva.jpg";
		propiedades[1][3] ="gnomo.png";
		propiedades[1][4] ="Arma daga";
		propiedades[1][5] ="1";

		propiedades[2][0]="0";
		propiedades[2][1]="2";
		propiedades[2][2] ="caverna_1.jpg";
		propiedades[2][3] ="duende1.png";
		propiedades[2][4] ="Posion salud";
		propiedades[2][5] ="30";

		propiedades[3][0]="1";
		propiedades[3][1]="0";
		propiedades[3][2] ="castillo.jpg";
		propiedades[3][3] ="gnomog.png";
		propiedades[3][4] ="Arma espada";
		propiedades[3][5] ="2";
		
		propiedades[4][0]="1";
		propiedades[4][1]="1";
		propiedades[4][2] ="cascada.jpg";
		propiedades[4][3] ="TrollGarrote.png";
		propiedades[4][4] ="Princesa";
		propiedades[4][5] =null;
		
		propiedades[5][0]="1";
		propiedades[5][1]="2";
		propiedades[5][2] ="mar.jpg";
		propiedades[5][3] ="TrollGarrote.png";
		propiedades[5][4] ="Arma ballesta";
		propiedades[5][5] = "5";
		
		propiedades[6][0]="2";
		propiedades[6][1]="0";
		propiedades[6][2] ="sierra.jpg";
		propiedades[6][3] ="TrollGarrote.png";
		propiedades[6][4] =null;
		propiedades[6][5] =null;
		
		propiedades[7][0]="2";
		propiedades[7][1]="1";
		propiedades[7][2] ="EntradaTemplo.jpg";
		propiedades[7][3] ="TrollGarrote.png";
		propiedades[7][4] =null;
		propiedades[7][5] =null;
		
		propiedades[8][0]="2";
		propiedades[8][1]="2";
		propiedades[8][2] ="CuadrilateroDragonball.jpg";
		propiedades[8][3] ="TrollGarrote.png";
		propiedades[8][4] ="Item esteroides";
		propiedades[8][5] =null;
		
		propiedades[9][0]="3";
		propiedades[9][1]="0";
		propiedades[9][2] ="nieve.jpg";
		propiedades[9][3] ="TrollGarrote.png";
		propiedades[9][4] ="Arma arco";
		propiedades[9][5] = "3";
		
		propiedades[10][0]="3";
		propiedades[10][1]="1";
		propiedades[10][2] ="Puerto.jpg";
		propiedades[10][3] ="TrollGarrote.png";
		propiedades[10][4] =null;
		propiedades[10][5] =null;
		
		propiedades[11][0]="3";
		propiedades[11][1]="2";
		propiedades[11][2] ="Desierto.jpg";
		propiedades[11][3] ="TrollGarrote.png";
		propiedades[11][4] ="Posion salud";
		propiedades[11][5] ="60";
	}

	public void Actualizado(){
		this.setChanged();
		this.notifyObservers();
	}
	
	public void CargarMapa(){
		this.setChanged();
		this.notifyObservers("cargar mapa");
	}

	public String[][] getPropiedades() {
		return propiedades;
	}

	public void setPropiedades(String[][] propiedades) {
		this.propiedades = propiedades;
	}

	public int getLimiteX() {
		return limiteX;
	}

	public int getLimiteY() {
		return limiteY;
	}
	
	public int getCoordenadaX() {
		return coordenadaX;
	}

	public void setCoordenadaX(int coordenadaX) {
		this.coordenadaX = coordenadaX;
	}

	public int getCoordenadaY() {
		return coordenadaY;
	}

	public void setCoordenadaY(int coordenadaY) {
		this.coordenadaY = coordenadaY;
	}

	public int getLimiteMatriz() {
		return limiteMatriz;
	}

}
