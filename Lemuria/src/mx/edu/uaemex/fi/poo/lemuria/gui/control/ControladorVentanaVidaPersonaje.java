package mx.edu.uaemex.fi.poo.lemuria.gui.control;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import mx.edu.uaemex.fi.poo.lemuria.gui.VentanaLemuria;
import mx.edu.uaemex.fi.poo.lemuria.gui.VentanaVidaPersonaje;
import mx.edu.uaemex.fi.poo.lemuria.modelo.Arma;
import mx.edu.uaemex.fi.poo.lemuria.modelo.Guerrero;

public class ControladorVentanaVidaPersonaje extends VentanaLemuria implements Observer {

	private static final long serialVersionUID = 1L;

	private VentanaVidaPersonaje ventanaVidaPersonaje;
	private long vidaTotal;
	private Guerrero guerrero;

	public VentanaVidaPersonaje getVentanaVidaPersonaje() {
		return ventanaVidaPersonaje;
	}

	public void setVentanaVidaPersonaje(VentanaVidaPersonaje ventanaVidaPersonaje) {
		this.ventanaVidaPersonaje = ventanaVidaPersonaje;
		this.ventanaVidaPersonaje.getCampoVida().setText(("100/100"));
		this.ventanaVidaPersonaje.setCampoPoder(String.valueOf(this.guerrero.getNivelDePoder()));
	}

	public Guerrero getGuerrero() {
		return guerrero;
	}

	public void setGuerrero(Guerrero guerrero) {
		this.guerrero = guerrero;
		this.vidaTotal=this.guerrero.getNivelDeSalud();
		this.guerrero.addObserver(this);
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		this.ventanaVidaPersonaje.setStatusPoints(this.guerrero.getStatusPoints()+"");
		if(this.guerrero.getStatusPoints()>0){
			this.ventanaVidaPersonaje.HabilitaStats(true);
		}
		else{
			this.ventanaVidaPersonaje.HabilitaStats(false);
		}
		
		if(this.guerrero.getItemEnMano() instanceof Arma){
			Arma armaEnMano = (Arma)(this.guerrero.getItemEnMano());
			this.ventanaVidaPersonaje.setCampoPoder(String.valueOf(this.guerrero.getNivelDePoder()+ " + " +armaEnMano.getPoder()));
		}
		else{
		this.ventanaVidaPersonaje.setCampoPoder(String.valueOf(this.guerrero.getNivelDePoder()));
		}
		
		if(this.guerrero.getNivelDeSalud() > this.vidaTotal){
			this.vidaTotal=this.guerrero.getNivelDeSalud();
		}
		
		this.ventanaVidaPersonaje.setCampoVida(this.guerrero.getNivelDeSalud() + "/" + this.vidaTotal);
		
		float porcentaje =(this.guerrero.getNivelDeSalud()*100)/vidaTotal;

		this.ventanaVidaPersonaje.getBarraVida().setValue((int) porcentaje);
		if(porcentaje < 30){
			this.ventanaVidaPersonaje.getBarraVida().setForeground(Color.RED);
		}
		if(porcentaje >= 30){
			this.ventanaVidaPersonaje.getBarraVida().setForeground(Color.YELLOW);
		}
		if(porcentaje >=50){
			this.ventanaVidaPersonaje.getBarraVida().setForeground(Color.GREEN);
		}
	}
	
	public void SubeAtaque(){
		this.guerrero.incrementaPoder(1);
		this.guerrero.DecrementaStatusPoints(1);
	}
	
	public void SubeVitalidad(){
		this.guerrero.incrementaSalud(10);
		this.guerrero.IncrementaVitalidad(1);
		this.ventanaVidaPersonaje.setVitalidad(""+this.guerrero.getVitalidad());
		this.guerrero.DecrementaStatusPoints(1);
	}
}
