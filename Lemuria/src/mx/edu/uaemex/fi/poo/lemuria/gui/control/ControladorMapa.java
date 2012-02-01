package mx.edu.uaemex.fi.poo.lemuria.gui.control;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import mx.edu.uaemex.fi.poo.lemuria.gui.PanelEscenario;
import mx.edu.uaemex.fi.poo.lemuria.gui.VentanaJuego;
import mx.edu.uaemex.fi.poo.lemuria.gui.VentanaMovimientos;
import mx.edu.uaemex.fi.poo.lemuria.modelo.Arma;
import mx.edu.uaemex.fi.poo.lemuria.modelo.Guerrero;
import mx.edu.uaemex.fi.poo.lemuria.modelo.Item;
import mx.edu.uaemex.fi.poo.lemuria.modelo.Mapa;
import mx.edu.uaemex.fi.poo.lemuria.modelo.Posion;
import mx.edu.uaemex.fi.poo.lemuria.modelo.error.BolsaLlenaException;
import mx.edu.uaemex.fi.poo.lemuria.modelo.error.TuEstasMuertoException;

public class ControladorMapa implements Observer{
	private Mapa mapa;
	private static Item arma;
	private PanelEscenario escenario;
	private VentanaJuego ventanaJuego;
	private VentanaMovimientos ventanaMovimientos;
	private static boolean[] monstruoDerrotado;
	private static int index;
	private Guerrero guerrero;

	public void Muevete(String direccion){
		if(direccion.compareTo("arriba")==0){
			////////////////////////////////////
			if(mapa.getCoordenadaX()==0){
				mapa.setCoordenadaX(mapa.getLimiteX());
			}

			else{
				mapa.setCoordenadaX(mapa.getCoordenadaX()-1);
			}
			///////////////////////////////////////////////
		}
		if(direccion.compareTo("abajo")==0){

			///////////////////////////////////////////////		
			if(mapa.getCoordenadaX()==mapa.getLimiteX()){
				mapa.setCoordenadaX(0);
			}

			else{
				mapa.setCoordenadaX(mapa.getCoordenadaX()+1);
			}
			///////////////////////////////////////////////
		}
		if(direccion.compareTo("izquierda")==0){
			///////////////////////////////////////////////
			if(mapa.getCoordenadaY()==0){
				mapa.setCoordenadaY(mapa.getLimiteY());
			}

			else{
				mapa.setCoordenadaY(mapa.getCoordenadaY()-1);
			}
			///////////////////////////////////////////////
		}

		if(direccion.compareTo("derecha")==0){
			///////////////////////////////////////////////

			if(mapa.getCoordenadaY()==mapa.getLimiteY()){
				mapa.setCoordenadaY(0);
			}

			else{
				mapa.setCoordenadaY(mapa.getCoordenadaY()+1);
			}
			///////////////////////////////////////////////
		}
		mapa.Actualizado();
		this.ventanaMovimientos.SetMovimiento(false);
	}

	public void ataca(boolean atacar) throws TuEstasMuertoException{
		if(atacar == true){
			if(monstruoDerrotado[index]==false){
				boolean gano;
				gano = ControladorAtaque.Hacele();
				if(gano == true){
					try {
						if(arma != null){
							if(arma.getNombre().compareTo("Princesa")==0){
								JOptionPane.showMessageDialog(null, "Ganaste! Encontraste a la princesa! ","Felicidades!", JOptionPane.INFORMATION_MESSAGE);
							}
							guerrero.pickUpItem(arma);
						}
					} catch (BolsaLlenaException e) {
						e.printStackTrace();
					}
					monstruoDerrotado[index]=true;
					this.guerrero.getArmeria().showArmeria();
				}
				else{
					System.out.println("Perdiste el ataque y te quedaste sin item en mano");
				}
			}
			this.ventanaMovimientos.SetMovimiento(true);
		}
		else if(atacar == false){
			this.ventanaMovimientos.SetMovimiento(true);
		}
	}

