package mx.edu.uaemex.fi.poo.lemuria.gui.control;

import java.util.Observable;
import java.util.Observer;

public class ControladorMovimientos implements Observer{

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
//	private VentanaMovimientos ventanaMovimientos;
//	private Mapa mapa;
//	private boolean[] monstruoDerrotado;
//	private String[] imagenesMapas;
//	
//	private char limitex = '3';
//	private char limitey = '4';
//	
//	private PanelEscenario panelEscenario;
//	private VentanaJuego VentanaJuego;
//	
//	private int i;
//	
//	private Item arma;
//	
//	private Guerrero guerrero;
//
//	public String[] getImagenesMapas() {
//		return imagenesMapas;
//	}
//
//	public void setImagenesMapas(String[] imagenesMapas) {
//		this.imagenesMapas = imagenesMapas;
//	}
//
//	public Guerrero getGuerrero() {
//		return guerrero;
//	}
//
//	public void setGuerrero(Guerrero guerrero) {
//		this.guerrero = guerrero;
//	}
//
//	public VentanaJuego getVentanaJuego() {
//		return VentanaJuego;
//	}
//
//	public void setVentanaJuego(VentanaJuego ventanaJuego) {
//		VentanaJuego = ventanaJuego;
//	}
//
//	public PanelEscenario getPanelEscenario() {
//		return panelEscenario;
//	}
//
//	public void setPanelEscenario(PanelEscenario panelEscenario) {
//		this.panelEscenario = panelEscenario;
//	}
//
//	public Mapa getMapa() {
//		return mapa;
//	}
//
//	public void setMapa(Mapa mapa) {
//		this.mapa = mapa;
//	}
//
//	public ControladorMovimientos() {
//		monstruoDerrotado = new boolean[13];
//		monstruoDerrotado[0]=true;
//		for(i=1; i<monstruoDerrotado.length; i++){
//			monstruoDerrotado[i]=false;
//		}
//		i=0;
//	}
//
//	public void Hacele(String direccion){
//		if(direccion.compareTo("arriba")==0){
//			
//			////////////////////////////////////
//			if(mapa.getCoordenadaX()==0){
//				mapa.setCoordenadaX(mapa.getLimiteX());
//			}
//			
//			else{
//				mapa.setCoordenadaX(mapa.getCoordenadaX()-1);
//			}
//			///////////////////////////////////////////////
//			
//			if( mapa.getPosicion()[0] == '1'){
//				mapa.getPosicion()[0] = limitey;
//				mapa.Actualizado();
//			}
//			
//			else{
//				mapa.getPosicion()[0] = (char) (mapa.getPosicion()[0]-1);
//				mapa.Actualizado();
//			}
//		}
//
//		if(direccion.compareTo("abajo")==0){
//			
//			///////////////////////////////////////////////		
//			if(mapa.getCoordenadaX()==mapa.getLimiteX()){
//				mapa.setCoordenadaX(0);
////				mapa.Actualizado();
//			}
//			
//			else{
//				mapa.setCoordenadaX(mapa.getCoordenadaX()+1);
////				mapa.Actualizado();
//			}
//			///////////////////////////////////////////////
////			
////			if(mapa.getPosicion()[0] < limitey){
////				mapa.getPosicion()[0] = (char) (mapa.getPosicion()[0]+1);
////				mapa.Actualizado();
////			}
////			else{
////				mapa.getPosicion()[0] = '1';
////				mapa.Actualizado();
//			}
//		}
//
//		if(direccion.compareTo("izquierda")==0){
//			///////////////////////////////////////////////
//			if(mapa.getCoordenadaY()==0){
//				mapa.setCoordenadaY(mapa.getLimiteY());
//			}
//			
//			else{
//				mapa.setCoordenadaY(mapa.getCoordenadaY()-1);
//			}
//			///////////////////////////////////////////////
//
//			if( mapa.getPosicion()[2] == '1'){
//				mapa.getPosicion()[2] = limitex;
//				mapa.Actualizado();
//			}
//			else{
//				mapa.getPosicion()[2] = (char) (mapa.getPosicion()[2]-1);
//				mapa.Actualizado();
//			}
//		}
//
//		if(direccion.compareTo("derecha")==0){
//			///////////////////////////////////////////////
//			
//			if(mapa.getCoordenadaY()==mapa.getLimiteY()){
//				mapa.setCoordenadaY(0);
//			}
//			
//			else{
//				mapa.setCoordenadaY(mapa.getCoordenadaY()+1);
//			}
//			
//			///////////////////////////////////////////////
//			
//			if(mapa.getPosicion()[2] < limitex){
//				mapa.getPosicion()[2] = (char) (mapa.getPosicion()[2]+1);
//				mapa.Actualizado();
//			}
//			else{
//				mapa.getPosicion()[2] = '1';
//				mapa.Actualizado();
//			}
//		}
//
//		System.out.println("(" + mapa.getPosicion()[0] + mapa.getPosicion()[1] + mapa.getPosicion()[2] + ")");
//
//		this.ventanaMovimientos.getBotonAbajo().setEnabled(false);
//		this.ventanaMovimientos.getBotonArriba().setEnabled(false);
//		this.ventanaMovimientos.getBotonIzquierda().setEnabled(false);
//		this.ventanaMovimientos.getBotonDerecha().setEnabled(false);
//		this.ventanaMovimientos.getBotonAtacar().setEnabled(true);
//		this.ventanaMovimientos.getBotonDefender().setEnabled(true);
//	}
//
//	public void Hacele() throws TuEstasMuertoException{
//		if(this.ventanaMovimientos.getBotonAtacar().isSelected()){
//			if(monstruoDerrotado[i]==false){
//				boolean gano;
//				gano = ControladorAtaque.Hacele();
//				if(gano == true){
//					try {
//						if(arma != null){
//							if(arma.getNombre().compareTo("princesa")==0){
//								JOptionPane.showMessageDialog(null, "Ganaste! Encontraste a la princesa! ","Felicidades!", JOptionPane.INFORMATION_MESSAGE);
//							}
//						guerrero.pickUpItem(this.arma);
//						}
//					} catch (BolsaLlenaException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					monstruoDerrotado[i]=true;
//					System.out.println("Derrotaste el monstruo!");
//					this.guerrero.getArmeria().showArmeria();
//				}
//				else{
//					System.out.println("Perdiste el ataque y te quedaste sin item en mano");
//				}
//			}
//			this.ventanaMovimientos.getBotonAbajo().setEnabled(true);
//			this.ventanaMovimientos.getBotonArriba().setEnabled(true);
//			this.ventanaMovimientos.getBotonIzquierda().setEnabled(true);
//			this.ventanaMovimientos.getBotonDerecha().setEnabled(true);
//			this.ventanaMovimientos.getBotonAtacar().setEnabled(false);
//			this.ventanaMovimientos.getBotonDefender().setEnabled(false);
//		}
//		else if(this.ventanaMovimientos.getBotonDefender().isSelected()){
//			System.out.println("defiende");
//			this.ventanaMovimientos.getBotonAbajo().setEnabled(true);
//			this.ventanaMovimientos.getBotonArriba().setEnabled(true);
//			this.ventanaMovimientos.getBotonIzquierda().setEnabled(true);
//			this.ventanaMovimientos.getBotonDerecha().setEnabled(true);
//			this.ventanaMovimientos.getBotonAtacar().setEnabled(false);
//			this.ventanaMovimientos.getBotonDefender().setEnabled(false);
//		}
//	}
//
//	public VentanaMovimientos getVentanaMovimientos() {
//		return ventanaMovimientos;
//	}
//
//	public void setVentanaMovimientos(VentanaMovimientos ventanaMovimientos) {
//		this.ventanaMovimientos = ventanaMovimientos;
//	}
//
//	@Override
//	public void update(Observable o, Object arg) {
//		BufferedImage fondo, enemigo;
//		try {
//			switch(mapa.getPosicion()[0]){
//			case '1': 
//				switch(mapa.getPosicion()[2]){
//				case '1':
//					i=0;
//					fondo= ImageIO.read(new File(imagenesMapas[0]));
//					this.panelEscenario.setEnemigo(null);
//					this.panelEscenario.setFondo(fondo);
//					this.VentanaJuego.repaint();
//					break;
//				case '2':
//					i=1;
//					fondo = ImageIO.read(new File(imagenesMapas[1]));
//					if(monstruoDerrotado[i]==false){
//						enemigo = ImageIO.read(new File("TrollGarrote.png"));
//						this.panelEscenario.setEnemigo(enemigo);
//						this.arma = new Arma("daga", 5);
//					}
//					else{
//						this.panelEscenario.setEnemigo(null);
//					}
//					this.panelEscenario.setFondo(fondo);
//					this.VentanaJuego.repaint();
//					break;
//				case '3':
//					i=2;
//					fondo = ImageIO.read(new File(imagenesMapas[2]));
//					if(monstruoDerrotado[i]==false){
//						enemigo = ImageIO.read(new File("TrollGarrote.png"));
//						this.panelEscenario.setEnemigo(enemigo);
//						this.arma = new Posion(Color.GREEN, 40);
//					}
//					else{
//						this.panelEscenario.setEnemigo(null);
//					}
//					this.panelEscenario.setFondo(fondo);
//					this.VentanaJuego.repaint();
//					break;
//				}
//				break;
//
//			case '2':
//				switch(mapa.getPosicion()[2]){
//				case '1':
//					i=3;
//					fondo = ImageIO.read(new File(imagenesMapas[3]));
//					if(monstruoDerrotado[i]==false){
//						enemigo = ImageIO.read(new File("TrollGarrote.png"));
//						this.panelEscenario.setEnemigo(enemigo);
//						this.arma = new Arma("espada", 1);
//					}
//					
//					else{
//						this.panelEscenario.setEnemigo(null);
//					}
//					
//					this.panelEscenario.setFondo(fondo);
//					this.VentanaJuego.repaint();
//					break;
//				case '2':
//					i=4;
//					fondo = ImageIO.read(new File(imagenesMapas[4]));
//					if(monstruoDerrotado[i]==false){
//						enemigo = ImageIO.read(new File("TrollGarrote.png"));
//						this.panelEscenario.setEnemigo(enemigo);
//						this.arma = new Item("princesa");
//					}
//					else{
//						this.panelEscenario.setEnemigo(null);
//					}
//					this.panelEscenario.setFondo(fondo);
//					this.VentanaJuego.repaint();
//					break;
//				case '3':
//					i=5;
//					fondo = ImageIO.read(new File(imagenesMapas[5]));
//					if(monstruoDerrotado[i]==false){
//						enemigo = ImageIO.read(new File("TrollGarrote.png"));
//						this.panelEscenario.setEnemigo(enemigo);
//						this.arma = new Arma("ballesta", 5);
//					}
//					else{
//						this.panelEscenario.setEnemigo(null);
//					}
//					this.panelEscenario.setFondo(fondo);
//					this.VentanaJuego.repaint();
//					break;
//				}
//				break;
//
//			case '3':
//				switch(mapa.getPosicion()[2]){
//				case '1':
//					i=6;
//					fondo = ImageIO.read(new File(imagenesMapas[6]));
//					if(monstruoDerrotado[i]==false){
//						enemigo = ImageIO.read(new File("TrollGarrote.png"));
//						this.panelEscenario.setEnemigo(enemigo);
//						System.out.println("Este mapa no tiene arma");
//						this.arma = null;
//					}
//					else{
//						this.panelEscenario.setEnemigo(null);
//					}
//					this.panelEscenario.setFondo(fondo);
//					this.VentanaJuego.repaint();
//					break;
//				case '2':
//					i=7;
//					fondo = ImageIO.read(new File(imagenesMapas[0]));
//					if(monstruoDerrotado[i]==false){
//						enemigo = ImageIO.read(new File("TrollGarrote.png"));
//						this.panelEscenario.setEnemigo(enemigo);
//						System.out.println("Este mapa no tiene arma y es igual al bosque");
//						this.arma = null;
//					}
//					else{
//						this.panelEscenario.setEnemigo(null);
//					}
//					this.panelEscenario.setFondo(fondo);
//					this.VentanaJuego.repaint();
//					break;
//				case '3':
//					i=8;
//					fondo = ImageIO.read(new File(imagenesMapas[0]));
//					if(monstruoDerrotado[i]==false){
//						enemigo = ImageIO.read(new File("TrollGarrote.png"));
//						this.panelEscenario.setEnemigo(enemigo);
//						System.out.println("Este mapa tiene un escudo y es igual al bosque");
//						this.arma = new Arma("escudo", 5);
//					}
//					else{
//						this.panelEscenario.setEnemigo(null);
//					}
//					this.panelEscenario.setFondo(fondo);
//					this.VentanaJuego.repaint();
//					break;
//				}
//				break;
//
//			case '4':
//				switch(mapa.getPosicion()[2]){
//				case '1':
//					i=9;
//					fondo = ImageIO.read(new File(imagenesMapas[9]));
//					if(monstruoDerrotado[i]==false){
//						enemigo = ImageIO.read(new File("TrollGarrote.png"));
//						this.panelEscenario.setEnemigo(enemigo);
//						this.arma = new Arma("arco", 5);
//					}
//					else{
//						this.panelEscenario.setEnemigo(null);
//					}
//					this.panelEscenario.setFondo(fondo);
//					this.VentanaJuego.repaint();
//					break;
//				case '2':
//					i=10;
//					fondo = ImageIO.read(new File(imagenesMapas[0]));
//					if(monstruoDerrotado[i]==false){
//						enemigo = ImageIO.read(new File("TrollGarrote.png"));
//						this.panelEscenario.setEnemigo(enemigo);
//						this.arma = null;
//						System.out.println("Este mapa no tiene arma y es igual que el bosque");
//					}
//					else{
//						this.panelEscenario.setEnemigo(null);
//					}
//					this.panelEscenario.setFondo(fondo);
//					this.VentanaJuego.repaint();
//					break;
//				case '3':
//					i=11;
//					fondo = ImageIO.read(new File(imagenesMapas[0]));
//					if(monstruoDerrotado[i]==false){
//						enemigo = ImageIO.read(new File("TrollGarrote.png"));
//						this.panelEscenario.setEnemigo(enemigo);
//						this.arma = new Posion(Color.GREEN, 40);
//					}
//					else{
//						this.panelEscenario.setEnemigo(null);
//					}
//					this.panelEscenario.setFondo(fondo);
//					this.VentanaJuego.repaint();
//					break;
//				}
//				break;
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

}
