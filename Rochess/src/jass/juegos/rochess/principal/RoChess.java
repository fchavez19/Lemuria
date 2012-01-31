package jass.juegos.rochess.principal
;

import java.util.HashMap;
import java.util.Random;
import java.util.Vector;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class RoChess {

	private MotorJuego motorJuego;
	private Pieza pieza=null;
	private VentanaJuego ventanaJuego;	
	private Tablero tablero;

	private int casillaSeleccionada;
	private int posicionOriginalPieza=-1;

	private int[] movimientosCaballo = {6, 15, -17, -10, 10, 17, -15, -6};
	private Vector<Integer> casillasSeleccionadas = new Vector<Integer>();

	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}

	public void setVentanaJuego(VentanaJuego ventanaJuego) {
		this.ventanaJuego = ventanaJuego;
	}


	public void initMotor(){
		motorJuego = new MotorJuego(ventanaJuego);
		motorJuego.setTablero(tablero);
		motorJuego.setActivo(true);
		motorJuego.start();
	}

	public boolean actionDown(float x, float y){
		if(tablero.getPiezaAt(x, y)!=pieza){
			if(pieza!=null){
				pieza.setSelected(false);
			}
		}
		pieza = this.tablero.getPiezaAt(x, y);

		posicionOriginalPieza = tablero.getCasillaAt((int)x, (int)y);
		tablero.addPieza(null, posicionOriginalPieza);
		if(pieza!=null){
			pieza.setSelected(true);
			displayRango();
			return true;
		}
		return false;
	}

	public void startDrag(float x, float y){
		pieza.setPosition((int)x,(int)y);
	}

	public void stopDrag(float x, float y){
		tablero.resetCasillas(casillasSeleccionadas);
		int i=tablero.getCasillaAt((int)x,(int)y);
		if( i >-1){
			if( (tablero.getPiezaAt(i)==null) && (compruebaCasillaFinal(i))){
				tablero.addPieza(pieza, i);
				pieza.setPosition(tablero.getRectanguloAt(i));
				return;
			}
		}
		tablero.addPieza(pieza, posicionOriginalPieza);
		pieza.setPosition(tablero.getRectanguloAt(posicionOriginalPieza));
		casillasSeleccionadas.removeAllElements();
	}

	public void displayRango(){
		if(pieza.getNombre().equals("caballo")){
			int casillaPosible;
			Sprite sprite;
			for(int i=0; i<movimientosCaballo.length; i++){
				casillaPosible= posicionOriginalPieza+movimientosCaballo[i];
				if( casillaPosible > -1 && (tablero.getPiezaAt(casillaPosible)==null) && casillaPosible<48){
					casillasSeleccionadas.add(casillaPosible);
					sprite = tablero.getCasillaAt(casillaPosible);
					sprite.setSelected(true);
				}
			}
		}
	}

	public boolean compruebaCasillaFinal(int casillaFinal){
		int i;
		for(i=0; i<casillasSeleccionadas.size(); i++){
				if(casillaFinal == casillasSeleccionadas.get(i)){
					return true;
				}
			}
		return false;
	}
}