	public int BuscarCoordenadas(){
		int i,j;

		String coordX=""+mapa.getCoordenadaX();
		String coordY= ""+mapa.getCoordenadaY();

		System.out.println("Coordenadas de arriba: ("+coordX + "," + coordY+")");

		for(i=0;i< mapa.getLimiteMatriz(); i++){
			j=0;
			if(mapa.getPropiedades()[i][j].compareTo(coordX)==0){
				if(mapa.getPropiedades()[i][j+1].compareTo(coordY)==0){
					return i;
				}
			}
		}
		JOptionPane.showMessageDialog(null, "Coordenadas fuera de rango. ", "Error de coordenadas", JOptionPane.ERROR_MESSAGE);
		return 0;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if(arg1!=null){
			if(arg1.equals("cargar mapa")){
				this.mapa = (Mapa)arg0;
				JOptionPane.showMessageDialog(null, "Carga del mapa exitosa. ", "Carga de mapa", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else{
			index = BuscarCoordenadas();
			BufferedImage fondo, enemigo;
			try {
				fondo = ImageIO.read(new File(mapa.getPropiedades()[index][2]));
				String nombreEnemigo=mapa.getPropiedades()[index][3];
				if(nombreEnemigo==null){
					monstruoDerrotado[index]=true;
				}
				if(monstruoDerrotado[index]==true){
					ventanaMovimientos.SetMovimiento(true);
					escenario.setEnemigo(null);
					arma=null;
				}
				else{
					enemigo = ImageIO.read(new File(nombreEnemigo));
					if(mapa.getPropiedades()[index][4]==null){
						arma=null;
					}
					else{
						if(mapa.getPropiedades()[index][4].compareTo("Princesa")==0){
							arma= new Item("Princesa");
							System.out.println("El nombre del item con el que ganas es: " + arma.getNombre());
						}

						int tipo = mapa.getPropiedades()[index][4].indexOf("Arma");
						if(tipo!=-1){
							tipo = mapa.getPropiedades()[index][4].indexOf(" ");
							String nombre =mapa.getPropiedades()[index][4].substring(tipo+1);
							long poder = Long.parseLong(mapa.getPropiedades()[index][5]);
							arma = new Arma(nombre, poder);
						}
						else{
							tipo = mapa.getPropiedades()[index][4].indexOf("Posion");
							if(tipo!=-1){
								tipo = mapa.getPropiedades()[index][4].indexOf(" ");
								String nombre =mapa.getPropiedades()[index][4].substring(tipo+1);
								long poder = Long.parseLong(mapa.getPropiedades()[index][5]);
								arma = new Posion(nombre, poder);
							}
							else{
								tipo = mapa.getPropiedades()[index][4].indexOf(" ");
								String nombre =mapa.getPropiedades()[index][4].substring(tipo+1);
								arma = new Item(nombre);
							}
						}
					}

					this.escenario.setEnemigo(enemigo);
				}
				this.escenario.setFondo(fondo);
				this.ventanaJuego.repaint();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public Mapa getMapa() {
		return mapa;
	}

	public void setMapa(Mapa mapa) {
		this.mapa = mapa;
		monstruoDerrotado = new boolean[this.mapa.getLimiteMatriz()];
		this.mapa.addObserver(this);
	}

	public Item getArma() {
		return arma;
	}

	public void setArma(Item arma) {
		this.arma = arma;
	}

	public PanelEscenario getEscenario() {
		return escenario;
	}

	public void setEscenario(PanelEscenario escenario) {
		this.escenario = escenario;
	}

	public VentanaJuego getVentanaJuego() {
		return ventanaJuego;
	}

	public void setVentanaJuego(VentanaJuego ventanaJuego) {
		this.ventanaJuego = ventanaJuego;
	}

	public VentanaMovimientos getVentanaMovimientos() {
		return ventanaMovimientos;
	}

	public void setVentanaMovimientos(VentanaMovimientos ventanaMovimientos) {
		this.ventanaMovimientos = ventanaMovimientos;
	}

	public Guerrero getGuerrero() {
		return guerrero;
	}

	public void setGuerrero(Guerrero guerrero) {
		this.guerrero = guerrero;
	}

}
