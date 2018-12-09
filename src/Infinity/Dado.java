package Infinity;

import java.util.Random;

public class Dado {

    private int caraResultante;

    public int lanzarDado() {
        int dado[] = {1, 2, 3, 4, 5, 6};
        int idx = new Random().nextInt(dado.length);
        int idx2 = new Random().nextInt(dado.length);
        int dado1 = dado[idx];
        int dado2 = dado[idx2];
        caraResultante = (dado1 + dado2);
        return caraResultante;
    }

    public int  probabilidadReliquia(Jugador jugador){
        if( caraResultante == 12){
            return activarReliquia(0.50f, jugador);
        } else {
            return activarReliquia(0.01f, jugador);
        }
    }

    public int activarReliquia(double suerte, Jugador jugador){
        Random r = new Random();
        float probabilidad = r.nextFloat();
        if(probabilidad <= suerte){
            jugador.cambiarVida(20);
            return 1;
        }
        return 0;
    }
}
