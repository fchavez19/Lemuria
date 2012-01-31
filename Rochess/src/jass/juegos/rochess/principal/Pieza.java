package jass.juegos.rochess.principal;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;

public class Pieza {
	private Color color;
	private String nombre;
	private int poder;
	private int puntosHabilidad;
	private Habilidad habilidad;
	private String raza;
	private Sprite sprite;
	
	public Pieza(String nombre, Sprite sprite){
		this.sprite=sprite;
		this.nombre=nombre;
	}
	
	public void draw(Canvas canvas){
		this.sprite.draw(canvas);
	}
	
	public void setPosition(Rect rectPosicionFinal){
		this.sprite.setPosition(rectPosicionFinal);
	}
	
	public void setPosition(int x, int y){
		this.sprite.setPosition(x, y);
	}
		
	public void setSelected(boolean estado){
		sprite.setSelected(estado);
	}

	public String getNombre() {
		return nombre;
	}
	
}