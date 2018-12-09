package Infinity;

import java.util.ArrayList;
import java.util.Random;

public class Guardian {
    private int vida;

    public Guardian(int cantidadJugadores) {
        this.vida = (15 * cantidadJugadores);
    }

    public int habilidadFuria(ArrayList<Jugador> jugadores) {
        Random r = new Random();
        float probabilidadHablidad = r.nextFloat();
        if (probabilidadHablidad <= 0.02f) {
            this.vida = this.vida + 2;
            for (int i = 0; i < jugadores.size(); i++) {
                jugadores.get(i).cambiarVida(-1);
            }
            return 1;
        }
        return 0;
    }

    public int getVida() {
        return this.vida;
    }

    public void restarVida(int cantidad) {
        this.vida = this.vida - cantidad;
        while (this.vida < 0) {
            this.vida = 0;
        }
    }
}
