package jass.juegos.rochess.principal;

import java.util.HashMap;
import java.util.Vector;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class Tablero {
	private Sprite casilla0, casilla1, casilla2, casilla3, casilla4, casilla5, casilla6, casilla7;
	private Sprite casilla8, casilla9, casilla10, casilla11, casilla12, casilla13, casilla14, casilla15;
	private Sprite casilla16, casilla17, casilla18, casilla19, casilla20, casilla21, casilla22, casilla23;
	private Sprite casilla24, casilla25, casilla26, casilla27, casilla28, casilla29, casilla30, casilla31;
	private Sprite casilla32, casilla33, casilla34, casilla35, casilla36, casilla37, casilla38, casilla39;
	private Sprite casilla40, casilla41, casilla42, casilla43, casilla44, casilla45, casilla46, casilla47;
	private Sprite spriteCaballo, spriteCaballo2;

	private Bitmap casilla, caballo, caballoSelected;

	private HashMap<Integer,Pieza> mapaPosiciones = new HashMap<Integer,Pieza>();
	private HashMap<Integer, Rect> mapaCoordenadas = new HashMap<Integer,Rect>();
	private HashMap<Integer, Sprite> mapaCasillas = new HashMap<Integer, Sprite>();
	
	private Pieza ultimaPiezaUsada;

	private int anchoTablero, panelIzquierdo, anchoCasilla;

	private Pieza piezaCaballo, piezaCaballo2;

	public void addPieza(Pieza pieza, int posicion){
		mapaPosiciones.put(posicion,pieza);
	}

	public int size(){
		return mapaPosiciones.size();
	}

	public void initCoordenadas(int anchoPantalla, int altoPantalla){
		anchoTablero = anchoPantalla / 2;
		panelIzquierdo = anchoPantalla / 4;
		anchoCasilla = anchoTablero / 8 +5;

		mapaCoordenadas.put(0, new Rect(panelIzquierdo, 10, panelIzquierdo+anchoCasilla,10+anchoCasilla));
		mapaCoordenadas.put(1, new Rect(panelIzquierdo+anchoCasilla, 10, panelIzquierdo+anchoCasilla*2,10+anchoCasilla));
		mapaCoordenadas.put(2, new Rect(panelIzquierdo+anchoCasilla*2, 10, panelIzquierdo+anchoCasilla*3,10+anchoCasilla));
		mapaCoordenadas.put(3, new Rect(panelIzquierdo+anchoCasilla*3, 10, panelIzquierdo+anchoCasilla*4,10+anchoCasilla));
		mapaCoordenadas.put(4, new Rect(panelIzquierdo+anchoCasilla*4, 10, panelIzquierdo+anchoCasilla*5,10+anchoCasilla));
		mapaCoordenadas.put(5, new Rect(panelIzquierdo+anchoCasilla*5, 10, panelIzquierdo+anchoCasilla*6,10+anchoCasilla));
		mapaCoordenadas.put(6, new Rect(panelIzquierdo+anchoCasilla*6, 10, panelIzquierdo+anchoCasilla*7,10+anchoCasilla));
		mapaCoordenadas.put(7, new Rect(panelIzquierdo+anchoCasilla*7, 10, panelIzquierdo+anchoCasilla*8,10+anchoCasilla));

		mapaCoordenadas.put(8, new Rect(panelIzquierdo, 10+anchoCasilla, panelIzquierdo+anchoCasilla,10+anchoCasilla*2));
		mapaCoordenadas.put(9, new Rect(panelIzquierdo+anchoCasilla, 10+anchoCasilla, panelIzquierdo+anchoCasilla*2,10+anchoCasilla*2));
		mapaCoordenadas.put(10, new Rect(panelIzquierdo+anchoCasilla*2, 10+anchoCasilla, panelIzquierdo+anchoCasilla*3,10+anchoCasilla*2));
		mapaCoordenadas.put(11, new Rect(panelIzquierdo+anchoCasilla*3, 10+anchoCasilla, panelIzquierdo+anchoCasilla*4,10+anchoCasilla*2));
		mapaCoordenadas.put(12, new Rect(panelIzquierdo+anchoCasilla*4, 10+anchoCasilla, panelIzquierdo+anchoCasilla*5,10+anchoCasilla*2));
		mapaCoordenadas.put(13, new Rect(panelIzquierdo+anchoCasilla*5, 10+anchoCasilla, panelIzquierdo+anchoCasilla*6,10+anchoCasilla*2));
		mapaCoordenadas.put(14, new Rect(panelIzquierdo+anchoCasilla*6, 10+anchoCasilla, panelIzquierdo+anchoCasilla*7,10+anchoCasilla*2));
		mapaCoordenadas.put(15, new Rect(panelIzquierdo+anchoCasilla*7, 10+anchoCasilla, panelIzquierdo+anchoCasilla*8,10+anchoCasilla*2));

		mapaCoordenadas.put(16, new Rect(panelIzquierdo, 10+anchoCasilla*2, panelIzquierdo+anchoCasilla,10+anchoCasilla*3));
		mapaCoordenadas.put(17, new Rect(panelIzquierdo+anchoCasilla, 10+anchoCasilla*2, panelIzquierdo+anchoCasilla*2,10+anchoCasilla*3));
		mapaCoordenadas.put(18, new Rect(panelIzquierdo+anchoCasilla*2, 10+anchoCasilla*2, panelIzquierdo+anchoCasilla*3,10+anchoCasilla*3));
		mapaCoordenadas.put(19, new Rect(panelIzquierdo+anchoCasilla*3, 10+anchoCasilla*2, panelIzquierdo+anchoCasilla*4,10+anchoCasilla*3));
		mapaCoordenadas.put(20, new Rect(panelIzquierdo+anchoCasilla*4, 10+anchoCasilla*2, panelIzquierdo+anchoCasilla*5,10+anchoCasilla*3));
		mapaCoordenadas.put(21, new Rect(panelIzquierdo+anchoCasilla*5, 10+anchoCasilla*2, panelIzquierdo+anchoCasilla*6,10+anchoCasilla*3));
		mapaCoordenadas.put(22, new Rect(panelIzquierdo+anchoCasilla*6, 10+anchoCasilla*2, panelIzquierdo+anchoCasilla*7,10+anchoCasilla*3));
		mapaCoordenadas.put(23, new Rect(panelIzquierdo+anchoCasilla*7, 10+anchoCasilla*2, panelIzquierdo+anchoCasilla*8,10+anchoCasilla*3));

		mapaCoordenadas.put(24, new Rect(panelIzquierdo, 10+anchoCasilla*3, panelIzquierdo+anchoCasilla,10+anchoCasilla*4));
		mapaCoordenadas.put(25, new Rect(panelIzquierdo+anchoCasilla, 10+anchoCasilla*3, panelIzquierdo+anchoCasilla*2,10+anchoCasilla*4));
		mapaCoordenadas.put(26, new Rect(panelIzquierdo+anchoCasilla*2, 10+anchoCasilla*3, panelIzquierdo+anchoCasilla*3,10+anchoCasilla*4));
		mapaCoordenadas.put(27, new Rect(panelIzquierdo+anchoCasilla*3, 10+anchoCasilla*3, panelIzquierdo+anchoCasilla*4,10+anchoCasilla*4));
		mapaCoordenadas.put(28, new Rect(panelIzquierdo+anchoCasilla*4, 10+anchoCasilla*3, panelIzquierdo+anchoCasilla*5,10+anchoCasilla*4));
		mapaCoordenadas.put(29, new Rect(panelIzquierdo+anchoCasilla*5, 10+anchoCasilla*3, panelIzquierdo+anchoCasilla*6,10+anchoCasilla*4));
		mapaCoordenadas.put(30, new Rect(panelIzquierdo+anchoCasilla*6, 10+anchoCasilla*3, panelIzquierdo+anchoCasilla*7,10+anchoCasilla*4));
		mapaCoordenadas.put(31, new Rect(panelIzquierdo+anchoCasilla*7, 10+anchoCasilla*3, panelIzquierdo+anchoCasilla*8,10+anchoCasilla*4));

		mapaCoordenadas.put(32, new Rect(panelIzquierdo, 10+anchoCasilla*4, panelIzquierdo+anchoCasilla,10+anchoCasilla*5));
		mapaCoordenadas.put(33, new Rect(panelIzquierdo+anchoCasilla, 10+anchoCasilla*4, panelIzquierdo+anchoCasilla*2,10+anchoCasilla*5));
		mapaCoordenadas.put(34, new Rect(panelIzquierdo+anchoCasilla*2, 10+anchoCasilla*4, panelIzquierdo+anchoCasilla*3,10+anchoCasilla*5));
		mapaCoordenadas.put(35, new Rect(panelIzquierdo+anchoCasilla*3, 10+anchoCasilla*4, panelIzquierdo+anchoCasilla*4,10+anchoCasilla*5));
		mapaCoordenadas.put(36, new Rect(panelIzquierdo+anchoCasilla*4, 10+anchoCasilla*4, panelIzquierdo+anchoCasilla*5,10+anchoCasilla*5));
		mapaCoordenadas.put(37, new Rect(panelIzquierdo+anchoCasilla*5, 10+anchoCasilla*4, panelIzquierdo+anchoCasilla*6,10+anchoCasilla*5));
		mapaCoordenadas.put(38, new Rect(panelIzquierdo+anchoCasilla*6, 10+anchoCasilla*4, panelIzquierdo+anchoCasilla*7,10+anchoCasilla*5));
		mapaCoordenadas.put(39, new Rect(panelIzquierdo+anchoCasilla*7, 10+anchoCasilla*4, panelIzquierdo+anchoCasilla*8,10+anchoCasilla*5));

		mapaCoordenadas.put(40, new Rect(panelIzquierdo, 10+anchoCasilla*5, panelIzquierdo+anchoCasilla,10+anchoCasilla*6));
		mapaCoordenadas.put(41, new Rect(panelIzquierdo+anchoCasilla, 10+anchoCasilla*5, panelIzquierdo+anchoCasilla*2,10+anchoCasilla*6));
		mapaCoordenadas.put(42, new Rect(panelIzquierdo+anchoCasilla*2, 10+anchoCasilla*5, panelIzquierdo+anchoCasilla*3,10+anchoCasilla*6));
		mapaCoordenadas.put(43, new Rect(panelIzquierdo+anchoCasilla*3, 10+anchoCasilla*5, panelIzquierdo+anchoCasilla*4,10+anchoCasilla*6));
		mapaCoordenadas.put(44, new Rect(panelIzquierdo+anchoCasilla*4, 10+anchoCasilla*5, panelIzquierdo+anchoCasilla*5,10+anchoCasilla*6));
		mapaCoordenadas.put(45, new Rect(panelIzquierdo+anchoCasilla*5, 10+anchoCasilla*5, panelIzquierdo+anchoCasilla*6,10+anchoCasilla*6));
		mapaCoordenadas.put(46, new Rect(panelIzquierdo+anchoCasilla*6, 10+anchoCasilla*5, panelIzquierdo+anchoCasilla*7,10+anchoCasilla*6));
		mapaCoordenadas.put(47, new Rect(panelIzquierdo+anchoCasilla*7, 10+anchoCasilla*5, panelIzquierdo+anchoCasilla*8,10+anchoCasilla*6));
	}

	public void initSprites(VentanaJuego ventanaJuego){
		caballo=BitmapFactory.decodeResource(ventanaJuego.getResources(),R.drawable.caballo_selected);
		casilla = BitmapFactory.decodeResource(ventanaJuego.getResources(),R.drawable.celda);
		casilla0 = new Sprite(casilla, new Rect(casilla.getWidth()/3,0,(casilla.getWidth()/3)*2,casilla.getHeight()));
		casilla0.setSelectedSource( new Rect((casilla.getWidth()/3)*2,0,(casilla.getWidth()/3)*3,casilla.getHeight()));
		casilla1 = new Sprite(casilla, new Rect(0,0,casilla.getWidth()/3,casilla.getHeight()));
		casilla1.setSelectedSource( new Rect((casilla.getWidth()/3)*2,0,(casilla.getWidth()/3)*3,casilla.getHeight()));
		casilla2 = new Sprite(casilla, new Rect(casilla.getWidth()/3,0,(casilla.getWidth()/3)*2,casilla.getHeight()));
		casilla2.setSelectedSource( new Rect((casilla.getWidth()/3)*2,0,(casilla.getWidth()/3)*3,casilla.getHeight()));
		casilla3 = new Sprite(casilla, new Rect(0,0,casilla.getWidth()/3,casilla.getHeight()));
		casilla3.setSelectedSource( new Rect((casilla.getWidth()/3)*2,0,(casilla.getWidth()/3)*3,casilla.getHeight()));
		casilla4 = new Sprite(casilla, new Rect(casilla.getWidth()/3,0,(casilla.getWidth()/3)*2,casilla.getHeight()));
		casilla4.setSelectedSource( new Rect((casilla.getWidth()/3)*2,0,(casilla.getWidth()/3)*3,casilla.getHeight()));
		casilla5 = new Sprite(casilla, new Rect(0,0,casilla.getWidth()/3,casilla.getHeight()));
		casilla5.setSelectedSource( new Rect((casilla.getWidth()/3)*2,0,(casilla.getWidth()/3)*3,casilla.getHeight()));
		casilla6 = new Sprite(casilla, new Rect(casilla.getWidth()/3,0,(casilla.getWidth()/3)*2,casilla.getHeight()));
		casilla6.setSelectedSource( new Rect((casilla.getWidth()/3)*2,0,(casilla.getWidth()/3)*3,casilla.getHeight()));
		casilla7 = new Sprite(casilla, new Rect(0,0,casilla.getWidth()/3,casilla.getHeight()));
		casilla7.setSelectedSource( new Rect((casilla.getWidth()/3)*2,0,(casilla.getWidth()/3)*3,casilla.getHeight()));
		
		casilla8 = new Sprite(casilla, new Rect(0,0,casilla.getWidth()/3,casilla.getHeight()));
		casilla8.setSelectedSource( new Rect((casilla.getWidth()/3)*2,0,(casilla.getWidth()/3)*3,casilla.getHeight()));
		casilla9 = new Sprite(casilla, new Rect(casilla.getWidth()/3,0,(casilla.getWidth()/3)*2,casilla.getHeight()));
		casilla9.setSelectedSource( new Rect((casilla.getWidth()/3)*2,0,(casilla.getWidth()/3)*3,casilla.getHeight()));
		casilla10 = new Sprite(casilla, new Rect(0,0,casilla.getWidth()/3,casilla.getHeight()));
		casilla10.setSelectedSource( new Rect((casilla.getWidth()/3)*2,0,(casilla.getWidth()/3)*3,casilla.getHeight()));
		casilla11 = new Sprite(casilla, new Rect(casilla.getWidth()/3,0,(casilla.getWidth()/3)*2,casilla.getHeight()));
		casilla11.setSelectedSource( new Rect((casilla.getWidth()/3)*2,0,(casilla.getWidth()/3)*3,casilla.getHeight()));
		casilla12 = new Sprite(casilla, new Rect(0,0,casilla.getWidth()/3,casilla.getHeight()));
		casilla12.setSelectedSource( new Rect((casilla.getWidth()/3)*2,0,(casilla.getWidth()/3)*3,casilla.getHeight()));
		casilla13 = new Sprite(casilla, new Rect(casilla.getWidth()/3,0,(casilla.getWidth()/3)*2,casilla.getHeight()));
		casilla13.setSelectedSource( new Rect((casilla.getWidth()/3)*2,0,(casilla.getWidth()/3)*3,casilla.getHeight()));
		casilla14 = new Sprite(casilla, new Rect(0,0,casilla.getWidth()/3,casilla.getHeight()));
		casilla14.setSelectedSource( new Rect((casilla.getWidth()/3)*2,0,(casilla.getWidth()/3)*3,casilla.getHeight()));
		casilla15 = new Sprite(casilla, new Rect(casilla.getWidth()/3,0,(casilla.getWidth()/3)*2,casilla.getHeight()));
		casilla15.setSelectedSource( new Rect((casilla.getWidth()/3)*2,0,(casilla.getWidth()/3)*3,casilla.getHeight()));

		casilla16 = new Sprite(casilla, new Rect(casilla.getWidth()/3,0,(casilla.getWidth()/3)*2,casilla.getHeight()));
		casilla16.setSelectedSource( new Rect((casilla.getWidth()/3)*2,0,(casilla.getWidth()/3)*3,casilla.getHeight()));
		casilla17 = new Sprite(casilla, new Rect(0,0,casilla.getWidth()/3,casilla.getHeight()));
		casilla17.setSelectedSource( new Rect((casilla.getWidth()/3)*2,0,(casilla.getWidth()/3)*3,casilla.getHeight()));
		casilla18 = new Sprite(casilla, new Rect(casilla.getWidth()/3,0,(casilla.getWidth()/3)*2,casilla.getHeight()));
		casilla18.setSelectedSource( new Rect((casilla.getWidth()/3)*2,0,(casilla.getWidth()/3)*3,casilla.getHeight()));
		casilla19 = new Sprite(casilla, new Rect(0,0,casilla.getWidth()/3,casilla.getHeight()));
		casilla19.setSelectedSource( new Rect((casilla.getWidth()/3)*2,0,(casilla.getWidth()/3)*3,casilla.getHeight()));
		casilla20 = new Sprite(casilla, new Rect(casilla.getWidth()/3,0,(casilla.getWidth()/3)*2,casilla.getHeight()));
		casilla20.setSelectedSource( new Rect((casilla.getWidth()/3)*2,0,(casilla.getWidth()/3)*3,casilla.getHeight()));
		casilla21 = new Sprite(casilla, new Rect(0,0,casilla.getWidth()/3,casilla.getHeight()));
		casilla21.setSelectedSource( new Rect((casilla.getWidth()/3)*2,0,(casilla.getWidth()/3)*3,casilla.getHeight()));
		casilla22 = new Sprite(casilla, new Rect(casilla.getWidth()/3,0,(casilla.getWidth()/3)*2,casilla.getHeight()));
		casilla22.setSelectedSource( new Rect((casilla.getWidth()/3)*2,0,(casilla.getWidth()/3)*3,casilla.getHeight()));

		casilla23 = new Sprite(casilla, new Rect(0,0,casilla.getWidth()/3,casilla.getHeight()));
		casilla23.setSelectedSource( new Rect((casilla.getWidth()/3)*2,0,(casilla.getWidth()/3)*3,casilla.getHeight()));
		casilla24 = new Sprite(casilla, new Rect(0,0,casilla.getWidth()/3,casilla.getHeight()));
		casilla24.setSelectedSource( new Rect((casilla.getWidth()/3)*2,0,(casilla.getWidth()/3)*3,casilla.getHeight()));
		casilla25 = new Sprite(casilla, new Rect(casilla.getWidth()/3,0,(casilla.getWidth()/3)*2,casilla.getHeight()));
		casilla25.setSelectedSource( new Rect((casilla.getWidth()/3)*2,0,(casilla.getWidth()/3)*3,casilla.getHeight()));
		casilla26 = new Sprite(casilla, new Rect(0,0,casilla.getWidth()/3,casilla.getHeight()));
		casilla26.setSelectedSource( new Rect((casilla.getWidth()/3)*2,0,(casilla.getWidth()/3)*3,casilla.getHeight()));
		casilla27 = new Sprite(casilla, new Rect(casilla.getWidth()/3,0,(casilla.getWidth()/3)*2,casilla.getHeight()));
		casilla27.setSelectedSource( new Rect((casilla.getWidth()/3)*2,0,(casilla.getWidth()/3)*3,casilla.getHeight()));
		casilla28 = new Sprite(casilla, new Rect(0,0,casilla.getWidth()/3,casilla.getHeight()));
		casilla28.setSelectedSource( new Rect((casilla.getWidth()/3)*2,0,(casilla.getWidth()/3)*3,casilla.getHeight()));
		casilla29 = new Sprite(casilla, new Rect(casilla.getWidth()/3,0,(casilla.getWidth()/3)*2,casilla.getHeight()));
		casilla29.setSelectedSource( new Rect((casilla.getWidth()/3)*2,0,(casilla.getWidth()/3)*3,casilla.getHeight()));
		casilla30 = new Sprite(casilla, new Rect(0,0,casilla.getWidth()/3,casilla.getHeight()));
		casilla30.setSelectedSource( new Rect((casilla.getWidth()/3)*2,0,(casilla.getWidth()/3)*3,casilla.getHeight()));
		casilla31 = new Sprite(casilla, new Rect(casilla.getWidth()/3,0,(casilla.getWidth()/3)*2,casilla.getHeight()));
		casilla31.setSelectedSource( new Rect((casilla.getWidth()/3)*2,0,(casilla.getWidth()/3)*3,casilla.getHeight()));
		
		casilla32 = new Sprite(casilla, new Rect(casilla.getWidth()/3,0,(casilla.getWidth()/3)*2,casilla.getHeight()));
		casilla32.setSelectedSource( new Rect((casilla.getWidth()/3)*2,0,(casilla.getWidth()/3)*3,casilla.getHeight()));
		casilla33 = new Sprite(casilla, new Rect(0,0,casilla.getWidth()/3,casilla.getHeight()));
		casilla33.setSelectedSource( new Rect((casilla.getWidth()/3)*2,0,(casilla.getWidth()/3)*3,casilla.getHeight()));
		casilla34 = new Sprite(casilla, new Rect(casilla.getWidth()/3,0,(casilla.getWidth()/3)*2,casilla.getHeight()));
		casilla34.setSelectedSource( new Rect((casilla.getWidth()/3)*2,0,(casilla.getWidth()/3)*3,casilla.getHeight()));
		casilla35 = new Sprite(casilla, new Rect(0,0,casilla.getWidth()/3,casilla.getHeight()));
		casilla35.setSelectedSource( new Rect((casilla.getWidth()/3)*2,0,(casilla.getWidth()/3)*3,casilla.getHeight()));
		casilla36 = new Sprite(casilla, new Rect(casilla.getWidth()/3,0,(casilla.getWidth()/3)*2,casilla.getHeight()));
		casilla36.setSelectedSource( new Rect((casilla.getWidth()/3)*2,0,(casilla.getWidth()/3)*3,casilla.getHeight()));
		casilla37 = new Sprite(casilla, new Rect(0,0,casilla.getWidth()/3,casilla.getHeight()));
		casilla37.setSelectedSource( new Rect((casilla.getWidth()/3)*2,0,(casilla.getWidth()/3)*3,casilla.getHeight()));
		casilla38 = new Sprite(casilla, new Rect(casilla.getWidth()/3,0,(casilla.getWidth()/3)*2,casilla.getHeight()));
		casilla38.setSelectedSource( new Rect((casilla.getWidth()/3)*2,0,(casilla.getWidth()/3)*3,casilla.getHeight()));
		casilla39 = new Sprite(casilla, new Rect(0,0,casilla.getWidth()/3,casilla.getHeight()));
		casilla39.setSelectedSource( new Rect((casilla.getWidth()/3)*2,0,(casilla.getWidth()/3)*3,casilla.getHeight()));
		
		casilla40 = new Sprite(casilla, new Rect(0,0,casilla.getWidth()/3,casilla.getHeight()));
		casilla40.setSelectedSource( new Rect((casilla.getWidth()/3)*2,0,(casilla.getWidth()/3)*3,casilla.getHeight()));
		casilla41 = new Sprite(casilla, new Rect(casilla.getWidth()/3,0,(casilla.getWidth()/3)*2,casilla.getHeight()));
		casilla41.setSelectedSource( new Rect((casilla.getWidth()/3)*2,0,(casilla.getWidth()/3)*3,casilla.getHeight()));
		casilla42 = new Sprite(casilla, new Rect(0,0,casilla.getWidth()/3,casilla.getHeight()));
		casilla42.setSelectedSource( new Rect((casilla.getWidth()/3)*2,0,(casilla.getWidth()/3)*3,casilla.getHeight()));
		casilla43 = new Sprite(casilla, new Rect(casilla.getWidth()/3,0,(casilla.getWidth()/3)*2,casilla.getHeight()));
		casilla43.setSelectedSource( new Rect((casilla.getWidth()/3)*2,0,(casilla.getWidth()/3)*3,casilla.getHeight()));
		casilla44 = new Sprite(casilla, new Rect(0,0,casilla.getWidth()/3,casilla.getHeight()));
		casilla44.setSelectedSource( new Rect((casilla.getWidth()/3)*2,0,(casilla.getWidth()/3)*3,casilla.getHeight()));
		casilla45 = new Sprite(casilla, new Rect(casilla.getWidth()/3,0,(casilla.getWidth()/3)*2,casilla.getHeight()));
		casilla45.setSelectedSource( new Rect((casilla.getWidth()/3)*2,0,(casilla.getWidth()/3)*3,casilla.getHeight()));
		casilla46 = new Sprite(casilla, new Rect(0,0,casilla.getWidth()/3,casilla.getHeight()));
		casilla46.setSelectedSource( new Rect((casilla.getWidth()/3)*2,0,(casilla.getWidth()/3)*3,casilla.getHeight()));
		casilla47 = new Sprite(casilla, new Rect(casilla.getWidth()/3,0,(casilla.getWidth()/3)*2,casilla.getHeight()));
		casilla47.setSelectedSource( new Rect((casilla.getWidth()/3)*2,0,(casilla.getWidth()/3)*3,casilla.getHeight()));

		spriteCaballo = new Sprite(caballo, new Rect(0,0,caballo.getWidth()/2, caballo.getHeight()));
		spriteCaballo.setSelectedSource(new Rect(caballo.getWidth()/2,0,caballo.getWidth(), caballo.getHeight()));

		spriteCaballo2 = new Sprite(caballo, new Rect(0,0,caballo.getWidth()/2, caballo.getHeight()));
		spriteCaballo2.setSelectedSource(new Rect(caballo.getWidth()/2,0,caballo.getWidth(), caballo.getHeight()));
	}

	public void initTablero(){
		casilla0.setPosition(mapaCoordenadas.get(0));
		casilla1.setPosition(mapaCoordenadas.get(1));
		casilla2.setPosition(mapaCoordenadas.get(2));
		casilla3.setPosition(mapaCoordenadas.get(3));
		casilla4.setPosition(mapaCoordenadas.get(4));
		casilla5.setPosition(mapaCoordenadas.get(5));
		casilla6.setPosition(mapaCoordenadas.get(6));
		casilla7.setPosition(mapaCoordenadas.get(7));

		casilla8.setPosition(mapaCoordenadas.get(8));
		casilla9.setPosition(mapaCoordenadas.get(9));
		casilla10.setPosition(mapaCoordenadas.get(10));
		casilla11.setPosition(mapaCoordenadas.get(11));
		casilla12.setPosition(mapaCoordenadas.get(12));
		casilla13.setPosition(mapaCoordenadas.get(13));
		casilla14.setPosition(mapaCoordenadas.get(14));
		casilla15.setPosition(mapaCoordenadas.get(15));

		casilla16.setPosition(mapaCoordenadas.get(16));
		casilla17.setPosition(mapaCoordenadas.get(17));
		casilla18.setPosition(mapaCoordenadas.get(18));
		casilla19.setPosition(mapaCoordenadas.get(19));
		casilla20.setPosition(mapaCoordenadas.get(20));
		casilla21.setPosition(mapaCoordenadas.get(21));
		casilla22.setPosition(mapaCoordenadas.get(22));
		casilla23.setPosition(mapaCoordenadas.get(23));

		casilla24.setPosition(mapaCoordenadas.get(24));
		casilla25.setPosition(mapaCoordenadas.get(25));
		casilla26.setPosition(mapaCoordenadas.get(26));
		casilla27.setPosition(mapaCoordenadas.get(27));
		casilla28.setPosition(mapaCoordenadas.get(28));
		casilla29.setPosition(mapaCoordenadas.get(29));
		casilla30.setPosition(mapaCoordenadas.get(30));
		casilla31.setPosition(mapaCoordenadas.get(31));

		casilla32.setPosition(mapaCoordenadas.get(32));
		casilla33.setPosition(mapaCoordenadas.get(33));
		casilla34.setPosition(mapaCoordenadas.get(34));
		casilla35.setPosition(mapaCoordenadas.get(35));
		casilla36.setPosition(mapaCoordenadas.get(36));
		casilla37.setPosition(mapaCoordenadas.get(37));
		casilla38.setPosition(mapaCoordenadas.get(38));
		casilla39.setPosition(mapaCoordenadas.get(39));
		casilla40.setPosition(mapaCoordenadas.get(40));
		casilla41.setPosition(mapaCoordenadas.get(41));

		casilla42.setPosition(mapaCoordenadas.get(42));
		casilla43.setPosition(mapaCoordenadas.get(43));
		casilla44.setPosition(mapaCoordenadas.get(44));
		casilla45.setPosition(mapaCoordenadas.get(45));
		casilla46.setPosition(mapaCoordenadas.get(46));
		casilla47.setPosition(mapaCoordenadas.get(47));

		mapaCasillas.put(0, casilla0);
		mapaCasillas.put(1, casilla1);
		mapaCasillas.put(2, casilla2);
		mapaCasillas.put(3, casilla3);
		mapaCasillas.put(4, casilla4);
		mapaCasillas.put(5, casilla5);
		mapaCasillas.put(6, casilla6);
		mapaCasillas.put(7, casilla7);
		
		mapaCasillas.put(8, casilla8);
		mapaCasillas.put(9, casilla9);
		mapaCasillas.put(10, casilla10);
		mapaCasillas.put(11, casilla11);
		mapaCasillas.put(12, casilla12);
		mapaCasillas.put(13, casilla13);
		mapaCasillas.put(14, casilla14);
		mapaCasillas.put(15, casilla15);
		
		mapaCasillas.put(16, casilla16);
		mapaCasillas.put(17, casilla17);
		mapaCasillas.put(18, casilla18);
		mapaCasillas.put(19, casilla19);
		mapaCasillas.put(20, casilla20);
		mapaCasillas.put(21, casilla21);
		mapaCasillas.put(22, casilla22);
		mapaCasillas.put(23, casilla23);
		
		mapaCasillas.put(24, casilla24);
		mapaCasillas.put(25, casilla25);
		mapaCasillas.put(26, casilla26);
		mapaCasillas.put(27, casilla27);
		mapaCasillas.put(28, casilla28);
		mapaCasillas.put(29, casilla29);
		mapaCasillas.put(30, casilla30);
		mapaCasillas.put(31, casilla31);
		
		mapaCasillas.put(32, casilla32);
		mapaCasillas.put(33, casilla33);
		mapaCasillas.put(34, casilla34);
		mapaCasillas.put(35, casilla35);
		mapaCasillas.put(36, casilla36);
		mapaCasillas.put(37, casilla37);
		mapaCasillas.put(38, casilla38);
		mapaCasillas.put(39, casilla39);

		mapaCasillas.put(40, casilla40);
		mapaCasillas.put(41, casilla41);
		mapaCasillas.put(42, casilla42);
		mapaCasillas.put(43, casilla43);
		mapaCasillas.put(44, casilla44);
		mapaCasillas.put(45, casilla45);
		mapaCasillas.put(46, casilla46);
		mapaCasillas.put(47, casilla47);

		piezaCaballo = new Pieza("caballo", spriteCaballo);
		piezaCaballo2 = new Pieza("caballo", spriteCaballo2);

		piezaCaballo.setPosition(mapaCoordenadas.get(2));
		piezaCaballo2.setPosition(mapaCoordenadas.get(4));
		
		mapaPosiciones.put(2, piezaCaballo);
		mapaPosiciones.put(4, piezaCaballo2);
	}

	public void drawTablero(Canvas canvas){

		casilla0.draw(canvas);
		casilla1.draw(canvas);
		casilla2.draw(canvas);
		casilla3.draw(canvas);
		casilla4.draw(canvas);
		casilla5.draw(canvas);
		casilla6.draw(canvas);
		casilla7.draw(canvas);
		
		casilla8.draw(canvas);
		casilla9.draw(canvas);
		casilla10.draw(canvas);
		casilla11.draw(canvas);
		casilla12.draw(canvas);
		casilla13.draw(canvas);
		casilla14.draw(canvas);
		casilla15.draw(canvas);
		
		casilla16.draw(canvas);
		casilla17.draw(canvas);
		casilla18.draw(canvas);
		casilla19.draw(canvas);
		casilla20.draw(canvas);
		casilla21.draw(canvas);
		casilla22.draw(canvas);
		casilla23.draw(canvas);
		
		casilla24.draw(canvas);
		casilla25.draw(canvas);
		casilla26.draw(canvas);
		casilla27.draw(canvas);
		casilla28.draw(canvas);
		casilla29.draw(canvas);
		casilla30.draw(canvas);
		casilla31.draw(canvas);
		
		casilla32.draw(canvas);
		casilla33.draw(canvas);
		casilla34.draw(canvas);
		casilla35.draw(canvas);
		casilla36.draw(canvas);
		casilla37.draw(canvas);
		casilla38.draw(canvas);
		casilla39.draw(canvas);
		
		casilla40.draw(canvas);
		casilla41.draw(canvas);
		casilla42.draw(canvas);
		casilla43.draw(canvas);
		casilla44.draw(canvas);
		casilla45.draw(canvas);
		casilla46.draw(canvas);
		casilla47.draw(canvas);
		
		piezaCaballo.draw(canvas);
		piezaCaballo2.draw(canvas);
	}

	public Pieza getPiezaAt(float x, float y){
		int i;
		for(i=0; i<mapaCoordenadas.size(); i++){
			if(mapaCoordenadas.get(i).contains((int)x, (int)y)){
				return mapaPosiciones.get(i);
			}
		}
		return null;
	}

	public Pieza getPiezaAt(int pos){
		return mapaPosiciones.get(pos);
	}
	
	public Rect getRectanguloAt(int posicion){
		return mapaCoordenadas.get(posicion);
	}
	
	public int getCasillaAt(int x, int y){
		int i;
		for(i=0; i<mapaCoordenadas.size(); i++){
			if(mapaCoordenadas.get(i).contains(x,y)){
				return i;
			}
		}
		return -1;
	}

	public Sprite getCasillaAt(int pos){
		return mapaCasillas.get(pos);
	}

	public void resetCasillas(Vector<Integer> vectorCasillasSeleccionadas){
		int i;
		for(i=0; i<vectorCasillasSeleccionadas.size(); i++){
			mapaCasillas.get(vectorCasillasSeleccionadas.get(i)).setSelected(false);
		}
	}

}
