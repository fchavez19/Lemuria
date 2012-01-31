package jass.juegos.rochess.principal;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class RochessActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new VentanaJuego(this));
    }
}