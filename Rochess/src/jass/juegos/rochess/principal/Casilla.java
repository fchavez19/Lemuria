package jass.juegos.rochess.principal;

import android.graphics.Canvas;
import android.graphics.Rect;

public class Casilla {
	boolean ocuppied = false;
	boolean selected = false;
	private Sprite sprite;
	private Rect posicion;
	
	public Casilla(Sprite sprite){
		this.sprite=sprite;
	}
	
	public void setOcuppied(boolean state) {
		this.ocuppied = state;
	}
	
	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}
	
	public void setPosicion(Rect posicion) {
		this.posicion = posicion;
	}
	
	public boolean isOcuppied() {
		return ocuppied;
	}

	public boolean isSelected() {
		return selected;
	}

	public void draw(Canvas canvas){
		this.sprite.draw(canvas);
	}
}
