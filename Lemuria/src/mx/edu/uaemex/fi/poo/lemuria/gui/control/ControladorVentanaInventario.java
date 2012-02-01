package mx.edu.uaemex.fi.poo.lemuria.gui.control;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;

import mx.edu.uaemex.fi.poo.lemuria.gui.VentanaInventario;
import mx.edu.uaemex.fi.poo.lemuria.modelo.Arma;
import mx.edu.uaemex.fi.poo.lemuria.modelo.Item;
import mx.edu.uaemex.fi.poo.lemuria.modelo.Guerrero;
import mx.edu.uaemex.fi.poo.lemuria.modelo.Posion;
import mx.edu.uaemex.fi.poo.lemuria.modelo.error.CantidadNoValidaException;
import mx.edu.uaemex.fi.poo.lemuria.modelo.error.ItemNoEncontradoException;

public class ControladorVentanaInventario implements Observer{
	private VentanaInventario ventanaInventario;
	private Guerrero guerrero;
	private int contadorArmas=1;
	
	public ControladorVentanaInventario(){
	}

	public void Hacele(String arma){
		try {
			int pos;
			if(arma.compareTo("espada")==0){
				pos = this.guerrero.getArmeria().find("espada");
				this.guerrero.setItemEnMano((Item)this.guerrero.getArmeria().getContenido()[pos]);
				JOptionPane.showMessageDialog(null, "Tienes en la mano: " + this.guerrero.getItemEnMano().getNombre(), "Item en mano", JOptionPane.INFORMATION_MESSAGE);
			}

			else if(arma.compareTo("daga")==0){
				pos = this.guerrero.getArmeria().find("daga");
				this.guerrero.setItemEnMano((Item)this.guerrero.getArmeria().getContenido()[pos]);
				JOptionPane.showMessageDialog(null, "Tienes en la mano: " + this.guerrero.getItemEnMano().getNombre(), "Item en mano", JOptionPane.INFORMATION_MESSAGE);
			}

			else if(arma.compareTo("posion salud")==0){
				pos = this.guerrero.getBolsa().find("posion salud");
				this.guerrero.setItemEnMano((Posion)this.guerrero.getBolsa().getContenido()[pos]);
				try {
					this.guerrero.incrementaSalud(((Posion)this.guerrero.getItemEnMano()).getMagia(1));
					JOptionPane.showMessageDialog(null, "Tienes en la mano: " + ((Posion)this.guerrero.getItemEnMano()).getNombre(), "Item en mano", JOptionPane.INFORMATION_MESSAGE);
					this.guerrero.getBolsa().dropItem(pos);
					this.ventanaInventario.HabilitaItem("posion salud",false);
				} catch (CantidadNoValidaException e) {
					e.printStackTrace();
				}
			}

			else if(arma.compareTo("esteroides")==0){
				pos = this.guerrero.getBolsa().find("esteroides");
				this.guerrero.setItemEnMano((Item)this.guerrero.getBolsa().getContenido()[pos]);
				guerrero.setNivelDeSalud(guerrero.getNivelDeSalud()/2);
				guerrero.setDopado(true,2);
				this.guerrero.getBolsa().dropItem(pos);
				this.ventanaInventario.HabilitaItem("esteroides",false);
			}
			
			else if(arma.compareTo("ballesta")==0){
				pos = this.guerrero.getArmeria().find("ballesta");
				this.guerrero.setItemEnMano((Item)this.guerrero.getArmeria().getContenido()[pos]);
				JOptionPane.showMessageDialog(null, "Tienes en la mano: " + this.guerrero.getItemEnMano().getNombre(), "Item en mano", JOptionPane.INFORMATION_MESSAGE);
			}

			else if(arma.compareTo("escudo")==0){
				pos = this.guerrero.getArmeria().find("escudo");
				this.guerrero.setItemEnMano((Item)this.guerrero.getArmeria().getContenido()[pos]);
				JOptionPane.showMessageDialog(null, "Tienes en la mano: " + this.guerrero.getItemEnMano().getNombre(), "Item en mano", JOptionPane.INFORMATION_MESSAGE);
			}

			else if(arma.compareTo("arco")==0){
				pos = this.guerrero.getArmeria().find("arco");
				this.guerrero.setItemEnMano((Item)this.guerrero.getArmeria().getContenido()[pos]);
				JOptionPane.showMessageDialog(null, "Tienes en la mano: " + this.guerrero.getItemEnMano().getNombre(), "Item en mano", JOptionPane.INFORMATION_MESSAGE);
			}

			else if(arma.compareTo("nada")==0){
				this.guerrero.setItemEnMano(null);
			}
		}
		catch (ItemNoEncontradoException e) {
			e.printStackTrace();
		}
	}

	public VentanaInventario getVentanaInventario() {
		return ventanaInventario;
	}

	public void setVentanaInventario(VentanaInventario ventanaInventario) {
		this.ventanaInventario = ventanaInventario;
	}

	public Guerrero getGuerrero() {
		return guerrero;
	}

	public void setGuerrero(Guerrero guerrero) {
		this.guerrero = guerrero;
		this.guerrero.getArmeria().addObserver(this);
		this.guerrero.getBolsa().addObserver(this);
	}

	public void update(Observable arg0, Object item) {

		if( ((Item)item).getNombre().compareTo("esteroides")==0){ 
			this.ventanaInventario.HabilitaItem("esteroides",true);
		}

		if(item instanceof Posion){
			if(((Posion)item).getColor() == Color.GREEN){
				this.ventanaInventario.HabilitaItem("posion salud",true);
			}
		}
		
		else{
			String coso = ((Item)item).getNombre();
			if(item instanceof Arma){
				if(contadorArmas == this.guerrero.getArmeria().showArmeria()){
					if(coso.compareTo("daga")==0){
						this.ventanaInventario.HabilitaItem("daga",true);
						contadorArmas++;
					}
					else if(coso.compareTo("espada")==0){
						this.ventanaInventario.HabilitaItem("espada",true);
						contadorArmas++;
					}
					else if(coso.compareTo("ballesta")==0){
						this.ventanaInventario.HabilitaItem("ballesta",true);
						contadorArmas++;
					}
					else if(coso.compareTo("escudo")==0){
						contadorArmas++;
						this.ventanaInventario.HabilitaItem("escudo",true);
					}
					else if(coso.compareTo("arco")==0){
						contadorArmas++;
						this.ventanaInventario.HabilitaItem("arco",true);
					}
				}
				else{
					if(coso.compareTo("daga")==0){
						this.ventanaInventario.HabilitaItem("daga",false);
						contadorArmas--;
					}
					else if(coso.compareTo("espada")==0){
						this.ventanaInventario.HabilitaItem("espada",false);
						contadorArmas--;
					}
					else if(coso.compareTo("ballesta")==0){
						this.ventanaInventario.HabilitaItem("ballesta",false);
						contadorArmas--;
					}
					else if(coso.compareTo("escudo")==0){
						this.ventanaInventario.HabilitaItem("escudo",false);
						contadorArmas--;
					}
					else if(coso.compareTo("arco")==0){
						this.ventanaInventario.HabilitaItem("arco",false);
						contadorArmas--;
					}
				}
			}
		}
	}
}