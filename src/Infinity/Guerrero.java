package Infinity;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

public class Guerrero extends Jugador {
    private int furia;

    public Guerrero(String nombre, int numCasillas) {
        super(nombre, numCasillas);
        this.furia = 5;
    }

    public void enfurecerse(ArrayList<Jugador> players, String nombreJugador) {
        if (this.furia > 0) {
            Iterator<Jugador> it = players.iterator();
            while (it.hasNext()) {
                Jugador jugador = it.next();
                if (jugador.getName().equals(nombreJugador)) {
                    jugador.cambiarVida(-1);
                }
            }
            this.furia -= 1;
        }
    }

    public String getClase() {
        return "Guerrero";
    }
}
