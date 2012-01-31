package jass.juegos.rochess.principal;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Vector;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class MotorJuego extends Thread{
	private VentanaJuego ventanaJuego;
	private Tablero tablero;
	private boolean activo = false;

	public MotorJuego(VentanaJuego ventanaJuego){
		this.ventanaJuego=ventanaJuego;
	}

	public void setActivo(boolean activo){
		this.activo=activo;
	}

	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}

	public void run(){
		while(activo){
			Canvas canvas = null;
			try {
				canvas = ventanaJuego.getHolder().lockCanvas();
				synchronized (ventanaJuego.getHolder()) {
					canvas.drawColor(Color.BLACK);
					tablero.drawTablero(canvas);
				}
			} finally {
				if (canvas != null) {
					ventanaJuego.getHolder().unlockCanvasAndPost(canvas);
				}
			}
		}
	}

	public void displayRango(Vector<Integer> cuadros){
	}

	public void displaySeleccion(int pos){
	}

	public void startDrag(float x, float y){
	}

	public void stopDrag(){
		return;
	}

}