package jass.juegos.rochess.principal;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Sprite {

	private int height, width;
	private Bitmap imagen;
	private Rect posicion, actualSource, inactiveSource, selectedSource;
	private int xInicial=0, yInicial=0; 

	public Sprite(Bitmap casilla, Rect rect) {
		this.imagen=casilla;
		this.inactiveSource=rect;
		this.actualSource=rect;
		this.width=actualSource.width();
		this.height=actualSource.height();
	}

	public boolean contains(int x, int y){
		return posicion.contains(x,y);
	}

	public void draw(Canvas canvas) {
		canvas.drawBitmap(imagen, actualSource,posicion, null);
	}

	public void draw(Canvas canvas, Rect rectanguloDestino) {
		this.posicion=rectanguloDestino;
		canvas.drawBitmap(imagen, actualSource,posicion, null);
	}

	public void setPosition(int xInicio, int yInicio) {
		this.xInicial=xInicio-width/2;
		this.yInicial=yInicio-height/2;
		this.posicion= new Rect(xInicial,yInicial,xInicial+width,yInicial+height);
	}

	public void setPosition(Rect posicionFinal) {
		this.posicion= posicionFinal;
	}

	public void setSelected(boolean estado){
		if(estado){
			this.actualSource=selectedSource;
			return;
		}
		this.actualSource=inactiveSource;
	}
	
	public void setSelectedSource(Rect source){
			this.selectedSource=source;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}
}  
