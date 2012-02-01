package mx.edu.uaemex.fi.poo.lemuria.Principal;

import mx.edu.uaemex.fi.poo.lemuria.gameadmin.modelo.Jugador;
import mx.edu.uaemex.fi.poo.lemuria.gui.PanelEscenario;
import mx.edu.uaemex.fi.poo.lemuria.gui.VentanaCodigosKonami;
import mx.edu.uaemex.fi.poo.lemuria.gui.VentanaInicial;
import mx.edu.uaemex.fi.poo.lemuria.gui.VentanaInventario;
import mx.edu.uaemex.fi.poo.lemuria.gui.VentanaJuego;
import mx.edu.uaemex.fi.poo.lemuria.gui.VentanaMovimientos;
import mx.edu.uaemex.fi.poo.lemuria.gui.VentanaRegistro;
import mx.edu.uaemex.fi.poo.lemuria.gui.VentanaSeleccionarMapa;
import mx.edu.uaemex.fi.poo.lemuria.gui.VentanaVidaPersonaje;
import mx.edu.uaemex.fi.poo.lemuria.gui.control.ControlGeneral;
import mx.edu.uaemex.fi.poo.lemuria.gui.control.ControladorAtaque;
import mx.edu.uaemex.fi.poo.lemuria.gui.control.ControladorLogin;
import mx.edu.uaemex.fi.poo.lemuria.gui.control.ControladorMapa;
import mx.edu.uaemex.fi.poo.lemuria.gui.control.ControladorMovimientos;
import mx.edu.uaemex.fi.poo.lemuria.gui.control.ControladorRegistro;
import mx.edu.uaemex.fi.poo.lemuria.gui.control.ControladorVentanaInventario;
import mx.edu.uaemex.fi.poo.lemuria.gui.control.ControladorVentanaVidaPersonaje;
import mx.edu.uaemex.fi.poo.lemuria.gui.control.VentanaInicialCtrl;
import mx.edu.uaemex.fi.poo.lemuria.modelo.Guerrero;
import mx.edu.uaemex.fi.poo.lemuria.modelo.Mapa;
import mx.edu.uaemex.fi.poo.lemuria.modelo.Troll;

public class Principal {

	public static void main(String[] args) {
		Guerrero guerrero = new Guerrero();
		guerrero.setNivelDeSalud(100);
		guerrero.setNivelDePoder(10);
		Troll troll = new Troll();
		troll.setNivelDePoder(5);
		
		Jugador player = new Jugador();
		VentanaInicial ventanaInicial = new VentanaInicial();
		
		VentanaInicialCtrl control = new VentanaInicialCtrl(player);
		ventanaInicial.setControl(control);
		
		ControlGeneral controlGeneral = new ControlGeneral();
		control.setFatherCtrl(controlGeneral);
		
		VentanaRegistro ventanaRegistro = new VentanaRegistro();
		ControladorRegistro controladorRegistro = new ControladorRegistro();
		controladorRegistro.setJugador(player);
		
		controlGeneral.setRegistroVent(ventanaRegistro);
		
		ControladorLogin controladorLogin = new ControladorLogin();
		ventanaInicial.setControladorLogin(controladorLogin);
		controladorLogin.setVentana(ventanaInicial);
		controladorLogin.setJugador(player);
		
		ventanaInicial.setVisible(true);
		
		VentanaJuego ventanaJuego = new VentanaJuego();
		ventanaJuego.setPlayerModel(player);
		PanelEscenario panelEscenario = new PanelEscenario("selva.jpg");
		ventanaJuego.setPanelSelva(panelEscenario);
		
		Mapa mapa = new Mapa();
		
		mapa.setCoordenadaX(new Integer(0));
		mapa.setCoordenadaY(new Integer(0));
		
		ControladorMapa controladorMapa = new ControladorMapa();
		controladorMapa.setMapa(mapa);
		controladorMapa.setEscenario(panelEscenario);
		controladorMapa.setVentanaJuego(ventanaJuego);
		ControladorAtaque controladorAtaque = new ControladorAtaque();
		controladorAtaque.setGuerrero(guerrero);
		controladorAtaque.setTroll(troll);
		controladorAtaque.DANO=10;
		controladorMapa.setGuerrero(guerrero);
		VentanaMovimientos ventanaMovimientos = new VentanaMovimientos();
		controladorMapa.setVentanaMovimientos(ventanaMovimientos);
		
		ControladorMovimientos controladorVentanaMovimientos = new ControladorMovimientos();
		ventanaMovimientos.setControladorMovimientos(controladorVentanaMovimientos);
		ventanaMovimientos.setControladorMapa(controladorMapa);
		ventanaMovimientos.setPlayerModel(player);
		controladorMapa.setVentanaMovimientos(ventanaMovimientos);
		
		VentanaInventario ventanaInventario = new VentanaInventario();
		ControladorVentanaInventario controladorVentanaInventario = new ControladorVentanaInventario();
		ventanaInventario.setControladorVentanaInventario(controladorVentanaInventario);
		controladorVentanaInventario.setGuerrero(guerrero);
		controladorVentanaInventario.setVentanaInventario(ventanaInventario);
		ventanaInventario.setPlayerModel(player);
		
		VentanaVidaPersonaje ventanaVidaPersonaje = new VentanaVidaPersonaje();
		ventanaVidaPersonaje.setPlayerModel(player);
		ControladorVentanaVidaPersonaje controladorVentanaVidaPersonaje = new ControladorVentanaVidaPersonaje();
		controladorVentanaVidaPersonaje.setGuerrero(guerrero);
		controladorVentanaVidaPersonaje.setVentanaVidaPersonaje(ventanaVidaPersonaje);
		ventanaVidaPersonaje.setFocusable(false);
		VentanaCodigosKonami ventanaCodigosKonami = new VentanaCodigosKonami();
		ventanaInicial.setVentanaCodigosKonami(ventanaCodigosKonami);
		ventanaCodigosKonami.setSize(350,120);
		ventanaCodigosKonami.setGuerrero(guerrero);

		ventanaInventario.setLocation(785, 0);
		ventanaJuego.setLocation(205, 0);
		ventanaMovimientos.setLocation(200, 437);
		ventanaVidaPersonaje.setLocation(550, 437);

		VentanaSeleccionarMapa ventanaSeleccionarMapa = new VentanaSeleccionarMapa();
		ventanaSeleccionarMapa.setControladorMapa(controladorMapa);
		ventanaInicial.setVentanaSeleccionarMapa(ventanaSeleccionarMapa);
		ventanaSeleccionarMapa.setSize(300,100);
		
		ventanaVidaPersonaje.setControladorVentanaVidaPersonaje(controladorVentanaVidaPersonaje);
	}
}