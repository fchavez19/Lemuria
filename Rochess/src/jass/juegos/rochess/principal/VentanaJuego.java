package jass.juegos.rochess.principal;

import java.util.Random;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnDragListener;

public class VentanaJuego extends SurfaceView{
	private SurfaceHolder contenedor;
	private Tablero tablero;
	private RoChess roChess;
	private boolean piezaSeleccionada=false;
	private Canvas canvas;

	public VentanaJuego(Context context) {
		super(context);

		roChess = new RoChess();		
		tablero = new Tablero();
		tablero.initSprites(this);	
		roChess.setTablero(tablero);
		roChess.setVentanaJuego(this);
		contenedor = getHolder();
		contenedor.addCallback(new Callback() {
			@Override
			public void surfaceChanged(SurfaceHolder holder, int format,
					int width, int height) {
			}
			@Override
			public void surfaceCreated(SurfaceHolder holder) {
				canvas = holder.lockCanvas(null);
				tablero.initCoordenadas(canvas.getWidth(),canvas.getHeight());
				tablero.initTablero();
				holder.unlockCanvasAndPost(canvas);
				roChess.initMotor();
			}

			@Override
			public void surfaceDestroyed(SurfaceHolder holder) {
			}
		});
	}

	public boolean onTouchEvent(MotionEvent event) {
		if(event.getAction() == event.ACTION_DOWN){
			piezaSeleccionada= roChess.actionDown(event.getX(), event.getY());
			return piezaSeleccionada;
		}

		else if(event.getAction() == event.ACTION_MOVE){
			roChess.startDrag(event.getX(), event.getY());
		}

		else if(event.getAction() == event.ACTION_UP){
			roChess.stopDrag(event.getX(), event.getY());
			piezaSeleccionada=false; //no es necesario ya que se inicializa en el action down
		}

		return true;
	}

}